package com.example.footballapp.security.permission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationPermission {
    READ("READ", 1),
    WRITE("WRITE", 2),
    DELETE("DELETE", 4);

    private final String permission;
    private final int level;
}
