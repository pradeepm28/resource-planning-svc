package com.colruytgroup.resourceplanningsvc.entity.project;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="PROJECT_SKILLS")
@NoArgsConstructor
public class ProjectSkills {

    @EmbeddedId
    private ProjectSkillsPk id;

    @Column(name="EFFORT")
    private double effort;

}
