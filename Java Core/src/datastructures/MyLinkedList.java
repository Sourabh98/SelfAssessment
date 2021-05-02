package datastructures;

public class MyLinkedList {

	private Node currentNode;
	private Node head;

	public void insertData(int data) {

		// If head is null it means we are inserting the first element in the linked
		// list..
		if (head == null) {
			currentNode = new Node();
			currentNode.setData(data);
			head = currentNode;

		}
		// if it is not the first element then we will have to traverse till the last
		// node and will add another node after that last node and will insert the data
		// into that node
		else {
			// as every node will have the reference of he next node...
			while (currentNode.getNextNode() != null) {
				// here we getting the reference of the next node which would be stored in the
				// current node..
				currentNode = currentNode.getNextNode();
			}

			// here we are creating the new node and assigning the reference of this node in
			// the node property of the last node to form the link in between the nodes..
			Node newNode = new Node();
			newNode.setData(data);
			currentNode.setNextNode(newNode);

		}
	}

	/*
	 * This method is to traverse the elements which we have added to the linked
	 * list
	 */

	public void show() {
		// if this condition evaluates to true then this means there is only one node in
		// the linked list.
		if (head.getNextNode() == null) {
			System.out.println(head.getData());
		}

		else {

			currentNode = head;
			while (currentNode.getNextNode() != null) {
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
			System.out.println(currentNode.getData());
		}

	}

	/*
	 * Now we will add the data at the start of the linked list for that we will
	 * have to put the reference of the head node in the new node in which we would
	 * be inserting the data and will make the new inserting node as the head, so as
	 * you can see we only have to put the reference of the head node in the
	 * firstnode which we would be inserting and that's it, that is why insertion
	 * and deletion is easy in linked list for the same in arraylist you will have
	 * to push all the elements by one index
	 */

	public void insertAtStart(int data) {
		Node firstNode = new Node();
		firstNode.setData(data);
		firstNode.setNextNode(head);
		head = firstNode;
	}

	/*
	 * Now we will make a method which will insert the data at a given index, for
	 * this we will have to iterate through the list to find the right index
	 * position for the inserting data(which is why listbased collections are bit
	 * expensive for this operation as it's worst time complexity would be O(n) i.e.
	 * when you will say you wanted to insert the data at the last index then we
	 * will have to iterate the whole list to get the exact index position and then
	 * we will insert the element.)
	 */

	public void insertAt(int index, int data) {

		/*
		 * here creating the node which we need to insert, now when you will insert a
		 * new node at a particular index you need to update the reference of the new
		 * node in the previous node and you need to insert the reference of the next
		 * node into the new node to form the link
		 */
		Node nodeAtIndex = new Node();
		nodeAtIndex.setData(data);
		currentNode = head;
		/*
		 * taking index-1 because head would be at 0th index so when we will execute the
		 * loop for the first time we will get the reference of the node which would be
		 * at the index position 1, so it would be like i=0--> will give the reference
		 * of the node which would be at position 1, now if we wanted to insert the new
		 * node at position 2 then we will have to give the reference of the new node in
		 * the node which would be at position 1 and that means for that i would be 0 so
		 * will have to make sure our for loop executes only once in this case and that
		 * would be possible when we will use the condition i<index-1-->0<2-1(for first
		 * time),1<2-1(for second time this will evaluates to false so our loop will get
		 * executed only once) and so we will get in the current node the node which
		 * would be at position 1 i and in that node we will have to set the reference
		 * of the new node and the reference which would be stored in this node
		 * previously will go into the new node. Just keep in mind you will have to make
		 * some changes if you wanted to insert the data at the end and at first index
		 */
		if (index == 0) {
			insertAtStart(data);
		} else {
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNextNode();
			}
			nodeAtIndex.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(nodeAtIndex);
		}
	}

	/* Now we will write the method to delete the element at a particular index */

	public void deleteAt(int index) {
		currentNode = head;
		/*
		 * If we are deleting the first node then we only need to change the head to the
		 * next node other than that everything would be same
		 */
		if (index == 0) {
			head = currentNode.getNextNode();
		}
		/*
		 * Now of we are deleting any node from in between in that case we will have to
		 * store the reference of the node which is next to the deleting node in the
		 * node which is before to the deleting node, here we are almost using the same logic which we used before for inserAt
		 */
		else {
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNextNode();
			}
			/*Here we are setting the reference of the node which is next to the deleting node in the node which is before the deleting node..*/
			currentNode.setNextNode(currentNode.getNextNode().getNextNode());
		}
	}

}
