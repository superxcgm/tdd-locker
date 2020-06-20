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
}
