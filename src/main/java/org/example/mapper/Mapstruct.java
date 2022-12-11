package org.example.mapper;

import java.util.List;

public interface Mapstruct<D, E> {

  D toDto(E element);

  List<D> toDtoList(List<E> elementList);

  E toEntity(D element);

  List<E> toEntityList(List<D> elementList);

}
