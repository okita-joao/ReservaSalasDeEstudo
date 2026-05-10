class SalaAulaTeorica extends Sala {
    private boolean possuiProjetor;

    public SalaAulaTeorica(
            String nome,
            int capacidade,
            boolean possuiProjetor) {

        super(nome, capacidade);

        this.possuiProjetor = possuiProjetor;
    }

    @Override
    void exibirInfo() {
        System.out.println(
                "Sala de aula teórica: " + nome
                + " | Capacidade: " + capacidade
                + " | Projetor: " + possuiProjetor
        );
    }
}