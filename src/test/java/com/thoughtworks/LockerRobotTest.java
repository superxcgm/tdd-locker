package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerRobotTest {
    @Test
    void should_store_to_the_first_locker_and_return_ticket_when_store_bag_given_the_first_locker_is_available() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        Bag bag = new Bag("");

        Ticket ticket = lockerRobot.storeBag(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers[0].checkTicket(ticket));
    }

    @Test
    void should_store_to_the_second_locker_and_return_ticket_when_store_bag_given_the_first_locker_is_full() {
        Locker[] lockers = new Locker[]{new Locker(1), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        Bag bag = new Bag("1");
        lockerRobot.storeBag(new Bag(""));

        Ticket ticket = lockerRobot.storeBag(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers[1].checkTicket(ticket));
    }

    @Test
    void should_throws_exception_when_store_bag_given_the_lockers_all_full() {
        Locker[] lockers = new Locker[]{new Locker(1), new Locker(1)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        lockerRobot.storeBag(new Bag("1"));
        lockerRobot.storeBag(new Bag("2"));
        Bag bag = new Bag("3");

        Assertions.assertThrows(LockerFullException.class, () -> lockerRobot.storeBag(bag));
    }

    @Test
    void should_take_the_correct_bag_when_take_bag_given_the_ticket_is_available() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        Bag bag = new Bag("");

        Ticket ticket = lockerRobot.storeBag(bag);

        Bag got_bag = lockerRobot.takeBag(ticket);
        Assertions.assertTrue(got_bag.equals(bag));
    }

    @Test
    void should_throw_exception_when_take_bag_given_the_ticket_is_unavailable() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        Bag bag = new Bag("");
        lockerRobot.storeBag(bag);

        Assertions.assertThrows(TicketInvalidException.class, () -> {
            Ticket fakeTicket = new Ticket(911);
            lockerRobot.takeBag(fakeTicket);
        });
    }
}
