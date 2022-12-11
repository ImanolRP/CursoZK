package org.example.mapper;

import org.example.dto.RegionDto;
import org.example.model.RegionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegionMapper extends Mapstruct<RegionDto, RegionEntity> {
}
