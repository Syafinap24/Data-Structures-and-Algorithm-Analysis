package Forum;

import java.util.Arrays;

public class sesi8_Deletion {

    public static int[] hapusElemen(int[] arr, int pos) {
        if (pos < 0 || pos >= arr.length) {
            System.out.println("Posisi tidak valid!");
            return arr;
        }

        int[] hasil = new int[arr.length - 1];

        for (int i = 0; i < pos; i++) {
            hasil[i] = arr[i];
        }

        for (int i = pos; i < arr.length - 1; i++) {
            hasil[i] = arr[i + 1];
        }

        System.out.println("Elemen pada indeks " + pos + " berhasil dihapus.");
        return hasil;
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 50, 70, 90};

        System.out.print("Array awal: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();

        arr = hapusElemen(arr, 2);

        System.out.print("Array setelah deletion: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
