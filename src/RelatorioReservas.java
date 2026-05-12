import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class RelatorioReservas extends Operacao {
    // Método Construtor da Classe
    public RelatorioReservas(SistemaDeReservas sistema) {
        super(sistema);
    }

    // Implementação da Operação de Relatório de Reservas
    public String executar(LocalDate dia) {
        String retorno = "Reservas confirmadas para o dia " + dia + ":\n";

        List<Reserva> lista = this.sistema.getRepositorioReservas().getReservasAtivas();

        Iterator<Reserva> it = lista.iterator();

        while (it.hasNext()) {
            Reserva res = it.next();
            retorno = retorno + res.apresentaReserva();
        }

        return retorno;
    }
}
