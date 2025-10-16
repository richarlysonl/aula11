import java.util.Scanner;
import java.util.Stack;

public class Num2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();
        Stack<Integer> aux = new Stack<>();

        // Preenche a pilha com alguns valores de exemplo
        for (int i = 1; i <= 5; i++) {
            pilha.push(i);
        }

        System.out.println("Pilha original: " + pilha);
        System.out.print("Digite o valor que deseja remover: ");
        int c = sc.nextInt();

        // Desempilha para pilha auxiliar até encontrar o item
        while (!pilha.isEmpty()) {
            int topo = pilha.pop();
            if (topo != c) {
                aux.push(topo);
            }
        }

        // Retorna os itens para a pilha original
        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }

        System.out.println("Pilha após remoção: " + pilha);
        sc.close();
    }
}
