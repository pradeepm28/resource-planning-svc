package com.colruytgroup.resourceplanningsvc.service;

import com.colruytgroup.resourceplanningsvc.bo.CoworkerBO;
import com.colruytgroup.resourceplanningsvc.entity.Coworker;
import com.colruytgroup.resourceplanningsvc.repository.CoworkerRepository;
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

    public List<CoworkerBO> getCoworkers() {
        List<Coworker> coworkerList = coworkerRepository.findAll();
        List<CoworkerBO> coworkerBOList = new ArrayList<>();

        for (Coworker coworker : coworkerList) {
            if (coworker.getLeavingDate() == null) {
                CoworkerBO coworkerBO = new CoworkerBO(coworker.getId(), coworker.getEmployeeID(), coworker.getName(), coworker.getJoiningDate());
                coworkerBOList.add(coworkerBO);
            }
        }
        return coworkerBOList;
    }

    public CoworkerBO getCoworkerById(Long id) {
        Optional<Coworker> coworker = coworkerRepository.findById(id);
        if (coworker.isPresent()) {
            Coworker coworkerData = coworker.get();
            CoworkerBO coworkerBO = new CoworkerBO(coworkerData.getId(), coworkerData.getEmployeeID(), coworkerData.getName(), coworkerData.getJoiningDate());
            return coworkerBO;
        } else {
            throw new NoSuchElementException("Coworker with ID " + id + " not present.");
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

        CoworkerBO coworkerBOCreated = new CoworkerBO(coworkerCreated.getId(), coworkerCreated.getEmployeeID(), coworkerCreated.getName(), coworkerCreated.getJoiningDate());
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

        CoworkerBO coworkerBOCreated = new CoworkerBO(coworkerCreated.getId(), coworkerCreated.getEmployeeID(), coworkerCreated.getName(), coworkerCreated.getJoiningDate());
        return coworkerBOCreated;
    }
}
