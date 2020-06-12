package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_package_given_locker_not_full() {
        Locker locker = new Locker(1);

        Ticket ticket = locker.storePacke();

        Assertions.assertNotNull(ticket);
    }
}
