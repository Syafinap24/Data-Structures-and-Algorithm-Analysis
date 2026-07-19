package Forum;

public class S17_QueueLinkedList {
		 
	    static class Node {
	        int data;
	        Node next;
	 
	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }
	 
	    static class LinkedListQueue {
	        private Node front, rear;
	 
	        public boolean isEmpty() {
	            return front == null;
	        }
	 
	        // enqueue() -> menambahkan node baru di belakang (rear), O(1)
	        public void enqueue(int data) {
	            Node newNode = new Node(data);
	            if (rear == null) {
	                front = rear = newNode;
	            } else {
	                rear.next = newNode;
	                rear = newNode;
	            }
	            System.out.println("Enqueue " + data + " -> Queue sekarang: " + toStringQueue());
	        }
	 
	        // dequeue() -> menghapus & mengembalikan node paling depan (front), O(1)
	        public int dequeue() {
	            if (isEmpty()) {
	                System.out.println("Queue kosong, tidak bisa dequeue()");
	                return -1;
	            }
	            int data = front.data;
	            front = front.next;
	            if (front == null) {
	                rear = null; // queue jadi kosong total
	            }
	            System.out.println("Dequeue -> " + data + " | Queue sekarang: " + toStringQueue());
	            return data;
	        }
	 
	        // peek() -> melihat elemen terdepan tanpa menghapus, O(1)
	        public int peek() {
	            if (isEmpty()) {
	                System.out.println("Queue kosong, tidak ada elemen terdepan");
	                return -1;
	            }
	            return front.data;
	        }
	 
	        private String toStringQueue() {
	            StringBuilder sb = new StringBuilder("[");
	            Node current = front;
	            while (current != null) {
	                sb.append(current.data);
	                if (current.next != null) sb.append(", ");
	                current = current.next;
	            }
	            return sb.append("]").toString();
	        }
	    }
	 
	    public static void main(String[] args) {
	        System.out.println("=== Queue Implementation using Linked List ===");
	        LinkedListQueue queue = new LinkedListQueue();
	 
	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	 
	        System.out.println("Elemen terdepan (peek): " + queue.peek());
	 
	        queue.dequeue();
	 
	        System.out.println("Apakah queue kosong? " + queue.isEmpty());
	 
	        // Uji sampai kosong
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue(); // kosong
	    }
}
