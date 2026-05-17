//membuat interface bernama keamanan
public interface Keamanan{
    //mengembalikan nilai true makanya menggunakan boolean 
    boolean autentikasi(); 
}

//membuat class kartu kredit dan E-Wallet mewarisi class pembayaran dan menrealisasikan interface keamnanan