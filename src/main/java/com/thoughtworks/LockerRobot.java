package com.thoughtworks;

import java.util.List;

public abstract class LockerRobot {
    protected List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket storeBag(Bag bag);

    public Bag takeBag(Ticket ticket) {
        for (Locker locker: lockers) {
            if (locker.isReleasedTicket(ticket)) {
                return locker.takeBag(ticket);
            }
        }
        throw new TicketInvalidException();
    }

    public boolean checkTicketIsMine(Ticket ticket) {
        for (Locker locker: lockers) {
            if (locker.isReleasedTicket(ticket)) {
                return true;
            }
        }
        return false;
    }

    public boolean available() {
        for (Locker locker: lockers) {
            if (locker.available()) {
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        int totalCapacity = 0;
        for (Locker locker: lockers) {
            totalCapacity += locker.getCapacity();
        }
        return totalCapacity;
    }

    public int getAvailableCapacity() {
        int totalAvailableCapacity = 0;
        for (Locker locker: lockers) {
            totalAvailableCapacity += locker.getAvailableCapacity();
        }
        return totalAvailableCapacity;
    }
}
