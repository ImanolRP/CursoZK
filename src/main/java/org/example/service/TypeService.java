package org.example.service;

import java.util.List;

import org.example.dto.TypeDto;

public interface TypeService {

  List<TypeDto> findAll();

  TypeDto findById(Long id);

}
