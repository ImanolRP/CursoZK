package org.example.service;

import java.util.List;

import org.example.dto.SpriteDto;

public interface SpriteService {

  List<SpriteDto> findAll();

  SpriteDto findById(Long id);

}
