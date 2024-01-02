package com.example.taskmanager.service;

import com.example.taskmanager.entity.Developer;
import com.example.taskmanager.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> getDevelopers() {
        return developerRepository.findAll();
    }
}
