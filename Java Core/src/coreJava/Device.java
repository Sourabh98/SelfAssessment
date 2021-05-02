package coreJava;

abstract class Device {

	private String deviceName;
	private boolean state;

//Now both are the instance variables so will get initialised using constructor
	public Device(String deviceName) {
		this.deviceName = deviceName;
//Initially switch will be off so setting the state as false
		this.state = false;
	}

	public void currentState() {
		if (state)
			System.out.println(deviceName + " on");
		else
			System.out.println(deviceName + " off");
	}

	/*Nested inner class starts here..*/	
	public class Switch {

		public void on() {
			state = true;
		}

		public void off() {
			state = false;
		}
	}
}
