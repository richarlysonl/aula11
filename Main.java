import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoHashTable tabela = new AlunoHashTable();
        System.out.println("Sistema de Gestão de Alunos");
        int opcao;
        do {
            exibirMenu();
            System.out.print("Opção: ");
            opcao = lerInt(sc);
            switch (opcao) {
                case 1:
                    inserirAluno(sc, tabela);
                    break;
                case 2:
                    buscarAluno(sc, tabela);
                    break;
                case 3:
                    removerAluno(sc, tabela);
                    break;
                case 4:
                    verificarChave(sc, tabela);
                    break;
                case 5:
                    System.out.println("\nTotal de alunos: " + tabela.size());
                    break;
                case 6:
                    System.out.println("\nTabela vazia: " + tabela.isEmpty());
                    break;
                case 7:
                    limparTabela(sc, tabela);
                    break;
                case 8:
                    System.out.println("\n" + tabela);
                    break;
                case 0:
                    System.out.println("\nEncerrando. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
    private static void exibirMenu() {
        System.out.println(" 1. Inserir / Atualizar aluno (put)");
        System.out.println(" 2. Buscar aluno (get)");
        System.out.println(" 3. Remover aluno (remove)");
        System.out.println(" 4. Verificar se chave existe (containsKey)");
        System.out.println(" 5. Quantidade de alunos (size)");
        System.out.println(" 6. Tabela está vazia? (isEmpty)");
        System.out.println(" 7. Limpar tabela (clear)");
        System.out.println(" 8. Exibir tabela completa");
        System.out.println(" 0. Sair");
    }
    private static void inserirAluno(Scanner sc, AlunoHashTable tabela) {
        System.out.println("\n[ Inserir / Atualizar Aluno ]");
        String nome  = lerString(sc, "Nome  : ");
        String curso = lerString(sc, "Curso : ");
        int    idade = lerIdade(sc);
        AlunoHashTable.Aluno aluno = new AlunoHashTable.Aluno(nome, curso, idade);
        boolean jaExistia = tabela.containsKey(nome, curso, idade);
        tabela.put(nome, curso, idade, aluno);
        if (jaExistia) {
            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Aluno inserido com sucesso. Total: " + tabela.size());
        }
    }
    private static void buscarAluno(Scanner sc, AlunoHashTable tabela) {
        System.out.println("\n[ Buscar Aluno ]");
        String nome  = lerString(sc, "Nome  : ");
        String curso = lerString(sc, "Curso : ");
        int    idade = lerIdade(sc);
        AlunoHashTable.Aluno aluno = tabela.get(nome, curso, idade);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
    private static void removerAluno(Scanner sc, AlunoHashTable tabela) {
        System.out.println("\n[ Remover Aluno ]");
        String nome  = lerString(sc, "Nome  : ");
        String curso = lerString(sc, "Curso : ");
        int    idade = lerIdade(sc);

        boolean removido = tabela.remove(nome, curso, idade);
        if (removido) {
            System.out.println("Aluno removido com sucesso. Total: " + tabela.size());
        } else {
            System.out.println("Aluno não encontrado. Nada foi removido.");
        }
    }
    private static void verificarChave(Scanner sc, AlunoHashTable tabela) {
        System.out.println("\n[ Verificar Chave ]");
        String nome  = lerString(sc, "Nome  : ");
        String curso = lerString(sc, "Curso : ");
        int    idade = lerIdade(sc);

        boolean existe = tabela.containsKey(nome, curso, idade);
        System.out.println(existe ? "Chave ENCONTRADA na tabela." : "Chave NÃO encontrada na tabela.");
    }
    private static void limparTabela(Scanner sc, AlunoHashTable tabela) {
        System.out.print("\nConfirma limpeza total da tabela? (s/n): ");
        String resp = sc.nextLine().trim();
        if (resp.equalsIgnoreCase("s")) {
            tabela.clear();
            System.out.println("Tabela limpa com sucesso.");
        } else {
            System.out.println("Operação cancelada.");
        }
    }
    private static String lerString(Scanner sc, String prompt) {
        String valor = "";
        while (valor.isEmpty()) {
            System.out.print(prompt);
            valor = sc.nextLine().trim();
            if (valor.isEmpty()) System.out.println("  Campo obrigatório. Digite um valor.");
        }
        return valor;
    }
    private static int lerIdade(Scanner sc) {
        while (true) {
            System.out.print("Idade : ");
            String linha = sc.nextLine().trim();
            try {
                int idade = Integer.parseInt(linha);
                if (idade > 0) return idade;
                System.out.println("  Idade deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("  Idade inválida. Digite um número inteiro.");
            }
        }
    }
    private static int lerInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

