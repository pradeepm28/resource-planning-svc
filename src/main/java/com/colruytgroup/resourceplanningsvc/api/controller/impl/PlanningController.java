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
    @ResponseStatus(value = HttpStatus.OK)
    public ProjectPlanningBO getPlanningByProjectCode(@PathVariable(value = "projectCode") String projectCode) {
        return planningService.getPlanningByProjectCode(projectCode);
    }

    @GetMapping(value = "/employee/{employeeCode}")
    @ResponseStatus(value = HttpStatus.OK)
    public EmployeePlanningBO getPlanningByemployeeCode(@PathVariable(value = "employeeCode") String employeeCode) {
        return planningService.getPlanningByemployeeCode(employeeCode);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createPlanning(@RequestBody PlanningBO planningBO) {
        planningService.createPlanning(planningBO);
        return "Planning is created successfully";
    }

    @PutMapping(value = "/project/{projectCode}/employee/{employeeId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String updatePlanning(@PathVariable(value = "projectCode") String projectCode, @PathVariable(value = "employeeId") String employeeId, @RequestBody PlanningBO planningBO) {
        planningService.updatePlanning(projectCode, employeeId, planningBO);
        return "Planning updated successfully";
    }

    @DeleteMapping(value = "/project/{projectCode}/employee/{employeeId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePlanning(@PathVariable(value = "projectCode") String projectCode, @PathVariable(value = "employeeId") String employeeId) {
        planningService.deletePlaning(projectCode, employeeId);

    }

}
