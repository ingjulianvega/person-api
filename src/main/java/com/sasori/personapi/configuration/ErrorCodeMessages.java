package com.sasori.personapi.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorCodeMessages {

    public static final String GENERAL_ERROR = "general-error";

    public static final String VALIDATION_NAME_EMPTY = "validation-name-empty";
    public static final String VALIDATION_NAME_NULL = "validation-name-null";
    public static final String VALIDATION_LASTNAME_EMPTY = "validation-lastname-empty";
    public static final String VALIDATION_LASTNAME_NULL = "validation-lastname-null";
    public static final String VALIDATION_GENDER_NULL = "validation-gender-null";
    public static final String VALIDATION_HEIGHT_NULL = "validation-height-null";
    public static final String VALIDATION_HEIGHT_POSITIVE = "validation-height-positive";
    public static final String VALIDATION_WEIGHT_NULL = "validation-weight-null";
    public static final String VALIDATION_WEIGHT_POSITIVE = "validation-weight-positive";

    public static final String VALIDATION_CODE_TO_VALIDATE_EMPTY = "validation-code-to-validate-empty";
    public static final String VALIDATION_CODE_TO_VALIDATE_INVALID_SIZE = "validation-code-to-validate-invalid-size";
    public static final String VALIDATION_CODE_TO_VALIDATE_INVALID_FORMAT = "validation-code-to-validate-invalid-format";
    public static final String VALIDATION_DOCUMENT_TYPE_EMPTY = "validation-document-type-empty";
    public static final String VALIDATION_DOCUMENT_NUMBER_EMPTY = "validation-document-number-empty";
    public static final String VALIDATION_DOCUMENT_TYPE_INVALID_FORMAT = "validation-document-number-invalid-format";
}
