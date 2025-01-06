package com.jpacourse.mapper;

import com.jpacourse.dto.AddressDto;
import com.jpacourse.persistence.entity.AddressEntity;

public final class AddressMapper
{

    public static AddressDto mapToTO(final AddressEntity addressEntity)
    {
        if (addressEntity == null)
        {
            return null;
        }
        final AddressDto addressDto = new AddressDto();
        addressDto.setId(addressEntity.getId());
        addressDto.setAddressLine1(addressEntity.getAddressLine1());
        addressDto.setAddressLine2(addressEntity.getAddressLine2());
        addressDto.setCity(addressEntity.getCity());
        addressDto.setPostalCode(addressEntity.getPostalCode());
        return addressDto;
    }

    public static AddressEntity mapToEntity(final AddressDto addressDto)
    {
        if(addressDto == null)
        {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressDto.getId());
        addressEntity.setAddressLine1(addressDto.getAddressLine1());
        addressEntity.setAddressLine2(addressDto.getAddressLine2());
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setPostalCode(addressDto.getPostalCode());
        return addressEntity;
    }
}
