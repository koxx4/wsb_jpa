package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    @Transactional
    public void testShouldAddNewVisit() {
        // given
        var patientId = 1L;
        var doctorId = 1L;
        var visitDateTime = LocalDateTime.now();
        var description = "Some patient visit";

        // when
        patientDao.addNewVisit(patientId, doctorId, visitDateTime, description);

        // then
        var patient = patientDao.findOne(patientId);
        var newVisit = patient.getVisits().get(2);

        assertThat(visitDao.findOne(newVisit.getId())).isNotNull();
        assertThat(patient.getVisits()).isNotEmpty();
        assertThat(newVisit.getDoctor().getId()).isEqualTo(doctorId);
        assertThat(newVisit.getTime()).isEqualTo(visitDateTime);
        assertThat(newVisit.getDescription()).isEqualTo(description);
    }
}
