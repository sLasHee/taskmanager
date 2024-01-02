package com.example.taskmanager.ontroller;

import com.example.taskmanager.entity.Developer;
import com.example.taskmanager.service.DeveloperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping(value = "developers")
    public List<Developer> getDevelopers() {
        return developerService.getDevelopers();
    }
}
