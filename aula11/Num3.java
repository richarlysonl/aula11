
import java.util.*;

class Aviao {
    String nome;
    int id;

    Aviao(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String toString() {
        return nome + " (ID: " + id + ")";
    }
}

public class Num3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Aviao> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("\n=== Controle de Pista de Decolagem ===");
            System.out.println("1) Listar número de aviões na fila");
            System.out.println("2) Autorizar decolagem do primeiro avião");
            System.out.println("3) Adicionar avião à fila");
            System.out.println("4) Listar todos os aviões na fila");
            System.out.println("5) Listar características do primeiro avião");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Aviões na fila: " + fila.size());
                    break;
                case 2:
                    if (!fila.isEmpty())
                        System.out.println("Decolou: " + fila.poll());
                    else
                        System.out.println("Nenhum avião na fila!");
                    break;
                case 3:
                    System.out.print("Nome do avião: ");
                    String nome = sc.nextLine();
                    System.out.print("ID do avião: ");
                    int id = sc.nextInt();
                    fila.add(new Aviao(nome, id));
                    System.out.println("Avião adicionado à fila!");
                    break;
                case 4:
                    if (fila.isEmpty())
                        System.out.println("Fila vazia!");
                    else
                        for (Aviao a : fila) System.out.println(a);
                    break;
                case 5:
                    if (!fila.isEmpty())
                        System.out.println("Primeiro da fila: " + fila.peek());
                    else
                        System.out.println("Fila vazia!");
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
