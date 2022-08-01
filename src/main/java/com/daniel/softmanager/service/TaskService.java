package com.daniel.softmanager.service;

import com.daniel.softmanager.exceptions.ToDoExceptions;
import com.daniel.softmanager.mapper.TaskInDTOToTask;
import com.daniel.softmanager.persistence.entity.Task;
import com.daniel.softmanager.persistence.entity.TaskStatus;
import com.daniel.softmanager.persistence.repository.TaskRepository;
import com.daniel.softmanager.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        this.repository.save(task);
        return task;
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) throw new ToDoExceptions("Task no found", HttpStatus.NOT_FOUND);
        this.repository.deleteById(id);
    }
}
