/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ThongTInHooaDon {

    String maHoaDon;

    String tenPhong;

    String tenTang;

    String tenLoaiPhong;

    String tenKhach;

    String tenDinhVu;

    String tenThietBi;

    Date ngayBD;

    Date ngayKT;

    int soDien;

    int soNuoc;

    long soTien;

    String trangThai;

    // dịch vụ
    public ThongTInHooaDon(String maHoaDon, String tenPhong, String tenTang, String tenLoaiPhong, String tdv, Date ngayBD, Date ngayKT, long soTien) {
        this.maHoaDon = maHoaDon;
        this.tenPhong = tenPhong;
        this.tenTang = tenTang;
        this.tenLoaiPhong = tenLoaiPhong;
        this.tenDinhVu = tdv;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.soTien = this.soTien;
    }

    public ThongTInHooaDon(String maHoaDon, String tenThietBi, Date ngayBD, Date ngayKT, long soTien) {
        this.maHoaDon = maHoaDon;
        this.tenThietBi = tenThietBi;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.soTien = soTien;
    }

    //phong
    public ThongTInHooaDon(String maHoaDon, String tenPhong, String tenTang, String tenLoaiPhong, long soTien, Date ngayBD, Date ngayKT) {
        this.maHoaDon = maHoaDon;
        this.tenPhong = tenPhong;
        this.tenTang = tenTang;
        this.tenLoaiPhong = tenLoaiPhong;
        this.soTien = soTien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenTang() {
        return tenTang;
    }

    public void setTenTang(String tenTang) {
        this.tenTang = tenTang;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getTenDinhVu() {
        return tenDinhVu;
    }

    public void setTenDinhVu(String tenDinhVu) {
        this.tenDinhVu = tenDinhVu;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public int getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
