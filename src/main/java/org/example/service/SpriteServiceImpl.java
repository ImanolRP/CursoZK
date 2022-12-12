package org.example.service;

import java.util.List;

import org.example.dto.SpriteDto;
import org.example.mapper.SpriteMapper;
import org.example.repository.SpriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpriteServiceImpl implements SpriteService {

  private SpriteRepository spriteRepository;
  private SpriteMapper spriteMapperImpl;

  @Autowired
  public SpriteServiceImpl(SpriteRepository spriteRepository,
      SpriteMapper spriteMapperImpl) {
    this.spriteRepository = spriteRepository;
    this.spriteMapperImpl = spriteMapperImpl;
  }

  @Override
  public List<SpriteDto> findAll() {
    return spriteMapperImpl.toDtoList(spriteRepository.findAll());
  }

  @Override
  public SpriteDto findById(Long id) {
    return spriteMapperImpl.toDto(spriteRepository.findOne(id));
  }

}
