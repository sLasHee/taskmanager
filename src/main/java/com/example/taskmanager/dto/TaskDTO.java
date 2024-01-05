package com.example.taskmanager.dto;

import com.example.taskmanager.entity.Developer;

import java.util.UUID;

public class TaskDTO {

    private UUID id;

    private String title;

    private Developer developer;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
