package com.colruytgroup.resourceplanningsvc.entity.coworker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COWORKER")
public class Coworker {
    @Id
    @Column(name="ID")
    private long id;

    @Column(name="EMP_ID")
    private String employeeID;

    @Column(name="NAME")
    private String name;

    @Column(name="JOINING_DATE")
    private LocalDate joiningDate;

    @Column(name="LEAVING_DATE")
    private LocalDate leavingDate;

    @Column(name="MODIFIED_ON")
    private LocalDateTime modifiedOn;

}
