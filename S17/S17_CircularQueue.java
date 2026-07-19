package Forum;
 

public class S17_CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;
 
    public S17_CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }
 
    public boolean isFull() {
        return size == capacity;
    }
 
    public boolean isEmpty() {
        return size == 0;
    }
 
    // enqueue() -> menambahkan elemen ke rear, lalu rear berputar dengan modulus
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue penuh, tidak bisa enqueue(" + data + ")");
            return;
        }
        queue[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
        System.out.print("Enqueue " + data + " -> ");
        display();
    }
 
    // dequeue() -> menghapus elemen dari front, lalu front berputar dengan modulus
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong, tidak bisa dequeue()");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.print("Dequeue -> " + data + " | ");
        display();
        return data;
    }
 
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong");
            return;
        }
        StringBuilder sb = new StringBuilder("Circular Queue: [");
        int i = front;
        for (int count = 0; count < size; count++) {
            sb.append(queue[i]);
            if (count < size - 1) sb.append(", ");
            i = (i + 1) % capacity;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("=== Demo Circular Queue (capacity = 5, tanpa library) ===");
        S17_CircularQueue cq = new S17_CircularQueue(5);
 
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.enqueue(60); // Queue penuh, akan ditolak
 
        cq.dequeue(); // 10 keluar, slot depan (index 0) kosong dan bisa dipakai lagi
        cq.dequeue(); // 20 keluar, slot index 1 kosong
 
        // Membuktikan efisiensi ruang: rear berputar kembali ke indeks awal (0, 1, ...)
        cq.enqueue(60);
        cq.enqueue(70);
 
        cq.display();
    }
}