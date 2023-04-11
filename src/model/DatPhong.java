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
public class DatPhong {

    private int id;

    private int idPhong;

    private int idKhachThue;

    private int idThoiGian;

    private Date thoiGianDatPhong;

    private Date thoiGianCheckIn;

    private Date thoiGianCheckOut;

    private Date thoiGianThanhToan;
    
    private String trangThai;
    
    private long tienCoc;
    
    private String mota;

    public DatPhong() {
    }

    public DatPhong(int id, int idPhong, int idKhachThue, int idThoiGian, Date thoiGianDatPhong, Date thoiGianCheckIn, Date thoiGianCheckOut, Date thoiGianThanhToan, String trangThai, long tienCoc, String mota) {
        this.id = id;
        this.idPhong = idPhong;
        this.idKhachThue = idKhachThue;
        this.idThoiGian = idThoiGian;
        this.thoiGianDatPhong = thoiGianDatPhong;
        this.thoiGianCheckIn = thoiGianCheckIn;
        this.thoiGianCheckOut = thoiGianCheckOut;
        this.thoiGianThanhToan = thoiGianThanhToan;
        this.trangThai = trangThai;
        this.tienCoc = tienCoc;
        this.mota = mota;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public float getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(long tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdThoiGian() {
        return idThoiGian;
    }

    public void setIdThoiGian(int idThoiGian) {
        this.idThoiGian = idThoiGian;
    }

    public Date getThoiGianDatPhong() {
        return thoiGianDatPhong;
    }

    public void setThoiGianDatPhong(Date thoiGianDatPhong) {
        this.thoiGianDatPhong = thoiGianDatPhong;
    }

    public Date getThoiGianCheckIn() {
        return thoiGianCheckIn;
    }

    public void setThoiGianCheckIn(Date thoiGianCheckIn) {
        this.thoiGianCheckIn = thoiGianCheckIn;
    }

    public Date getThoiGianCheckOut() {
        return thoiGianCheckOut;
    }

    public void setThoiGianCheckOut(Date thoiGianCheckOut) {
        this.thoiGianCheckOut = thoiGianCheckOut;
    }

    public Date getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(Date thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }
    
}
