package com.sasori.personapi.web.controller;

import com.sasori.personapi.web.model.ApiError;
import com.sasori.personapi.web.model.PersonDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Api(value = "person", tags = "persons")
public interface Person {

    @ApiOperation(value = "Get a person by id", nickname = "get-person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation Successful."),
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class)
    })
    @GetMapping("/{personId}")
    ResponseEntity<PersonDto> getPerson(@NotNull @PathVariable("personId") UUID personId);

    @ApiOperation(value = "Create a new person", nickname = "create-person")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class)
    })
    @PostMapping
    ResponseEntity handlePost(@NotNull @Valid @RequestBody PersonDto PersonDto);

    @ApiOperation(value = "Update a person", nickname = "update-person")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class)
    })
    @PutMapping({"/{personId}"})
    ResponseEntity handleUpdate(@NotNull @PathVariable("personId") UUID personId,
                                @NotNull @Valid @RequestBody PersonDto PersonDto);

    @ApiOperation(value = "Delete a person", nickname = "delete-person")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class)
    })
    @DeleteMapping({"/{personId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@NotNull @PathVariable("personId") UUID personId);
}
