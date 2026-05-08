class SalaTrabalhoGrupo extends Sala {
    public SalaTrabalhoGrupo(String nome) {
        super(nome);
    }

    @Override
    void exibirInfo() {
        System.out.println("Sala de trabalho: " + nome);
    }
}