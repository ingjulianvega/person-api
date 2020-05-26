package com.sasori.personapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
    @Null
    private UUID id;
    @Null
    private Long version;
    @Null
    private Timestamp createdDate;
    @Null
    private Timestamp lastModifiedDate;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    private GenderEnum gender;
    @NotNull
    @NotBlank
    @Positive
    private double height;
    @NotNull
    @NotBlank
    @Positive
    private double weight;
}
