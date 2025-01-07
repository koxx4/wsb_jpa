package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientWithPastVisitsDto;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;

import static java.time.LocalDateTime.now;


@Service
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;
    private final PatientMapper patientMapper;
    private final Clock clock;

    @Autowired
    PatientServiceImpl(PatientDao patientDao, PatientMapper patientMapper, Clock clock)
    {
        this.patientDao = patientDao;
        this.patientMapper = patientMapper;
        this.clock = clock;
    }


    @Override
    public PatientWithPastVisitsDto getPatientWithPastVisits(Long patientId) {
        var patient = patientDao.findOne(patientId);
        return patientMapper.toPatientWithPastVisitsDto(patient, now(clock));
    }

    @Override
    @Transactional
    public void removePatient(Long patientId) {
        patientDao.delete(patientId);
    }
}
