package projGerenciaConsultas;

// Classe criada para agendamento e gerenciamento de consultas
public class Consulta {
	//Declaração de variáveis
	Paciente paciente; //Utilização do Objeto paciente para termos acesso as variáveis e funções
	String data;
	String hora;
	Medico medico;  //Utilização do Objeto paciente para termos acesso as variáveis e funções

	public Consulta(Paciente paciente, String data, String hora, Medico medico) {

		this.paciente = paciente;
		this.data = data;
		this.hora = hora;
		this.medico = medico;
	}
	
	// Gets & Sets

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	// public String toString() {
	// String s = "\n" +
	// "| Data: " + this.data + " Hora: " + this.hora +
	// " | Paciente: " + this.paciente.getNome() + // pega o nome do paciente da
	// consulta
	// " | MÃ©dico: " + this.medico.getNome() + " |"; // pega o nome do medico da
	// consulta
	//
	// return s;
	// }

}
