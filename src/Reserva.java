import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private Sala sala;
    private Usuario solicitante;
    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private int idReserva;

    public Reserva(Sala sala, Usuario solicitante, LocalDate data, LocalTime inicio, LocalTime horarioFim, int id) {
        this.setSala(sala);
        this.setSolicitante(solicitante);
        this.setData(data);
        this.setHorarioInicio(inicio);
        this.setHorarioFim(horarioFim);
        this.setIdReserva(id);
    }

    // #region Getters e Setters
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    private void setIdReserva(int id) {
        this.idReserva = id;
    }

    public int getIdReserva() {
        return this.idReserva;
    }
    // #endregion

}
