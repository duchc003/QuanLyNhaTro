/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class LoaiPhong {
    
    private int id;
    
    private String tenLoaiPhong;
    
    private long giaThue;
    
    private int dienTich;
    
    private String tienNghi;
    
    private String hinhAnh;
    
    private String trangThai;

    public LoaiPhong() {
    }

    public LoaiPhong(int id, String tenLoaiPhong, long giaThue, int dienTich, String hinhAnh, String trangThai) {
        this.id = id;
        this.tenLoaiPhong = tenLoaiPhong;
        this.giaThue = giaThue;
        this.dienTich = dienTich;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public LoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public LoaiPhong(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public long getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(long giaThue) {
        this.giaThue = giaThue;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public String getTienNghi() {
        return tienNghi;
    }

    public void setTienNghi(String tienNghi) {
        this.tienNghi = tienNghi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "LoaiPhong{" + "id=" + id + ", tenLoaiPhong=" + tenLoaiPhong + ", giaThue=" + giaThue + ", dienTich=" + dienTich + ", hinhAnh=" + hinhAnh + ", trangThai=" + trangThai + '}';
    }
    
}
