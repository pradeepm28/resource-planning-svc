package com.colruytgroup.resourceplanningsvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="SKILL")
public class Skill {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="SKILL_NAME")
    private String name;

}
