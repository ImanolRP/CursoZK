package org.example.clientapi.pokeapi.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokemonType {

  @JsonProperty("slot")
  private Integer slot;

  @JsonProperty("type")
  private Type type;

}
