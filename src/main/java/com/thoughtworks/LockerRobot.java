package com.thoughtworks;

public class LockerRobot {
    Locker[] lockers;
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
}
