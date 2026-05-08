// Obs.: Criar Atributo para Lista de Salas Interessadas !!! (TALVEZ)

public class Aluno implements Observer{
    // Atributos da Classe Aluno
    private String nome;
    private String RA;

    // Método Construtor da Classe Aluno:
    public Aluno(String nome, String RA) {
        this.setNome(nome);
        this.setRA(RA);
    }

    // #region Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getRA() {
        return this.RA;
    }
    // #endregion

    // Método de Update do Observer
    public void update(Subject s) {
    }
}
