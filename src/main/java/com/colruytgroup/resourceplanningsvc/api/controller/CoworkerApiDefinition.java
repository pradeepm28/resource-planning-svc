package com.colruytgroup.resourceplanningsvc.api.controller;

import com.colruytgroup.resourceplanningsvc.bo.CoworkerBO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Coworker Operations")
public interface CoworkerApiDefinition {
    @Operation(description = "Get All Coworkers")
    @ApiResponse(responseCode = "200",description = "All coworkers details are fetched!!")
    ResponseEntity<List<CoworkerBO>> getCoworkers();

    @Operation(description = "Get Coworker details by Technical Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coworker details by technical id are fetched!"),
            @ApiResponse(responseCode = "404", description = "Coworker by Technical ID not found!")
    })
    ResponseEntity<CoworkerBO> getCoworkerById(@Parameter(in = ParameterIn.PATH, name = "id", description = "Coworker Technical Id", required = true) Long id);

    ResponseEntity<CoworkerBO> getCoworkerByEmployeeCode(String employeeCode);

    ResponseEntity<String> deleteCoworker(Long id);

    ResponseEntity<CoworkerBO> addCoworker(CoworkerBO coworkerBO);

    ResponseEntity<CoworkerBO> updateCoworker(Long id, CoworkerBO coworkerBO);
}
