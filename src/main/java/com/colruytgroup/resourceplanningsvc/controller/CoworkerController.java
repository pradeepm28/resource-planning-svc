package com.colruytgroup.resourceplanningsvc.controller;

import com.colruytgroup.resourceplanningsvc.entity.Coworker;
import com.colruytgroup.resourceplanningsvc.repository.CoworkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "coworkers")
@AllArgsConstructor
public class CoworkerController {
    private CoworkerRepository coworkerRepository;

    @GetMapping
    public List<Coworker> getCoworkers(){
        //return Collections.singletonList(new Coworker(1,"Abc", LocalDate.of(2024,01,01)));
        return coworkerRepository.findAll();
    }
}
