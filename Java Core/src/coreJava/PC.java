package coreJava;

public class PC {
	
	public static void main(String[] args) {
		
		Buffer b=new Buffer();
		 Producer producer=new Producer(b);
		 Thread producerThread=new Thread(producer);
		 producerThread.setName("Producer Thread");
		 producerThread.start();
		 Consumer consumer=new Consumer(b);
		 Thread consumerThread=new Thread(consumer);
		 consumerThread.setName("Consumer thread");
		 consumerThread.start();
		 
	}

}
