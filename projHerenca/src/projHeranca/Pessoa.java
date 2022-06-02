package projHeranca;

public abstract class Pessoa {
	
	String nome;
	int idade;
	
	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public abstract String info();
//		String s = String.format ("Nome: %s Idade: %d", this.nome, this.idade);
//	return s;
	
	
}
