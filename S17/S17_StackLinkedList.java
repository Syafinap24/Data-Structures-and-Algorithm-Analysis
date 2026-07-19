package Forum;

public class S17_StackLinkedList {
		 
	    static class Node {
	        int data;
	        Node next;
	 
	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }
	 
	    static class LinkedListStack {
	        private Node top; // top selalu menunjuk ke head dari linked list
	 
	        public boolean isEmpty() {
	            return top == null;
	        }
	 
	        // push() -> menyisipkan node baru di depan (head), jadi top selalu O(1)
	        public void push(int data) {
	            Node newNode = new Node(data);
	            newNode.next = top;
	            top = newNode;
	            System.out.println("Push " + data + " -> Stack sekarang: " + toStringStack());
	        }
	 
	        // pop() -> menghapus & mengembalikan node paling depan (top), O(1)
	        public int pop() {
	            if (isEmpty()) {
	                System.out.println("Stack Underflow, tidak bisa pop()");
	                return -1;
	            }
	            int popped = top.data;
	            top = top.next;
	            System.out.println("Pop -> " + popped + " | Stack sekarang: " + toStringStack());
	            return popped;
	        }
	 
	        // peek() -> melihat elemen teratas tanpa menghapus, O(1)
	        public int peek() {
	            if (isEmpty()) {
	                System.out.println("Stack kosong, tidak ada elemen teratas");
	                return -1;
	            }
	            return top.data;
	        }
	 
	        private String toStringStack() {
	            StringBuilder sb = new StringBuilder("[");
	            Node current = top;
	            while (current != null) {
	                sb.append(current.data);
	                if (current.next != null) sb.append(", ");
	                current = current.next;
	            }
	            return sb.append("]").toString();
	        }
	    }
	 
	    public static void main(String[] args) {
	        System.out.println("=== Stack Implementation using Linked List ===");
	        LinkedListStack stack = new LinkedListStack();
	 
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	 
	        System.out.println("Elemen teratas (peek): " + stack.peek());
	 
	        stack.pop();
	 
	        System.out.println("Apakah stack kosong? " + stack.isEmpty());
	 
	        // Uji underflow
	        stack.pop();
	        stack.pop();
	        stack.pop(); // underflow, stack sudah kosong
	    }
}
