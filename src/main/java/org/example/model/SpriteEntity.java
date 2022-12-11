package org.example.model;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SPRITE")
public class SpriteEntity {

  @Id
  @Column(name = "ID_SPRITE")
  private Long id;

  @OneToOne
  @JoinColumn(name = "ID_SPRITE", referencedColumnName = "ID_POKEMON",
      insertable = false, updatable = false)
  private PokemonEntity pokemon;

  @Column(name = "FRONTAL_DEFAULT")
  private String frontalDefault;

  @Column(name = "FRONTAL_FEMALE")
  private String frontalFemale;

  @Column(name = "FRONTAL_SHINY")
  private String frontalShiny;

  @Column(name = "FRONTAL_SHINY_FEMALE")
  private String frontalShinyFemale;

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}
