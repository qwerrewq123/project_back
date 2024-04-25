package com.example.study.common;

public interface ResponseMessage {
    String SUCCESS = "Success.";
    String VALIDATION_FAILED = "Validation failed.";

    String DUPLICATE_ID = "Duplicate id.";



    String SIGN_IN_FAIL ="Login information mismatch.";
    String CERTIFICATION_FAIL = "Certification Failed.";

    String MAIL_FAIL = "Mail send failed.";
    String DATABASE_ERROR = "Database error.";

    String NOT_EXISTED_USER = "This user does not exist";
    String NOT_EXISTED_STUDY = "This study does not exist";

    String NO_PERMISSION = "No permission";
}
