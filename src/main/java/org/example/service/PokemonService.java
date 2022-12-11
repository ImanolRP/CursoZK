package org.example.service;

import java.util.List;

import org.example.dto.PokemonDto;

public interface PokemonService {

  List<PokemonDto> findAll();

}
