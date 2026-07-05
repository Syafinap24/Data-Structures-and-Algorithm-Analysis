package Forum;

public class Sesi9_DeletionLinkedList {

	class Node {

	    int data;
	    Node next;

	    Node(int data) {
	        this.data = data;
	        next = null;
	    }
	}
	
    Node head;

    // Menambahkan data di akhir linked list
    public void insert(int data) {

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

    // Menghapus node pertama
    public void deleteFirst() {

        if (head != null) {
            head = head.next;
        }
    }

    // Menghapus node di posisi tertentu
    public void deleteMiddle(int position) {

        if (head == null)
            return;

        if (position == 1) {
            deleteFirst();
            return;
        }

        Node current = head;

        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Menghapus node terakhir
    public void deleteLast() {

        if (head == null)
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
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

        Sesi9_DeletionLinkedList list = new Sesi9_DeletionLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Data Awal");
        list.display();

        list.deleteFirst();
        System.out.println("Setelah Delete First");
        list.display();

        list.deleteMiddle(2);
        System.out.println("Setelah Delete Middle");
        list.display();

        list.deleteLast();
        System.out.println("Setelah Delete Last");
        list.display();
    }

}
