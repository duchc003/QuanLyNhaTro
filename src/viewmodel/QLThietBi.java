/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class QLThietBi {

    private int id;
    private String ten;
    private int soLuong;
    private long giaTien;
    private String moTa;
    private String tinhTrang;

    public QLThietBi() {
    }

    public QLThietBi(int id, String ten, int soLuong, long giaTien, String moTa, String tinhTrang) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    
    public Object[] rowData() {
        return new Object[]{ten,soLuong, giaTien, moTa, tinhTrang};
    }

}
