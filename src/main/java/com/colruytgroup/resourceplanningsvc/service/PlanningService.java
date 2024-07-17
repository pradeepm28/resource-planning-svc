package com.colruytgroup.resourceplanningsvc.service;

import com.colruytgroup.resourceplanningsvc.bo.*;
import com.colruytgroup.resourceplanningsvc.entity.Planning;
import com.colruytgroup.resourceplanningsvc.entity.PlanningPK;
import com.colruytgroup.resourceplanningsvc.repository.PlanningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PlanningService {

    private final PlanningRepository planningRepository;
    private final ProjectService projectService;
    private final CoworkerService coworkerService;

    public ProjectPlanningBO getPlanningByProjectCode(String projectCode) {
        ProjectBO project = projectService.getProjectByCode(projectCode);
        List<Planning> projectPlanning = planningRepository.findPlanningsById_ProjectId(project.getId());
        List<ProjectResourceBO> projectResourceBOList = new ArrayList<>();

        projectPlanning.forEach(planning -> {
            CoworkerBO coworkerById = coworkerService.getCoworkerById(planning.getId().getCoworkerId());
            ProjectResourceBO projectResourceBO = ProjectResourceBO.builder()
                    .employeeID(coworkerById.getEmployeeID())
                    .employeeName(coworkerById.getName())
                    .employeeSkills(coworkerById.getSkills())
                    .planningStartDate(planning.getStartDate().toLocalDate())
                    .planningEndDate(Objects.nonNull(planning.getEndDate()) ? planning.getEndDate().toLocalDate() : null)
                    .projectAllocation(planning.getAllocation())
                    .build();
            projectResourceBOList.add(projectResourceBO);
        });

        ProjectPlanningBO projectPlanningBO = ProjectPlanningBO.builder()
                .projectCode(project.getCode())
                .projectName(project.getName())
                .projectStartDate(project.getStartDate())
                .projectEndDate(project.getEndDate())
                .projectDuration(project.getDuration())
                .projectResources(projectResourceBOList)
                .build();
        return projectPlanningBO;
    }

    public EmployeePlanningBO getPlanningByemployeeCode(String employeeCode) {
        CoworkerBO coworkerBO = coworkerService.getCoworkerByEmployeeCode(employeeCode);
        List<Planning> employeePlanning = planningRepository.findPlanningsById_CoworkerId(coworkerBO.getId());
        List<EmployeeProjectsBO> employeeProjectsBOList = new ArrayList<>();

        employeePlanning.forEach(planning -> {
            ProjectBO projectBO = projectService.getProjectById(planning.getId().getProjectId());
            EmployeeProjectsBO employeeProjectsBO = EmployeeProjectsBO.builder()
                    .projectCode(projectBO.getCode())
                    .projectName(projectBO.getName())
                    .projectStartDate(projectBO.getStartDate())
                    .projectEndDate(Objects.nonNull(projectBO.getEndDate()) ? projectBO.getEndDate() : null)
                    .projectDuration(projectBO.getDuration())
                    .planningStartDate(planning.getStartDate().toLocalDate())
                    .planningEndDate(Objects.nonNull(planning.getEndDate()) ? planning.getEndDate().toLocalDate() : null)
                    .projectAllocation(planning.getAllocation())
                    .build();
            employeeProjectsBOList.add(employeeProjectsBO);
        });

        EmployeePlanningBO employeePlanningBO = EmployeePlanningBO.builder()
                .employeeID(coworkerBO.getEmployeeID())
                .employeeName(coworkerBO.getName())
                .employeeSkills(coworkerBO.getSkills())
                .employeeProjects(employeeProjectsBOList)
                .build();
        return employeePlanningBO;
    }

    public void createPlanning(PlanningBO planningBO) {
        ProjectBO project = projectService.getProjectByCode(planningBO.getProjectCode());
        CoworkerBO coworker = coworkerService.getCoworkerByEmployeeCode(planningBO.getEmployeeId());
        PlanningPK planningPK = new PlanningPK();
        planningPK.setProjectId(project.getId());
        planningPK.setCoworkerId(coworker.getId());

        Planning planning = Planning.builder()
                .id(planningPK)
                .startDate(LocalDateTime.of(planningBO.getStartDate(), LocalTime.now()))
                .endDate(Objects.nonNull(planningBO.getEndDate()) ? LocalDateTime.of(planningBO.getEndDate(), LocalTime.now()) : null)
                .allocation(planningBO.getAllocation())
                .build();
        planningRepository.save(planning);

    }

    @Transactional
    public void deletePlaning(String projectCode, String employeeId) {
        ProjectBO project = projectService.getProjectByCode(projectCode);
        CoworkerBO coworker = coworkerService.getCoworkerByEmployeeCode(employeeId);
        PlanningPK planningPK = new PlanningPK();

        planningPK.setProjectId(project.getId());
        planningPK.setCoworkerId(coworker.getId());

        planningRepository.deletePlanningById(planningPK);
    }
}
