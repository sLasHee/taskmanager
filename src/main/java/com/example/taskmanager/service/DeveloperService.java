package com.example.taskmanager.service;

import com.example.taskmanager.dto.DeveloperDTO;
import com.example.taskmanager.entity.Developer;
import com.example.taskmanager.repository.DeveloperRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> getDevelopers() {
        return developerRepository.findAll();
    }

    public Developer createDeveloper(DeveloperDTO developerDTO) {
        Developer developer = new Developer();
        developer.setId(developerDTO.getId());
        developer.setNickName(developerDTO.getNickName());
        return developerRepository.save(developer);
    }

    public String deleteDeveloper(UUID id) {
        Optional<Developer> optional = developerRepository.findById(id);
        if (optional.isPresent()) {
            Developer developer = optional.get();
            developerRepository.delete(developer);
            return String.format("Developer with id: %s was deleted", id);
        }
        return String.format("There is no developer with this id: %s", id);
    }

    public Page<Developer> getPageWithPagination(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = getSort(sortField, sortDirection);
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return developerRepository.findAll(pageable);
    }

    private Sort getSort(String sortField, String sortDirection) {
        Sort ascending = Sort.by(sortField).ascending();
        Sort descending = Sort.by(sortField).descending();
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? ascending : descending;
    }
}
