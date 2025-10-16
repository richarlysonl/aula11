import java.util.*;

public class Num5 {
    public static void main(String[] args) {
        Queue<Integer> F = new LinkedList<>();
        Stack<Integer> P = new Stack<>();
        Random r = new Random();

        for (int i = 0; i < 1000; i++) {
            int num = r.nextInt(1000); // números aleatórios de 0 a 999
            if (F.contains(num)) {
                P.push(num);
            } else {
                F.add(num);
            }
        }

        System.out.println("Fila F (sem repetidos): " + F);
        System.out.println("Pilha P (repetidos): " + P);
    }
}
