package com.thoughtworks;

public class Locker {
    private int capacity;
    private int packages = 0;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storePackage() {
        if (packages >= capacity) {
            throw new RuntimeException("储物柜已满");
        }
        packages++;
        return new Ticket();
    }

    public boolean takePackage(Ticket ticket) {
        return true;
    }
}
