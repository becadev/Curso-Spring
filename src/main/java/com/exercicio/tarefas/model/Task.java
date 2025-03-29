package com.exercicio.tarefas.model;
// modelo de estrutura dos dados no banco

import jakarta.persistence.*;

@Entity
@Table(name =  "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private boolean concluida;

    public Task(Long id, String descricao, boolean b) {}
    public Task(String descricao, boolean concluida) {
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    @Override
    public String toString() {
        return "Tarefas:" +
                "id =" + id +
                ", descricao='" + descricao + '\'' +
                ", concluida=" + concluida + "\n"
                ;
    }
}
