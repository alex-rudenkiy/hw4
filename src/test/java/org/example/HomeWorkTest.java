package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeWorkTest {
    private TicketManager ticketManager;

    @BeforeEach public void setUp() {
        ticketManager = new SimpleTicketManager();
    }

    @Test public void testAddPensionTicket() {
        Ticket ticket = new Ticket("pension");
        ticketManager.add(ticket);

        assertEquals(ticket, ticketManager.next());
    }

    @Test public void testAddOtherTicket() {
        Ticket ticket = new Ticket("concert");
        ticketManager.add(ticket);
        assertEquals(ticket, ticketManager.next());
    }

    @Test public void testNextWithEmptyQueue() {
        assertNull(ticketManager.next());
    }

    @Test public void testNextWithMixedTickets() {
        Ticket pensionTicket = new Ticket("pension");
        Ticket otherTicket = new Ticket("concert");
        ticketManager.add(otherTicket);
        ticketManager.add(pensionTicket);

        assertEquals(pensionTicket, ticketManager.next());
        assertEquals(otherTicket, ticketManager.next());
    }

    @Test
    public void testAddNullTicket() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketManager.add(null);
        });
        assertEquals("Ticket cannot be null and type cannot be empty.", exception.getMessage());
    }

    @Test
    public void testAddTicketWithEmptyType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketManager.add(new Ticket(""));
        });
        assertEquals("Ticket cannot be null and type cannot be empty.", exception.getMessage());
    }
}
