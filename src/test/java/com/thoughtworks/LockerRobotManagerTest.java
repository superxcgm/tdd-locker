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
        LockerRobotManager robotManager = new LockerRobotManager(robots, Arrays.asList());
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
        LockerRobotManager robotManager = new LockerRobotManager(robots, Arrays.asList());
        Bag bag = new Bag("");
        Bag bag1 = new Bag("");
        robotManager.storeBag(bag);

        Ticket ticket = robotManager.storeBag(bag1);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(robot2.checkTicketIsMine(ticket));
    }

    @Test
    void should_throw_LockerFullException_when_store_bag_given_robot_manager_has_2_robot_no_locker_robots_all_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        List<Locker> lockers1 = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        PrimaryLockerRobot robot2 = new PrimaryLockerRobot(lockers1);
        List<LockerRobot> robots = Arrays.asList(robot1, robot2);
        LockerRobotManager robotManager = new LockerRobotManager(robots, Arrays.asList());
        Bag bag = new Bag("");
        Bag bag1 = new Bag("");
        robotManager.storeBag(bag);
        robotManager.storeBag(bag1);

        Assertions.assertThrows(LockerFullException.class, () -> {
            robotManager.storeBag(bag1);
        });
    }

    @Test
    void should_return_ticket_and_the_bag_stored_in_first_locker_when_store_bag_given_robot_manager_no_robot_has_two_lockers_locker1_is_not_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1), new Locker(1));
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(), lockers);
        Bag bag = new Bag("");

        Ticket ticket = robotManager.storeBag(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers.get(0).isReleasedTicket(ticket));
    }

    @Test
    void should_return_ticket_and_the_bag_stored_in_second_locker_when_store_bag_given_robot_manager_no_robot_has_two_lockers_locker1_is_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1), new Locker(1));
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(), lockers);
        Bag bag = new Bag("");
        Bag bag1 = new Bag("");
        robotManager.storeBag(bag);
        Ticket ticket = robotManager.storeBag(bag1);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers.get(1).isReleasedTicket(ticket));
    }

    @Test
    void should_throw_LockerFullException_when_store_bag_given_robot_manager_no_robot_has_two_lockers_all_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1), new Locker(1));
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(), lockers);
        Bag bag = new Bag("");
        Bag bag1 = new Bag("");
        robotManager.storeBag(bag);
        robotManager.storeBag(bag1);

        Assertions.assertThrows(LockerFullException.class, () -> {
            robotManager.storeBag(new Bag(""));
        });
    }

    @Test
    void should_return_ticket_and_the_bag_stored_in_first_robot_locker_when_store_bag_given_robot_manager_has_one_robot_has_one_locker_robot_locker_not_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        List<Locker> lockers1 = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(robot1), lockers1);

        Ticket ticket = robotManager.storeBag(new Bag(""));

        Assertions.assertTrue(robot1.checkTicketIsMine(ticket));
    }

    @Test
    void should_return_ticket_and_the_bag_stored_in_first_locker_when_store_bag_given_robot_manager_has_one_robot_has_one_locker_robot_locker_is_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        List<Locker> lockers1 = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(robot1), lockers1);
        robotManager.storeBag(new Bag(""));

        Ticket ticket = robotManager.storeBag(new Bag(""));

        Assertions.assertTrue(lockers1.get(0).isReleasedTicket(ticket));
    }

    @Test
    void should_throw_LockerFullException_when_store_bag_given_robot_manager_has_one_robot_has_one_locker_all_full() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        List<Locker> lockers1 = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(robot1), lockers1);
        robotManager.storeBag(new Bag(""));
        robotManager.storeBag(new Bag(""));

        Assertions.assertThrows(LockerFullException.class, () -> {
            robotManager.storeBag(new Bag(""));
        });
    }

    @Test
    void should_take_the_true_bag_when_take_bag_given_robot_manager_has_one_robot_has_no_locker_ticket_is_valid() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(robot1), Arrays.asList());
        Bag bag = new Bag("");
        Ticket ticket = robotManager.storeBag(bag);

        Bag gotBag = robotManager.takeBag(ticket);

        Assertions.assertEquals(bag, gotBag);
    }

    @Test
    void should_take_the_true_bag_when_take_bag_given_robot_manager_has_one_robot_has_no_locker_ticket_is_unValid() {
        List<Locker> lockers = Arrays.asList(new Locker(1));
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(lockers);
        LockerRobotManager robotManager = new LockerRobotManager(Arrays.asList(robot1), Arrays.asList());

        Assertions.assertThrows(TicketInvalidException.class, () -> {
            robotManager.takeBag(new Ticket(0));
        });
    }
}
