package com.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListExampleImpl implements ListExample {

    private List<String> list = new ArrayList<>();

    @Override
    public void add(String element) {
        list.add(element);
    }

    @Override
    public void addNonNullable(@NotNull String element) {
        Objects.requireNonNull(element);
        list.add(element);
    }

    @Override
    public String get(Integer index) {
        if (index == null || index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }
}
