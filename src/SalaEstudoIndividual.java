class SalaEstudoIndividual extends Sala {
	public SalaEstudo(String nome) {
        super(nome);
    }

    @Override
    void exibirInfo() {
        System.out.println("Sala de estudo: " + nome);
    }
}