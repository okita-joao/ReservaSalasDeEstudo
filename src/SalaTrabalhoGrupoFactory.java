class SalaTrabalhoGrupoFactory extends SalaFactory {
    @Override
    public Sala criarSala(
            String nome,
            int capacidade) {

        return new SalaTrabalhoGrupo(
                nome,
                capacidade,
                true
        );
    }
}