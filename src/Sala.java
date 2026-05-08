abstract class Sala {
    protected String nome;

    public Sala(String nome) {
        this.nome = nome;
    }

    abstract void exibirInfo();
}