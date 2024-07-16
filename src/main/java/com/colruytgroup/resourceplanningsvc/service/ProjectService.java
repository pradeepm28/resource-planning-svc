package com.colruytgroup.resourceplanningsvc.service;

import com.colruytgroup.resourceplanningsvc.bo.ProjectBO;
import com.colruytgroup.resourceplanningsvc.entity.project.Project;
import com.colruytgroup.resourceplanningsvc.entity.project.ProjectSkills;
import com.colruytgroup.resourceplanningsvc.entity.Skill;
import com.colruytgroup.resourceplanningsvc.repository.project.ProjectRepository;
import com.colruytgroup.resourceplanningsvc.repository.project.ProjectSkillsRepository;
import com.colruytgroup.resourceplanningsvc.repository.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ProjectService {

    private ProjectRepository projectRepository;
    private ProjectSkillsRepository projectSkillsRepository;
    private SkillRepository skillRepository;

    public List<ProjectBO> getProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectBO> projectBOList = new ArrayList<>();
        projects.forEach(project -> {
            ProjectBO projectBO = new ProjectBO();
            projectBO.setId(project.getId());
            projectBO.setCode(project.getCode());
            projectBO.setName(project.getName());
            projectBO.setDuration(project.getDuration());
            projectBO.setStartDate(project.getStartDate());
            projectBO.setEndDate(project.getEndDate());

            List<ProjectSkills> projectSkills = projectSkillsRepository.findProjectSkillsByIdProjectId(project.getId());
            List<String> skills = new ArrayList<>();
            projectSkills.forEach(projectSkill -> {
                Optional<Skill> skill = skillRepository.findById(projectSkill.getId().getSkillId());
                if (skill.isPresent()) {
                    skills.add(skill.get().getName());
                }
            });
            projectBO.setSkills(skills);
            projectBOList.add(projectBO);
        });
        return projectBOList;
    }

    public ProjectBO getProjectByCode(String code) {
        Optional<Project> project = projectRepository.findProjectByCode(code);
        if (project.isPresent()) {
            Project projectData = project.get();
            List<String> skills = getProjectSkills(projectData.getId());
            ProjectBO projectBO = new ProjectBO(projectData.getId(), projectData.getCode(), projectData.getName(), projectData.getDuration(), projectData.getStartDate(), projectData.getEndDate(), skills);
            return projectBO;
        } else {
            throw new NoSuchElementException("Project with code " + code + " not present.");
        }
    }

    public ProjectBO getProjectById(Long Id) {
        Optional<Project> project = projectRepository.findById(Id);
        if (project.isPresent()) {
            Project projectData = project.get();
            List<String> skills = getProjectSkills(projectData.getId());
            ProjectBO projectBO = new ProjectBO(projectData.getId(), projectData.getCode(), projectData.getName(), projectData.getDuration(), projectData.getStartDate(), projectData.getEndDate(), skills);
            return projectBO;
        } else {
            throw new NoSuchElementException("Project with code " + Id + " not present.");
        }

    }

    private List<String> getProjectSkills(Long id) {
        List<ProjectSkills> projectSkillsList = projectSkillsRepository.findProjectSkillsByIdProjectId(id);
        List<String> projectSkills = new ArrayList<>();
        projectSkillsList.forEach(projectSkill -> {
            Optional<Skill> skillId = skillRepository.findById(projectSkill.getId().getSkillId());
            skillId.ifPresent(value -> projectSkills.add(value.getName()));
        });
        return projectSkills;
    }

    public void deleteProjectByCode(String code) {
        projectRepository.deleteProjectsByCode(code);


    }

    public ProjectBO addProject(ProjectBO projectBO) {
        Project project = new Project();
        project.setId(projectBO.getId());
        project.setCode(projectBO.getCode());
        project.setName(projectBO.getName());
        project.setDuration(projectBO.getDuration());
        project.setStartDate(projectBO.getStartDate());
        project.setEndDate(projectBO.getEndDate());

        //Input BO will have "CICS". Should we convert this "CICS" to Skill ID and then load to ProjectSkills table?

        List<String> skills = getProjectSkills(projectBO.getId());
        Project project1 = projectRepository.save(project);
        ProjectBO projectBOCreated = new ProjectBO(project1.getId(), project1.getCode(), project1.getName(), project1.getDuration(), project1.getStartDate(), project1.getEndDate(), List.of());

        return projectBOCreated;
    }
}
