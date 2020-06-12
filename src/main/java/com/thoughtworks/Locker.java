package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private int capacity;
    private int packages = 0;
    private List<Ticket> list = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storePackage() {
        if (packages >= capacity) {
            throw new RuntimeException("储物柜已满");
        }
        packages++;
        Ticket ticket = Ticket.getNextTick();
        list.add(ticket);
        return ticket;
    }

    public void takePackage(Ticket ticket) {
        if (list.contains(ticket)) {
            list.remove(ticket);
            return;
        }
        throw new RuntimeException("非法票据");
    }
}
