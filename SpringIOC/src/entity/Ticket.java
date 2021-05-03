package entity;

public class Ticket {

	/* Counter variable is used to count number of tickets has been distributed */
	private static int counter;
	private int ticketNumber;

	public Ticket() {
		/*
		 * Every time a ticket object will get created the counter will be increased by
		 * 1 as it is a static member so it's value will be shared in between all the
		 * objects
		 */
		ticketNumber = ++counter;
	}

	public void show() {
		System.out.println("It is ticket Number: " + ticketNumber);
	}
}
