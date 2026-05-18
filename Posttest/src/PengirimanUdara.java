//pengiriman udara yang mewarisi layanan pegiriman dan mengimplementasikan kedua interface
public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    //menambahkan atribut untuk pengiriman udara
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh, String nomorPenerbangan, double nilaiBarang) {
    super(noResi, beratBarang, jarakTempuh);
    this.nomorPenerbangan = nomorPenerbangan;
    this.nilaiBarang = nilaiBarang;
    this.statusSaatIni = "Menunggu Jadwal Penerbangan";
}

public double getNilaiBarang() {
    return nilaiBarang;
}

    @Override //mengimplementasikan hitung ongkos kirim
    public double hitungOngkosKirim(){
        double ongkosJalurUdara = (beratBarang * 25000) + (jarakTempuh * 5000);
        return ongkosJalurUdara;
    }

    @Override //mengimplementasikan hitung Premi dimana mengembalikan nilai premi sebesar 3% dari nilai barang
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03;
    }

    //seperti aturan sebelumnya untuk mengimplementasikan method update status untuk memperbarui posisi terkini
    @Override
    public void updateStatus(String Status) {
        this.statusSaatIni = Status;
    }

    @Override //mengimplementasikan method cek lokasi terakhir untuk menampilkan posisi terakhir
    public String cekLokasiTerakhir(){
        return statusSaatIni;
    }
}
