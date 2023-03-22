package org.example.service.carlist;

import org.example.dto.CarDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CarServiceImpl implements CarService {

	private List<CarDTO> cars = new ArrayList<CarDTO>(20);

	public CarServiceImpl() {

		Random r = new Random(0L); // random but same data
		String[][] raw = {{"China", "Geely", "Panda", "Sedan"}, {"France", "Peugeot", "RCZ", "Sport"},
				{"France", "Renault", "Megane", "Sedan"}, {"Germany", "Audi", "TT", "Sport"},
				{"Germany", "BMW", "X3", "SUV"}, {"Germany", "Mercedes-Benz", "Sprinter", "Van"},
				{"Germany", "Volkswagen", "Transporter", "Van"}, {"Germany", "Porsche", "Cayenne", "SUV"},
				{"Italy", "Ferrari", "F430", "Supercar"}, {"Italy", "Lamborghini", "Gallardo", "Supercar"},
				{"Japan", "Toyota", "Camry", "Sedan"}, {"Japan", "Mitsubishi", "Pajero", "SUV"},
				{"Japan", "Nissan", "GT-R", "Sport"}, {"Japan", "Subaru", "Legacy", "MPV"},
				{"Korea", "Hyundai", "Tucson", "SUV"}, {"Korea", "Kia", "Rio", "Sedan"},
				{"Sweden", "Volvo", "S40", "Sedan"}, {"Taiwan", "LUXGEN", "Luxgen7", "MPV"},
				{"United States", "Ford", "Focus", "Sedan"},
				{"United Kingdom", "Land Rover", "Discovery", "SUV"}};
		int[] disp = new int[]{1600, 1800, 2000, 2400, 3000, 3200, 3500}; // engine displacement
		double[] cost = new double[]{19999.9, 24999.9, 29999.9, 34999.9, 39999.9}; // cost

		// create in-memory data
		for(int i = 0; i < 20; ++i) {
			CarDTO car = new CarDTO();
			car.setCountry(raw[i][0]);
			car.setMake(raw[i][1]);
			car.setModel(raw[i][2]);
			car.setType(raw[i][3]);
			cars.add(car);
		}
		Collections.shuffle(cars, r);
	}

	public List<CarDTO> findAll() {
		return cars;
	}

}
