class SalaLaboratorioFactory extends SalaFactory {
    @Override
    public Sala criarSala(
            String nome,
            int capacidade) {

        return new SalaLaboratorio(
                nome,
                capacidade,
                30
        );
    }
}