package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao
{

}
