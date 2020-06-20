package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmartLockerRobotTest {

    @Test
    void should_return_ticket_and_store_bag_to_first_locker_when_store_bag_given_first_locker_have_more_free_space() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        secondLocker.storeBag(new Bag(""));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));

        Ticket ticket = smartLockerRobot.storeBag(new Bag("1"));

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(firstLocker.isReleasedTicket(ticket));
    }

    @Test
    void should_return_ticket_and_store_bag_to_second_locker_when_store_bag_given_second_locker_have_more_free_space() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        firstLocker.storeBag(new Bag(""));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));

        Ticket ticket = smartLockerRobot.storeBag(new Bag("1"));

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(secondLocker.isReleasedTicket(ticket));
    }

    @Test
    void should_return_ticket_and_store_bag_to_first_locker_when_store_bag_given_first_locker_have_same_free_space_with_second_locker() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        firstLocker.storeBag(new Bag("1"));
        secondLocker.storeBag(new Bag("2"));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));

        Ticket ticket = smartLockerRobot.storeBag(new Bag("3"));

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(firstLocker.isReleasedTicket(ticket));
    }

    @Test
    void should_throw_LockerFullException_when_store_bag_given_all_locker_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        firstLocker.storeBag(new Bag("1"));
        secondLocker.storeBag(new Bag("2"));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));

        Assertions.assertThrows(LockerFullException.class, () -> smartLockerRobot.storeBag(new Bag("3")));
    }

    @Test
    void should_get_correct_bag_when_take_bag_given_a_valid_ticket() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        Bag bag = new Bag("1");
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.storeBag(bag);

        Bag gotBag = smartLockerRobot.takeBag(ticket);

        Assertions.assertEquals(bag, gotBag);
    }
}
