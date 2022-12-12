package org.example.service;

import java.util.HashMap;

import org.example.dto.PokemonDto;
import org.springframework.data.domain.Page;

public interface PokemonService {

  Page<PokemonDto> findPageByFilters(Integer numPagina,
      Integer numRegistrosPagina, HashMap<String, Object> filters);

}
