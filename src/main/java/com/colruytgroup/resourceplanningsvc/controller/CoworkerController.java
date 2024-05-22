package com.colruytgroup.resourceplanningsvc.controller;

import com.colruytgroup.resourceplanningsvc.bo.CoworkerBO;
import com.colruytgroup.resourceplanningsvc.service.CoworkerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "coworkers")
@AllArgsConstructor
public class CoworkerController {
    private CoworkerService coworkerService;

    @GetMapping
    public List<CoworkerBO> getCoworkers(){
        //return Collections.singletonList(new Coworker(1,"Abc", LocalDate.of(2024,01,01)));
        return coworkerService.getCoworkers();
    }

    @GetMapping(value="/{id}")
    public CoworkerBO getCoworkerById(@PathVariable(value="id") Long id){
        return coworkerService.getCoworkerById(id);
    }
}
