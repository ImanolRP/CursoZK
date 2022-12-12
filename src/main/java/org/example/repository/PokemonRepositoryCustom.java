package org.example.repository;

import java.util.HashMap;

import org.example.model.PokemonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PokemonRepositoryCustom {

  Page<PokemonEntity> findPageByFilters(PageRequest page,
      HashMap<String, Object> filters);

}
