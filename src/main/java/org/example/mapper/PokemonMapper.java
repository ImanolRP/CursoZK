package org.example.mapper;

import org.example.dto.PokemonDto;
import org.example.model.PokemonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    uses = {RegionMapper.class, SpriteMapper.class, TypeMapper.class})
public interface PokemonMapper extends Mapstruct<PokemonDto, PokemonEntity> {
}
