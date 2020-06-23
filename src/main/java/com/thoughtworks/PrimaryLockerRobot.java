package com.thoughtworks;

import java.util.List;

public class PrimaryLockerRobot extends LockerRobot {
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket storeBag(Bag bag) {
        for (Locker locker: lockers) {
            if (locker.available()) {
                return locker.storeBag(bag);
            }
        }
        throw new LockerFullException();
    }
}
