package org.example.mapper;

import java.util.List;

import org.example.dto.PokemonDto;
import org.example.model.PokemonEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@Mapper(componentModel = "spring",
    uses = {RegionMapper.class, SpriteMapper.class, TypeMapper.class})
public interface PokemonMapper extends Mapstruct<PokemonDto, PokemonEntity> {

  default Page<PokemonDto> toDtoPage(Page<PokemonEntity> page) {
    List<PokemonDto> dtos = toDtoList(page.getContent());
    return new PageImpl<>(dtos,
        new PageRequest(page.getNumber(), page.getNumberOfElements()),
        page.getTotalElements());
  }

}
