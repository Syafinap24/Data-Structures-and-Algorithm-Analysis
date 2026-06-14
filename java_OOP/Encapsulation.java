package java_OOP;

class DaunEncap {
    private String jenis;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        DaunEncap jambu = new DaunEncap();
        DaunEncap pepaya = new DaunEncap();

        jambu.setJenis("Daun Jambu");
        pepaya.setJenis("Daun Pepaya");

        System.out.println(jambu.getJenis());
        System.out.println(pepaya.getJenis());
    }
}