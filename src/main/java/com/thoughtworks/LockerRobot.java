package com.thoughtworks;

public class LockerRobot {
    private Locker[] lockers;
    public LockerRobot(Locker[] lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        for (Locker locker: lockers) {
            if (locker.available()) {
                return locker.storeBag(bag);
            }
        }
        throw new LockerFullException();
    }

    public Bag takeBag(Ticket ticket) {
        for (Locker locker: lockers) {
            if (locker.checkTicket(ticket)) {
                return locker.takeBag(ticket);
            }
        }
        throw new TicketInvalidException();
    }
}
