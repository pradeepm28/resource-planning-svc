package com.colruytgroup.resourceplanningsvc.controller;

import com.colruytgroup.resourceplanningsvc.bo.CoworkerBO;
import com.colruytgroup.resourceplanningsvc.service.CoworkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "coworkers")
@AllArgsConstructor
public class CoworkerController {
    private CoworkerService coworkerService;

    @GetMapping
    public ResponseEntity<List<CoworkerBO>> getCoworkers() {
        //return Collections.singletonList(new Coworker(1,"Abc", LocalDate.of(2024,01,01)));
        //return ResponseEntity.ok(coworkerService.getCoworkers());
        return new ResponseEntity<>(coworkerService.getCoworkers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CoworkerBO> getCoworkerById(@PathVariable(value = "id") Long id) {
        //return ResponseEntity.ok(coworkerService.getCoworkerById(id));
        return new ResponseEntity<>(coworkerService.getCoworkerById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/emp/{employeeCode}")
    public ResponseEntity<CoworkerBO> getCoworkerByEmployeeCode(@PathVariable(value = "employeeCode") String employeeCode) {
        //return ResponseEntity.ok(coworkerService.getCoworkerById(id));
        return new ResponseEntity<>(coworkerService.getCoworkerByEmployeeCode(employeeCode), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCoworker(@PathVariable(value = "id") Long id) {
        coworkerService.deleteCoworker(id);
        return new ResponseEntity<>("Coworker with Id " + id + "is deleted successfully", HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<CoworkerBO> addCoworker(@RequestBody CoworkerBO coworkerBO) {
        CoworkerBO coworker = coworkerService.addCoworker(coworkerBO);
        return new ResponseEntity<>(coworker, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CoworkerBO> updateCoworker(@PathVariable(value = "id") Long id, @RequestBody CoworkerBO coworkerBO) {
        CoworkerBO coworker = coworkerService.updateCoworker(coworkerBO);
        return new ResponseEntity<>(coworker, HttpStatus.OK);
    }
}
