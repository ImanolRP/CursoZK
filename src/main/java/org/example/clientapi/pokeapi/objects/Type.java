package org.example.clientapi.pokeapi.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Type {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("url")
  private String url;

  @Override
  public String toString() {
    return "INSERT INTO TYPE (ID_TYPE, NOMBRE) " //
        + "VALUES (" + id + ", '" + name + "');";
  }
}
