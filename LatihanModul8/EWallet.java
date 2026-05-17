public class EWallet extends Pembayaran implements Keamanan{
    //menambahkan atribut nomor HP untuk menyimpan nomor HP.
    private String nomorHP;
    public EWallet(String namaPembayar, double nominal, String nomorHP){
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran(){
        System.out.println("Total Tagihan Keseluruhan: " + nominal);
    }

    @Override
    public boolean autentikasi(){
        System.out.println("Autentikasi Berhasil!");
        return true;
    }
}