public class Usuario implements Observer {
    // Atributos da Classe Usuario
    private String nome;

    // Método Construtor da Classe Usuário
    public Usuario(String nome) {
        this.setNome(nome);
    }

    // #region Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    // #endregion

    public void update(Subject s) {
        if (s instanceof Reserva) {
            Reserva E = (Reserva) s;
            System.out.println(this.getNome() + " você recebeu uma notificação... A sala " + E.getSala().getNome()
                    + " está livre nos seguintes horários: " + E.getHorarioInicio() + " - " + E.getHorarioFim()
                    + ". Deseja reservá-la?");
        }
    }
}
