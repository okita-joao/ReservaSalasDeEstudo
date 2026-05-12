public interface Reservar {
	public String executar(Sala sala, Usuario solicitante, LocalDate data, LocalTime inicio, LocalTime horarioFim);
}