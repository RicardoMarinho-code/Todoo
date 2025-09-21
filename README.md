# Todoo - Gerenciador de Tarefas em Linha de Comando

`Todoo` é uma aplicação de console simples, desenvolvida em Java, para gerenciar uma lista de tarefas (To-Do list). Permite criar, visualizar, atualizar, marcar como concluída e remover tarefas de forma interativa através de um menu no terminal.

Este projeto foi desenvolvido como parte de uma atividade acadêmica, focando em boas práticas de programação orientada a objetos.

## Funcionalidades

- **Criar Tarefa**: Adiciona uma nova tarefa com título e descrição opcional.
- **Visualizar Todas as Tarefas**: Lista todas as tarefas existentes, mostrando ID, título, descrição, status (concluída ou não) e data de criação.
- **Filtrar Tarefas**: Permite visualizar apenas as tarefas pendentes ou apenas as concluídas.
- **Atualizar Tarefa**: Modifica o título, a descrição e o status de uma tarefa existente a partir de seu ID.
- **Marcar como Concluída**: Altera o status de uma tarefa para "concluída".
- **Remover Tarefa**: Exclui uma tarefa da lista.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **JDK 8+**: O projeto utiliza `streams` e `collectors`, sendo compatível com Java 8 ou superior.

## Como Executar o Projeto

1.  **Pré-requisitos**:
    - Ter o JDK (Java Development Kit) versão 8 ou superior instalado e configurado no seu sistema.

2.  **Compilação**:
    - Abra um terminal e navegue até a pasta `src` do projeto.
    - Execute o comando abaixo para compilar todos os arquivos `.java`:
      ```bash
      javac ucb/grupo3/application/Main.java ucb/grupo3/model/Tarefa.java ucb/grupo3/service/TarefaServico.java
      ```

3.  **Execução**:
    - Ainda na pasta `src`, execute o comando para iniciar a aplicação:
      ```bash
      java ucb.grupo3.application.Main
      ```
    - O menu interativo será exibido no terminal, e você poderá começar a gerenciar suas tarefas.

## Estrutura do Projeto

O código-fonte está organizado na pasta `src` seguindo uma arquitetura em camadas simples:

```
src
└── ucb
    └── grupo3
        ├── application   # Camada de Apresentação (Interface com o usuário)
        │   └── Main.java
        ├── model         # Camada de Modelo (Objetos de dados)
        │   └── Tarefa.java
        └── service       # Camada de Serviço (Lógica de negócio)
            └── TarefaServico.java
```

- **`application`**: Contém a classe `Main`, responsável pela interface com o usuário (menu e interações no console).
- **`model`**: Contém a classe `Tarefa`, que representa o modelo de dados de uma tarefa.
- **`service`**: Contém a classe `TarefaServico`, que implementa a lógica de negócio para gerenciar as tarefas (criar, ler, atualizar, deletar).