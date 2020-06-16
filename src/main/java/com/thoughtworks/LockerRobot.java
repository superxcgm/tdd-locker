package com.thoughtworks;

public class LockerRobot {
    Locker[] lockers;
    public LockerRobot(Locker[] lockers) {
        this.lockers = lockers;
    }

    public Ticket storePackage(MPackage mPackage) {
        return lockers[0].storePackage(mPackage);
    }
}
