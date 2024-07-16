package com.colruytgroup.resourceplanningsvc.bo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder /* pattern */
public class PlanningBO {
    private String projectCode;
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long allocation;
}
