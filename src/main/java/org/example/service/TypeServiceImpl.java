package org.example.service;

import java.util.List;

import org.example.dto.TypeDto;
import org.example.mapper.TypeMapper;
import org.example.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

  private TypeRepository typeRepository;
  private TypeMapper typeMapperImpl;

  @Autowired
  public TypeServiceImpl(TypeRepository typeRepository,
      TypeMapper typeMapperImpl) {
    this.typeRepository = typeRepository;
    this.typeMapperImpl = typeMapperImpl;
  }

  @Override
  public List<TypeDto> findAll() {
    return typeMapperImpl.toDtoList(typeRepository.findAll());
  }

  @Override
  public TypeDto findById(Long id) {
    return typeMapperImpl.toDto(typeRepository.findOne(id));
  }

}
