public class Main{
    public static void main(String[] args){
        //membuat objek kartu kredit dan e-wallet
        KartuKredit kk = new KartuKredit("Monica", 100000, "081234567890");
        EWallet ew = new EWallet("Haruka", 50000, "089876543210");

        //simpan data tersebut ke dalam array dengan tipe pembayaram
        Pembayaran[] pmbyrn = {kk, ew};

        //menelusuri array dengan menggunakan perulangan 
        for(Pembayaran p : pmbyrn){
            p.tampilkanDetail(); //memanggil method tampilkan detail untuk menampilkan detail transaksi
            
            //apakah objek p merupakan implements dari Keamanan, jika iya maka masuk ke dalam if
            if(p instanceof Keamanan){ 
                Keamanan k = (Keamanan) p; //melakukan casting objek p ke tipe keamanan
                boolean hasilnya = k.autentikasi(); //memanggil method autentikasi untuk melakukan autentikasi  

                if(hasilnya == true){
                    p.prosesPembayaran(); //memanggil method proses pembayaran untuk memproses pembayaran jika autentikasi berhasil
                }
            }
        }
    }
}
