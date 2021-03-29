package com.poly.ass1.model;

public class LoaiChi {
    int idloaichi;
    String loaichi;
    public LoaiChi(int idloaichi, String loaichi) {
        this.idloaichi = idloaichi;
        this.loaichi = loaichi;
    }

    public LoaiChi() {
    }

    public int getIdloaichi() {
        return idloaichi;
    }

    public void setIdloaichi(int idloaichi) {
        this.idloaichi = idloaichi;
    }

    public String getLoaichi() {
        return loaichi;
    }

    public void setLoaichi(String loaichi) {
        this.loaichi = loaichi;
    }
}
