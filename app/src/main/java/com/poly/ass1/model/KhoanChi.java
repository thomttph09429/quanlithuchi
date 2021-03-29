package com.poly.ass1.model;

public class KhoanChi {
    int idkhoanchi;
    String khoanchi;

    public KhoanChi() {
    }

    public KhoanChi(int idkhoanchi, String khoanchi) {
        this.idkhoanchi = idkhoanchi;
        this.khoanchi = khoanchi;
    }

    public int getIdkhoanchi() {
        return idkhoanchi;
    }

    public void setIdkhoanchi(int idkhoanchi) {
        this.idkhoanchi = idkhoanchi;
    }

    public String getKhoanchi() {
        return khoanchi;
    }

    public void setKhoanchi(String khoanchi) {
        this.khoanchi = khoanchi;
    }
}
