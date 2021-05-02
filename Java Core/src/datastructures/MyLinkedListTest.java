package datastructures;

public class MyLinkedListTest {
	
	public static void main(String[] args) {
		
/*List based collection maintains the insertion order.*/
		MyLinkedList linkedList=new MyLinkedList();
		linkedList.insertData(10);
		linkedList.insertData(20);
		linkedList.insertData(30);
		linkedList.insertAtStart(5);
		linkedList.insertAtStart(2);
		
		//this will insert the value 1 at index 3
		linkedList.insertAt(3, 1);
		linkedList.insertAt(0, 55);
		linkedList.show();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Now performing deletion.......");
		linkedList.deleteAt(0);
		System.out.println("Printing again................");
		linkedList.show();
	}
}
