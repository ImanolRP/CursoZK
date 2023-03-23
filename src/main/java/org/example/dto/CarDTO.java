package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {

  private Integer id;
  private String model;
  private String make;
  private String description;
  private String preview;
  private Integer price;

  public CarDTO(Integer id, String model, String make, String description,
      String preview, Integer price) {
    this.id = id;
    this.model = model;
    this.make = make;
    this.description = description;
    this.preview = preview;
    this.price = price;
  }

}
