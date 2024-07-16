package com.colruytgroup.resourceplanningsvc.bo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ProjectResourceBO {

    private String employeeID;
    private String employeeName;
    private List<String> employeeSkills;
    private LocalDate planningStartDate;
    private LocalDate planningEndDate;
    private Long projectAllocation;
}
