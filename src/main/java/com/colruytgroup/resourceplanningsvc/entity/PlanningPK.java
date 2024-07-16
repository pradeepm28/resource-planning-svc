package com.colruytgroup.resourceplanningsvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PlanningPK implements Serializable {

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Column(name = "COWORKER_ID")
    private Long coworkerId;
}
