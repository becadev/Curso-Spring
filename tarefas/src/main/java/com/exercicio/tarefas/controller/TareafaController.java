package com.exercicio.tarefas.controller;

import com.exercicio.tarefas.model.Task;
import com.exercicio.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TareafaController {
    private final TarefaService tarefaService;

    @Autowired
    public TareafaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public String getAllTarefas() {
        return "Suas tarefas: \n" +
                " " + tarefaService.listarTarefas();
    }

    @PostMapping
    public Task createTarefa(@RequestBody Task tarefa) {
        return tarefaService.addTarefa(tarefa);
    }
    @PutMapping("/{id}")
    public Task changeTarefa(@PathVariable("id") Long id, @RequestBody Task novaTarefa) {
        return tarefaService.updateTarefa(id, novaTarefa);
    }
    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable("id") Long id) {
        tarefaService.deleteTask(id);;
    }
}
