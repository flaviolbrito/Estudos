package ex03;

public class ContaBancariaTeste {

    public static void main(String[] args) {

        Cliente c1 = new Cliente();
        c1.nome = "Flavio Teste";
        c1.numeroRG = "29.444.231-5";
        c1.endereco = "Av Nova Orizonte, n.123";
        c1.numeroCPF = "264.781.194-21";

       ContaBancaria cb1 = new ContaBancaria(c1.nome,c1.endereco,c1.numeroCPF);
        System.out.println("Conta criada: " + cb1.nomeCliente + " " + cb1.cpfCliente);
        System.out.println("Conta criada: " + cb1.endCliente + " " + cb1.saldo);
        cb1.deposita(100);
        cb1.saque(50);
        cb1.deposita(10);
        System.out.println("Saldo final: " + cb1.saldo);
    }


}
