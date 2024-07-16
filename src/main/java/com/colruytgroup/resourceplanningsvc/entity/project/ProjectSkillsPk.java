package com.colruytgroup.resourceplanningsvc.entity.project;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ProjectSkillsPk implements Serializable {

    @Column(name = "PROJECT_ID")
    private Long projectId;
    @Column(name = "SKILL_ID")
    private Long skillId;

}
