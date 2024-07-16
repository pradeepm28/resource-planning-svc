package com.colruytgroup.resourceplanningsvc.repository.coworker;

import com.colruytgroup.resourceplanningsvc.entity.coworker.CoworkerSkills;
import com.colruytgroup.resourceplanningsvc.entity.coworker.CoworkerSkillsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoworkerSkillsRepository extends JpaRepository<CoworkerSkills, CoworkerSkillsPK> {

    List<CoworkerSkills> findCoworkerSkillsByIdCoworkerId(Long coworkerId);

}
