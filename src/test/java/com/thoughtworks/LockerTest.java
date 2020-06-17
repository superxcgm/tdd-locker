package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_bag_given_locker_not_full() {
        Locker locker = new Locker(1);

        Ticket ticket = locker.storeBag(new Bag(""));

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_throw_exception_when_store_bag_given_locker_full() {
        Locker locker = new Locker(1);
        locker.storeBag(new Bag(""));

        Assertions.assertThrows(LockerFullException.class, () -> locker.storeBag(new Bag("")));
    }

    @Test
    void should_take_bag_success_when_take_bag_given_ticket_valid() {
        Locker locker = new Locker(1);
        Bag bag = new Bag("");
        Ticket ticket = locker.storeBag(bag);

        Bag gotbag = locker.takeBag(ticket);

        Assertions.assertTrue(bag.equals(gotbag));
    }

    @Test
    void should_take_the_correct_bag_when_take_bag_given_ticket_valid() {
        Locker locker = new Locker(2);
        Bag onebag = new Bag("123");
        Bag twobag = new Bag("456");

        Ticket oneTicket = locker.storeBag(onebag);
        Bag gotbag = locker.takeBag(oneTicket);

        Assertions.assertFalse(gotbag.equals(twobag));
    }

    @Test
    void should_throw_exception_when_take_bag_given_fake_ticket() {
        Locker locker = new Locker(1);

        Assertions.assertThrows(TicketInvalidException.class, () -> locker.takeBag(new Ticket(5)));
    }

    @Test
    void should_throw_exception_when_take_bag_given_used_ticket() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.storeBag(new Bag(""));
        locker.takeBag(ticket);

        Assertions.assertThrows(TicketInvalidException.class, () -> locker.takeBag(ticket));
    }
}
