public abstract class LayananPengiriman {
    //menyimpan data operasional, dengan hak protected
    protected String noResi;
    protected double beratBarang; //satuan kg
    protected double jarakTempuh; //satuan km

    //constructor untuk inisialisasi data operasional
    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuh){
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }

    //menyiapkan method konkret yang bertugas untuk menampilkan data dari operasional
    public void cetakResi(){
        System.out.println("====================================");
        System.out.println("======= Informasi Pengiriman =======");
        System.out.println("====================================");
        System.out.println("No Resi: " + noResi);
        System.out.println("Berat Barang: " + beratBarang + " kg");
        System.out.println("Jarak Tempuh: " + jarakTempuh + " km");
        System.out.println("====================================");
    }

    //mendeklarasikan sebuah abstract method untuk menghitung biaya pengiriman, yang akan diimplementasikan oleh kelas turunan
    public abstract double hitungOngkosKirim();
}
