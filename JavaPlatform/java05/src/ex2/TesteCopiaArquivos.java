package ex2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteCopiaArquivos {

	//Teste IO - Input Output Arquivos - interface FileVisitor - Copia arquivo
	public static void main(String[] args) {

		try {

			// Windows
			// Path origem = Paths.get("C:\\Users\\flavi\\Downloads\\slf4j-api-1.7.9.jar");
			// Path destino = Paths.get("C:\\Users\\flavi\\Downloads\\copia");

            //Mac
			Path origem = Paths.get("/Users/flaviolbrito/Downloads/slf4j-api-1.7.9.jar");
			Path destino = Paths.get("/Users/flaviolbrito/Downloads/copia");
			Files.walkFileTree(origem, new CopiarArquivos(destino));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
