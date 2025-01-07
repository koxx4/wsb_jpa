package com.jpacourse.mapper;

import com.jpacourse.dto.VisitDto;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class VisitMapper {

    public VisitDto mapToDto(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        return new VisitDto(
                visitEntity.getId(),
                visitEntity.getTime(),
                visitEntity.getDoctor().getFirstName(),
                visitEntity.getDoctor().getLastName(),
                visitEntity.getTreatments().stream()
                        .map(MedicalTreatmentEntity::getType)
                        .map(TreatmentType::name)
                        .collect(toList())
        );
    }
}
