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
@Table(name = "POKEMON")
public class PokemonEntity {

  @Id
  @Column(name = "ID_POKEMON")
  private Long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "ALTURA")
  private Double altura;

  @Column(name = "PESO")
  private Double peso;

  @OneToOne
  @JoinColumn(name = "TIPO_1", referencedColumnName = "ID_TYPE",
      insertable = false, updatable = false)
  private TypeEntity tipo1;

  @OneToOne
  @JoinColumn(name = "TIPO_2", referencedColumnName = "ID_TYPE",
      insertable = false, updatable = false)
  private TypeEntity tipo2;

  @OneToOne
  @JoinColumn(name = "ID_REGION", referencedColumnName = "ID_REGION",
      insertable = false, updatable = false)
  private RegionEntity region;

  @OneToOne(mappedBy = "pokemon", fetch = FetchType.EAGER)
  private SpriteEntity sprite;

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}
