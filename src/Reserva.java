import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva extends EventoReserva {

    public Reserva(Sala sala, Usuario solicitante, LocalDate data, LocalTime inicio, LocalTime horarioFim, int id) {
        super(sala, solicitante, data, inicio, horarioFim, id, true);
    }

    // Método para apresentar a reserva
    public String apresentaReserva() {
        return this.getSala().getNome() + ", Solicitante: " + this.getSolicitante().getNome() + ", " + this.getData()
                + " das " + this.getHorarioInicio() + " até " + this.getHorarioFim() + "\n";
    }
}
