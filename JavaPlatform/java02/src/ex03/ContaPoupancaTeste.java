package ex03;

public class ContaPoupancaTeste {

    public static void main(String[] args) {

        Cliente c2 = new Cliente();
        c2.nome = "Marta Tereza";
        c2.numeroRG = "12.123.124-4";
        c2.numeroCPF = "123.123.124-48";
        c2.endereco = "Av. Santo Antonio, 123";

        ContaPoupanca cp1 = new ContaPoupanca(c2.nome, c2.endereco,c2.numeroCPF);
        cp1.saque(100);
        System.out.println("Cliente: " + c2.nome +" " + c2.numeroCPF + " " + c2.endereco);
        System.out.println("Saque: " + cp1.saldo);
    }
}
