package com.sasori.personapi.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

import static com.sasori.personapi.configuration.ErrorCodeMessages.*;

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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private Timestamp createdDate;
    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private Timestamp lastModifiedDate;
    @NotBlank(message = VALIDATION_NAME_NULL)
    private String name;
    @NotBlank(message = VALIDATION_LASTNAME_NULL)
    private String lastName;
    @NotNull(message = VALIDATION_GENDER_NULL)
    private GenderEnum gender;
    @Positive(message = VALIDATION_HEIGHT_POSITIVE)
    private double height;
    @Positive(message = VALIDATION_WEIGHT_POSITIVE)
    private double weight;
}
