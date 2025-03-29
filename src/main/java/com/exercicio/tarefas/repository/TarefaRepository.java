package com.exercicio.tarefas.repository;

import com.exercicio.tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// INterface responsável por acessar o banco de dados
@Repository // define repositorio de persistencia de dados, ou seja,
public interface TarefaRepository extends JpaRepository<Task,Long> {

}
