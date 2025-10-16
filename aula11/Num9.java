public class Num9 {

    public static int somaLista(int[] lista, int indice) {
        if (indice >= lista.length) {
            return 0;
        } else {
            return lista[indice] + somaLista(lista, indice + 1);
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4};
        int soma = somaLista(numeros, 0);
        System.out.println("Soma: " + soma);
    }
}
