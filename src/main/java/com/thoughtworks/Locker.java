package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, MPackage> items = new HashMap<>();
    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storePackage(MPackage mPackage) {
        if (items.size() >= capacity) {
            throw new LockerFullException();
        }
        Ticket ticket = Ticket.getNextTick();
        items.put(ticket, mPackage);
        return ticket;
    }

    public MPackage takePackage(Ticket ticket) {
        if (items.containsKey(ticket)) {
            MPackage mPackage = items.get(ticket);
            items.remove(ticket);
            return mPackage;
        }
        throw new TicketInvalidException();
    }
}
