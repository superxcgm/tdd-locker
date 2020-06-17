package com.thoughtworks;

import java.util.Objects;

public class Bag {
    private String name;
    Bag(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return Objects.equals(name, bag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
