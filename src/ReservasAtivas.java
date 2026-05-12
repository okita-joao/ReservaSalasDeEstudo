import java.util.ArrayList;
import java.util.List;

public class ReservasAtivas {
    // Atributos da Classe Reservas Ativas
    private int numReservasAtivas = 0;
    private List<Reserva> repositorioReservas = new ArrayList<Reserva>();

    // Método Construtor da Classe de Reservas Ativas
    public ReservasAtivas() {
    }

    // #region Getters e Setter
    public void setReservasAtivas(List<Reserva> repositorioReservas) {
        this.repositorioReservas = repositorioReservas;
    }

    public List<Reserva> getReservasAtivas() {
        return this.repositorioReservas;
    }

    private void refreshNumReservasAtivas() {
        this.numReservasAtivas = this.getReservasAtivas().size();
    }

    public int getNumReservasAtivas() {
        return this.numReservasAtivas;
    }
    // #endregion

    // Método para adicionar uma Reserva Ativa
    public void addReserva(Reserva R) {
        this.repositorioReservas.add(R);
        this.refreshNumReservasAtivas();
    }

    // Método para remover uma Reserva Ativa
    public void removeReserva(Reserva R) {
        // Notificar os interessados
        R.notifyObservers();

        this.repositorioReservas.remove(R);
        this.refreshNumReservasAtivas();
    }

    // Método para buscar uma Reserva Ativa numa data e horário específicos
    public Reserva buscaReserva(int id) {
        int inicio = 0;
        int fim = this.getNumReservasAtivas() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Reserva res = this.getReservasAtivas().get(meio);
            int idTemp = res.getIdReserva();

            if (idTemp == id)
                return res;
            else if (idTemp < id)
                inicio = meio + 1;
            else
                fim = meio - 1;
        }

        return null;
    }
}
