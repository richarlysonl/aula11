
public class Num10 {

    public static int potencia(int a, int b) {
        // Caso base
        if (b == 0) {
            return 1;
        } else {
            return a * potencia(a, b - 1);
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        int resultado = potencia(a, b);
        System.out.println(a + " elevado a " + b + " = " + resultado);
    }
}
