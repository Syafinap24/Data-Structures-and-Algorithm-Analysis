package Forum;


public class Sesi9_CircularLinkedList {

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

    Node head;

    // Menambahkan node ke Circular Linked List
    public void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {

            head = newNode;
            newNode.next = head;
            return;
        }

        Node current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;
    }

    // Menampilkan isi Circular Linked List
    public void display() {

        if (head == null) {
            return;
        }

        Node current = head;

        do {

            System.out.print(current.data + " -> ");

            current = current.next;

        } while (current != head);

        System.out.println("(kembali ke head)");
    }

    public static void main(String[] args) {

        Sesi9_CircularLinkedList list = new Sesi9_CircularLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Circular Linked List");
        list.display();

    }

}