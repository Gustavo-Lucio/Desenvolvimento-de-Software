package projHeranca;

public class Medico extends Pessoa{

	String CRM;
	String spec;
	
	public Medico(String nome, int idade, String CRM, String spec) {
		super(nome, idade);
		this.CRM = CRM;
		this.spec = spec;
	}
	public String info() {
		String s = String.format ("Nome: Doutor %s \nIdade: %d, \nCRM: %s, \nEspecialidade: %s\n", this.nome, this.idade, this.CRM, this.spec);
	return s;
	}
	
}
