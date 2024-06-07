package com.colruytgroup.resourceplanningsvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="COWORKER_SKILLS")
public class CoworkerSkills {

    @EmbeddedId
    private CoworkerSkillsPK id;

}
