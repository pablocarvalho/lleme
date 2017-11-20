package uff.ic.lleme.tic10002.trabalhos.s20171.emanuelmachado;

/*

Universidade Federal Fluminense - UFF
Instituto de Computação - IC
TIC10002 - Estrutura de Dados e Algorítmos

Aluno: Emanuel Antunes Machado

Abaixo estão as justificativas para a utilização de cada estrutura de dados utilizada neste trabalho.

1. Árvore AVL (por ano_mes) - Árvore de Listas Encadeadas

A árvore AVL é uma árvore de busca binária autobalanceada e as operações de busca
de elementos possui a complexidade O(logn), onde n é o número de elementos da árvore.
Nesta estrutura de dados, a diferença entre alturas das subárvores não é maior do que um.

Esta estrutura de dados foi escolhida para atender à pesquisa entre intervalos,
pois é necessário o balanceamento da estrutura para evitar que a inclusão de nós seja feita
sempre em uma única direção, visto que as datas de uma filial podem obedecer a uma ordem crescente.
Sem este balanceamento, cada inclusão de novo nó, no pior caso, acrescentaria mais um nível na árvore,
ou seja, aumentando a altura e, consequentemente, prejudicando a busca.

2. Tabela Hash (por filial) - Tabela Hash de Listas Encadeadas

A tabela Hash foi utilizada para atender à pesquisa por chaves de filiais, pois,
independente do número de chaves da tabela, o acesso a qualquer uma delas é
direto fazendo com que o tempo de busca seja constante O(1), caso não hajam
colisões em todas as inclusões.

3. Lista Encadeada

A estrutura de dados Lista Encadeada foi utilizada para guardar as vendas, pois:

- Todos os elementos da lista precisam ser consultados para a soma de vendas;
- A ordenação e a prioridade das vendas não são relevantes para atender às buscas propostas;
- Não se sabe exatamente quantas vendas uma filial realiza;
- A armazenagem em memória da lista é exatamente de acordo com o tamanho de todas as entradas;
- A inclusão de uma nova venda pode ser feita no final da lista, sem a necessidade ordenação.

Porque não uma "Árvore (por ano_mes) de Hashes (por filial)"?

Em relação ao Hash, poderia haver grande desperdício de memória com posições vazias.
Cada nó da árvore conteria uma tabela com n posições, mesmo se existir apenas uma venda.

Porque não um "Hash (por filial) de Árvores (por ano_mes)"?

Em relação as árvores, esse tipo de estrutura de dados requer uma grande quantidade de
memória para seu armazenamento. Cada índice (chave) da tabela hash conteria uma árvore.


 */
import java.io.FileNotFoundException;

public class TrabalhoEmanuel {

    public static void main(String[] args) throws FileNotFoundException {

        // Instancia as vendas, carregando-as nas estruturas em Árvore e Hash
        Vendas vendas = new Vendas();

        System.out.println("Total de vendas das filiais com códigos entre 10 e 20: R$ " + vendas.totalVenda(10, 20));
        System.out.println("Total de vendas das filiais com códigos entre 10 e 20 nos meses de Jan/17 até Jun/17: R$ " + vendas.totalVenda(10, 20, "201701", "201706"));
        System.out.println("Total de vendas de todas as filiais nos meses de Ago/17 até Out/17: R$ " + vendas.totalVenda("201708", "201710"));
    }

}
