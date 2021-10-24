package au.com.qsone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import au.com.qsone.model.Property;

@Mapper
public interface PropertyMapper {

    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    public au.com.qsone.entity.Property dtoToEntity(Property source);

    public Property entityToDto(au.com.qsone.entity.Property destination);
}