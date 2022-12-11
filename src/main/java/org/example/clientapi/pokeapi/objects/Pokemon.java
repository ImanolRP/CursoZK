package org.example.clientapi.pokeapi.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pokemon {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("url")
  private String url;

  @JsonProperty("height")
  private Double height;

  @JsonProperty("weight")
  private Double weight;

  @JsonProperty("types")
  private List<PokemonType> types;

  @JsonProperty("sprites")
  private Sprites sprites;

  public String toString(List<Type> allTypes) {
    Long type1 = getType1(allTypes);
    Long type2 = getType2(allTypes);
    return "INSERT INTO POKEMON (ID_POKEMON, NOMBRE, ALTURA, PESO, TIPO_1, TIPO_2) " //
        + "VALUES (" + id + ", '" + name + "', " + height + ", " + weight + ", "
        + type1 + ", " + type2 + ");";
  }

  private Long getType2(List<Type> allTypes) {
    if (types.size() != 2) {
      return null;
    }
    Type type = getTypeByName(allTypes, types.get(1).getType().getName());
    return type.getId();
  }

  private Long getType1(List<Type> allTypes) {
    Type type = getTypeByName(allTypes, types.get(0).getType().getName());
    return type.getId();
  }

  private Type getTypeByName(List<Type> allTypes, String name) {
    return allTypes.stream()
        .filter(type -> type.getName().equalsIgnoreCase(name)).findFirst()
        .orElse(null);
  }
}
