/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HoangKimDong
 */
public class HoaDonThietBi {

    private String TenPhong;
    private String TenTang;
    private String loaiPhong;
    private String tenKhach;
    private String TenTB;
    private int soluong;
    private Long giaTien;

    public HoaDonThietBi( String TenPhong, String TenTang, String loaiPhong, String tenKhach, String TenTB, int soluong, Long giaTien) {
        this.TenPhong = TenPhong;
        this.TenTang = TenTang;
        this.loaiPhong = loaiPhong;
        this.tenKhach = tenKhach;
        this.TenTB = TenTB;
        this.soluong = soluong;
        this.giaTien = giaTien;
    }
    
    public HoaDonThietBi() {
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public String getTenTang() {
        return TenTang;
    }

    public void setTenTang(String TenTang) {
        this.TenTang = TenTang;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getTenTB() {
        return TenTB;
    }

    public void setTenTB(String TenTB) {
        this.TenTB = TenTB;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Long getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Long giaTien) {
        this.giaTien = giaTien;
    }

    public Long tongtien() {
        Long tongtien;
        return tongtien = soluong * giaTien;
    }

    @Override
    public String toString() {
        return "HoaDonThietBi{" + "TenPhong=" + TenPhong + ", TenTang=" + TenTang + ", loaiPhong=" + loaiPhong + ", tenKhach=" + tenKhach + ", TenTB=" + TenTB + ", soluong=" + soluong + ", giaTien=" + giaTien + '}';
    }

}
