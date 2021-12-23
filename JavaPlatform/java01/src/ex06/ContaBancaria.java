package ex06;

public class ContaBancaria {
// Teste IDE Intellij / Eclipse
	// atributos
	private String titular;
	private double saldo;

	// métodos
	public void saque(double valor){
		saldo -= valor;
	}
	
	public void deposita(double valor){
		saldo += valor;
	}
	
	// getters / setters
	public String getTitular() {
		return titular;
	}

	//Exemplo usando o this
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo(){
		return saldo;
	}

}
