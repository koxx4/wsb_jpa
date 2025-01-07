package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static java.util.Optional.ofNullable;

@Repository
public class PersistentPatientDao extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    private final DoctorDao doctorDao;

    @Autowired
    PersistentPatientDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public void addNewVisit(Long patientId, Long doctorId, LocalDateTime visitDateTime, String description) {
        var doctor = ofNullable(doctorDao.findOne(doctorId))
                .orElseThrow(() -> new EntityNotFoundException(doctorId));
        var patient = ofNullable(findOne(patientId))
                .orElseThrow(() -> new EntityNotFoundException(patientId));

        var newVisit = new VisitEntity();
        newVisit.setPatient(patient);
        newVisit.setDoctor(doctor);
        newVisit.setTime(visitDateTime);
        newVisit.setDescription(description);

        patient.getVisits().add(newVisit);
        save(patient);
    }
}
