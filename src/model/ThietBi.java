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
public class ThietBi {
    
    private int idHopDong;
    
    private int idThietBi;
    
    private int idKhachThue;
    
    private int idPhong;
    
    private int soLuong;

    private Date ngaySuDung;
    
    private Date ngayTraLai;
    
    private String trangThai;
    
    private long chiPhi;

    public ThietBi() {
    }

    public ThietBi(int idHopDong, int idThietBi, int idKhachThue, int idPhong, int soLuong, Date ngaySuDung, Date ngayTraLai, String trangThai, long chiPhi) {
        this.idHopDong = idHopDong;
        this.idThietBi = idThietBi;
        this.idKhachThue = idKhachThue;
        this.idPhong = idPhong;
        this.soLuong = soLuong;
        this.ngaySuDung = ngaySuDung;
        this.ngayTraLai = ngayTraLai;
        this.trangThai = trangThai;
        this.chiPhi = chiPhi;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public ThietBi(int idThietBi) {
        this.idThietBi = idThietBi;
    }
    
    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public int getIdThietBi() {
        return idThietBi;
    }

    public void setIdThietBi(int idThietBi) {
        this.idThietBi = idThietBi;
    }

    public int getIdKhachThue() {
        return idKhachThue;
    }

    public void setIdKhachThue(int idKhachThue) {
        this.idKhachThue = idKhachThue;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(Date ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }

    public Date getNgayTraLai() {
        return ngayTraLai;
    }

    public void setNgayTraLai(Date ngayTraLai) {
        this.ngayTraLai = ngayTraLai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public long getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(long chiPhi) {
        this.chiPhi = chiPhi;
    }
    
    
    
}