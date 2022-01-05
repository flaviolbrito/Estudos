package colecoes.ArrayList;

import java.util.ArrayList;

public class TesteArrayList {

	/**
	 * @param args
	 */
	// Teste ArrayList - listaString
	public static void main(String[] args) {

		ArrayList<String> listaString = new ArrayList<String>();

		listaString.add("a");
		listaString.add("b");
		listaString.add("c");
		listaString.add("d");
		listaString.add("teste XX");

		for (int i = 0; i < listaString.size(); i++) {
			System.out.println("listaString " + i + ": " + listaString.get(i));
		}
		System.out.println("Total Lista: " + listaString.size());
	}

}
