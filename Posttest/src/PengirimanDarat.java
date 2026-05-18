//pengiriman daray mewarisi layanan pengiriman dan hanya mengimplementasikan interface dari lacak kargo

public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    //menambahkan atribut baru yaitu jenisTruk dan status saay ini untuk menyimpan jenis truk yang digunakan dan status terkini dari pengiriman darat       
    private String jenisTruk;
    private String statusSaatIni;

    //membuat konstruktor untuk menginisalisasi kan atribut dari layanan pengiriman dan atribut baru yang ditambahkan
    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir"; //status awal pada statusSaatIni adalah menunggu kurir
    }

    // override method hitung ongkos kirim 
    @Override
    public double hitungOngkosKirim() {
        double ongkosJalurDarat = (beratBarang * 5000) + (jarakTempuh * 2000);
        if(jenisTruk.equalsIgnoreCase("Tronton")) {
            ongkosJalurDarat += 150000;
        }
        return ongkosJalurDarat;
    }

    @Override //mengimplementasikan method update status untuk memperbarui posisi terkini
    public void updateStatus(String Status) {
        this.statusSaatIni = Status;
    }

    @Override //mengimplementasikan method cek lokasi terakhir untuk menampilkan posisi terakhir
    public String cekLokasiTerakhir(){
        return statusSaatIni;
    }
}
