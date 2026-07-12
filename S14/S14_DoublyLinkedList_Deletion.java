package Forum;

public class S14_DoublyLinkedList_Deletion {

    // Node dijadikan static class biasa (bukan lagi wadah untuk method-method list & main)
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

    Node head;

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
        newNode.prev = current;
    }

    // 1. Hapus node PERTAMA (beginning)
    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // 2. Hapus node SETELAH node tertentu
    public void deleteAfter(Node prevNode) {
        if (prevNode == null || prevNode.next == null) return;
        Node toDelete = prevNode.next;
        prevNode.next = toDelete.next;
        if (toDelete.next != null) {
            toDelete.next.prev = prevNode;
        }
    }

    // 3. Hapus node SEBELUM node tertentu
    public void deleteBefore(Node nextNode) {
        if (nextNode == null || nextNode.prev == null) return;
        Node toDelete = nextNode.prev;
        if (toDelete.prev == null) {
            head = nextNode;
            nextNode.prev = null;
        } else {
            toDelete.prev.next = nextNode;
            nextNode.prev = toDelete.prev;
        }
    }

    // 4. Hapus node di POSISI tertentu
    public void deleteAtPosition(int pos) {
        if (head == null) return;
        if (pos == 1) {
            deleteFirst();
            return;
        }
        Node current = head;
        for (int i = 1; i < pos && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Posisi tidak valid.");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    // 5. Hapus node TERAKHIR (end)
    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
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
        S14_DoublyLinkedList_Deletion dll = new S14_DoublyLinkedList_Deletion();
        // Deret ganjil: 1, 3, 5, 7, 9
        dll.insert(1);
        dll.insert(3);
        dll.insert(5);
        dll.insert(7);
        dll.insert(9);

        System.out.println("Data Awal:");
        dll.display();

        dll.deleteFirst();
        System.out.println("Setelah delete first:");
        dll.display();

        dll.deleteAtPosition(2);
        System.out.println("Setelah delete posisi 2:");
        dll.display();

        dll.deleteLast();
        System.out.println("Setelah delete last:");
        dll.display();
    }
}