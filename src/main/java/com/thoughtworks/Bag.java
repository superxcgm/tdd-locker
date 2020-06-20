package com.thoughtworks;

import java.util.Objects;

public class Bag {
    private String id;
    Bag(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return Objects.equals(id, bag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
