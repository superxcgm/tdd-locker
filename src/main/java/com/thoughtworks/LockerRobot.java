package com.thoughtworks;

public class LockerRobot {
    private Locker[] lockers;
    public LockerRobot(Locker[] lockers) {
        this.lockers = lockers;
    }

    public Ticket storePackage(MPackage mPackage) {
        for (Locker locker: lockers) {
            if (locker.available()) {
                return locker.storePackage(mPackage);
            }
        }
        throw new LockerFullException();
    }

    public MPackage tackPackage(Ticket ticket) {
        for (Locker locker: lockers) {
            if (locker.checkTicket(ticket)) {
                return locker.takePackage(ticket);
            }
        }
        throw new TicketInvalidException();
    }
}
