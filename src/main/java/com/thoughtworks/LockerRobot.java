package com.thoughtworks;

import java.util.List;

public class LockerRobot {
    private List<Locker> lockers;
    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(MPackage mPackage) {
        Ticket ticket = null;
        for (Locker locker: lockers) {
            try {
                ticket = locker.storePackage(mPackage);
                break;
            }catch (LockerFullException e) {

            }
        }

        return ticket;
    }
}
