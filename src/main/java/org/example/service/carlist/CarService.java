package org.example.service.carlist;

import org.example.dto.CarDTO;

import java.util.List;

public interface CarService {

	/**
	 * Retrieve all cars in the car store.
	 * @return all cars.
	 */
	public List<CarDTO> findAll();

}
