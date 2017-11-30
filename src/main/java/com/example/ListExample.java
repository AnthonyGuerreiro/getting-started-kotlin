package com.example;

import org.jetbrains.annotations.NotNull;

public interface ListExample {

    void add(String element);
    void addNonNullable(@NotNull String element);
    String get(Integer index);
}
