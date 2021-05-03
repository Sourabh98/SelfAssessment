package entity;

import org.springframework.beans.factory.BeanFactory;

import iocContainer.MyFactory;

public class User2 {

	public static void main(String[] args) {

		BeanFactory factory = MyFactory.getIocContainer();
		Conductor conductor = (Conductor) factory.getBean("conductor");
		System.out.println("Displaying hashcode for the conductor: " + conductor.hashCode());
		Ticket ticket = conductor.getTicket();
		System.out.println("Displaying hashcode of the ticket: " + ticket.hashCode());
		ticket.show();
		System.out.println(
				"Asking the container again for the conductor, again the container should return the same conductor as we defined this bean as the singleton..");
		Conductor conductor2 = (Conductor) factory.getBean("conductor");
		System.out.println("Displaying hashcode for the conductor: " + conductor2.hashCode());
		System.out.println(
				"Asking the conductor to give the ticket which is injected by the container at the time of the creation of the Conductor object...");
		Ticket ticket2 = conductor2.getTicket();
		System.out.println(
				"Now ideally the hashcode of this should be different as we have defined the scope of the Ticket as prototype...");
		System.out.println("Printing the hashcode of the ticket2: " + ticket2.hashCode());
		ticket2.show();
		/*But you will see the same ticket hashcode and the number as container is returning the same reference again because the constructor got invoked only once first time after that container kept 
		 * the reference to itself and return the same reference but as we defined the ticket scope as prototype so we were expecting the new object every time so this problem we will have to solve using.
		 * 
		 */
		
		Conductor honestConductor=(HonestConductor)factory.getBean("honestConductor");
		System.out.println("Displaying hashcode for the honest conductor: " + honestConductor.hashCode());
		System.out.println("Asking the honest conductor for the ticket..");
		Ticket ticket1=honestConductor.getTicket();
		System.out.println("Displaying hashcode of the first ticket: " + ticket1.hashCode());
		ticket1.show();
		System.out.println(
				"Asking the container again for the conductor, again the container should return the same conductor as we defined this bean as the singleton..");
		Conductor honestConductor2 = (HonestConductor) factory.getBean("honestConductor");
		System.out.println("Displaying hashcode for the honest conductor2: " + honestConductor2.hashCode());
		System.out.println(
				"Asking the conductor to give the ticket now in this case we have explicitly asked the container in the getTicket method to create a new bean using the getBean method so in this case"
				+ "dependencies are not getting injected by the container..");
		Ticket honestConductorticket2 = honestConductor2.getTicket();
		System.out.println("Printing the hashcode of the honestConductorticket2: " + honestConductorticket2.hashCode());
		honestConductorticket2.show();
		
		/*Now below is the implementation through configuration using lookup method sub element, we have provided the configuration for singleton bean and we have provide the lookup method as well.*/
		System.out.println("Below is the implementation through lookup method..");
		Conductor honestConductorViaLookupMethod=(Conductor)factory.getBean("honestConductorViaLookupMethod");
		System.out.println("Displaying hashcode for the honest conductor via lookup: " + honestConductorViaLookupMethod.hashCode());
		System.out.println("Asking the honest conductor for the ticket..");
		
		Ticket ticketViaLookUp=honestConductorViaLookupMethod.getTicket();
		System.out.println("Displaying hashcode of the first ticket: " + ticketViaLookUp.hashCode());
		ticketViaLookUp.show();
		System.out.println(
				"Asking the container again for the conductor, again the container should return the same conductor as we defined this bean as the singleton..");
		Conductor honestConductorViaLookupMethod2 = (Conductor) factory.getBean("honestConductorViaLookupMethod");
		System.out.println("Displaying hashcode for the honest conductor2: " + honestConductorViaLookupMethod2.hashCode());
		System.out.println(
				"Asking the conductor to give the ticket now in this case we have explicitly asked the container in the getTicket method to create a new bean using the getBean method so in this case"
				+ "dependencies are not getting injected by the container..");
		Ticket ticketViaLookUp2 = honestConductorViaLookupMethod2.getTicket();
		System.out.println("Printing the hashcode of the honestConductorticket2: " + ticketViaLookUp2.hashCode());
		ticketViaLookUp2.show();
		
	}

}
