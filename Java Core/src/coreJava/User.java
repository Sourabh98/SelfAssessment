package coreJava;

public class User {

	public static void main(String[] args) {

		/* Creating two different External Devices */
		System.out.println("Creating two different External Devices");
		ExternalSwitchDevice device1 = new ExternalSwitchDevice("fan");
		ExternalSwitchDevice device2 = new ExternalSwitchDevice("light");
		/* Obtaining the switch for both the devices */
		System.out.println("Obtaining the switch for both the devices");
		Device.Switch switch1 = device1.getSwitch();
		Device.Switch switch2 = device2.getSwitch();
		System.out.println("Fetching the initial state of Device1");
		device1.currentState();
		System.out.println("Fetching the initial state of Device2");
		device2.currentState();
		System.out.println("Turning Switch on for device 1");
		switch1.on();
		System.out.println("Turning Switch on for device 2");
		switch2.on();
		System.out.println("Fetching the initial state of Device1");
		device1.currentState();
		System.out.println("Fetching the initial state of Device2");
		device2.currentState();
	}

}
