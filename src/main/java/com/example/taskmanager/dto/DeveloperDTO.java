package com.example.taskmanager.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class DeveloperDTO {

    private UUID id;

    @NotEmpty
    private String nickName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
