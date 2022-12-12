package org.example.repository;

import org.example.model.SpriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpriteRepository extends JpaRepository<SpriteEntity, Long> {
}
