package entity;

public class DishonestConductor extends Conductor{
	
	private Ticket ticket;

	@Override
	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(Ticket ticket)
	{
		this.ticket=ticket;
	}

}
