package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.entity.Developer;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.DeveloperRepository;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    private final DeveloperRepository developerRepository;

    public TaskService(TaskRepository taskRepository, DeveloperRepository developerRepository) {
        this.taskRepository = taskRepository;
        this.developerRepository = developerRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(TaskDTO taskDTO) {
        Developer developer = developerRepository.getReferenceById(taskDTO.getDeveloper().getId());
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDeveloper(developer);
        return taskRepository.save(task);
    }

    public String deleteTask(UUID id) {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            Task task = optional.get();
            taskRepository.delete(task);
            return String.format("Task with id: %s was deleted", id);
        }
        return String.format("There is no task with this id: %s", id);
    }
}
