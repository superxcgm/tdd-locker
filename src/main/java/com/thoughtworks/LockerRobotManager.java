package com.thoughtworks;

import java.util.List;

public class LockerRobotManager {
    private List<LockerRobot> robots;
    private List<Locker> lockers;
    public LockerRobotManager(List<LockerRobot> robots, List<Locker> lockers) {
        this.robots = robots;
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        for (LockerRobot robot: robots) {
            if (robot.available()) {
                return robot.storeBag(bag);
            }
        }

        for (Locker locker: lockers) {
            if (locker.available()) {
                return locker.storeBag(bag);
            }
        }

        throw new LockerFullException();
    }

    public Bag takeBag(Ticket ticket) {
        for (LockerRobot robot: robots) {
            if (robot.checkTicketIsMine(ticket)) {
                return robot.takeBag(ticket);
            }
        }

        for (Locker locker: lockers) {
            if (locker.isReleasedTicket(ticket)) {
                return locker.takeBag(ticket);
            }
        }

        throw  new TicketInvalidException();
    }

    public int getAvailableCapacity() {
        int totalAvailableCapacity = 0;
        for (LockerRobot robot : robots) {
            totalAvailableCapacity += robot.getAvailableCapacity();
        }
        for (Locker locker : lockers) {
            totalAvailableCapacity += locker.getAvailableCapacity();
        }
        return totalAvailableCapacity;
    }

    public int getCapacity() {
        int totalCapacity = 0;
        for (LockerRobot robot : robots) {
            totalCapacity += robot.getCapacity();
        }
        for (Locker locker : lockers) {
            totalCapacity += locker.getCapacity();
        }
        return totalCapacity;
    }

    public String generateReport() {
        String report = "";
        report += "M " + getAvailableCapacity() + " " + getCapacity() + "\n";
        for (Locker locker : lockers) {
            report += "  L " + locker.getAvailableCapacity() + " " + locker.getCapacity() + "\n";
        }
        for (LockerRobot robot : robots) {
            report += "  R " + robot.getAvailableCapacity() + " " + robot.getCapacity() + "\n";
            for (Locker locker : robot.lockers) {
                report += "    L " + locker.getAvailableCapacity() + " " + locker.getCapacity() + "\n";
            }
        }
        return report;
    }
}
