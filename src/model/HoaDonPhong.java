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
public class HoaDonPhong {

    private int idHopDong;

    private int idKhachThue;

    private int idPhong;

    private String maHoaDon;

    private Date ngayTao;

    private Date ngayKT;

    private double tienKhachDua;

    private double tienPhong;

    private String ghiChu;

    private String trangThai;

    public HoaDonPhong() {
    }

    public HoaDonPhong(int idKhachThue, int idPhong, String maHoaDon, Date ngayTao, Date ngayKT, double tienKhachDua, double tienPhong, String ghiChu, String trangThai) {
        this.idKhachThue = idKhachThue;
        this.idPhong = idPhong;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayKT = ngayKT;
        this.tienKhachDua = tienKhachDua;
        this.tienPhong = tienPhong;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public int getIdKhachThue() {
        return idKhachThue;
    }

    public void setIdKhachThue(int idKhachThue) {
        this.idKhachThue = idKhachThue;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(double tienPhong) {
        this.tienPhong = tienPhong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
