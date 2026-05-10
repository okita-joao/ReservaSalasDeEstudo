class SalaAulaTeoricaFactory extends SalaFactory {
    @Override
    public Sala criarSala(
            String nome,
            int capacidade) {

        return new SalaAulaTeorica(
                nome,
                capacidade,
                true
        );
    }
}