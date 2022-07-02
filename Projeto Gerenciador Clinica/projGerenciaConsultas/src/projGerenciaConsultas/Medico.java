package projGerenciaConsultas;

// Classe para o cadastro de médico
public class Medico extends Pessoa {
//Declaração de variaveis para classe Médico que extende pessoas
	String CRM;
	String especialidade;

	public Medico(String nome, String CPF, int idade, String CRM, String especialidade) {
		super(nome, CPF, idade); //Variaveis vinda da Herança
		this.CRM = CRM;
		this.especialidade = especialidade;
	}
	
	// Gets & Sets 

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
