package ex03;

class FatorialLong {

    public static void main(String[] args) {
        long fatorial = 1;
        int fim = 10;
        for (int n = 1; n <=fim; n++){
            fatorial *= n;
            System.out.println("numero: " + n + " " + "fatorial :" + fatorial);
        }
        System.out.println("quantidade de loop:" + fim );
    }

}
