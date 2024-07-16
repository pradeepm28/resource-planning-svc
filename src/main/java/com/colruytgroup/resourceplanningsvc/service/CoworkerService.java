package com.colruytgroup.resourceplanningsvc.service;

import com.colruytgroup.resourceplanningsvc.bo.CoworkerBO;
import com.colruytgroup.resourceplanningsvc.entity.coworker.Coworker;
import com.colruytgroup.resourceplanningsvc.entity.coworker.CoworkerSkills;
import com.colruytgroup.resourceplanningsvc.entity.Skill;
import com.colruytgroup.resourceplanningsvc.repository.coworker.CoworkerRepository;
import com.colruytgroup.resourceplanningsvc.repository.coworker.CoworkerSkillsRepository;
import com.colruytgroup.resourceplanningsvc.repository.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CoworkerService {
    private CoworkerRepository coworkerRepository;
    private CoworkerSkillsRepository coworkerSkillsRepository;
    private SkillRepository skillRepository;

    public List<CoworkerBO> getCoworkers() {
        List<Coworker> coworkerList = coworkerRepository.findAll();
        List<CoworkerBO> coworkerBOList = new ArrayList<>();

        for (Coworker coworker : coworkerList) {
            if (coworker.getLeavingDate() == null) {
                List<String> skills = getCoworkerSkills(coworker.getId());
                CoworkerBO coworkerBO = new CoworkerBO(coworker.getId(), coworker.getEmployeeID(), coworker.getName(), coworker.getJoiningDate(), skills);
                coworkerBOList.add(coworkerBO);
            }
        }
        return coworkerBOList;
    }

    public CoworkerBO getCoworkerById(Long id) {
        Optional<Coworker> coworker = coworkerRepository.findById(id);
        if (coworker.isPresent()) {
            Coworker coworkerData = coworker.get();
            List<String> skills = getCoworkerSkills(coworkerData.getId());
            CoworkerBO coworkerBO = new CoworkerBO(coworkerData.getId(), coworkerData.getEmployeeID(), coworkerData.getName(), coworkerData.getJoiningDate(), skills);
            return coworkerBO;
        } else {
            throw new NoSuchElementException("Coworker with ID " + id + " not present.");
        }
    }

    public CoworkerBO getCoworkerByEmployeeCode(String employeeCode) {
        Coworker coworker = coworkerRepository.findCoworkerByEmployeeID(employeeCode);
        if (coworker instanceof Coworker) {
            List<String> skills = getCoworkerSkills(coworker.getId());
            CoworkerBO coworkerBO = new CoworkerBO(coworker.getId(), coworker.getEmployeeID(), coworker.getName(), coworker.getJoiningDate(), skills);
            return coworkerBO;
        } else {
            throw new NoSuchElementException("Coworker with code " + employeeCode + " not present.");
        }
    }

    public void deleteCoworker(Long id) {
        coworkerRepository.deleteById(id);
    }

    public CoworkerBO addCoworker(CoworkerBO coworkerBO) {
        Coworker coworker = new Coworker();
        coworker.setId(coworkerBO.getId());
        coworker.setName(coworkerBO.getName());
        coworker.setEmployeeID(coworkerBO.getEmployeeID());
        coworker.setJoiningDate(coworkerBO.getJoiningDate());
        coworker.setModifiedOn(LocalDateTime.now());

        Coworker coworkerCreated = coworkerRepository.save(coworker);

        CoworkerBO coworkerBOCreated = new CoworkerBO(coworkerCreated.getId(), coworkerCreated.getEmployeeID(), coworkerCreated.getName(), coworkerCreated.getJoiningDate(), List.of());
        return coworkerBOCreated;
    }

    public CoworkerBO updateCoworker(CoworkerBO coworkerBO) {
        Coworker coworker = new Coworker();
        coworker.setId(coworkerBO.getId());
        coworker.setName(coworkerBO.getName());
        coworker.setEmployeeID(coworkerBO.getEmployeeID());
        coworker.setJoiningDate(coworkerBO.getJoiningDate());
        coworker.setModifiedOn(LocalDateTime.now());

        Coworker coworkerCreated = coworkerRepository.save(coworker);

        CoworkerBO coworkerBOCreated = new CoworkerBO(coworkerCreated.getId(), coworkerCreated.getEmployeeID(), coworkerCreated.getName(), coworkerCreated.getJoiningDate(), List.of());
        return coworkerBOCreated;
    }

    private List<String> getCoworkerSkills(long id) {
        List<String> skills = new ArrayList<>();
        List<CoworkerSkills> coworkerSkills = coworkerSkillsRepository.findCoworkerSkillsByIdCoworkerId(id);
        coworkerSkills.forEach((coworkerSkill -> {
            Optional<Skill> skill = skillRepository.findById(coworkerSkill.getId().getSkillId());
            skill.ifPresent(value -> skills.add(value.getName()));
        }));
        return skills;
    }
}
