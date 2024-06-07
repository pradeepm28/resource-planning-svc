package com.colruytgroup.resourceplanningsvc.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CoworkerSkillsPK implements Serializable {

    @Column(name="COWORKER_ID")
    private Long coworkerId;

    @Column(name="SKILL_ID")
    private Long skillId;
}
