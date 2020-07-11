package com.product.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * BaseEntity.
 *
 * @author Islombek Karimov
 * @since 11.07.2020
 */
@MappedSuperclass
public class BaseEntity implements Serializable, Cloneable {

  private static final long serialVersionUID = -6949108352947209553L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity that = (BaseEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
