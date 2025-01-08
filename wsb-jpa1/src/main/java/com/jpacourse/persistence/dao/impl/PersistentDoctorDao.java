package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

@Repository
class PersistentDoctorDao extends AbstractDao<DoctorEntity, Long> implements DoctorDao
{

}
