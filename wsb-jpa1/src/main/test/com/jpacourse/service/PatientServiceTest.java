package com.jpacourse.service;

import com.jpacourse.dto.VisitDto;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private VisitDao visitDao;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Test
    @Transactional
    public void testRemovePatient() {
        // given
        var patient = patientDao.findOne(1L);
        var patientDoctors = patient.getVisits().stream()
                .map(VisitEntity::getDoctor)
                .map(DoctorEntity::getId)
                .collect(toList());
        var patientVisits = patient.getVisits().stream()
                .map(VisitEntity::getId)
                .collect(toList());

        //when
        patientService.removePatient(patient.getId());

        //then
        assertThat(patientDao.findOne(patient.getId())).isNull();
        assertThat(visitDao.findAll()).extracting(VisitEntity::getId).doesNotContainAnyElementsOf(patientVisits);
        assertThat(doctorDao.findAll()).extracting(DoctorEntity::getId).containsAll(patientDoctors);
    }

    @Test
    @Transactional
    public void testGetPatientWithPastVisits() {
        // given
        var doctor = doctorDao.findOne(1L);
        var patient = new PatientEntity();

        patient.setFirstName("John");
        patient.setLastName("Cena");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patient.setEmail("email@google.pl");
        patient.setTelephoneNumber("123456789");
        patient.setPatientNumber("#100");
        patient.setRegistrationDate(LocalDate.now());
        patient.setAddress(addressDao.findOne(1L));

        List<VisitEntity> visits = List.of(
                createVisit(LocalDateTime.now().minusDays(1), patient, doctor),
                createVisit(LocalDateTime.now().minusDays(2), patient, doctor),
                createVisit(LocalDateTime.now().minusDays(3), patient, doctor),
                createVisit(LocalDateTime.now().plusDays(1), patient, doctor)
        );
        patient.setVisits(visits);
        patientDao.save(patient);

        // when
        var result = patientService.getPatientWithPastVisits(patient.getId());

        // then
        var visitsDtos = result.pastVisits();
        var visitsIds = result.pastVisits().stream().map(VisitDto::id).collect(toList());

        assertThat(result).isNotNull();
        assertThat(result.firstName()).isEqualTo(patient.getFirstName());
        assertThat(result.lastName()).isEqualTo(patient.getLastName());
        assertThat(result.registrationDate()).isEqualTo(patient.getRegistrationDate());
        assertThat(visitsIds).containsExactlyInAnyOrder(
                visits.get(0).getId(), visits.get(1).getId(), visits.get(2).getId()
        );
        assertThat(visitsDtos).extracting(VisitDto::doctorFirstName).containsOnly(doctor.getFirstName());
        assertThat(visitsDtos).extracting(VisitDto::doctorLastName).containsOnly(doctor.getLastName());
    }

    private VisitEntity createVisit(LocalDateTime visitDateTime, PatientEntity patient, DoctorEntity doctor) {
        var visit = new VisitEntity();
        visit.setTime(visitDateTime);
        visit.setDescription("Test visit " + RandomString.make(10));
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTreatments(List.of(getRandomTreatment()));
        return visit;
    }

    private MedicalTreatmentEntity getRandomTreatment() {
        var treatment = new MedicalTreatmentEntity();
        treatment.setDescription("Test treatment " + RandomString.make(10));
        treatment.setType(TreatmentType.values()[random.nextInt(TreatmentType.values().length)]);
        return treatment;
    }
}
