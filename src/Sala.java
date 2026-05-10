abstract class Sala {
    protected String nome;
    protected int capacidade;
    protected boolean disponivel;

    public Sala(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        disponivel = false;
    }

    public void liberar() {
        disponivel = true;
    }

    abstract void exibirInfo();
}