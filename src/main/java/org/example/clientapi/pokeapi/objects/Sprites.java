package org.example.clientapi.pokeapi.objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sprites {

  private Long id;

  @JsonProperty("back_default")
  private String back_default;

  @JsonProperty("back_female")
  private String back_female;

  @JsonProperty("back_shiny")
  private String back_shiny;

  @JsonProperty("back_shiny_female")
  private String back_shiny_female;

  @JsonProperty("front_default")
  private String front_default;

  @JsonProperty("front_female")
  private String front_female;

  @JsonProperty("front_shiny")
  private String front_shiny;

  @JsonProperty("front_shiny_female")
  private String front_shiny_female;

  public String getFront_default() {
    if (StringUtils.isBlank(front_default)) {
      return null;
    }
    return "'" + front_default + "'";
  }

  public String getFront_female() {
    if (StringUtils.isBlank(front_female)) {
      return null;
    }
    return "'" + front_female + "'";
  }

  public String getFront_shiny() {
    if (StringUtils.isBlank(front_shiny)) {
      return null;
    }
    return "'" + front_shiny + "'";
  }

  public String getFront_shiny_female() {
    if (StringUtils.isBlank(front_shiny_female)) {
      return null;
    }
    return "'" + front_shiny_female + "'";
  }

  @Override
  public String toString() {
    return "INSERT INTO SPRITE (ID_SPRITE, FRONTAL_DEFAULT, FRONTAL_FEMALE, FRONTAL_SHINY, FRONTAL_SHINY_FEMALE) " //
        + "VALUES (" + id + ", "//
        + getFront_default() + ", " //
        + getFront_female() + ", " //
        + getFront_shiny() + ", " //
        + getFront_shiny_female() //
        + ");";
  }
}
