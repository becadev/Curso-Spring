package com.exercicio.tarefas.service;

import com.exercicio.tarefas.model.Task;
import com.exercicio.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    public List<Task> listarTarefas(){
        return tarefaRepository.findAll();
    }
    public Task addTarefa(Task task) {
        return tarefaRepository.save(task);
    }
    public Task updateTarefa(Long id, Task novaTarefa) {
        Task tarefas = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não registrada"));
        tarefas.setDescricao(novaTarefa.getDescricao());
        tarefas.setConcluida(novaTarefa.isConcluida());
        return tarefaRepository.save(tarefas); // salva a atualização
    }
    public void deleteTask(Long id) {
        if(!tarefaRepository.existsById(id))
            throw new RuntimeException("Tarefa Não Encontrada");
        tarefaRepository.deleteById(id);
    }
}
