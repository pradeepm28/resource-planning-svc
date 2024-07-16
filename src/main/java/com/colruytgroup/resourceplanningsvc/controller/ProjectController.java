package com.colruytgroup.resourceplanningsvc.controller;

import com.colruytgroup.resourceplanningsvc.bo.CoworkerBO;
import com.colruytgroup.resourceplanningsvc.bo.ProjectBO;
import com.colruytgroup.resourceplanningsvc.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "projects")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;

    @GetMapping
    public List<ProjectBO> getProjects() {
        return projectService.getProjects();

    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProjectBO> getProjectByCode(@PathVariable(value = "code") String code) {
        return new ResponseEntity<>(projectService.getProjectByCode(code), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<String> deleteProject(@PathVariable(value = "code") String code) {
        projectService.deleteProjectByCode(code);
        return new ResponseEntity<>("Project with code " + code + "is deleted successfully", HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ProjectBO> addProject(@RequestBody ProjectBO projectBO) {
        ProjectBO project = projectService.addProject(projectBO);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}

