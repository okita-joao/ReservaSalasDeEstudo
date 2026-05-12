// Notas:
// + Implementação do Padrão Singleton para que o Sistema de Reservas
//   seja único durante a execução da aplicação.

public class SistemaDeReservas {
    // Instância Única e centralizada
    private static SistemaDeReservas instance;

    // Atributos relacionados a essa instância única
    private HistoricoReservas logs = new HistoricoReservas();
    private ReservasAtivas repositorioReservas = new ReservasAtivas();

    private SistemaDeReservas() {
    }

    public static synchronized SistemaDeReservas getInstance() {
        if (instance == null) {
            instance = new SistemaDeReservas();
        }
        return instance;
    }

    // #region Getters e Setters
    public void setRepositorioReservas(ReservasAtivas R) {
        this.repositorioReservas = R;
    }

    public ReservasAtivas getRepositorioReservas() {
        return this.repositorioReservas;
    }

    public void setLogs(HistoricoReservas H) {
        this.logs = H;
    }

    public HistoricoReservas getLogs() {
        return this.logs;
    }

    public int getNumReservasAtivas() {
        return this.getRepositorioReservas().getNumReservasAtivas();
    }

    public int getNumEventosReservas() {
        return this.getLogs().getNumEventos();
    }
    // #endregion
}
