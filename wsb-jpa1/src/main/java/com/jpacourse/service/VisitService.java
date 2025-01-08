package com.jpacourse.service;

import com.jpacourse.dto.VisitDto;

import java.util.List;

public interface VisitService
{
    List<VisitDto> getPatientVisits(Long patientId);
}
