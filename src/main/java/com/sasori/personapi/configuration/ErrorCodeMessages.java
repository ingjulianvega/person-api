package com.sasori.personapi.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorCodeMessages {

    public static final String GENERAL_ERROR = "general-error";

    public static final String VALIDATION_NAME_NULL = "validation-name-null";
    public static final String VALIDATION_LASTNAME_NULL = "validation-lastname-null";
    public static final String VALIDATION_GENDER_NULL = "validation-gender-null";
    public static final String VALIDATION_HEIGHT_POSITIVE = "validation-height-positive";
    public static final String VALIDATION_WEIGHT_POSITIVE = "validation-weight-positive";
    public static final String PERSON_NOT_FOUND = "person-not-found";
}
