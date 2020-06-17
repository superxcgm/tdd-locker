package com.thoughtworks;

import java.util.List;

public class LockerRobot {
    private List<Locker> lockers;
    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(MPackage mPackage) {
        return lockers.get(0).storePackage(mPackage);
    }
}
