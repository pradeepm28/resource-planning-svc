package com.colruytgroup.resourceplanningsvc.bo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeProjectsBO {
    private String projectCode;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private Long projectDuration;
    private LocalDate planningStartDate;
    private LocalDate planningEndDate;
    private Long projectAllocation;
}
