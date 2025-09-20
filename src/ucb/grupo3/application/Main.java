package ucb.grupo3.application;

import ucb.grupo3.model.Tarefa;
import ucb.grupo3.service.TarefaServico;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaServico servico = new TarefaServico();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU DE TAREFAS ===");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Visualizar todas as tarefas");
            System.out.println("3. Visualizar tarefas pendentes");
            System.out.println("4. Visualizar tarefas concluídas");
            System.out.println("5. Atualizar tarefa");
            System.out.println("6. Marcar tarefa como concluída");
            System.out.println("7. Remover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição (ou enter p/ manter vazio): ");
                    String descricao = sc.nextLine();
                    Tarefa nova = servico.criarTarefa(titulo, descricao);
                    System.out.println("Tarefa criada com ID " + nova.getId());
                    break;
                }
                case 2: {
                    listarTarefas(servico.visualizarTarefas());
                    break;
                }
                case 3: {
                    List<Tarefa> pendentes = servico.visualizarTarefas()
                            .stream().filter(t -> !t.isCompleta()).toList();
                    listarTarefas(pendentes);
                    break;
                }
                case 4: {
                    List<Tarefa> concluidas = servico.visualizarTarefas()
                            .stream().filter(Tarefa::isCompleta).toList();
                    listarTarefas(concluidas);
                    break;
                }
                case 5: {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo título (ou enter p/ manter): ");
                    String titulo = sc.nextLine();
                    if (titulo.isBlank()) titulo = null;

                    System.out.print("Nova descrição (ou enter p/ manter): ");
                    String descricao = sc.nextLine();
                    if (descricao.isBlank()) descricao = null;

                    System.out.print("Alterar status? (s/n): ");
                    String resp = sc.nextLine();
                    Boolean completa = null;
                    if (resp.equalsIgnoreCase("s")) {
                        System.out.print("Está concluída? (true/false): ");
                        completa = sc.nextBoolean();
                        sc.nextLine();
                    }

                    servico.atualizarTarefa(id, titulo, descricao, completa);
                    System.out.println("Tarefa atualizada (se encontrada).");
                    break;
                }
                case 6: {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.marcarTarefa(id);
                    System.out.println("Tarefa marcada como concluída.");
                    break;
                }
                case 7: {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.removerTarefa(id);
                    System.out.println("Tarefa removida (se encontrada).");
                    break;
                }
                case 0: {
                    rodando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                }
                default: System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    private static void listarTarefas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (Tarefa t : tarefas) {
                String tCompleta = t.isCompleta() ? "Sim" : "Não";
                System.out.println("ID: " + t.getId() +
                        " | Título: " + t.getTitulo() +
                        " | Descrição: " + t.getDescricao() +
                        " | Concluída: " + tCompleta +
                        " | Criada em: " + t.getDataAgora());
            }
        }
    }
}