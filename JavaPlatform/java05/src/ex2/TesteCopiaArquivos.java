package ex2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteCopiaArquivos {

	//Teste IO - Input Output Arquivos - interface FileVisitor
	public static void main(String[] args) {

		try {
			
			Path origem = Paths.get("C:\\Users\\flavi\\Downloads\\download.pdf");
			Path destino = Paths.get("C:\\Users\\flavi\\Downloads\\copia");
			Files.walkFileTree(origem, new CopiarArquivos(destino));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
