package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimaryLockerRobotTest {
    @Test
    void should_store_to_the_first_locker_and_return_ticket_when_store_bag_given_the_first_locker_is_available() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag("");

        Ticket ticket = primaryLockerRobot.storeBag(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers[0].isReleasedTicket(ticket));
    }

    @Test
    void should_store_to_the_second_locker_and_return_ticket_when_store_bag_given_the_first_locker_is_full() {
        Locker[] lockers = new Locker[]{new Locker(1), new Locker(2)};
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag("1");
        primaryLockerRobot.storeBag(new Bag(""));

        Ticket ticket = primaryLockerRobot.storeBag(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers[1].isReleasedTicket(ticket));
    }

    @Test
    void should_throws_exception_when_store_bag_given_the_lockers_all_full() {
        Locker[] lockers = new Locker[]{new Locker(1), new Locker(1)};
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        primaryLockerRobot.storeBag(new Bag("1"));
        primaryLockerRobot.storeBag(new Bag("2"));
        Bag bag = new Bag("3");

        Assertions.assertThrows(LockerFullException.class, () -> primaryLockerRobot.storeBag(bag));
    }

    @Test
    void should_take_the_correct_bag_when_take_bag_given_the_ticket_is_available() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag("");

        Ticket ticket = primaryLockerRobot.storeBag(bag);

        Bag gotBag = primaryLockerRobot.takeBag(ticket);
        Assertions.assertEquals(gotBag, bag);
    }

    @Test
    void should_throw_exception_when_take_bag_given_the_ticket_is_unavailable() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag("");
        primaryLockerRobot.storeBag(bag);

        Assertions.assertThrows(TicketInvalidException.class, () -> {
            Ticket fakeTicket = new Ticket(911);
            primaryLockerRobot.takeBag(fakeTicket);
        });
    }
}
