package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    @EntityGraph(attributePaths = {"developer"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select t from Task t left join fetch t.developer d")
    List<Task> findAll();
}
