package com.jpacourse.service;

import com.jpacourse.dto.VisitDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitServiceTest {
    @Autowired
    private VisitService visitService;

    @Test
    @Transactional
    public void testShouldReturnPatientVisits() {
        // given
        var patientId = 5L;

        // when
        var patientVisits = visitService.getPatientVisits(patientId);

        // then
        assertThat(patientVisits).hasSize(2);
        assertThat(patientVisits).extracting(VisitDto::id).containsExactlyInAnyOrder(5L, 6L);
    }
}
