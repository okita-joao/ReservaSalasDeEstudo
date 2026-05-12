import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Terminal {
    private SistemaDeReservas sistema;
    private Faculdade faculdade;
    private Scanner scanner;

    public Terminal(SistemaDeReservas sistema, Faculdade faculdade) {
        this.sistema = sistema;
        this.faculdade = faculdade;
        this.scanner = new Scanner(System.in);
    }

    public Terminal(SistemaDeReservas sistema) {
        this(sistema, new Faculdade());
    }

    public void iniciar() {
        System.out.println("SISTEMA DE RESERVAS DE SALAS - Terminal iniciado");

        boolean executando = true;

        while (executando) {
            printMenu();
            String comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "rsala":
                    executarReserva();
                    break;

                case "crsala":
                    executarCancelamento();
                    break;

                case "relat":
                    executarRelatorio();
                    break;

                case "usuarios":
                    listarUsuarios();
                    break;

                case "exit":
                    executando = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }
    }

    private void executarReserva() {
        Usuario solicitante = selecionarOuCadastrarUsuario();
        Sala sala = selecionarSala();

        LocalDate data = lerData("Digite a data da reserva (AAAA-MM-DD): ");
        LocalTime inicio = lerHora("Digite o horário de início (HH:MM): ");
        LocalTime fim = lerHora("Digite o horário de fim (HH:MM): ");

        if (!inicio.isBefore(fim)) {
            System.out.println("Horário inválido: o início precisa ser antes do fim.");
            return;
        }

        String resultado = reservarSala(sala, solicitante, data, inicio, fim);
        System.out.println(resultado);
    }

    private String reservarSala(Sala sala, Usuario solicitante, LocalDate data, LocalTime inicio, LocalTime fim) {
        ReservasAtivas repositorio = this.sistema.getRepositorioReservas();
        HistoricoReservas logs = this.sistema.getLogs();

        int id = logs.getNumEventos();
        EventoReserva evento = new EventoReserva(sala, solicitante, data, inicio, fim, id, false);

        List<Reserva> reservas = repositorio.getReservasAtivas();
        boolean conflito = false;

        for (Reserva r : reservas) {
            boolean mesmaSala = r.getSala().getNome().equalsIgnoreCase(sala.getNome());
            boolean mesmaData = r.getData().equals(data);
            boolean conflitoHorario = r.getHorarioFim().isAfter(inicio) && r.getHorarioInicio().isBefore(fim);

            if (mesmaSala && mesmaData && conflitoHorario) {
                conflito = true;
                r.addObserver(solicitante);
            }
        }

        logs.addEventoReserva(evento);

        if (!conflito) {
            evento.setTentativa(true);
            repositorio.addReserva(new Reserva(sala, solicitante, data, inicio, fim, id));
            return "Reserva concluída com sucesso. ID da reserva: " + id;
        }

        return "Não foi possível concluir a reserva, pois já existe conflito de horário.";
    }

    private void executarCancelamento() {
        int id = lerInteiro("Digite o ID da reserva que deseja cancelar: ");
        String resultado = new CancelarReserva(this.sistema).executar(id);
        System.out.println(resultado);
    }

    private void executarRelatorio() {
        LocalDate dia = lerData("Digite a data do relatório (AAAA-MM-DD): ");
        String resultado = new RelatorioReservas(this.sistema).executar(dia);
        System.out.println(resultado);
    }

    private Usuario selecionarOuCadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine().trim();

        Usuario existente = this.faculdade.buscarUsuarioPorNome(nome);
        if (existente != null) {
            return existente;
        }

        System.out.println("Usuário não encontrado. Deseja cadastrá-lo agora?");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");

        int tipo = lerInteiro("Escolha uma opção: ");

        if (tipo == 2) {
            System.out.print("Digite o ID do professor: ");
            String idProfessor = scanner.nextLine().trim();

            Professor professor = new Professor(nome, idProfessor);
            this.faculdade.addUsuario(professor);
            return professor;
        }

        System.out.print("Digite o RA do aluno: ");
        String ra = scanner.nextLine().trim();

        Aluno aluno = new Aluno(nome, ra);
        this.faculdade.addUsuario(aluno);
        return aluno;
    }

    private Sala selecionarSala() {
        System.out.println("\nEscolha o tipo de sala:");
        System.out.println("1 - Sala de Aula Teórica");
        System.out.println("2 - Sala de Estudo Individual");
        System.out.println("3 - Sala de Laboratório");
        System.out.println("4 - Sala de Trabalho em Grupo");

        int tipo = lerInteiro("Opção: ");

        System.out.print("Digite o nome da sala: ");
        String nome = scanner.nextLine().trim();

        int capacidade = lerInteiro("Digite a capacidade da sala: ");

        SalaFactory factory;

        switch (tipo) {
            case 1:
                factory = new SalaAulaTeoricaFactory();
                break;
            case 2:
                factory = new SalaEstudoIndividualFactory();
                break;
            case 3:
                factory = new SalaLaboratorioFactory();
                break;
            case 4:
                factory = new SalaTrabalhoGrupoFactory();
                break;
            default:
                System.out.println("Tipo inválido. Usando Sala de Aula Teórica por padrão.");
                factory = new SalaAulaTeoricaFactory();
                break;
        }

        return factory.criarSala(nome, capacidade);
    }

    private LocalDate lerData(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String texto = scanner.nextLine().trim();
                return LocalDate.parse(texto);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato AAAA-MM-DD.");
            }
        }
    }

    private LocalTime lerHora(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String texto = scanner.nextLine().trim();
                return LocalTime.parse(texto);
            } catch (DateTimeParseException e) {
                System.out.println("Horário inválido. Use o formato HH:MM.");
            }
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String texto = scanner.nextLine().trim();
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    public void printMenu() {
        System.out.println("\nComandos disponíveis:");
        System.out.println("rsala    -> Reservar uma sala");
        System.out.println("crsala   -> Cancelar reserva");
        System.out.println("relat    -> Gerar relatório");
        System.out.println("usuarios -> Listar usuários cadastrados");
        System.out.println("exit     -> Sair");
        System.out.print("\nDigite um comando: ");
    }

    private void listarUsuarios() {
        if (this.faculdade.getUsuarios().isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("Usuários cadastrados:");
        for (Usuario u : this.faculdade.getUsuarios()) {
            System.out.println("- " + u.getNome());
        }
    }

    public void setSistema(SistemaDeReservas sistema) {
        this.sistema = sistema;
    }

    public SistemaDeReservas getSistema() {
        return this.sistema;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Faculdade getFaculdade() {
        return this.faculdade;
    }
}