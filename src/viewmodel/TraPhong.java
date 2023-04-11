/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TraPhong {
    
    private String tenKhach;
    
    private String tenPhong;
    
    private Date ngayBD;
    
    private Date ngayKT;
    
    private long gia;

    public TraPhong() {
    }

    public TraPhong(String tenKhach, String tenPhong, Date ngayBD, Date ngayKT, long gia) {
        this.tenKhach = tenKhach;
        this.tenPhong = tenPhong;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.gia = gia;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
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

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "TraPhong{" + "tenKhach=" + tenKhach + ", tenPhong=" + tenPhong + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", gia=" + gia + '}';
    }
    
}
