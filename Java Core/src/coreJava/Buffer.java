package coreJava;

public class Buffer {
	
	private int value;
	private boolean flag=false;
	
	public synchronized void produce(int x) {

		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

		this.value = x;
		System.out.println(value + " is produced.");
		flag = true;
		notify();

	}
	
	public synchronized void consume() {

		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

		System.out.println(value + " is consumed..");
		flag = false;
		notify();

	}

}
