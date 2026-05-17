abstract class Pembayaran{//membuat class abstrak bernama pembayaran
    protected String namaPembayar; 
    protected double nominal;

    //constructor untuk class Pembayaran
    public Pembayaran(String namaPembayar, double nominal){
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    //concrete method untuk menampilkan detail dan mencetak nama pembayar dan nomminal pada transaksi
    //concrete method merupakan method yang mempunyai isi atau body
    //artinya
    public void tampilkanDetail(){
        System.out.println("Nama Pembayar: " + namaPembayar);
        System.out.println("Nominal Transaksi: " + nominal);
    }

    //abstract method bernama prosespembayaran
    abstract void prosesPembayaran();
}