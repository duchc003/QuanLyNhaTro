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
public class HoaDonDinhVuAdd {
    
    private int IDHopDong;
    
    private int IDKhachThue;
    
    private int IDPhong;
    
    private String maHoaDon;
    
    private Date ngayTaoHoaDon;
    
    private Date ngayKetThuc;
    
    private long soTien;
    
    private int soNuoc;
    
    private int soDien;
    
    private String ghiChu;
    
    private String trangThai;

    public HoaDonDinhVuAdd() {
    }

    public HoaDonDinhVuAdd(int IDPhong, String maHoaDon, Date ngayTaoHoaDon, Date ngayKetThuc, long soTien, int soNuoc, int soDien, String ghiChu) {
        this.IDPhong = IDPhong;
        this.maHoaDon = maHoaDon;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.ngayKetThuc = ngayKetThuc;
        this.soTien = soTien;
        this.soNuoc = soNuoc;
        this.soDien = soDien;
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getIDHopDong() {
        return IDHopDong;
    }

    public void setIDHopDong(int IDHopDong) {
        this.IDHopDong = IDHopDong;
    }

    public int getIDKhachThue() {
        return IDKhachThue;
    }

    public void setIDKhachThue(int IDKhachThue) {
        this.IDKhachThue = IDKhachThue;
    }

    public int getIDPhong() {
        return IDPhong;
    }

    public void setIDPhong(int IDPhong) {
        this.IDPhong = IDPhong;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public int getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
