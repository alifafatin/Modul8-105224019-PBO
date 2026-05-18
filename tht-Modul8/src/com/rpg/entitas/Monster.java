package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Monster extends Karakter {
    private String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang(){
        System.out.println(" " + nama  + "menyerang! damage: " + baseDamage);
        return baseDamage; //mengembalikkan nilai damage
    }

    @Override
    public void bertahan(){
        hp += 10;
        System.out.println(nama + " bertahan! HP +10. HP sekarang: " + hp);
    }

    @Override
    public void gunakanItem(){
       System.out.println(nama + " tidak mempunyai item!"); 
    }

    @Override
    public void tampilkanStatus(){
        System.out.println(nama + "| " + nama + "- " + jenisMonster + " | HP: " + hp);
    }
}
