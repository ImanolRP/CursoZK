package org.example.clientapi.pokeapi.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokemonPage {

  @JsonProperty("count")
  private Long count;

  @JsonProperty("next")
  private String next;

  @JsonProperty("previous")
  private String previous;

  @JsonProperty("results")
  private List<Pokemon> results;

}
