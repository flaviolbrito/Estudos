package ex03;

public class Cliente {
	String numeroRG, numeroCPF, nome, endereco;

	// herança de construtores
	public Cliente() {
		super();
	}

	//Sobrecarga de Construtores
	public Cliente(String numeroRG) {
		super();
		this.numeroRG = numeroRG;
	}

	public Cliente(String numeroRG, String numeroCPF, String nome, String endereco) {
		super();
		this.numeroRG = numeroRG;
		this.numeroCPF = numeroCPF;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	
}
