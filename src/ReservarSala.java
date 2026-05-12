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
    private List<Reserva> verificaSala(Sala sala, LocalDate data, LocalTime inicio, LocalTime horarioFim) {
        List<Reserva> lista = this.sistema.getRepositorioReservas();
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
        List<Reserva> conflitos = this.verificaSala(sala, data, inicio, horarioFim);

        if (conflitos.size() == 0) {
            int N = this.sistema.getN();
            this.sistema.getRepositorioReservas().add(new Reserva(sala, solicitante, data, inicio, horarioFim, N));
            this.sistema.incrementaN();

            return "Reserva foi concluída com sucesso! Guarde o id dela: " + N + "\n";
        } else {
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
