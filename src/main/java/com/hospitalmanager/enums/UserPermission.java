package com.hospitalmanager.enums;

public enum UserPermission {
    PATIENT_REGISTRATION("patient:registrition"),
    PATIENT_DATA_READ("patient:data_read"),
    PATIENT_MODIFICATION("patient:modification"),
    PATIENT_DELETE("patient:delete"),
    PATIENT_TRANSFER("patient:transfer"),
    MEDICAL_RECORD_CREATE("medical_record:create"),
    MEDICAL_RECORD_READ("medical_record:read"),
    MEDICAL_RECORD_MODIFICATION("medical_record:modification"),
    MEDICAL_RECORD_DELETE("medical_record:delete"),
    MEDICAL_RECORD_ARCHIVED("medical_record:archived");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
