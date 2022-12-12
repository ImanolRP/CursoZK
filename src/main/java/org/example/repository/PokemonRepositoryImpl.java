package org.example.repository;

import java.util.HashMap;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.example.model.PokemonEntity;
import org.example.model.QPokemonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class PokemonRepositoryImpl implements PokemonRepositoryCustom {

  /**
   * The Entity manager.
   */
  @PersistenceContext
  EntityManager entityManager;

  @Override
  public Page<PokemonEntity> findPageByFilters(PageRequest page,
      HashMap<String, Object> filters) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

    QueryResults<PokemonEntity> resultPage = queryFactory //
        .selectFrom(QPokemonEntity.pokemonEntity) //
        .where(getWhere(filters)) //
        .offset(page.getPageNumber() * page.getPageSize()) //
        .limit(page.getPageSize()) //
        .fetchResults();

    return new PageImpl<>(resultPage.getResults(), page, resultPage.getTotal());
  }

  private Predicate getWhere(HashMap<String, Object> filters) {
    BooleanBuilder where = new BooleanBuilder();

    if (Objects.isNull(filters)) {
      return where;
    }
    if (Objects.nonNull(filters.get("nombrePokemon"))) {
      String nombrePokemon = (String) filters.get("nombrePokemon");
      where.and(QPokemonEntity.pokemonEntity.nombre
          .containsIgnoreCase(nombrePokemon));
    }
    if (Objects.nonNull(filters.get("alturaMinPokemon"))) {
      Double alturaMinPokemon = (Double) filters.get("alturaMinPokemon");
      where.and(QPokemonEntity.pokemonEntity.altura.goe(alturaMinPokemon));
    }
    if (Objects.nonNull(filters.get("alturaMaxPokemon"))) {
      Double alturaMaxPokemon = (Double) filters.get("alturaMaxPokemon");
      where.and(QPokemonEntity.pokemonEntity.altura.loe(alturaMaxPokemon));
    }
    if (Objects.nonNull(filters.get("pesoMinPokemon"))) {
      Double pesoMinPokemon = (Double) filters.get("pesoMinPokemon");
      where.and(QPokemonEntity.pokemonEntity.peso.goe(pesoMinPokemon));
    }
    if (Objects.nonNull(filters.get("pesoMaxPokemon"))) {
      Double pesoMaxPokemon = (Double) filters.get("pesoMaxPokemon");
      where.and(QPokemonEntity.pokemonEntity.peso.loe(pesoMaxPokemon));
    }
    if (Objects.nonNull(filters.get("tipo1"))) {
      Long tipo1 = (Long) filters.get("tipo1");
      where.and(QPokemonEntity.pokemonEntity.tipo1.id.eq(tipo1)
          .or(QPokemonEntity.pokemonEntity.tipo2.id.eq(tipo1)));
    }
    if (Objects.nonNull(filters.get("tipo2"))) {
      Long tipo2 = (Long) filters.get("tipo2");
      where.and(QPokemonEntity.pokemonEntity.tipo1.id.eq(tipo2)
          .or(QPokemonEntity.pokemonEntity.tipo2.id.eq(tipo2)));
    }
    if (Objects.nonNull(filters.get("region"))) {
      Long region = (Long) filters.get("region");
      where.and(QPokemonEntity.pokemonEntity.region.id.eq(region));
    }
    return where;
  }

}
