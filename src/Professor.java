public class Professor extends Usuario {
    // Atributos da Classe Professor
    private String idProfessor;

    // Método Construtor da Classe Professor
    public Professor(String nome, String idProfessor) {
        super(nome);
        this.setIdProfessor(idProfessor);
    }

    // #region Getters e Setters
    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getIdProfessor() {
        return this.idProfessor;
    }
    // #endregion
}
