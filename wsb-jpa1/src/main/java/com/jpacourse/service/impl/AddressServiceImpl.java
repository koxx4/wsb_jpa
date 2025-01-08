package com.jpacourse.service.impl;

import com.jpacourse.dto.AddressDto;
import com.jpacourse.mapper.AddressMapper;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
class AddressServiceImpl implements AddressService
{
    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao)
    {
        this.addressDao = addressDao;
    }

    @Override
    public AddressDto findById(Long id) {
        final AddressEntity entity = addressDao.findOne(id);
        return AddressMapper.mapToTO(entity);
    }
}
