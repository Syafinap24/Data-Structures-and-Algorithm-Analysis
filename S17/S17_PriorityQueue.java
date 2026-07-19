package Forum;

public class S17_PriorityQueue {

    static class MinHeapPriorityQueue {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeapPriorityQueue(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1; }
        private int right(int i) { return 2 * i + 2; }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void add(int data) {
            if (size == capacity) {
                System.out.println("Priority Queue penuh, tidak bisa add(" + data + ")");
                return;
            }
            heap[size] = data;
            int current = size;
            size++;

            while (current != 0 && heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
            System.out.println("Add " + data + " -> Heap sekarang: " + toStringHeap());
        }

        public int poll() {
            if (isEmpty()) {
                System.out.println("Priority Queue kosong, tidak bisa poll()");
                return -1;
            }
            int root = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            System.out.println("Poll -> " + root + " | Heap sekarang: " + toStringHeap());
            return root;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Priority Queue kosong");
                return -1;
            }
            return heap[0];
        }

        private void heapifyDown(int i) {
            int smallest = i;
            int l = left(i);
            int r = right(i);

            if (l < size && heap[l] < heap[smallest]) smallest = l;
            if (r < size && heap[r] < heap[smallest]) smallest = r;

            if (smallest != i) {
                swap(i, smallest);
                heapifyDown(smallest);
            }
        }

        private String toStringHeap() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(heap[i]);
                if (i < size - 1) sb.append(", ");
            }
            return sb.append("]").toString();
        }
    }

    static class Pemohon {
        String nama;
        int prioritas;

        Pemohon(String nama, int prioritas) {
            this.nama = nama;
            this.prioritas = prioritas;
        }

        @Override
        public String toString() {
            return nama + " (prioritas " + prioritas + ")";
        }
    }

    static class PemohonPriorityQueue {
        private Pemohon[] heap;
        private int size;
        private int capacity;

        public PemohonPriorityQueue(int capacity) {
            this.capacity = capacity;
            heap = new Pemohon[capacity];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1; }
        private int right(int i) { return 2 * i + 2; }

        private void swap(int i, int j) {
            Pemohon temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void add(Pemohon p) {
            if (size == capacity) {
                System.out.println("Antrian penuh, tidak bisa menambahkan " + p.nama);
                return;
            }
            heap[size] = p;
            int current = size;
            size++;

            while (current != 0 && heap[current].prioritas < heap[parent(current)].prioritas) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public Pemohon poll() {
            if (isEmpty()) return null;
            Pemohon root = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return root;
        }

        private void heapifyDown(int i) {
            int smallest = i;
            int l = left(i);
            int r = right(i);

            if (l < size && heap[l].prioritas < heap[smallest].prioritas) smallest = l;
            if (r < size && heap[r].prioritas < heap[smallest].prioritas) smallest = r;

            if (smallest != i) {
                swap(i, smallest);
                heapifyDown(smallest);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demo Priority Queue (Min-Heap, tanpa library) ===");
        MinHeapPriorityQueue pq = new MinHeapPriorityQueue(10);

        pq.add(3);
        pq.add(1);
        pq.add(2);

        System.out.println("Elemen prioritas tertinggi (peek): " + pq.peek());

        System.out.println();
        while (!pq.isEmpty()) {
            pq.poll();
        }

        System.out.println();
        System.out.println("=== Simulasi Antrian Pembuatan KTP (Priority Queue custom object) ===");
        PemohonPriorityQueue antrianKTP = new PemohonPriorityQueue(10);

        antrianKTP.add(new Pemohon("Dewi", 3));
        antrianKTP.add(new Pemohon("Rian", 1));
        antrianKTP.add(new Pemohon("Sari", 2));

        System.out.println("Urutan pemohon yang dilayani:");
        while (!antrianKTP.isEmpty()) {
            System.out.println(antrianKTP.poll());
        }
    }
}