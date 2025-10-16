import java.util.*;

public class Num7 {
    public static void inverterFila(Queue<Integer> fila) {
        Stack<Integer> pilha = new Stack<>();

        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }
        while (!pilha.isEmpty()) {
            fila.offer(pilha.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        for (int i = 1; i <= 20; i++) {
            fila.offer(i);
        }
        System.out.println("Fila original: " + fila);
        inverterFila(fila);
        System.out.println("Fila invertida: " + fila);
    }
}

