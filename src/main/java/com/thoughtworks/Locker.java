package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, MPackage> packages = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storePackage(MPackage mPackage) {
        if (packages.size() >= capacity) {
            throw new LockerFullException();
        }
        Ticket ticket = Ticket.getNextTick();
        packages.put(ticket, mPackage);
        return ticket;
    }

    public MPackage takePackage(Ticket ticket) {
        if (packages.containsKey(ticket)) {
            MPackage mPackage = packages.get(ticket);
            packages.remove(ticket);
            return mPackage;
        }
        throw new TicketInvalidException();
    }
}
