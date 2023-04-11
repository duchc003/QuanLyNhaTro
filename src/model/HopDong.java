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
public class HopDong {

    private int id;

    private int idKhach;

    private int idPhong;

    private String maHD;

    private Date ngayBD;

    private Date ngayKT;

    private long tienCoc;
    
    private int ngayChotTienPhong;

    private String kiThanhToan;

    private int thanhToanMoiLan;

    private String trangThai;

    public HopDong() {
    }

    public HopDong(int id, int idKhach, int idPhong, String maHD, Date ngayBD, Date ngayKT, long tienCoc, int ngayChotTienPhong, String kiThanhToan, int thanhToanMoiLan, String trangThai) {
        this.id = id;
        this.idKhach = idKhach;
        this.idPhong = idPhong;
        this.maHD = maHD;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.tienCoc = tienCoc;
        this.ngayChotTienPhong = ngayChotTienPhong;
        this.kiThanhToan = kiThanhToan;
        this.thanhToanMoiLan = thanhToanMoiLan;
        this.trangThai = trangThai;
    }

    public HopDong(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhach() {
        return idKhach;
    }

    public int getNgayChotTienPhong() {
        return ngayChotTienPhong;
    }

    public void setNgayChotTienPhong(int ngayChotTienPhong) {
        this.ngayChotTienPhong = ngayChotTienPhong;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
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

    public long getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(long tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getKiThanhToan() {
        return kiThanhToan;
    }

    public void setKiThanhToan(String kiThanhToan) {
        this.kiThanhToan = kiThanhToan;
    }

    public int getThanhToanMoiLan() {
        return thanhToanMoiLan;
    }

    public void setThanhToanMoiLan(int thanhToanMoiLan) {
        this.thanhToanMoiLan = thanhToanMoiLan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

}
