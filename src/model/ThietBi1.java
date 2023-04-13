/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ThietBi1 {

    private String id;
    private String ten;
    private int soluong;
    private long giaTien;
    private String moTa;
    private String tinhTrang;

    public ThietBi1() {
    }

    public ThietBi1(String id, String ten, int soluong, long giaTien, String moTa, String tinhTrang) {
        this.id = id;
        this.ten = ten;
        this.soluong = soluong;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(long giaTien) {
        this.giaTien = giaTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "ThietBi1{" + "id=" + id + ", ten=" + ten + ", soluong=" + soluong + ", giaTien=" + giaTien + ", moTa=" + moTa + ", tinhTrang=" + tinhTrang + '}';
    }

}
