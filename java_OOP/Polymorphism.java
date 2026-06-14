package java_OOP;

class DaunPoly {
    void bentuk() {
        System.out.println("Bentuk daun");
    }
}

class DaunJambuPoly extends DaunPoly {
    void bentuk() {
        System.out.println("Daun jambu berbentuk oval");
    }
}

class DaunPepayaPoly extends DaunPoly {
    void bentuk() {
        System.out.println("Daun pepaya berbentuk menjari");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        DaunPoly daun1 = new DaunJambuPoly();
        DaunPoly daun2 = new DaunPepayaPoly();

        daun1.bentuk();
        daun2.bentuk();
    }
}