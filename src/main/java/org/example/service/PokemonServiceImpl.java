package org.example.service;

import java.util.List;

import org.example.dto.PokemonDto;
import org.example.mapper.PokemonMapper;
import org.example.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
  public List<PokemonDto> findAll() {
    return pokemonMapperImpl.toDtoList(pokemonRepository.findAll());
  }

}
