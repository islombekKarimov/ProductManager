package com.product.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converter.
 *
 * @author Islombek Karimov
 * @since 16.07.2020
 */
public class Converter<T, U> {
  private final Function<T, U> fromDto;
  private final Function<U, T> fromEntity;

  public Converter(Function<T, U> fromDto, Function<U, T> fromEntity) {
    this.fromDto = fromDto;
    this.fromEntity = fromEntity;
  }

  public final U fromDTO(final T dto) {
    return fromDto.apply(dto);
  }

  public final T fromEntity(final U entity) {
    return fromEntity.apply(entity);
  }

  public final List<U> fromDTOs(final Collection<T> DTOs) {
    return DTOs.stream().map(this::fromDTO).collect(Collectors.toList());
  }

  public final List<T> fromEntities(final Collection<U> entities) {
    return entities.stream().map(this::fromEntity).collect(Collectors.toList());
  }
}
