package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LockerRobotManagerTest {
    @Test
    void should_return_ticket_and_the_bag_stored_in_first_robot_locker_when_store_bag_given_robot_manager_has_2_robot_no_locker() {
        List<Locker> lockers = Arrays.asList(new Locker(2), new Locker(2));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        PrimaryLockerRobot robot2 = new PrimaryLockerRobot(lockers);
        List<LockerRobot> robots = Arrays.asList(robot1, robot2);
        LockerRobotManager robotManager = new LockerRobotManager(robots, null);
        Bag bag = new Bag("");

        Ticket ticket = robotManager.storeBag(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(robot1.checkTicketIsMine(ticket));
    }

    @Test
    void should_return_ticket_and_the_bag_stored_in_second_robot_locker_when_store_bag_given_robot_manager_has_2_robot_no_locker_robot1_is_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        List<Locker> lockers1 = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        PrimaryLockerRobot robot2 = new PrimaryLockerRobot(lockers1);
        List<LockerRobot> robots = Arrays.asList(robot1, robot2);
        LockerRobotManager robotManager = new LockerRobotManager(robots, null);
        Bag bag = new Bag("");
        Bag bag1 = new Bag("");
        robotManager.storeBag(bag);

        Ticket ticket = robotManager.storeBag(bag1);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(robot2.checkTicketIsMine(ticket));
    }
}