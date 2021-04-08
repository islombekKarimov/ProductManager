package com.product.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.product.enums.RolePermissions.*;

public enum Role {
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE)),
    SELLER(Sets.newHashSet());

    private final Set<RolePermissions> permissions;

    Role(Set<RolePermissions> permissions) {
        this.permissions = permissions;
    }
}
