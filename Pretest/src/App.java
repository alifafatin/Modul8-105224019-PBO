abstract class Karyawan{
    protected String nama;

    public Karyawan(String nama){
        this.nama = nama;
    }
}

class  Programmer extends Karyawan{
    private double gajiPokok;
    public Programmer(Sting nama, double gajiPokok){
        super(nama);
        this.gajiPokok = gajiPokok;
    }

    void tampilkanGaji(){
        System.out.println("Nama: " + nama);
        System.out.println("Gaji Pokok: " + gajiPokok);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Programer programmer = new Programmer("Nama Aja", 50000);
        programmer.tampilkanGaji();
    }
}