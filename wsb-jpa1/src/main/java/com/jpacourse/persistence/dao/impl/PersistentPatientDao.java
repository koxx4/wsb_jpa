package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
class PersistentPatientDao extends AbstractDao<PatientEntity, Long> implements PatientDao
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
        update(patient);
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", getDomainClass())
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findHavingMoreThanVisits(int visitsCount) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitsCount", getDomainClass())
                .setParameter("visitsCount", visitsCount)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsBeforeYear(int year) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE YEAR(p.dateOfBirth) < :year", getDomainClass())
                .setParameter("year", year)
                .getResultList();
    }
}
