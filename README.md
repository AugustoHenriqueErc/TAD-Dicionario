# TP2 - Estruturas de Dados

## Objetivo
Este projeto faz parte da disciplina **Programação III (2025.03)** e tem como objetivo comparar o desempenho de diferentes implementações do **TAD Dicionário**, medindo o tempo de execução das operações fundamentais:

- Inserção de chave-valor
- Consulta por chave
- Remoção de chave

## Estruturas de Dados Implementadas
O TAD Dicionário foi implementado utilizando diferentes estruturas de dados, a fim de analisar vantagens e desvantagens de cada abordagem:

- **Lista Duplamente Encadeada Circular**
- **Árvore Binária**
- **Árvore AVL**

## Funcionalidades
O sistema permite:
- Realizar testes de inserção, busca e remoção de N elementos dentro das estruturas de dados.
- Medir o tempo de execução de cada operação em diferentes estruturas.
- Comparar os resultados de desempenho.

## Estrutura do Projeto
- `src/` → Código-fonte Java
- `README.md` → Documentação do projeto
- `TP2 - Estruturas de Dados.pdf` → Especificação completa do trabalho
- `notes.tp2.xopp` → Anotações do projeto
- `out/` → Saída de compilação

```
├── app/
│   └── Main.java                  # Ponto de entrada da aplicação
├── controller/
│   ├── Benchmark.java              # Executa benchmarks das operações
│   ├── DataValidator.java          # Valida dados de entrada
│   └── TestGenerator.java          # Geração de testes de inserção, busca e remoção
├── model.structures/
│   ├── avlTree/
│   │   ├── AVLTree.java            # Implementação usando árvore AVL
│   │   ├── Node.java               # Nó da árvore AVL
│   │   └── testAVLTree.java        # Teste da árvore AVL
│   ├── circularLinkedList/
│   │   ├── CircularLinkedList.java # Implementação usando lista circular
│   │   ├── TestCircularLinkedList.java # Testes da lista circular
│   │   └── Cell.java               # Célula implementada pela lista circular
│   ├── tree/
│   │   ├── BinaryTree.java         # Implementação usando árvore binária
│   │   ├── Leaf.java               # Nó folha da árvore binária
│   │   └── testBinaryTree.java     # Teste da árvore Binária
│   └── Dictionary.java             # Interface implementada pelas estruturas de dados
```

## Como Executar
1. Clone este repositório
   ```bash
   git clone https://github.com/AugustoHenriqueErc/TAD-Dicionario.git
2. Compile o projeto no IntelliJ IDEA ou utilizando o javac
    ```bash
    javac -d out src/*/*/*.java
3. Execute a aplicação
    ```bash
    java src/app/Main.java
