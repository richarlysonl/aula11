import java.util.Scanner;
import java.util.Stack;

public class Num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();

        System.out.print("Digite uma sequência de caracteres: ");
        String texto = sc.nextLine();

        // Empilhar todos os caracteres
        for (char c : texto.toCharArray()) {
            pilha.push(c);
        }

        // a) Imprimir texto na ordem inversa
        System.out.print("Texto invertido: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }

        // b) Verificar se é palíndromo (ignorando espaços e pontos)
        String filtrado = texto.replaceAll("[ .]", "").toLowerCase();
        String invertido = new StringBuilder(filtrado).reverse().toString();

        if (filtrado.equals(invertido)) {
            System.out.println("\nÉ um palíndromo!");
        } else {
            System.out.println("\nNão é um palíndromo.");
        }

        sc.close();
    }
}
