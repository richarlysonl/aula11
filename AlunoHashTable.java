public class AlunoHashTable {

    // ─── Classe Aluno ────────────────────────────────────────────────────────
    public static class Aluno {
        private String nome;
        private String curso;
        private int    idade;

        public Aluno(String nome, String curso, int idade) {
            this.nome  = nome;
            this.curso = curso;
            this.idade = idade;
        }

        public String getNome()  { return nome;  }
        public String getCurso() { return curso; }
        public int    getIdade() { return idade; }

        @Override
        public String toString() {
            return "Aluno{nome='" + nome + "', curso='" + curso + "', idade=" + idade + "}";
        }
    }

    // ─── Nó da lista encadeada (encadeamento separado) ───────────────────────
    private static class Node {
        String chave;
        Aluno  aluno;
        Node   proximo;

        Node(String chave, Aluno aluno) {
            this.chave    = chave;
            this.aluno    = aluno;
            this.proximo  = null;
        }
    }

    // ─── Atributos da tabela ─────────────────────────────────────────────────
    private static final int    CAPACIDADE_INICIAL = 16;
    private static final double FATOR_DE_CARGA     = 0.75;

    private Node[] tabela;
    private int    tamanho;      // quantidade de elementos armazenados
    private int    capacidade;   // tamanho atual do array

    // ─── Construtor ──────────────────────────────────────────────────────────
    public AlunoHashTable() {
        this.capacidade = CAPACIDADE_INICIAL;
        this.tabela     = new Node[capacidade];
        this.tamanho    = 0;
    }

    // ─── Composição da chave ─────────────────────────────────────────────────
    private String buildKey(String nome, String curso, int idade) {
        return nome + curso + idade;
    }

    // ─── Função hash personalizada ───────────────────────────────────────────
    private int hashFunction(String key, int tableSize) {
        long hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash + key.charAt(i);
        }
        return (int) (Math.abs(hash) % tableSize);
    }

    // ─── put ─────────────────────────────────────────────────────────────────
    public void put(String nome, String curso, int idade, Aluno aluno) {
        // Redimensiona antes de inserir se necessário
        if ((double)(tamanho + 1) > capacidade * FATOR_DE_CARGA) {
            redimensionar();
        }

        String chave  = buildKey(nome, curso, idade);
        int    indice = hashFunction(chave, capacidade);

        Node atual = tabela[indice];

        // Percorre a lista do bucket procurando chave duplicada
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                atual.aluno = aluno; // atualiza se já existe
                return;
            }
            atual = atual.proximo;
        }

        // Insere novo nó no início da lista (O(1))
        Node novo = new Node(chave, aluno);
        novo.proximo  = tabela[indice];
        tabela[indice] = novo;
        tamanho++;
    }

    // ─── get ─────────────────────────────────────────────────────────────────
    public Aluno get(String nome, String curso, int idade) {
        String chave  = buildKey(nome, curso, idade);
        int    indice = hashFunction(chave, capacidade);

        Node atual = tabela[indice];
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return atual.aluno;
            }
            atual = atual.proximo;
        }
        return null; // não encontrado
    }

    // ─── remove ──────────────────────────────────────────────────────────────
    public boolean remove(String nome, String curso, int idade) {
        String chave  = buildKey(nome, curso, idade);
        int    indice = hashFunction(chave, capacidade);

        Node atual    = tabela[indice];
        Node anterior = null;

        while (atual != null) {
            if (atual.chave.equals(chave)) {
                if (anterior == null) {
                    tabela[indice] = atual.proximo; // era o primeiro nó
                } else {
                    anterior.proximo = atual.proximo;
                }
                tamanho--;
                return true;
            }
            anterior = atual;
            atual    = atual.proximo;
        }
        return false; // chave não encontrada
    }

    // ─── containsKey ─────────────────────────────────────────────────────────
    public boolean containsKey(String nome, String curso, int idade) {
        return get(nome, curso, idade) != null;
    }

    // ─── size ────────────────────────────────────────────────────────────────
    public int size() {
        return tamanho;
    }

    // ─── isEmpty ─────────────────────────────────────────────────────────────
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // ─── clear ───────────────────────────────────────────────────────────────
    public void clear() {
        tabela    = new Node[capacidade];
        tamanho   = 0;
    }

    // ─── Redimensionamento ───────────────────────────────────────────────────
    private void redimensionar() {
        int    novaCapacidade = capacidade * 2;
        Node[] novaTabela     = new Node[novaCapacidade];

        // Reinsere todos os elementos recalculando os índices
        for (int i = 0; i < capacidade; i++) {
            Node atual = tabela[i];
            while (atual != null) {
                Node proximo  = atual.proximo;          // guarda o próximo antes de mover
                int  novoIdx  = hashFunction(atual.chave, novaCapacidade);

                // Insere no início do novo bucket
                atual.proximo     = novaTabela[novoIdx];
                novaTabela[novoIdx] = atual;

                atual = proximo;
            }
        }

        tabela    = novaTabela;
        capacidade = novaCapacidade;
    }

    // ─── toString (diagnóstico) ───────────────────────────────────────────────
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlunoHashTable [tamanho=").append(tamanho)
          .append(", capacidade=").append(capacidade).append("]\n");

        for (int i = 0; i < capacidade; i++) {
            if (tabela[i] != null) {
                sb.append("  bucket[").append(i).append("]: ");
                Node atual = tabela[i];
                while (atual != null) {
                    sb.append("[").append(atual.chave).append(" -> ").append(atual.aluno).append("]");
                    if (atual.proximo != null) sb.append(" -> ");
                    atual = atual.proximo;
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
