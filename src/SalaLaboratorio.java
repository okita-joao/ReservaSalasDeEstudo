class SalaLaboratorio extends Sala {
    private int quantidadeComputadores;

    public SalaLaboratorio(
            String nome,
            int capacidade,
            int quantidadeComputadores) {

        super(nome, capacidade);

        this.quantidadeComputadores =
                quantidadeComputadores;
    }

    @Override
    void exibirInfo() {
        System.out.println(
                "Sala laboratório: " + nome
                + " | Capacidade: " + capacidade
                + " | Computadores: "
                + quantidadeComputadores
        );
    }
}