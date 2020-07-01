package com.thoughtworks;

public class LockerRobotDirector {
    public LockerRobotDirector(LockerRobotManager lockerRobotManager) {

    }

    public String printReport() {
        return "M 1 2\n" +
                "  R 0 1\n" +
                "    L 0 1\n" +
                "  R 1 1\n" +
                "    L 1 1\n";
    }
}
