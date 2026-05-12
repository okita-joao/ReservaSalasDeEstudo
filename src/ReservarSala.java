import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ReservarSala extends Operacao {
    // Método Construtor da Classe
    public ReservarSala(SistemaDeReservas sistema) {
        super(sistema);
    }

    // Implementação para verificar se é possível reservar sala no horário
    // requisitado
    private List<Reserva> verificaSala(Sala sala, LocalDate data, LocalTime inicio, LocalTime horarioFim,
            List<Reserva> lista) {
        List<Reserva> conflitos = new ArrayList<Reserva>();

        Iterator<Reserva> it = lista.iterator();

        while (it.hasNext()) {
            Reserva res = it.next();

            // Verifica se há conflito de horário
            boolean A = res.getSala().getNome().equals(sala.getNome());
            if (!A)
                continue;

            boolean B = res.getData().equals(data);
            if (!B)
                continue;

            boolean C = res.getHorarioFim().isAfter(inicio);
            boolean D = res.getHorarioInicio().isBefore(horarioFim);
            if (C && D)
                conflitos.add(res);
        }

        return conflitos;
    }

    // Implementação da Operação de Reservar uma Sala
    public String executar(Sala sala, Usuario solicitante, LocalDate data, LocalTime inicio, LocalTime horarioFim) {
        // Recupera o Histórico de Reservas e as Reservas Ativas para executar o
        // algoritmo
        HistoricoReservas H = this.sistema.getLogs();

        ReservasAtivas R = this.sistema.getRepositorioReservas();

        // Pega o id do Evento de Reserva
        int N = H.getNumEventos();

        // Já cria o Evento de Reserva, pois isso já é uma tentiva de Reserva
        EventoReserva E = new EventoReserva(sala, solicitante, data, inicio, horarioFim, N, false);

        // Verifica as Reservas Ativas conflitantes com a Tentativa atual
        List<Reserva> lista = R.getReservasAtivas();
        List<Reserva> conflitos = this.verificaSala(sala, data, inicio, horarioFim, lista);

        // Caso não haja Reservas Ativas conflitantes:
        if (conflitos.size() == 0) {
            E.setTentativa(true);
            H.addEventoReserva(E);

            R.addReserva(new Reserva(sala, solicitante, data, inicio, horarioFim, N));

            return "Reserva foi concluída com sucesso! Guarde o id dela: " + N + "\n";
        }

        // Caso haja uma ou mais Reservas Ativas conflitantes
        else {
            H.addEventoReserva(E);

            String msgErro = "Infelizmente não foi possível concluir sua reserva, devido aos seguintes horários:\n";

            Iterator<Reserva> it = conflitos.iterator();

            while (it.hasNext()) {
                Reserva res = it.next();
                msgErro = msgErro + res.apresentaReserva();
            }

            return msgErro;
        }
    }
}
