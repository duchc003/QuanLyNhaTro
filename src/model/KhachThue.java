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
public class KhachThue {
    
    private int id;
    
    private String hoVaTen;
    
    private Date ngaySinh;
    
    private boolean gioiTinh;
    
    private int sdt;
    
    private String email;
    
    private String cmnd;
    
     private String queQuan;
    
    public KhachThue() {
    }

    public KhachThue(int id, String hoVaTen, Date ngaySinh, boolean gioiTinh, int sdt, String email, String cmnd, String queQuan) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.cmnd = cmnd;
        this.queQuan = queQuan;
    }

    public KhachThue(String hoVaTen, Date ngaySinh, boolean gioiTinh, int sdt, String email, String cmnd, String queQuan) {
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.cmnd = cmnd;
        this.queQuan = queQuan;
    }


    public KhachThue(String email) {
        this.email = email;
    }

    public KhachThue(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return "KhachThue{" + "id=" + id + '}';
    }
 
}
