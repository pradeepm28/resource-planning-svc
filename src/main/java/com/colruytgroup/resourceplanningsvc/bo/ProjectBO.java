package com.colruytgroup.resourceplanningsvc.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectBO {

    private Long id;
    private String code;
    private String name;
    private Long duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> skills;
}
