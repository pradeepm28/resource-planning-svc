package com.colruytgroup.resourceplanningsvc.repository;

import com.colruytgroup.resourceplanningsvc.entity.CoworkerSkills;
import com.colruytgroup.resourceplanningsvc.entity.CoworkerSkillsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoworkerSkillsRepository extends JpaRepository<CoworkerSkills, CoworkerSkillsPK> {

    List<CoworkerSkills> findCoworkerSkillsByIdCoworkerId(Long coworkerId);

}
