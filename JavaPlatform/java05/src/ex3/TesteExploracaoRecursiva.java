package ex3;

import java.nio.file.Files;
import java.nio.file.Paths;
// TesteExploracaoRecursiva - Lista Diretório e exibe todos os arquivos extensão ".java"
public class TesteExploracaoRecursiva {

	public static void main(String[] args) {

		try {
			// No Paths incluir o diretório desejado
			Files.list(Paths.get("E:\\teste")).filter(p -> p.toString().endsWith(".java"))
					.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
