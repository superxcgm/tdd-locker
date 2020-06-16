package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerRobotTest {
    @Test
    void should_store_to_the_first_locker_and_return_ticket_when_store_package_given_the_first_locker_is_available() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        MPackage mPackage = new MPackage("");

        Ticket ticket = lockerRobot.storePackage(mPackage);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers[0].takePackage(ticket).equals(mPackage));
    }

    @Test
    void should_store_to_the_second_locker_and_return_ticket_when_store_package_given_the_first_locker_is_full() {
        Locker[] lockers = new Locker[]{new Locker(0), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        MPackage mPackage = new MPackage("");

        Ticket ticket = lockerRobot.storePackage(mPackage);

        Assertions.assertNotNull(ticket);
        Assertions.assertTrue(lockers[1].takePackage(ticket).equals(mPackage));
    }

    @Test
    void should_throws_exception_when_store_package_given_the_lockers_all_full() {
        Locker[] lockers = new Locker[]{new Locker(0), new Locker(0)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        MPackage mPackage = new MPackage("");

        Assertions.assertThrows(LockerFullException.class, () -> lockerRobot.storePackage(mPackage));
    }

    @Test
    void should_take_the_correct_package_when_take_package_given_the_ticket_is_available() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        MPackage mPackage = new MPackage("");

        Ticket ticket = lockerRobot.storePackage(mPackage);

        MPackage gotPackage = lockerRobot.tackPackage(ticket);
        Assertions.assertTrue(gotPackage == mPackage);
    }

    @Test
    void should_throw_exception_when_take_package_given_the_ticket_is_unavailable() {
        Locker[] lockers = new Locker[]{new Locker(2), new Locker(2)};
        LockerRobot lockerRobot = new LockerRobot(lockers);
        MPackage mPackage = new MPackage("");
        lockerRobot.storePackage(mPackage);

        Assertions.assertThrows(TicketInvalidException.class, () -> lockerRobot.tackPackage(new Ticket(911)));
    }
}
