package com.example.taskmanager.controller;

import com.example.taskmanager.dto.DeveloperDTO;
import com.example.taskmanager.entity.Developer;
import com.example.taskmanager.service.DeveloperService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping(value = "/developers")
    public List<Developer> getDevelopers() {
        return developerService.getDevelopers();
    }

    @PostMapping(value = "/createDeveloper")
    public Developer createDeveloper(@Valid @RequestBody DeveloperDTO developerDTO) {
        return developerService.create(developerDTO);
    }

    @DeleteMapping(value = "/deleteDeveloper/{id}")
    public String deleteDeveloper(@PathVariable UUID id) {
        return developerService.deleteDeveloper(id);
    }
}
