package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();
    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storeBag(Bag bag) {
        if (!available()) {
            throw new LockerFullException();
        }
        Ticket ticket = Ticket.getNextTick();
        ticketBagMap.put(ticket, bag);
        return ticket;
    }

    public Bag takeBag(Ticket ticket) {
        if (isReleasedTicket(ticket)) {
            Bag bag = ticketBagMap.get(ticket);
            ticketBagMap.remove(ticket);
            return bag;
        }
        throw new TicketInvalidException();
    }

    public Boolean available() {
        return ticketBagMap.size() < capacity;
    }

    public Boolean isReleasedTicket(Ticket ticket) {
        return ticketBagMap.containsKey(ticket);
    }

    public int getFreeSpace() {
        return capacity - ticketBagMap.size();
    }
}
