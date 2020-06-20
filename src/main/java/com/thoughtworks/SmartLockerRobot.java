package com.thoughtworks;

import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        Locker maxFreeSpaceLocker = null;

        for (Locker locker : lockers) {
            if (maxFreeSpaceLocker == null) {
                maxFreeSpaceLocker = locker;
            } else if (locker.getFreeSpace() > maxFreeSpaceLocker.getFreeSpace()) {
                maxFreeSpaceLocker = locker;
            }
        }

        return maxFreeSpaceLocker.storeBag(bag);
    }

    public Bag takeBag(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isReleasedTicket(ticket)) {
                return locker.takeBag(ticket);
            }
        }

        throw new TicketInvalidException();
    }
}
