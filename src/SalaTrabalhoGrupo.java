class SalaTrabalhoGrupo extends Sala {
    private boolean possuiQuadro;

    public SalaTrabalhoGrupo(
            String nome,
            int capacidade,
            boolean possuiQuadro) {

        super(nome, capacidade);

        this.possuiQuadro = possuiQuadro;
    }

    @Override
    void exibirInfo() {
        System.out.println(
                "Sala de trabalho em grupo: " + nome
                + " | Capacidade: " + capacidade
                + " | Quadro: "
                + possuiQuadro
        );
    }
}