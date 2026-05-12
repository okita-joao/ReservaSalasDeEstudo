import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Terminal {
    // Atributos da Classe TerminalUI do Sistema de Reservas
    private SistemaDeReservas sistema;

    // Método Construtor da Classe
    public Terminal(SistemaDeReservas sistema) {
        this.setSistema(sistema);
    }

    public void iniciar() {
        // Apresentação Terminal
        System.out.println("SISTEMA DE RESERVAS DE SALAS - Terminal UI iniciado");

        // Loop de Interação com o Usuário
        boolean executando = true;

        while (executando) {
            Scanner scanner = new Scanner(System.in);

            this.printMenu();

            String comando = scanner.nextLine();

            switch (comando.toLowerCase()) {
                Operacao op;
                case "rsala":
                    
                    (new ReservarSala(this.getSistema())).executar(null, null, null, null, null);
                    break;

                case "crsala":

                    (new CancelarReserva(this.getSistema())).executar(id);
                    break;

                case "relat":

                    (new RelatorioReservas(this.getSistema())).executar(dia);
                    break;

                case "exit":
                    executando = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Comando inválido.");
                    break;
            }

            scanner.close();
        }
    }

    // #region Getters e Setters
    public void setSistema(SistemaDeReservas sistema) {
        this.sistema = sistema;
    }

    public SistemaDeReservas getSistema() {
        return this.sistema;
    }
    // #endregion

    public void printMenu() {
        System.out.println("Comandos disponíveis:\n");

        System.out.println("rsala   -> Reservar uma sala");
        System.out.println("crsala  -> Cancelar reserva de uma sala");
        System.out.println("relat   -> Gerar relatório de salas por data");
        System.out.println("exit    -> Sair do sistema");

        System.out.println("\nDigite um comando:");
    }

}
