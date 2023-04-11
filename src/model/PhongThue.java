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
public class PhongThue {

    private int idKhachThue;

    private int idPhong;

    private Date ngayBD;

    private Date ngayKt;

    private float giaPhong;

    private String tinhTrang;

    public PhongThue() {
    }

    public PhongThue(int idKhachThue, int idPhong, Date ngayBD, Date ngayKt, float giaPhong, String tinhTrang) {
        this.idKhachThue = idKhachThue;
        this.idPhong = idPhong;
        this.ngayBD = ngayBD;
        this.ngayKt = ngayKt;
        this.giaPhong = giaPhong;
        this.tinhTrang = tinhTrang;
    }
    
    public PhongThue(int idKhachThue, int idPhong, float giaPhong, String tinhTrang) {
        this.idKhachThue = idKhachThue;
        this.idPhong = idPhong;
        this.giaPhong = giaPhong;
        this.tinhTrang = tinhTrang;
    }

    public int getIdKhachThue() {
        return idKhachThue;
    }

    public void setIdKhachThue(int idKhachThue) {
        this.idKhachThue = idKhachThue;
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

    public Date getNgayKt() {
        return ngayKt;
    }

    public void setNgayKt(Date ngayKt) {
        this.ngayKt = ngayKt;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
