package org.example.clientapi.pokeapi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.clientapi.pokeapi.objects.Pokemon;
import org.example.clientapi.pokeapi.objects.PokemonPage;
import org.example.clientapi.pokeapi.objects.Type;

public class DDLGenerator {

  public static void main(String[] args) throws IOException {
    PokeApiClient api = new PokeApiClient();
    try {
      List<Type> allTypes = getPokemonTypes(api);
      generateInsertTypes(allTypes);
      List<Pokemon> allPokemon = getAllPokemonInfo(api);
      generateInsertPokemons(allPokemon, allTypes);
      generateInsertSprites(allPokemon);
    } catch (Exception e) {
      int i = 0;
    }
  }

  private static void generateInsertSprites(List<Pokemon> allPokemon)
      throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(
        "src/main/resources/curso-zk-ddl/004-insert-sprites.sql"));
    for (Pokemon each : allPokemon) {
      each.getSprites().setId(each.getId());
      writer.write(each.getSprites().toString() + "\n");
    }
    writer.close();
  }

  private static void generateInsertPokemons(List<Pokemon> allPokemon,
      List<Type> allTypes) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(
        "src/main/resources/curso-zk-ddl/003-insert-pokemons.sql"));
    for (Pokemon each : allPokemon) {
      writer.write(each.toString(allTypes) + "\n");
    }
    writer.close();
  }

  private static List<Pokemon> getAllPokemonInfo(PokeApiClient api) {
    PokemonPage pokemonPage = api.getAllPokemon();
    List<Pokemon> allPokemon = new ArrayList<>();
    for (Pokemon pokemon : pokemonPage.getResults()) {
      allPokemon.add(api.getPokemonByIdOrName(pokemon.getName()));
    }
    return allPokemon;
  }

  private static void generateInsertTypes(List<Type> allTypes)
      throws IOException {
    BufferedWriter writer = new BufferedWriter(
        new FileWriter("src/main/resources/curso-zk-ddl/002-insert-type.sql"));
    for (Type each : allTypes) {
      writer.write(each.toString() + "\n");
    }
    writer.close();
  }

  private static List<Type> getPokemonTypes(PokeApiClient api) {
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
