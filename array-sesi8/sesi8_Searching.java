package Forum;

public class sesi8_Searching {

    public static void cariElemen(int[] arr, int target) {
        boolean ditemukan = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Elemen " + target + " ditemukan pada indeks " + i);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Elemen " + target + " tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 40, 60, 80, 100};

        System.out.println("Array awal: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Indeks " + i + ": " + arr[i]);
        }
        System.out.println();

        cariElemen(arr, 20);
        cariElemen(arr, 49);
    }
}
