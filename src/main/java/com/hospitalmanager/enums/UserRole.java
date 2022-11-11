package com.hospitalmanager.enums;

public enum UserRole {
    HOSPITAL_DIRECTOR("hospital_director"),
    DOCTOR("doctor"),
    ADMINISTRATOR("administrator"),
    NURSE("nurse"),
    CONTRIBUTOR("contributor"),
    PATIENT("patient");

    private String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

//    HOSPITAL_DIRECTOR(Sets.newHashSet()),
//    DOCTOR(
//            Sets.newHashSet(
//                    PATIENT_TRANSFER,
//                    MEDICAL_RECORD_READ,
//                    MEDICAL_RECORD_MODIFICATION)),
//    ADMINISTRATOR(
//            Sets.newHashSet(
//                    PATIENT_REGISTRATION,
//                    PATIENT_DATA_READ,
//                    PATIENT_MODIFICATION,
//                    PATIENT_DELETE,
//                    PATIENT_TRANSFER,
//                    MEDICAL_RECORD_CREATE,
//                    MEDICAL_RECORD_MODIFICATION,
//                    MEDICAL_RECORD_READ,
//                    MEDICAL_RECORD_DELETE,
//                    MEDICAL_RECORD_ARCHIVED)),
//    CONTRIBUTOR(
//            Sets.newHashSet(
//                    PATIENT_DATA_READ,
//                    MEDICAL_RECORD_READ,
//                    MEDICAL_RECORD_MODIFICATION)),
//    //nurse, dieticians,physiotherapys etc.
//    PATIENT(
//            Sets.newHashSet(
//                    PATIENT_DATA_READ));
//
//    private final Set<UserPermission>permissions;
//
//
//    UserRole(Set<UserPermission> permissions) {
//        this.permissions = permissions;
//    }
}
