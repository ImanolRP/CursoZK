package org.example.mapper;

import org.example.dto.SpriteDto;
import org.example.model.SpriteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PokemonMapper.class})
public interface SpriteMapper extends Mapstruct<SpriteDto, SpriteEntity> {
}
