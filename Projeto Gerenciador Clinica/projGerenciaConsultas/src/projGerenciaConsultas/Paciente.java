package projGerenciaConsultas;

//Classe para o cadastro de paciente
public class Paciente extends Pessoa {
	// Declaração de variaveis para classe Paciente que extende pessoas
	String codigo;
	String historico;
	String CEP;
	String email;
	String telefone;

	public Paciente(String nome, String CPF, int idade, String codigo, String historico, String CEP, String email,
			String telefone) {
		super(nome, CPF, idade);
		this.codigo = codigo;
		this.historico = historico;
		this.CEP = CEP;
		this.email = email;
		this.telefone = telefone;
	}
	
	// Gets & Sets

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getHistorico() {
		return historico;
	}

	public void addHistorico(String entrada) {
		this.historico += "\n" + entrada;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		CEP = CEP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
