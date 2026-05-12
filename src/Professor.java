public class Professor implements Observer {
    // Atributos da Classe Professor
    private String nome;
    private String idProfessor;

    // Método Construtor da Classe Professor
    public Professor(String nome, String idProfessor) {
        this.setNome(nome);
        this.setIdProfessor(idProfessor);
    }

    // #region Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getIdProfessor() {
        return this.idProfessor;
    }
    // #endregion

    // Método do Update do Observer
    public void update(Subject s) {
        if (s instanceof Sala) {
            ((Sala) s).exibirInfo();
        }
    }
}
