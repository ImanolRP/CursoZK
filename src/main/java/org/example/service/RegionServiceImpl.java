package org.example.service;

import java.util.List;

import org.example.dto.RegionDto;
import org.example.mapper.RegionMapper;
import org.example.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

  private RegionRepository regionRepository;
  private RegionMapper regionMapperImpl;

  @Autowired
  public RegionServiceImpl(RegionRepository regionRepository,
      RegionMapper regionMapperImpl) {
    this.regionRepository = regionRepository;
    this.regionMapperImpl = regionMapperImpl;
  }

  @Override
  public List<RegionDto> findAll() {
    return regionMapperImpl.toDtoList(regionRepository.findAll());
  }

  @Override
  public RegionDto findById(Long id) {
    return regionMapperImpl.toDto(regionRepository.findOne(id));
  }

}
