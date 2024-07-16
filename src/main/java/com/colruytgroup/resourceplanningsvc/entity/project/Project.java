package com.colruytgroup.resourceplanningsvc.entity.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private Long duration;
    private LocalDate startDate;
    private LocalDate endDate;

}
