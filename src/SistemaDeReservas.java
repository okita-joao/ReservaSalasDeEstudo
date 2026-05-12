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

    // #region Getters e Setters
    public void setRepositorioReservas(List<Reserva> lista) {
        this.repositorioReservas = lista;
    }

    public List<Reserva> getRepositorioReservas() {
        return this.repositorioReservas;
    }

    private void setN(int N) {
        this.N = N;
    }

    public int getN() {
        return this.N;
    }

    public void incrementaN() {
        int x = this.getN();
        this.setN(x + 1);
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
