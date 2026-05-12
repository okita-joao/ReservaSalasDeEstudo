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
