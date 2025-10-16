import java.util.*;

public class Num6 {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numeros.add(random.nextInt(1000) + 1);
            numeros.add(-(random.nextInt(1000) + 1));
        }

        Collections.shuffle(numeros);

        fila.addAll(numeros);

        while (!fila.isEmpty()) {
            int numero = fila.peek();

            if (numero > 0) {

                pilha.push(fila.poll());
            } else {
                fila.poll(); 
                if (!pilha.isEmpty()) {
                    System.out.println("Desempilhado: " + pilha.pop());
                } else {
                    System.out.println("Pilha vazia. Nada a desempilhar.");
                }
            }
        }
    }
}
