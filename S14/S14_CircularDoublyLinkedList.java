package Forum;

public class S14_CircularDoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class CircularDoublyLinkedList {
        Node head = null;
        Node tail = null;

        public void insertAtTail(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                head.prev = tail;
                head.next = tail;
                tail.prev = head;
                tail.next = head;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = head;
                head.prev = newNode;
                tail = newNode;
            }
        }

        public void display() {
            if (head == null) {
                System.out.println("Linked List kosong");
                return;
            }
            Node current = head;
            do {
                System.out.print(current.data + " <-> ");
                current = current.next;
            } while (current != head);
            System.out.println("(kembali ke head)");
        }

        public static void main(String[] args) {
            CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
            // Deret genap: 2, 4, 6, 8
            cdll.insertAtTail(2);
            cdll.insertAtTail(4);
            cdll.insertAtTail(6);
            cdll.insertAtTail(8);

            System.out.println("Circular Doubly Linked List:");
            cdll.display();
        }
    }
}