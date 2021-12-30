package com.example.studing.childrenhelper.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {
   abstract public E toEntity(D d);
   abstract public D toDto(E e);

   public List<E> toListEntities(List<D> dtos){
       return dtos.stream().map(x->toEntity(x)).collect(Collectors.toList());
   }

   public List<D> toListDtos(List<E> entities){
       return entities.stream().map(x->toDto(x)).collect(Collectors.toList());
   }
 }
