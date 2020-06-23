package com.thoughtworks;

import java.util.List;

public class SmartLockerRobot extends LockerRobot{
    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
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
}
