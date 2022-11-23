package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

  private Integer id;
  private String model;
  private String make;
  private String preview;
  private String description;
  private Integer price;

  public Car() {}

  public Car(Integer id, String model, String make, String description,
      String preview, Integer price) {
    this.id = id;
    this.model = model;
    this.make = make;
    this.preview = preview;
    this.description = description;
    this.price = price;
  }

}
