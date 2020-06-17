package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LockerRobotTest {
    @Test
    void should_return_ticket_and_store_package_to_1st_locker_when_store_package_given_first_locker_not_full() {
        Locker firstLocker = new Locker(2);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, new Locker(3)));
        MPackage mPackage = new MPackage("");

        Ticket ticket = robot.store(mPackage);

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(mPackage, firstLocker.takePackage(ticket));
    }

    @Test
    void should_return_ticket_and_store_package_to_2nd_locker_when_store_package_given_first_locker_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(3);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, secondLocker));
        MPackage mPackage1 = new MPackage("1");
        MPackage mPackage2 = new MPackage("2");
        robot.store(mPackage1);

        Ticket ticket = robot.store(mPackage2);

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(mPackage2, secondLocker.takePackage(ticket));
    }

    @Test
    void should_hint_locker_full_when_store_package_given_all_locker_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, secondLocker));

        robot.store(new MPackage("1"));
        robot.store(new MPackage("2"));

        Assertions.assertThrows(LockerFullException.class, () -> robot.store(new MPackage("3")));
    }
}
