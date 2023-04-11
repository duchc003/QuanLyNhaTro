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
public class Tang {
    
    private int id;
    
    private String tenTang;
    
    private String soLuongPhong;
    
    private Date ngayTao;
    
    private Date ngaySuaDoi;

    public Tang() {
    }

    public Tang(int id, String tenTang, String soLuongPhong, Date ngayTao, Date ngaySuaDoi) {
        this.id = id;
        this.tenTang = tenTang;
        this.soLuongPhong = soLuongPhong;
        this.ngayTao = ngayTao;
        this.ngaySuaDoi = ngaySuaDoi;
    }

    public Tang(String tenTang) {
        this.tenTang = tenTang;
    }

    public Tang(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTang() {
        return tenTang;
    }

    public void setTenTang(String tenTang) {
        this.tenTang = tenTang;
    }

    public String getSoLuongPhong() {
        return soLuongPhong;
    }

    public void setSoLuongPhong(String soLuongPhong) {
        this.soLuongPhong = soLuongPhong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySuaDoi() {
        return ngaySuaDoi;
    }

    public void setNgaySuaDoi(Date ngaySuaDoi) {
        this.ngaySuaDoi = ngaySuaDoi;
    }

    @Override
    public String toString() {
        return "Tang{" + "tenTang=" + tenTang + '}';
    }
    
}
