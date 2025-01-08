package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    void addNewVisit(Long patientId, Long doctorId, LocalDateTime visitDateTime, String description);
    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findHavingMoreThanVisits(int visitsCount);
    List<PatientEntity> findPatientsBeforeYear(int year);
}
