public interface Asuransi {
    //implementasi metode hitung premi 
    double hitungPremi(double nilaiBarang);

    //membuat default method dialam interface asuransi yang berfungsi untuk mencetak teks 
    default void cetakAsuransi(){
        System.out.println("Polis Asuransi aktif: Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang");
    }
    
}
