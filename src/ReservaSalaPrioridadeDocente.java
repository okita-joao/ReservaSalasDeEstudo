import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class ReservaSalaPrioridadeDocente
        implements Reservar {

    public ReservaSalaPrioridadeDocente(
            SistemaDeReservas sistema) {

        super(sistema);
    }

    private List<Reserva> verificarConflitos(
            Sala sala,
            LocalDate data,
            LocalTime inicio,
            LocalTime fim,
            List<Reserva> reservas) {

        List<Reserva> conflitos =
                new ArrayList<>();

        for (Reserva r : reservas) {

            boolean mesmaSala =
                    r.getSala().getNome()
                    .equals(sala.getNome());

            boolean mesmaData =
                    r.getData().equals(data);

            boolean conflitoHorario =
                    r.getHorarioFim().isAfter(inicio)
                    && r.getHorarioInicio().isBefore(fim);

            if (mesmaSala
                    && mesmaData
                    && conflitoHorario) {

                conflitos.add(r);
            }
        }

        return conflitos;
    }

    public String executar(
            Sala sala,
            Usuario usuario,
            LocalDate data,
            LocalTime inicio,
            LocalTime fim) {

        ReservasAtivas R =
                sistema.getRepositorioReservas();

        List<Reserva> conflitos =
                verificarConflitos(
                        sala,
                        data,
                        inicio,
                        fim,
                        R.getReservasAtivas());

        // sem conflitos
        if (conflitos.isEmpty()) {

            int id =
                    sistema.getLogs().getNumEventos();

            R.addReserva(
                    new Reserva(
                            sala,
                            usuario,
                            data,
                            inicio,
                            fim,
                            id));

            return "Reserva criada.";
        }

        // docente possui prioridade
        if (usuario.isDocente()) {

            for (Reserva r : conflitos) {

                if (!r.getSolicitante()
                        .isDocente()) {

                    R.removeReserva(r);
                }
            }

            int id =
                    sistema.getLogs().getNumEventos();

            R.addReserva(
                    new Reserva(
                            sala,
                            usuario,
                            data,
                            inicio,
                            fim,
                            id));

            return "Reserva criada com prioridade docente.";
        }

        return "Horário ocupado.";
    }
}