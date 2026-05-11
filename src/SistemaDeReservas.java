// Notas:
// + Implementação do Padrão Singleton para que o Sistema de Reservas
//   seja único durante a execução da aplicação.

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class SistemaDeReservas {
    // Instância Única e centralizada
    private static SistemaDeReservas instance;
    private int N = 0;
    private List<Reserva> repositorioReservas = new ArrayList<Reserva>();

    private SistemaDeReservas() {
    }

    public static synchronized SistemaDeReservas getInstance() {
        if (instance == null) {
            instance = new SistemaDeReservas();
        }
        return instance;
    }

    // Métodos para Reservar uma Sala
    public void reservarSala(Sala sala, Usuario solicitante, LocalDate data, LocalTime inicio, LocalTime horarioFim) {
        repositorioReservas.add(new Reserva(sala, solicitante, data, inicio, horarioFim, N));
        N = N + 1;

        sala.reservar();
    }

    public void cancelaReserva(int idReserva) {
        int inicio = 0;
        int fim = repositorioReservas.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Reserva res = repositorioReservas.get(meio);
            int id = res.getIdReserva();

            if (id == idReserva) {
                res.getSala().liberar();
                repositorioReservas.remove(meio);
                break;
            } else if (id > idReserva) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
    }

}
