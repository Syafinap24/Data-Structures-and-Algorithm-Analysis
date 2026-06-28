package Forum;

public class sesi8_Insertion {

    public static int[] sisipElemen(int[] arr, int elemenBaru, int pos) {
        if (pos < 0 || pos > arr.length) {
            System.out.println("Posisi tidak valid!");
            return arr;
        }

        int[] hasil = new int[arr.length + 1];
        
        for (int i = 0; i < pos; i++) {
            hasil[i] = arr[i];
        }

        hasil[pos] = elemenBaru;

        for (int i = pos; i < arr.length; i++) {
            hasil[i + 1] = arr[i];
        }

        System.out.println("Elemen " + elemenBaru + " berhasil disisipkan pada indeks " + pos);
        return hasil;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.print("Array awal: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();

        arr = sisipElemen(arr, 25, 2);

        System.out.print("Array setelah insertion: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
 
}
