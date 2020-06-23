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
}
