/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class DinhVu {
    
    private int idHopDong;
    
    private int idDinhVu;
    
    private int idPhongTro;
    
    private int idKhachThue;
    
    private int soLuong;
    
    private long thanhTien;
    
    private long donGia;

    public DinhVu() {
    }

    public DinhVu(int idHopDong, int idDinhVu, int idPhongTro, int idKhachThue, int soLuong, long thanhTien, long donGia) {
        this.idHopDong = idHopDong;
        this.idDinhVu = idDinhVu;
        this.idPhongTro = idPhongTro;
        this.idKhachThue = idKhachThue;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.donGia = donGia;
    }

    public DinhVu(int idDinhVu) {
        this.idDinhVu = idDinhVu;
    }

    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public int getIdDinhVu() {
        return idDinhVu;
    }

    public void setIdDinhVu(int idDinhVu) {
        this.idDinhVu = idDinhVu;
    }

    public int getIdPhongTro() {
        return idPhongTro;
    }

    public void setIdPhongTro(int idPhongTro) {
        this.idPhongTro = idPhongTro;
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

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }
   
}
