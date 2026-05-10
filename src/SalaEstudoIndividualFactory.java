class SalaEstudoIndividualFactory extends SalaFactory {
    @Override
    public Sala criarSala(
            String nome,
            int capacidade) {

        return new SalaEstudoIndividual(
                nome,
                capacidade,
                true
        );
    }
}