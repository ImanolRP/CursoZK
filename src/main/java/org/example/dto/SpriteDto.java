package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpriteDto {

  private Long id;
  private String frontalDefault;
  private String frontalFemale;
  private String frontalShiny;
  private String frontalShinyFemale;

}
