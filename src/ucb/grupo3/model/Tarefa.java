package ucb.grupo3.model;

import java.time.LocalDateTime;

public class Tarefa {
    private final int id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private final LocalDateTime dataCriacao;

    // Construtores (recursivos, não está na descrição da atividade, mas foi solicitado na aula)
    public Tarefa(int id){
        this(id,"Sem título");
    }

    public Tarefa(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
        this.dataCriacao = LocalDateTime.now();
        this.completa = false;
    }

    public Tarefa(int id, String titulo, String descricao) {
        this(id, titulo);
        this.descricao = descricao;
    }

    public Tarefa(int id, String titulo, String descricao, boolean completa) {
        this(id, titulo, descricao);
        this.completa = completa;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

}