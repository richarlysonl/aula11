import java.util.*;

public class Num4 {
    public static void main(String[] args) {
        Queue<Integer> F1 = new LinkedList<>();
        Queue<Integer> F2 = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();

        Random r = new Random();

        // Preenche F1 com 100 números aleatórios
        for (int i = 0; i < 100; i++) {
            F1.add(r.nextInt(1000));
        }

        System.out.println("Fila original (F1): " + F1);

        // Passa tudo pra pilha pra inverter
        while (!F1.isEmpty()) {
            pilha.push(F1.poll());
        }

        // Transfere da pilha para F2 (agora invertida)
        while (!pilha.isEmpty()) {
            F2.add(pilha.pop());
        }

        System.out.println("Fila invertida (F2): " + F2);
    }
}
