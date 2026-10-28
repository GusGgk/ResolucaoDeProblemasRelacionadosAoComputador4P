# Resolução de Problemas Relacionados ao Computador - 4º Período

Este repositório contém as implementações, listas de exercícios, trabalhos (TDEs) e provas desenvolvidas durante a disciplina de **Resolução de Problemas Estruturados (Estrutura de Dados)** do 4º período do curso de Engenharia de Software na **PUCPR**.

Todo o código foi desenvolvido em **Java**, com foco em lógica algorítmica e criação de estruturas de dados do zero.

---

## 📚 Tópicos Abordados

- **RA1 (1º Bimestre):** Listas Encadeadas (Simples, Duplas, Circulares), Pilhas (Stacks) e Filas (Queues).
- **RA2 (2º Bimestre):** Árvores Binárias de Busca (BST) e algoritmos práticos.

---

## 📂 Estrutura do Repositório (Código-Fonte)

Abaixo está a organização principal da pasta `src/`, dividida pelos bimestres da disciplina:

```text
📦 src
 ┣ 📜 Main.java
 ┃
 ┣ 📂 RA1 (Pilhas, Filas e Listas Encadeadas)
 ┃ ┣ 📂 CancelamentoPet / CantinhoSeguro / PatinhasLimpas / Passarinhos (Aplicações práticas de estruturas)
 ┃ ┣ 📂 ExerciciosFilasEPilhas (Deques, Filas Circulares e Pilhas)
 ┃ ┣ 📂 ListadeExercicios (Variações de Listas Simples e Duplamente Encadeadas)
 ┃ ┗ 📂 TDE1 (Trabalho de Destaque)
 ┃    ┗ 💡 Algoritmo Flood Fill utilizando Pilha e Fila, com geração de imagens e GIFs (animacao_fila.gif, animacao_pilha.gif).
 ┃
 ┗ 📂 RA2 (Árvores Binárias)
   ┣ 📂 ExerciciosDesafio (Ex: CatalogoPlanetas)
   ┣ 📂 ListaExerciciosArvoreBinaria e ListaExerciciosArvoreBinaria2 (Implementações de BST)
   ┣ 📂 SimuladoProva
   ┗ 📂 PROVA (Projeto Doceria)
(Nota: Diretórios de build como out/, configurações da IDE .idea/, e centenas de frames de imagem gerados no TDE1 foram omitidos desta visualização para focar no código-fonte).
```

## 🚀 Destaque: TDE 1 - Algoritmo Flood Fill
O diretório `src/RA1/TDE1` contém uma aplicação visual desenvolvida na disciplina que implementa o famoso algoritmo Flood Fill (utilizado na ferramenta "Balde de Tinta" de editores de imagem). Foi construído do zero utilizando duas abordagens:

- **Pilha** (DFS - Busca em Profundidade)

- **Fila** (BFS - Busca em Largura)

O programa processa a imagem `imagem.png`, exporta os frames passo a passo na pasta e gera GIFs animados demonstrando como o computador preenche os pixels em cada estrutura de dados.

---
## 🛠️ Tecnologias Utilizadas
Linguagem: Java

Paradigma: Orientação a Objetos e Estrutura de Dados

Ferramentas: IntelliJ IDEA

---
## ▶️ Como Executar
Clone o repositório:
```
Bash
git clone [https://github.com/GusGgk/ResolucaoDeProblemasRelacionadosAoComputador4P.git](https://github.com/GusGgk/ResolucaoDeProblemasRelacionadosAoComputador4P.git)
```
Abra a pasta na sua IDE de preferência (recomendado IntelliJ IDEA).
Navegue até a classe `Main.java` do pacote que deseja testar (por exemplo, `src/RA1/TDE1/Main.java`).
Execute o arquivo.


## 👨‍💻 Autor
Gustavo Giacoia Kumagai (GK)<br>
Bacharelando em Engenharia de Software - PUCPR<br>
🌐 [Portfólio técnico](gusgk.com.br)
