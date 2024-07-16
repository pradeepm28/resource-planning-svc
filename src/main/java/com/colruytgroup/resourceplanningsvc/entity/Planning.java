package com.colruytgroup.resourceplanningsvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PLANNING")
public class Planning {

    @EmbeddedId
    private PlanningPK id;

    @Column(name="START_DATE")
    private LocalDateTime startDate;

    @Column(name="END_DATE")
    private LocalDateTime endDate;

    @Column(name="ALLOCATION")
    private Long allocation;

}
