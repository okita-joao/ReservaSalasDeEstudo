public class CancelarReserva extends Operacao {
    // Método Construtor da Classe
    public CancelarReserva(SistemaDeReservas sistema) {
        super(sistema);
    }

    // Implementação da Operação de Cancelar Reserva de uma Sala
    public String executar(int id) {
        // Pega o repositório de Reservas Ativas do Sistema
        ReservasAtivas R = this.sistema.getRepositorioReservas();

        // Implementação para verificar se a reserva que será removida existe
        Reserva res = R.buscaReserva(id);

        // Se a reserva não existe então ele não faz nada
        if (res == null)
            return "Não foi possível executar o cancelamento, pois não existe Reserva Ativa com id: " + id;

        // Se a reserva existe remove-a do repositório de Reservas Ativas do Sistema
        R.removeReserva(res);

        // Notificar os interessados desse horário

        return "Cancelamento concluído com sucesso!";
    }
}
