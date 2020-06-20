package com.thoughtworks;

import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        Locker maxFreeSpaceLocker = lockers.get(0);

        for (Locker locker: lockers) {
            if (locker.getFreeSpace() > maxFreeSpaceLocker.getFreeSpace()) {
                maxFreeSpaceLocker = locker;
            }
        }

        return maxFreeSpaceLocker.storeBag(bag);
    }
}
