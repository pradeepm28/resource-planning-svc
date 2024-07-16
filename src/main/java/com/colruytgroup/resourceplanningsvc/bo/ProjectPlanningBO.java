package com.colruytgroup.resourceplanningsvc.bo;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ProjectPlanningBO {
    private String projectCode;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private Long projectDuration;
    private List<ProjectResourceBO> projectResources;
}
