package org.example.service;

import java.util.HashMap;

import org.example.dto.PokemonDto;
import org.example.mapper.PokemonMapper;
import org.example.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

  private PokemonRepository pokemonRepository;
  private PokemonMapper pokemonMapperImpl;

  @Autowired
  public PokemonServiceImpl(PokemonRepository pokemonRepository,
      PokemonMapper pokemonMapperImpl) {
    this.pokemonRepository = pokemonRepository;
    this.pokemonMapperImpl = pokemonMapperImpl;
  }

  @Override
  public Page<PokemonDto> findPageByFilters(Integer numPagina,
      Integer numRegistrosPagina, HashMap<String, Object> filters) {
    return pokemonMapperImpl.toDtoPage(pokemonRepository.findPageByFilters(
        new PageRequest(numPagina, numRegistrosPagina), filters));
  }

}
