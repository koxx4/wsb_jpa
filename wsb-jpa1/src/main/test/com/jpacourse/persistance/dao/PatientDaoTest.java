package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Test
    @Transactional
    public void testShouldFindByLastName() {
        // given
        var lastName = "Jones";

        // when
        var patients = patientDao.findByLastName(lastName);

        // then
        assertThat(patients).hasSize(2);
        assertThat(patients).allMatch(patient -> patient.getLastName().equals(lastName));
    }

    @Test
    @Transactional
    public void testShouldFindHavingMoreThanVisits() {
        // given
        var visitsCount = 1;

        // when
        var patients = patientDao.findHavingMoreThanVisits(visitsCount);

        // then
        assertThat(patients).hasSize(2);
        assertThat(patients).allMatch(patient -> patient.getVisits().size() > visitsCount);
    }

    @Test
    @Transactional
    public void testShouldFindPatientsBeforeYear() {
        // given
        var year = 1994;

        // when
        var patients = patientDao.findPatientsBeforeYear(year);

        // then
        assertThat(patients).hasSize(3);
        assertThat(patients).allMatch(patient -> patient.getDateOfBirth().getYear() < year);
    }

    @Test
    public void shouldThrowOptimisticLockingException() {
        // given
        var patientId = 1L;
        var patientT1 = patientDao.findOne(patientId);

        // when
        patientT1.setFirstName("Adam");
        patientDao.update(patientT1);

        // then
        assertThatThrownBy(() -> {
            patientT1.setFirstName("Madam");
            patientDao.update(patientT1);
        }).isInstanceOf(ObjectOptimisticLockingFailureException.class);
    }
}
