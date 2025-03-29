package com.exercicio.tarefas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.exercicio.tarefas.model.Task;
import com.exercicio.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TareafaController {
    private final TarefaService tarefaService;

    @Autowired
    public TareafaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }



    @GetMapping
    public String getAllTarefas(Model model) { // Model serve como um objeto de transporte para enviar dados para a view.
        model.addAttribute("tarefas", tarefaService.listarTarefas());
        return "index"; // retorna o template html
//        return "Suas tarefas: \n" +
//                " " + tarefaService.listarTarefas();
    }

    @PostMapping
    public String createTarefa(@RequestParam String descricao, Model model) {
        tarefaService.addTarefa(new Task(descricao, false));
        model.addAttribute("tarefas", tarefaService.listarTarefas()); // vai atualizar a lista de tarefas
        return "redirect:/tasks"; // atualiza a página
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> changeTarefa(@PathVariable("id") Long id, @RequestParam("descricao") String descricao) {
        Task novaTarefa = new Task(id, descricao, false);
        Task updateTarefa = tarefaService.updateTarefa(id, novaTarefa);
        return ResponseEntity.ok(updateTarefa);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTarefa(@PathVariable("id") Long id) {
        tarefaService.deleteTask(id);
        return "redirect:/tasks";
    }
}
