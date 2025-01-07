package com.jpacourse.rest;

import com.jpacourse.dto.PatientWithPastVisitsDto;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController
{
    private final PatientService patientService;

    @Autowired
    private PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    PatientWithPastVisitsDto findById(@PathVariable Long id) {
        return patientService.getPatientWithPastVisits(id);
    }

    @DeleteMapping("/{id}")
    void removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
    }
}
