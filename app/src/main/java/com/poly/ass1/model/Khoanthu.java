package com.poly.ass1.model;

public class Khoanthu {
    int idkhoanthu;
    String khoanthu;

    public int getIdkhoanthu() {
        return idkhoanthu;
    }

    public Khoanthu() {
    }

    public void setIdkhoanthu(int idkhoanthu) {
        this.idkhoanthu = idkhoanthu;
    }

    public String getKhoanthu() {
        return khoanthu;
    }

    public void setKhoanthu(String khoanthu) {
        this.khoanthu = khoanthu;
    }

    public Khoanthu(int idkhoanthu, String khoanthu) {
        this.idkhoanthu = idkhoanthu;
        this.khoanthu = khoanthu;
    }
}
