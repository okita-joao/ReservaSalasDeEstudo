public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(" SISTEMA DE RESERVAS DE SALAS ");
        System.out.println("\n");

        // Inicialização da faculdade
        Faculdade faculdade = new Faculdade();

        System.out.println("Criando usuários...\n");

        // Professores
        Professor prof1 = new Professor("Carlos Silva", "P001");
        Professor prof2 = new Professor("Fernanda Souza", "P002");

        // Alunos
        Aluno aluno1 = new Aluno("João Pedro", "2023001");
        Aluno aluno2 = new Aluno("Marina Costa", "2023002");
        Aluno aluno3 = new Aluno("Lucas Oliveira", "2023003");

        // Adicionando usuários à faculdade
        faculdade.addUsuario(prof1);
        faculdade.addUsuario(prof2);

        faculdade.addUsuario(aluno1);
        faculdade.addUsuario(aluno2);
        faculdade.addUsuario(aluno3);

        // Prints dos usuários criados
        System.out.println("Professor criado: " + prof1.getNome());
        System.out.println("Professor criado: " + prof2.getNome());

        System.out.println("Aluno criado: " + aluno1.getNome());
        System.out.println("Aluno criado: " + aluno2.getNome());
        System.out.println("Aluno criado: " + aluno3.getNome());

        System.out.println("\n======================================\n");

        System.out.println("Criando salas...\n");

        // Factories
        SalaFactory aulaFactory = new SalaAulaTeoricaFactory();
        SalaFactory labFactory = new SalaLaboratorioFactory();
        SalaFactory estudoFactory = new SalaEstudoIndividualFactory();
        SalaFactory grupoFactory = new SalaTrabalhoGrupoFactory();

        // Salas
        Sala sala1 = aulaFactory.criarSala("Sala 101", 40);
        Sala sala2 = aulaFactory.criarSala("Sala 102", 35);

        Sala sala3 = labFactory.criarSala("Laboratório Info 1", 25);

        Sala sala4 = estudoFactory.criarSala("Cabine Individual 1", 1);

        Sala sala5 = grupoFactory.criarSala("Sala de Grupo A", 10);

        // Prints das salas criadas
        System.out.println("Sala criada: " + sala1.getNome());
        System.out.println("Sala criada: " + sala2.getNome());

        System.out.println("Sala criada: " + sala3.getNome());

        System.out.println("Sala criada: " + sala4.getNome());

        System.out.println("Sala criada: " + sala5.getNome());

        System.out.println("\n======================================\n");

        // Inicialização do sistema
        SistemaDeReservas sistema = new SistemaDeReservas();

        System.out.println("Sistema inicializado com sucesso.\n");

        // Inicialização do terminal
        Terminal terminal = new Terminal(sistema, faculdade);

        System.out.println("Iniciando terminal...\n");

        // Loop principal
        terminal.iniciar();
    }
}
