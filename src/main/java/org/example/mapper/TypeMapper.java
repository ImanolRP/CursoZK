package org.example.mapper;

import org.example.dto.TypeDto;
import org.example.model.TypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper extends Mapstruct<TypeDto, TypeEntity> {
}
