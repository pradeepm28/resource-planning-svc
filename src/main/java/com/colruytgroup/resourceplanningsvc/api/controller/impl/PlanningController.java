package com.colruytgroup.resourceplanningsvc.api.controller.impl;

import com.colruytgroup.resourceplanningsvc.bo.EmployeePlanningBO;
import com.colruytgroup.resourceplanningsvc.bo.PlanningBO;
import com.colruytgroup.resourceplanningsvc.bo.ProjectPlanningBO;
import com.colruytgroup.resourceplanningsvc.service.PlanningService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "planning")
@AllArgsConstructor
public class PlanningController {
    private PlanningService planningService;

    @GetMapping(value = "/project/{projectCode}")
    public ResponseEntity<ProjectPlanningBO> getPlanningByProjectCode(@PathVariable(value = "projectCode") String projectCode) {
        return ResponseEntity.status(HttpStatus.OK).body(planningService.getPlanningByProjectCode(projectCode));
    }

    @GetMapping(value = "/employee/{employeeCode}")
    public ResponseEntity<EmployeePlanningBO> getPlanningByemployeeCode(@PathVariable(value = "employeeCode") String employeeCode) {
        return ResponseEntity.status(HttpStatus.OK).body(planningService.getPlanningByemployeeCode(employeeCode));
    }

    @PostMapping
    public ResponseEntity<String> createPlanning(@RequestBody PlanningBO planningBO) {
        planningService.createPlanning(planningBO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Planning is created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updatePlanning(@RequestBody PlanningBO planningBO) {
        planningService.createPlanning(planningBO);
        return ResponseEntity.status(HttpStatus.OK).body("Planning updated successfully");
    }

    @DeleteMapping(value = "/project/{projectCode}/employee/{employeeId}")
    public ResponseEntity<String> deletePlanning(@PathVariable(value = "projectCode") String projectCode,@PathVariable(value = "employeeId") String employeeId) {
        planningService.deletePlaning(projectCode,employeeId);
        return new ResponseEntity<>("Employee with code " + employeeId + "is deleted successfully from the project" + projectCode, HttpStatus.NO_CONTENT);
    }

}
