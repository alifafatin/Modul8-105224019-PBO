public class KartuKredit extends Pembayaran implements Keamanan{
    private String nomorKartu; //menambahkan atribut nomor kartu untuk menyimpan nomor kartu

    public KartuKredit(String namaPembayar, double nominal, String nomorKartu){
        super(namaPembayar, nominal); //memanggil constructor dari induk yaitu class Pembayaran
        this.nomorKartu = nomorKartu; //menginisialisasi atribut nomor kartu dengan nilai yang diberikan saat membuat KartuKredit
    }

    @Override //mengambil method yang ada didalam class Pembaayaran ke class KartuKredit
    public void prosesPembayaran(){
        double admin = nominal * 0.02;//menghitung admmin yang diambil dari 2% dari nominal transaksi
        double totalTagihan = nominal + admin; //menghitung total tagihan keseluruhan dengan menjumlahkan nominal dengan admin yang sebelumnya sudah dihitung
        //mencetak biaya admin dan total tagihan keseluruhan
        System.out.println("Biaya Admin: " + admin);
        System.out.println("Total Tagihan Keseluruhan: " + totalTagihan);
    }

    @Override //mengambil method yang ada di dalam class pembayaran yaitu autentikasi
    public boolean autentikasi(){
        //autentikasi pin berhasil maka mengembalikan nilai true
        System.out.println("Autentikasi PIN berhasil!");
        return true;
    }

}