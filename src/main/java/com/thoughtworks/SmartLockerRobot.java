package com.thoughtworks;

import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers;
    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        return lockers.get(0).storeBag(bag);
    }
}
