package com.jpacourse.service.impl;

import com.jpacourse.dto.VisitDto;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDao;
    private final VisitMapper visitMapper;

    @Autowired
    VisitServiceImpl(VisitDao pVisitDao, VisitMapper visitMapper)
    {
        visitDao = pVisitDao;
        this.visitMapper = visitMapper;
    }

    @Override
    public List<VisitDto> getPatientVisits(Long patientId) {
        return visitDao.findByPatientId(patientId).stream()
                .map(visitMapper::mapToDto)
                .collect(toList());
    }
}
