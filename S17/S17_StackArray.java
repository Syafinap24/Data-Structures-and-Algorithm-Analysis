package Forum;


public class S17_StackArray  {
		 
	    static class ArrayStack {
	        private int[] arr;
	        private int top;
	        private int capacity;
	 
	        public ArrayStack(int size) {
	            capacity = size;
	            arr = new int[capacity];
	            top = -1;
	        }
	 
	        public boolean isEmpty() {
	            return top == -1;
	        }
	 
	        public boolean isFull() {
	            return top == capacity - 1;
	        }
	 
	        // push() -> menambahkan elemen ke atas stack, O(1)
	        public void push(int data) {
	            if (isFull()) {
	                System.out.println("Stack Overflow, tidak bisa push(" + data + ")");
	                return;
	            }
	            arr[++top] = data;
	            System.out.println("Push " + data + " -> Stack sekarang: " + toStringStack());
	        }
	 
	        // pop() -> menghapus & mengembalikan elemen teratas, O(1)
	        public int pop() {
	            if (isEmpty()) {
	                System.out.println("Stack Underflow, tidak bisa pop()");
	                return -1;
	            }
	            int popped = arr[top--];
	            System.out.println("Pop -> " + popped + " | Stack sekarang: " + toStringStack());
	            return popped;
	        }
	 
	        // peek() -> melihat elemen teratas tanpa menghapus, O(1)
	        public int peek() {
	            if (isEmpty()) {
	                System.out.println("Stack kosong, tidak ada elemen teratas");
	                return -1;
	            }
	            return arr[top];
	        }
	 
	        private String toStringStack() {
	            StringBuilder sb = new StringBuilder("[");
	            for (int i = 0; i <= top; i++) {
	                sb.append(arr[i]);
	                if (i < top) sb.append(", ");
	            }
	            return sb.append("]").toString();
	        }
	    }
	 
	    public static void main(String[] args) {
	        System.out.println("=== Stack Implementation using Array ===");
	        ArrayStack stack = new ArrayStack(5);
	 
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	 
	        System.out.println("Elemen teratas (peek): " + stack.peek());
	 
	        stack.pop();
	 
	        System.out.println("Apakah stack kosong? " + stack.isEmpty());
	 
	        // Uji overflow
	        stack.push(40);
	        stack.push(50);
	        stack.push(60);
	        stack.push(70); // overflow, capacity = 5
	 
	        // Uji underflow
	        stack.pop();
	        stack.pop();
	        stack.pop();
	        stack.pop();
	        stack.pop(); // underflow, stack sudah kosong
	    }
}
