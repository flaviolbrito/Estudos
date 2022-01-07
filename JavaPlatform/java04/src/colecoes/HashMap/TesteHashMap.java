package colecoes.HashMap;

import java.util.HashMap;
import java.util.Map;

//Teste HashMap - mapeamento de objetos no esquema chave/valor para pesquisa
public class TesteHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> nomes = new HashMap<>();

		nomes.put(1, "Maria");
		nomes.put(2, "José");
		nomes.put(3, "Henrique");
		nomes.put(4, "Matias");
		nomes.put(5, "Nascimento");
		nomes.put(6, "Maria");

		System.out.println(nomes);
		System.out.println(nomes.get(2));

	}

}
