# TP2 - Estruturas de Dados

Trabalho acadêmico da disciplina **Programação III (2025.1)** cujo objetivo é analisar o desempenho de operações em diferentes **implementações do TAD Dicionário** (`insert`, `lookup`, `remove`).  

O projeto compara o tempo de execução de operações básicas em múltiplas estruturas de dados, permitindo observar na prática como a escolha da estrutura impacta a eficiência do programa.

---

## 📂 Estrutura do Projetosrc/
├── app/
│ └── Main.java # Ponto de entrada da aplicação
├── model/
│ └── Book.java # Classe de modelo (representa livros usados nos testes)
├── controller/
│ ├── Benchmark.java # Executa benchmarks das operações
│ ├── DataValidator.java # Valida dados de entrada
│ ├── TestBenchmark.java # Classe de testes para benchmark
│ ├── TestGenerator.java # Geração de dados de teste
│ ├── TimeFormatter.java # Formata tempos medidos
│ ├── testDataValidator.java # Testes do validador de dados
│ └── structures/
│ ├── Cell.java # Estrutura de célula para listas encadeadas
│ ├── Dictionary.java # Interface do TAD Dicionário
│ ├── stock/
│ │ ├── Stock.java # Estrutura de dicionário baseada em "estoque"
│ │ └── testStock.java # Testes da estrutura Stock
│ └── circularLinkedList/
│ ├── CircularLinkedList.java # Implementação usando lista circular
│ └── TestCircularLinkedList.java # Testes da lista circular

## 🧩 Classes Principais

- **`Dictionary<T>`**: Interface que define as operações básicas do TAD Dicionário.
- **`CircularLinkedList<T>`**: Implementação do dicionário usando lista encadeada circular.
- **`Stock<T>`**: Estrutura alternativa que também implementa o dicionário.
- **`Benchmark`**: Responsável por medir o tempo de execução das operações nas diferentes implementações.
- **`Book`**: Modelo utilizado nos testes para simular registros.
- **`Main`**: Classe principal que inicializa e executa os experimentos.

---

## ⚙️ Como Executar

### Pré-requisitos
- **Java 17+** (ou versão compatível definida pelo professor).
- IntelliJ IDEA ou outra IDE de sua preferência.

### Passos
1. Clone o repositório ou extraia os arquivos: git clone <url-do-repo> ou apenas extraia o .zip.

2. Abra o projeto em sua IDE.

3. Compile e execute a classe principal: src/app/Main.java

4. Siga as instruções para inserir dados

5. Os resultados dos benchmarks serão exibidos no console

O programa gera tempos de execução para cada operação (insert, lookup, remove) em cada estrutura de dados.
Esses valores permitem uma comparação prática entre as diferentes implementações do TAD Dicionário
