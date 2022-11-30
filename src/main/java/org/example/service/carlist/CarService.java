package org.example.service.carlist;

import java.util.List;

import org.example.dto.Car;

public interface CarService {

  public List<Car> findAll();

  public List<Car> search(String filtro);

  public void save(Car coche);

}
