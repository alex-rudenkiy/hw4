package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleTicketManager implements TicketManager {
	private final Queue<Ticket> pensionTickets = new LinkedList<>();
	private final Queue<Ticket> otherTickets = new LinkedList<>();

	@Override public void add(Ticket ticket) {
		if (ticket == null || ticket.type == null || ticket.type.isEmpty()) {
			throw new IllegalArgumentException("Ticket cannot be null and type cannot be empty.");
		}
		if ("pension".equals(ticket.type)) {
			pensionTickets.add(ticket);
		} else {
			otherTickets.add(ticket);
		}
	}

	@Override public Ticket next() {
		if (!pensionTickets.isEmpty()) {
			return pensionTickets.poll();
		} else if (!otherTickets.isEmpty()) {
			return otherTickets.poll();
		}
		return null; // Если очереди пусты, возвращаем null
	}
}
