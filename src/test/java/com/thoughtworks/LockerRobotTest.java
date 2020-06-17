package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LockerRobotTest {
    @Test
    void should_return_ticket_and_store_package_to_1st_locker_when_store_given_first_locker_not_full() {
        Locker firstLocker = new Locker(2);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, new Locker(3)));
        MPackage mPackage = new MPackage();

        Ticket ticket = robot.store(mPackage);

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(mPackage, firstLocker.takePackage(ticket));
    }
}
