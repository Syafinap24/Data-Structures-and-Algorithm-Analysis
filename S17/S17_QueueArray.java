package Forum;

public class S17_QueueArray {
		 
	    static class ArrayQueue {
	        private int[] arr;
	        private int front;
	        private int rear;
	        private int capacity;
	 
	        public ArrayQueue(int size) {
	            capacity = size;
	            arr = new int[capacity];
	            front = 0;
	            rear = -1;
	        }
	 
	        public boolean isEmpty() {
	            return rear < front;
	        }
	 
	        public boolean isFull() {
	            return rear == capacity - 1;
	        }
	 
	        // enqueue() -> menambahkan elemen ke belakang antrian (rear), O(1)
	        public void enqueue(int data) {
	            if (isFull()) {
	                System.out.println("Queue penuh, tidak bisa enqueue(" + data + ")");
	                return;
	            }
	            arr[++rear] = data;
	            System.out.println("Enqueue " + data + " -> Queue sekarang: " + toStringQueue());
	        }
	 
	        // dequeue() -> menghapus & mengembalikan elemen dari depan antrian (front), O(1)
	        public int dequeue() {
	            if (isEmpty()) {
	                System.out.println("Queue kosong, tidak bisa dequeue()");
	                return -1;
	            }
	            int data = arr[front++];
	            System.out.println("Dequeue -> " + data + " | Queue sekarang: " + toStringQueue());
	            return data;
	        }
	 
	        // peek() -> melihat elemen terdepan tanpa menghapus, O(1)
	        public int peek() {
	            if (isEmpty()) {
	                System.out.println("Queue kosong, tidak ada elemen terdepan");
	                return -1;
	            }
	            return arr[front];
	        }
	 
	        private String toStringQueue() {
	            StringBuilder sb = new StringBuilder("[");
	            for (int i = front; i <= rear; i++) {
	                sb.append(arr[i]);
	                if (i < rear) sb.append(", ");
	            }
	            return sb.append("]").toString();
	        }
	    }
	 
	    public static void main(String[] args) {
	        System.out.println("=== Queue Implementation using Array ===");
	        ArrayQueue queue = new ArrayQueue(5);
	 
	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	 
	        System.out.println("Elemen terdepan (peek): " + queue.peek());
	 
	        queue.dequeue();
	 
	        System.out.println("Apakah queue kosong? " + queue.isEmpty());
	 
	        // Catatan: ini adalah Queue LINEAR (bukan circular),
	        // jadi slot yang sudah di-dequeue (index 0) tidak bisa dipakai lagi.
	        queue.enqueue(40);
	        queue.enqueue(50);
	        queue.enqueue(60); // penuh karena capacity = 5, meski elemen aktif cuma 4
	 
	        // Uji sampai kosong
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue(); // kosong
	    }
}
