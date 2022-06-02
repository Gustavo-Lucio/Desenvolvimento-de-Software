package projHeranca;

public class Paciente extends Pessoa{
	
	String identificacao;

	public Paciente(String nome, int idade, String identificacao) {
		super(nome, idade);
		this.identificacao = identificacao;
	}
	
	public String info() {
		String s = String.format ("Nome: Sr. %s \nIdade: %d \nIdentificação: %s\n", this.nome, this.idade, this.identificacao);
	return s;

	}

}	
