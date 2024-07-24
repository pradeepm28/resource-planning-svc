package com.colruytgroup.resourceplanningsvc.bo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpdatePlanningBO {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long allocation;
}
