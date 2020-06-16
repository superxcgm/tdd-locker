package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_package_given_locker_not_full() {
        Locker locker = new Locker(1);

        Ticket ticket = locker.storePackage();

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_throw_exception_when_store_package_given_locker_full() {
        Locker locker = new Locker(1);
        locker.storePackage();

        Assertions.assertThrows(LockerFullException.class, () -> locker.storePackage());
    }

    @Test
    void should_take_package_success_when_take_package_given_ticket_valid() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.storePackage();

        Assertions.assertDoesNotThrow(() -> locker.takePackage(ticket));
    }

    @Test
    void should_throw_exception_when_take_package_given_fake_ticket() {
        Locker locker = new Locker(1);

        Assertions.assertThrows(TicketInvalidException.class, () -> locker.takePackage(new Ticket(5)));
    }

    @Test
    void should_throw_exception_when_take_package_given_used_ticket() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.storePackage();
        locker.takePackage(ticket);

        Assertions.assertThrows(RuntimeException.class, () -> locker.takePackage(ticket));
    }
}
