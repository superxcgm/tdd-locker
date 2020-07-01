package com.thoughtworks;

import java.util.List;

public class LockerRobotDirector {
    private final List<LockerRobotManager> lockerRobotManagers;

    public LockerRobotDirector(List<LockerRobotManager> lockerRobotManagers) {
        this.lockerRobotManagers = lockerRobotManagers;
    }

    public String printReport() {
        String report = "";
        for (LockerRobotManager manager : lockerRobotManagers) {
            report += manager.generateReport();
        }
        return report;
    }
}
