class SalaEstudoIndividual extends Sala {
    private boolean isolamentoAcustico;

    public SalaEstudoIndividual(
            String nome,
            int capacidade,
            boolean isolamentoAcustico) {

        super(nome, capacidade);

        this.isolamentoAcustico = isolamentoAcustico;
    }

    @Override
    void exibirInfo() {
        System.out.println(
                "Sala de estudo individual: " + nome
                + " | Capacidade: " + capacidade
                + " | Isolamento acústico: "
                + isolamentoAcustico
        );
    }
}