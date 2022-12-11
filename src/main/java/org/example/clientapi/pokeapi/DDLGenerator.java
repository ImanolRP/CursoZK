package org.example.clientapi.pokeapi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.application.vm.initoverride.BaseVM;
import org.example.clientapi.pokeapi.objects.Pokemon;
import org.example.clientapi.pokeapi.objects.PokemonPage;
import org.example.clientapi.pokeapi.objects.Region;
import org.example.clientapi.pokeapi.objects.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DDLGenerator {

  private static final Logger LOG = LoggerFactory.getLogger(BaseVM.class);

  public static void main(String[] args) throws IOException {
    PokeApiClient api = new PokeApiClient();
    try {
      List<Region> allRegions = getAllRegions();
      generateInsertRegions(allRegions);
      List<Type> allTypes = getAllPokemonTypes(api);
      generateInsertTypes(allTypes);
      List<Pokemon> allPokemon = getAllPokemonInfo(api);
      generateInsertPokemons(allPokemon, allTypes);
      generateInsertSprites(allPokemon);
    } catch (Exception e) {
      LOG.error("ERRROR al generar sql -> ", e);
    }
  }

  private static void generateInsertSprites(List<Pokemon> allPokemon)
      throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(
        "src/main/resources/curso-zk-ddl/005-insert-sprites.sql"));
    for (Pokemon each : allPokemon) {
      each.getSprites().setId(each.getId());
      writer.write(each.getSprites().toString() + "\n");
    }
    writer.close();
  }

  private static void generateInsertPokemons(List<Pokemon> allPokemon,
      List<Type> allTypes) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(
        "src/main/resources/curso-zk-ddl/004-insert-pokemons.sql"));
    for (Pokemon each : allPokemon) {
      writer.write(each.toString(allTypes) + "\n");
    }
    writer.close();
  }

  private static List<Pokemon> getAllPokemonInfo(PokeApiClient api) {
    PokemonPage pokemonPage = api.getAllPokemon();
    List<Pokemon> allPokemon = new ArrayList<>();
    for (Pokemon pokemon : pokemonPage.getResults()) {
      Pokemon pokemonAux = api.getPokemonByIdOrName(pokemon.getName());
      pokemonAux.setRegion(getRegionById(pokemonAux.getId()));
      allPokemon.add(pokemonAux);
    }
    return allPokemon;
  }

  private static Region getRegionById(Long id) {
    if (1 <= id || id >= 151) {
      // 1 Kanto 1-151
      return new Region(1L, "Kanto");
    } else if (152 <= id || id >= 251) {
      // 2 Johto 152-251
      return new Region(2L, "Johto");
    } else if (252 <= id || id >= 386) {
      // 3 Hoenn 252-386
      return new Region(3L, "Hoenn");
    } else if (387 <= id || id >= 493) {
      // 4 Sinnoh 387-493
      return new Region(4L, "Sinnoh");
    } else if (494 <= id || id >= 649) {
      // 5 Teselia 494-649
      return new Region(5L, "Teselia");
    } else if (650 <= id || id >= 721) {
      // 6 Kalos 650-721
      return new Region(6L, "Kalos");
    } else if (722 <= id || id >= 809) {
      // 7 Alola 722-809
      return new Region(7L, "Alola");
    } else if (810 <= id || id >= 902) {
      // 8 Galar 810-902
      return new Region(8L, "Galar");
    }
    return null;
  }

  private static void generateInsertTypes(List<Type> allTypes)
      throws IOException {
    BufferedWriter writer = new BufferedWriter(
        new FileWriter("src/main/resources/curso-zk-ddl/003-insert-type.sql"));
    for (Type each : allTypes) {
      writer.write(each.toString() + "\n");
    }
    writer.close();
  }

  private static void generateInsertRegions(List<Region> allRegions)
      throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(
        "src/main/resources/curso-zk-ddl/002-insert-regions.sql"));
    for (Region each : allRegions) {
      writer.write(each.toString() + "\n");
    }
    writer.close();
  }

  private static List<Region> getAllRegions() {
    List<Region> allRegions = new ArrayList<>();
    allRegions.add(new Region(1L, "Kanto"));
    allRegions.add(new Region(2L, "Johto"));
    allRegions.add(new Region(3L, "Hoenn"));
    allRegions.add(new Region(4L, "Sinnoh"));
    allRegions.add(new Region(5L, "Teselia"));
    allRegions.add(new Region(6L, "Kalos"));
    allRegions.add(new Region(7L, "Alola"));
    allRegions.add(new Region(8L, "Galar"));
    return allRegions;
  }

  private static List<Type> getAllPokemonTypes(PokeApiClient api) {
    List<Type> types = new ArrayList<>();
    Type type;
    Long idType = 1L;
    do {
      type = api.getTypeByIdOrName(idType);
      if (Objects.nonNull(type)) {
        types.add(type);
        idType++;
      }
    } while (type != null);
    return types;
  }

}
