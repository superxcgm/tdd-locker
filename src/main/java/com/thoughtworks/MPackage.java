package com.thoughtworks;

import java.util.Objects;

public class MPackage {
    String name;
    MPackage(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MPackage mPackage = (MPackage) o;
        return Objects.equals(name, mPackage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
