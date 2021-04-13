package com.product.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.product.enums.RolePermissions.ADMIN_READ;
import static com.product.enums.RolePermissions.ADMIN_WRITE;

public enum Role {
  ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE)),
  SELLER(Sets.newHashSet());

  private final Set<RolePermissions> permissions;

  Role(Set<RolePermissions> permissions) {
    this.permissions = permissions;
  }

  public Set<RolePermissions> getPermissions() {
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities() {
    Set<SimpleGrantedAuthority> permissions =
        getPermissions().stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toSet());
    permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return permissions;
  }
}
