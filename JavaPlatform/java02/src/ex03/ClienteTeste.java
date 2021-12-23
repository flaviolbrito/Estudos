package ex03;

public class ClienteTeste {

	public static void main(String[] args) {

		Cliente c1 = new Cliente();
		c1.nome = "Flavio Teste";
		c1.numeroRG = "29.444.231-5";
		c1.endereco = "Av Nova Orizonte, n.123";
		c1.numeroCPF = "264.781.194-21";

		System.out.println("cliente:  " + c1.nome + " "+ c1.numeroCPF + " "+  c1.numeroRG);
		System.out.println("Endereco: " + c1.endereco);

	}

}
