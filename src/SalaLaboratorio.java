class SalaLaboratorio extends Sala {
	public SalaLaboratorio(String nome) {
        super(nome);
    }

    @Override
    void exibirInfo() {
        System.out.println("Sala laboratório: " + nome);
    }
}