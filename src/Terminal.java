import java.util.Scanner;

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

        // Mostrando Menu de possíveis comandos

        // Loop de Interação com o Usuário
        while (true) {

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
}
