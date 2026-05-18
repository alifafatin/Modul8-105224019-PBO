public class Main {
    public static void main(String[] args) {
        //membuat objek untuk pengiriman udara dan pengiriman darat
        PengirimanDarat pengirimandarat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara pengirimanudara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        //update status setiap pengiriman untuk menampilkan posisi terkini
        pengirimandarat.updateStatus("Sedang di jalan tol Cipali");
        pengirimanudara.updateStatus("Sedang transit di bandara Soekarno-Hatta");

        //menyimpan kedua objek dalam array polymorpshim bertipe layanan pengiriman
        LayananPengiriman[] daftarPengirimans = {pengirimandarat, pengirimanudara};

        //menamimpalkan loop 
        for(LayananPengiriman layanan : daftarPengirimans){
            layanan.cetakResi();

            if(layanan instanceof LacakKargo){
                LacakKargo lacak = (LacakKargo) layanan;
                System.out.println("Status    :" + lacak.cekLokasiTerakhir());
            }

            double ongkos = layanan.hitungOngkosKirim();
            System.out.println("Ongkos Dasar: Rp " + ongkos);

            if(layanan instanceof Asuransi){
                Asuransi asuransi = (Asuransi) layanan;
                asuransi.cetakAsuransi();

                //menghitung total premi
                PengirimanUdara pengirimanUdara = (PengirimanUdara) layanan;
                double premi = asuransi.hitungPremi(pengirimanUdara.getNilaiBarang());
                double total = ongkos + premi;

                System.out.println("Premi (3%): Rp" + premi);
                System.out.println("Total Tagihan: Rp " + total);
            } else {
                System.out.println("Total Tagihan: Rp " + ongkos);
            }
        }
        
    }
}