package java_OOP;

class Daun {
    void tampil() {
        System.out.println("Ini adalah daun.");
    }
}

class DaunJambu extends Daun {
    void bentuk() {
        System.out.println("Daun jambu berbentuk oval.");
    }
}

class DaunPepaya extends Daun {
    void bentuk() {
        System.out.println("Daun pepaya berbentuk menjari.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        DaunJambu jambu = new DaunJambu();
        DaunPepaya pepaya = new DaunPepaya();

        jambu.tampil();
        jambu.bentuk();
        pepaya.bentuk();
    }
}