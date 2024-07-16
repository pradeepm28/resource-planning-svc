package com.colruytgroup.resourceplanningsvc.repository.project;

import com.colruytgroup.resourceplanningsvc.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findProjectByCode(String code);

    Optional<Project> findById(Long Id);

    void deleteProjectsByCode(String code);
}
