package com.thoughtworks;

import java.util.List;

public class LockerRobot {
    private List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storePackage(MPackage mPackage) {
        Ticket ticket = null;
        for (Locker locker : lockers) {
            try {
                ticket = locker.storePackage(mPackage);
                break;
            } catch (LockerFullException e) {

            }
        }

        if (ticket == null) {
            throw new LockerFullException();
        }

        return ticket;
    }

    public MPackage takePackage(Ticket ticket) {
        MPackage mPackage = null;
        for (Locker locker : lockers) {
            try {
                mPackage = locker.takePackage(ticket);
            } catch (TicketInvalidException e) {

            }
        }

        if (mPackage == null) {
            throw new TicketInvalidException();
        }
        return mPackage;
    }
}
