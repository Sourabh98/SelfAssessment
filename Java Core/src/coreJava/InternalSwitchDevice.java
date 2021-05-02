package coreJava;

public class InternalSwitchDevice extends Device {

	public InternalSwitchDevice(String deviceName) {
		super(deviceName);
	}
	
	/*Switch is a nested non static inner class in abstract device class and as you can see the below method is non static so this will get invoked on the instance of the InternalSwitchDevice class
	 * so indirectly for the creation of the object of the Switch class if you see the syntax would be like outerClassObj.new Switch() as the outer class is Device which we extend it here*/
	public Switch getSwitch()
	{
		return new Switch();
	}

}
