package org.example.service;

import java.util.List;

import org.example.dto.RegionDto;

public interface RegionService {

  List<RegionDto> findAll();

  RegionDto findById(Long id);

}
