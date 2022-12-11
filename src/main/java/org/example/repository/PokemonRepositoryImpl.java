package org.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PokemonRepositoryImpl implements PokemonRepositoryCustom {

  @PersistenceContext
  EntityManager entityManager;

}
