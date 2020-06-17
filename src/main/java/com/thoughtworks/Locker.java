package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> items = new HashMap<>();
    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storeBag(Bag bag) {
        if (!available()) {
            throw new LockerFullException();
        }
        Ticket ticket = Ticket.getNextTick();
        items.put(ticket, bag);
        return ticket;
    }

    public Bag takeBag(Ticket ticket) {
        if (checkTicket(ticket)) {
            Bag bag = items.get(ticket);
            items.remove(ticket);
            return bag;
        }
        throw new TicketInvalidException();
    }

    public Boolean available() {
        return items.size() < capacity;
    }

    public Boolean checkTicket(Ticket ticket) {
        return items.containsKey(ticket);
    }
}
