package ucb.grupo3.service;

import ucb.grupo3.model.Tarefa;
import java.util.ArrayList;

public class TarefaServico {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private int contadorID = 1;

    public Tarefa criarTarefa() {
        Tarefa tarefa = new Tarefa(contadorID++);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criarTarefa(String titulo) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criarTarefa(String titulo, String descricao, boolean completa) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo, descricao, completa);
        tarefas.add(tarefa);
        return tarefa;
    }

    // Visualizar tarefas
    public ArrayList<Tarefa> visualizarTarefas() {
        return new ArrayList<>(tarefas);
    }

    // Atualizar tarefa
    public void atualizarTarefa(int id, String novoTitulo, String novaDescricao, Boolean completa) {
    for (Tarefa tarefa : tarefas) {
        if (tarefa.getId() == id) {
            if (novoTitulo != null) {
                tarefa.setTitulo(novoTitulo);
            }
            if (novaDescricao != null) {
                tarefa.setDescricao(novaDescricao);
            }
            if (completa != null) { 
                tarefa.setCompleta(completa);
            }
            break;
        }
    }
}

    // Remover tarefa
    public void removerTarefa(int id) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == id) {
                tarefas.remove(i);
                break;
            }
        }
    }

    // Marcar tarefa como concluída
    public void marcarTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setCompleta(true);
                break;
            }
        }
    }
}