package Forum;

public class S14_DoublyLinkedList_Insertion {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;

    // Insert di awal (push at head)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert setelah node tertentu
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) return;
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
    }

    // Insert sebelum node tertentu
    public void insertBefore(Node nextNode, int data) {
        if (nextNode == null) return;
        Node newNode = new Node(data);
        newNode.prev = nextNode.prev;
        newNode.next = nextNode;
        if (nextNode.prev != null) {
            nextNode.prev.next = newNode;
        } else {
            head = newNode;
        }
        nextNode.prev = newNode;
    }

    // Insert di posisi tertentu
    public void insertAtPosition(int pos, int data) {
        if (pos == 1) {
            insertAtHead(data);
            return;
        }
        Node current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Posisi tidak valid.");
            return;
        }
        insertAfter(current, data);
    }

    // Insert di akhir (push at tail)
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
        newNode.prev = current;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        S14_DoublyLinkedList_Insertion dll = new S14_DoublyLinkedList_Insertion();

        dll.insertAtTail(15);
        dll.insertAtTail(35);
        dll.insertAtTail(55);

        System.out.println("Setelah insert tail:");
        dll.display();

        dll.insertAtHead(5);

        System.out.println("Setelah insert head:");
        dll.display();

        dll.insertAtPosition(3, 25);

        System.out.println("Setelah insert posisi 3:");
        dll.display();

        // Insert setelah node dengan data 25
        Node target = dll.head.next.next;
        dll.insertAfter(target, 30);

        System.out.println("Setelah insert after node 25:");
        dll.display();
    }
}