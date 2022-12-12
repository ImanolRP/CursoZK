package org.example.repository;

import org.example.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository
    extends JpaRepository<PokemonEntity, Long>,
    QueryDslPredicateExecutor<PokemonEntity>, PokemonRepositoryCustom {

}
