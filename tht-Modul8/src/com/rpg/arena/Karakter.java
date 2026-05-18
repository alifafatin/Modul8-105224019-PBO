package com.rpg.arena;

public abstract class Karakter implements AksiBertarung { //membuat kelas abstrak yang mengimplementasikan AksiBertarung
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    //constructor untuk kelas karakter
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; //secara default menjadi false
    }

    //membuat getter dan setter untuk masing2 atribut
    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getBaseDamage(){
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
    }

    public boolean getIsDefending(){
        return isDefending;
    }

    public void setIsDefending(boolean isDefending){
        this.isDefending = isDefending;
    }

    //membuat metode terima damage, jika is defending true maka damage akan mengurangi HP yang sebesar setengahnya
    public void terimaDamage(int damage){
        if(isDefending){ //apakah karakter sedang bertahan?
            damage = damage / 2; //mengurangi damage menjadi setengahnya karena bertahan
            System.out.println(" Bertahan! Damage dikurngi menjadi: " + damage);
            isDefending = false; //setelah menerima damage, karakter tidak lagi bertahan (mengembalikan is defending menjadi false)
        }
        hp -= damage;
        if(hp < 0){
            hp = 0; //hp tidak akan menjadi negatif
        }
    }

    public abstract void tampilkanStatus();

}
