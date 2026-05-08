class SalaAulaTeorica extends Sala {
	public SalaAulaTeorica(String nome) {
        super(nome);
    }

    @Override
    void exibirInfo() {
        System.out.println("Sala de aula teórica: " + nome);
    }
}