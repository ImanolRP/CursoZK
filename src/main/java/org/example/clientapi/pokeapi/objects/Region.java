package org.example.clientapi.pokeapi.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Region {

  private Long id;

  private String name;

  public Region(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "INSERT INTO REGION (ID_REGION, NOMBRE) " //
        + "VALUES (" + id + ", '" + name + "');";
  }
}
