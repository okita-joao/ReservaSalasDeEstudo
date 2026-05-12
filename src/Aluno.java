// Obs.: Criar Atributo para Lista de Salas Interessadas !!! (TALVEZ)

public class Aluno extends Usuario {
    // Atributos da Classe Aluno
    private String RA;

    // Método Construtor da Classe Aluno:
    public Aluno(String nome, String RA) {
        super(nome);
        this.setRA(RA);
    }

    // #region Getters e Setters
    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getRA() {
        return this.RA;
    }
    // #endregion
}
