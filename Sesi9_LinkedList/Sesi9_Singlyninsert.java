package Forum;

public class Sesi9_Singlyninsert {

	class Node {

	    int data;
	    Node next;

	    Node(int data) {
	        this.data = data;
	        next = null;
	    }
	}

    Node head;

    // Menyisipkan elemen di awal linked list
    public void insertAtHead(int data) {

        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;
    }

    // Menyisipkan elemen di akhir linked list
    public void insertAtTail(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Menyisipkan elemen pada posisi tertentu
    public void insertAtPosition(int position, int data) {

        if (position == 1) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);

        Node current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Posisi tidak valid.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Menampilkan isi linked list
    public void display() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Sesi9_Singlyninsert list = new Sesi9_Singlyninsert();

        list.insertAtHead(20);
        list.insertAtHead(10);

        list.insertAtTail(40);

        list.insertAtPosition(3, 30);

        System.out.println("Singly Linked List");
        list.display();

    }

}