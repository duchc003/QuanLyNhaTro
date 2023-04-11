/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author HoangKimDong
 */
public class TaoHoaDonTB {

    private String id;

    private int idkhachThue;
    private int idPhong;
    private String maHD;
    private Date ngaytao;
    private Date ngaykt;
    private long soTien;
    private String ghichu;

    public TaoHoaDonTB(String id, int idkhachThue, int idPhong, String maHD, Date ngaytao, Date ngaykt, long soTien, String ghichu) {
        this.id = id;

        this.idkhachThue = idkhachThue;
        this.idPhong = idPhong;
        this.maHD = maHD;
        this.ngaytao = ngaytao;
        this.ngaykt = ngaykt;
        this.soTien = soTien;
        this.ghichu = ghichu;
    }

    public TaoHoaDonTB() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdkhachThue() {
        return idkhachThue;
    }

    public void setIdkhachThue(int idkhachThue) {
        this.idkhachThue = idkhachThue;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(Date ngaykt) {
        this.ngaykt = ngaykt;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

}
