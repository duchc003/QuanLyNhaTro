/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class HoaDonDinhVu {

    int id;

    int idHoaDon;

    private String tenPhong;

    private String tenTang;

    private String loaiPhong;

    private int soDien;

    private int soNuoc;

    public HoaDonDinhVu() {
    }

    public HoaDonDinhVu(String tenPhong, String tenTang, String loaiPhong, int soDien, int soNuoc) {
        this.tenPhong = tenPhong;
        this.tenTang = tenTang;
        this.loaiPhong = loaiPhong;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
    }

    public HoaDonDinhVu(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenTang() {
        return tenTang;
    }

    public void setTenTang(String tenTang) {
        this.tenTang = tenTang;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public long getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public long getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

}
