package com.rpg.main;

import java.util.Scanner;
import com.rpg.entitas.Pahlawan; //import class phlawan
import com.rpg.entitas.Monster; //import class monster

public class GameEngine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //untuk menerima input
        System.out.print("masukkan nama pahlawan: "); //cetak atau perintah
        String namaPahlawan = scanner.nextLine(); //sinpan hasil input ke variabel nama

        //buat objek pahlawan
        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 150, 20, 100, 3);
        //buat array monster
        Monster[] monsters = {
            new Monster("goblin", 60, 12, "goblin biasa"),
            new Monster("orc", 100, 20, "orc prajurit"),
            new Monster("dragon", 180, 35, "naga tua")
        };

        System.out.println("dimulai!"); //game dimulai!

        //loop untuk panggil monster satu per satu secara berurutan 
        for (int i = 0; i < monsters.length; i++){
            Monster musuh = monsters[i]; //mengambil monster ke i dari array
            System.out.println("lawan " + (i+1) + ": " + musuh.getNama()); //cetak nama monsternya 

            //loop sebagai battle loop, dimana berjalan atau berfungsi selama hp pahlawan dan hp monster di atas 0
            while (pahlawan.getHp() > 0 && musuh.getHp() > 0) {
                pahlawan.tampilkanStatus();//tampilkan status pahlawan dlu
                musuh.tampilkanStatus();//tampilkan status monster dulu
                System.out.println("1. serang  2. skill  3. bertahan  4. heal 0. keluar"); // aksi yang bisa dilakukan oleh pahlawan
                System.out.print("pilihan: "); //inpuit pilihan dari pahlawan 
                int pilihan = scanner.nextInt(); //simpan hasil input
                scanner.nextLine();

                int dmgKeMonster = 0; //nilai awal damage adalah 0
                switch (pilihan) {  //switch case
                    case 1: //jika milih 1 maka akan nyerang monster, monster nerima damage
                        dmgKeMonster = pahlawan.serang();
                        musuh.terimaDamage(dmgKeMonster);
                        break;
                    case 2: //jika milih 2 maka akna menhasilkan skill
                        dmgKeMonster = pahlawan.serang("fireball", 30); //menggunakan skill fireball dengan cost 30
                        musuh.terimaDamage(dmgKeMonster); //monster nerima damage skillnya
                        break;
                    case 3: //pahlawan bertahan, is degending jdi true
                        pahlawan.bertahan();
                        break;
                    case 4: //pahlawan pakai item, hp bertambah menjadi 30
                        pahlawan.gunakanItem();
                        break;
                    case 0:
                        break; //jika pahlawan sudah muak maka bisa langsung selesai 
                    default:
                        System.out.println("pilihan tidak valid!"); //jika pilihan tidak valid maka akan menampilkan ini
                }

                //jika monster masih hidup maka monster akan balas nyerang
                if (musuh.getHp() > 0) {
                    int dmgKePahlawan = musuh.serang();
                    pahlawan.terimaDamage(dmgKePahlawan);
                } else {
                    System.out.println(musuh.getNama() + " telah dikalahkan!");
                }
            }

            if (pahlawan.getHp() <= 0) { //jika pahlawan mati maka akan break
                break;
            }
            System.out.println("lanjut ke monster berikutnya..."); //pahlawan winner
        }

        if (pahlawan.getHp() > 0) { //akhir setelah loop selesai
            //pajlawan masih hidup setelah mengalahkan semua monster
            System.out.println("selamat! " + pahlawan.getNama() + " menamatkan dungeon!");
        } else {
            System.out.println("game over! " + pahlawan.getNama() + " telah gugur.");
        }

        scanner.close(); //untuk menutup scanner
    }
}