package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter{
    private int mana;//xp pahlawan 
    private int level; //level pahlawan

    //konstruktor untuk kelas pahlawan yang menerima parameter nama, hp, base damage, mana, dan level
    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); //memanggil konstruktor dari kelas induk yaitu karakter
        this.mana = mana;
        this.level = level;
    }

    //membuat getter dan setter untuk masing2 atribut
    public int getMana(){
        return mana;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    @Override
    public int serang(){
        int damage = (baseDamage * level);
        System.out.println(nama + " Menyerang! damage: " + damage);
        return damage; //mengembalikkan nilai damage 
    }
    @Override
    public void tampilkanStatus(){ //menampilkan status
        System.out.println(nama + "| HP: " + hp + "| Mana: " + mana + "| Level: " + level);
    }

    @Override //menggunakan item untuk memulihkan HP
    public void gunakanItem(){
        hp += 30;
        System.out.println(nama + " menggunakan item! HP +30. HP sekarang: " + hp);
    }

    //overloading serang versi skill
    public int serang(String namaSkill, int manaCost){
        //jika mana cukup untuk menggunakan skill, maka akan mengurangi mana sesuai dengan mana cost dan menghasilkan damage yang lebih besar
        if(mana >= manaCost){
            mana -= manaCost;
            int damage = baseDamage * level * 2;
            System.out.println(nama + " menggunakan skill " + namaSkill + "! damage: " + damage);
            return damage;
        } else {
            System.out.println("Mana tidak cukup untuk menggunakan skill " + namaSkill + "!" + "Memerlukan mana: " + manaCost + ", tetapi hanya memiliki: " + mana);
            return 0; //jika mana tidak cukup, maka serangan skill gagal dan menghasilkan damage 0
        }

    }

    @Override
    public void bertahan(){
        isDefending = true; //mengubah status bertahan menjadi true
        System.out.println(nama + " Bertahan!");
    }
}
