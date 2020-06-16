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
}
