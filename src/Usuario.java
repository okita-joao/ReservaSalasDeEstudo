public abstract class Usuario implements Observer {
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
}
