import java.util.List;
import java.util.ArrayList;

public class HistoricoReservas {
    // Atributos da Classe Histórico de Reservas
    private int numEventos = 0;
    private List<EventoReserva> logs = new ArrayList<EventoReserva>();

    // Método Construtor da Classe Histórico de Reservas
    public HistoricoReservas() {
    }

    // #region Getters e Setters
    private void refreshNumEventos() {
        this.numEventos = this.getLogs().size();
    }

    public int getNumEventos() {
        return this.numEventos;
    }

    public void setLogs(List<EventoReserva> logs) {
        this.logs = logs;
    }

    public List<EventoReserva> getLogs() {
        return this.logs;
    }
    // #endregion

    // Método para Inserção de Evento de Reserva:
    public void addEventoReserva(EventoReserva E) {
        this.logs.add(E);
        this.refreshNumEventos();
    }

    // Como esses logs são importantes, então como política de
    // segurança desse software eles não serão deletáveis.

    // Método para busca de um Evento Específico
}
