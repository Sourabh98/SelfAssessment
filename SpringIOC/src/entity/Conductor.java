package entity;

public abstract class Conductor {
	
	/*We would need to give more than one implementation for the conductor that's why we made this class as Abstract, every passenger will ask the conductor for the ticket by invoking the getTicket()
	 * method.*/
	public abstract Ticket getTicket();

}
