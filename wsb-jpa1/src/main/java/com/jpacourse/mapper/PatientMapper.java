package com.jpacourse.mapper;

import com.jpacourse.dto.PatientWithPastVisitsDto;
import com.jpacourse.dto.VisitDto;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PatientMapper {

    private final VisitMapper visitMapper;

    @Autowired
    public PatientMapper(VisitMapper visitMapper) {
        this.visitMapper = visitMapper;
    }

    public PatientWithPastVisitsDto toPatientWithPastVisitsDto(PatientEntity patientEntity, LocalDateTime visitDateTimeCutoff) {
        if (patientEntity == null) {
            return null;
        }
        return new PatientWithPastVisitsDto(
                patientEntity.getFirstName(),
                patientEntity.getLastName(),
                getPatientVisitsBefore(patientEntity, visitDateTimeCutoff),
                patientEntity.getRegistrationDate()
        );
    }

    private List<VisitDto> getPatientVisitsBefore(PatientEntity patientEntity, LocalDateTime visitDateTimeCutoff) {
        return patientEntity.getVisits().stream()
                .filter(visitEntity -> visitEntity.getTime().isBefore(visitDateTimeCutoff))
                .map(visitMapper::mapToDto)
                .collect(toList());
    }
}
