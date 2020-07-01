package com.thoughtworks;

public class LockerRobotDirector {
    private final LockerRobotManager lockerRobotManager;

    public LockerRobotDirector(LockerRobotManager lockerRobotManager) {
        this.lockerRobotManager = lockerRobotManager;
    }

    public String printReport() {
        return lockerRobotManager.generateReport();
    }
}
