package colecoes.Enumeration;

import java.util.Enumeration;
import java.util.Hashtable;

public class TesteEnumeration {

	/**
	 * @param args
	 */
	//TesteEnumeration - // Enumeration serve para andar sobre as coleções
	public static void main(String[] args) {

		Hashtable<Integer, String> nomes = new Hashtable<Integer, String>();

		nomes.put(1, "Maria"); // hash integer@492
		nomes.put(2, "José");
		nomes.put(3, "Henrique");
		nomes.put(4, "Matias");
		nomes.put(5, "Nascimento");
		nomes.put(6, "Maria");
		nomes.put(1, "Maria"); // hash integer@492

		System.out.println("Todos os nomes: " + nomes);
		System.out.println("Posicao 2: " + nomes.get(2));
         // Enumeration serve para andar sobre as coleções
		Enumeration<String> enumeracao = nomes.elements();

		while (enumeracao.hasMoreElements()) {
			System.out.println("Nome: " + enumeracao.nextElement());
		}

	}

}
