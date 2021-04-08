package com.product.enums;

public enum RolePermissions {
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin;write");

    private final String permission;

    RolePermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
