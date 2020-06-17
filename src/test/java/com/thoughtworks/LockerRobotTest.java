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

        Ticket ticket = robot.storePackage(mPackage);

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
        robot.storePackage(mPackage1);

        Ticket ticket = robot.storePackage(mPackage2);

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(mPackage2, secondLocker.takePackage(ticket));
    }

    @Test
    void should_hint_locker_full_when_store_package_given_all_locker_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, secondLocker));

        robot.storePackage(new MPackage("1"));
        robot.storePackage(new MPackage("2"));

        Assertions.assertThrows(LockerFullException.class, () -> robot.storePackage(new MPackage("3")));
    }

    @Test
    void should_get_correct_package_when_take_package_given_a_valid_ticket() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, secondLocker));
        MPackage mPackage = new MPackage("1");
        Ticket ticket = robot.storePackage(mPackage);

        MPackage got_package = robot.takePackage(ticket);

        Assertions.assertEquals(got_package, mPackage);
    }

    @Test
    void should_hint_ticket_invalid_when_take_package_given_a_fake_ticket() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobot robot = new LockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket fakeTicket = new Ticket(666);

        Assertions.assertThrows(TicketInvalidException.class, () -> robot.takePackage(fakeTicket));
    }
}
