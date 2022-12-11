package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokemonDto {

  private Long id;
  private String nombre;
  private Double altura;
  private Double peso;
  private TypeDto tipo1;
  private TypeDto tipo2;
  private RegionDto region;
  private SpriteDto sprite;

}
