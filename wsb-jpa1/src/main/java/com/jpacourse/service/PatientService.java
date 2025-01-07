package com.jpacourse.service;

import com.jpacourse.dto.PatientWithPastVisitsDto;

public interface PatientService
{
    PatientWithPastVisitsDto getPatientWithPastVisits(Long patientId);
    void removePatient(Long patientId);
}
