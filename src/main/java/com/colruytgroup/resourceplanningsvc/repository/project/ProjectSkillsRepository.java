package com.colruytgroup.resourceplanningsvc.repository.project;

import com.colruytgroup.resourceplanningsvc.entity.project.ProjectSkills;
import com.colruytgroup.resourceplanningsvc.entity.project.ProjectSkillsPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectSkillsRepository extends JpaRepository<ProjectSkills, ProjectSkillsPk> {
    public List<ProjectSkills> findProjectSkillsByIdProjectId(Long projectId);
}
