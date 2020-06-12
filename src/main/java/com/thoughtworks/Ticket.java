package com.thoughtworks;

public class Ticket {
    private int ID;

    public Ticket(int ID) {
        this.ID = ID;
    }

    static Ticket getNextTick() {
        return new Ticket(counter++);
    }

    static int counter = 0;
}
