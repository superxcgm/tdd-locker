package com.thoughtworks;

import java.util.List;

public class LockerRobotManager {
    private List<LockerRobot> robots;
    public LockerRobotManager(List<LockerRobot> robots, Object o) {
        this.robots = robots;
    }

    public Ticket storeBag(Bag bag) {
        return robots.get(0).storeBag(bag);
    }
}
