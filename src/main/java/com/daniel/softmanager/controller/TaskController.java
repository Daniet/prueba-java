package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Task;
import com.daniel.softmanager.persistence.entity.TaskStatus;
import com.daniel.softmanager.service.TaskService;
import com.daniel.softmanager.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
