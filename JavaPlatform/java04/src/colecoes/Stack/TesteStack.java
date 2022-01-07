package colecoes.Stack;

import java.util.Stack;

//TesteStack - Pilha Sistema LIFO - último a entrar, primeiro a sair.
public class TesteStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack<String> stackS = new Stack<String>();

		stackS.push("a");
		stackS.push("b");
		stackS.push("c");
		stackS.push("d");
		stackS.push("e");

		int tamanho = stackS.size();

		for (int i = 0; i < tamanho; i++) {
			System.out.println("stack " + i + ": " + stackS.pop());
		}

	}

}

//Stack – Esta classe permite a inclusão de elementos que são colocados em uma pilha.
// O elemento junta-se à pilha no topo e sai dela também a partir do topo.
// A Stack usa o sistema LIFO (last-in first-out), ou seja, “último a entrar, primeiro a sair”