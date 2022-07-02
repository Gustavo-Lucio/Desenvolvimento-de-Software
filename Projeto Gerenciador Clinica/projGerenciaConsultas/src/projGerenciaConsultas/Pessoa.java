package projGerenciaConsultas;
//Classe pessoa (PAI) na herança
public abstract class Pessoa {
	//Declaração de variáveis
	String nome;
	String CPF;
	int idade;
	
	
	public Pessoa(String nome, String CPF, int idade) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
	}

	// Gets & Sets 
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String CPF) {
		CPF = CPF;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}
	

	
}
