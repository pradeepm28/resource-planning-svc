package com.colruytgroup.resourceplanningsvc.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CoworkerBO {


    private long id;
    private String employeeID;
    private String name;
    private LocalDate joiningDate;

}
