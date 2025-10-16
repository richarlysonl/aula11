import java.util.Random;
import java.util.Stack;
public class Num8 {
    private Stack<Integer> pilhaPositivos = new Stack<>();
    private Stack<Integer> pilhaNegativos = new Stack<>();
    public void processarNumeros() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(201) - 100;

            if (numero > 0) {
                pilhaPositivos.push(numero);
            } else if (numero < 0) {
                pilhaNegativos.push(numero);
            } else {
                System.out.println("Número zero encontrado. Tentando desempilhar:");
                if (!pilhaPositivos.isEmpty()) {
                    System.out.println("Desempilhado de P (positivo): " + pilhaPositivos.pop());
                } else {
                    System.out.println("Pilha P (positivos) está vazia.");
                }

                if (!pilhaNegativos.isEmpty()) {
                    System.out.println("Desempilhado de N (negativo): " + pilhaNegativos.pop());
                } else {
                    System.out.println("Pilha N (negativos) está vazia.");
                }
                System.out.println("------");
            }
        }
        System.out.println("Elementos restantes na pilha de positivos (P): " + pilhaPositivos.size());
        System.out.println("Elementos restantes na pilha de negativos (N): " + pilhaNegativos.size());
    }

    public static void main(String[] args) {
        Num8 tp = new Num8();
        tp.processarNumeros();
    }
}
