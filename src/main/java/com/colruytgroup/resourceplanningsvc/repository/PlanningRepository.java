package com.colruytgroup.resourceplanningsvc.repository;

import com.colruytgroup.resourceplanningsvc.entity.Planning;
import com.colruytgroup.resourceplanningsvc.entity.PlanningPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, PlanningPK> {
    List<Planning> findPlanningsById_ProjectId(Long projectId);
    List<Planning> findPlanningsById_CoworkerId(Long projectId);

}
