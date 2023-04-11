/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import util.XMoney;

/**
 *
 * @author ASUS
 */
public class PhongView {
    
    private String maPhong;
    
    private String khuVuc;
    
    private String loaiPhong;
    
    private int soLuongNguoi;
    
    private long dienTich;
    
    private long giaPhong;
    
    private String trangThai;

    public PhongView() {
    }

    public PhongView(String maPhong, String khuVuc, String loaiPhong, int soLuongNguoi, long dienTich, long giaPhong, String trangThai) {
        this.maPhong = maPhong;
        this.khuVuc = khuVuc;
        this.loaiPhong = loaiPhong;
        this.soLuongNguoi = soLuongNguoi;
        this.dienTich = dienTich;
        this.giaPhong = giaPhong;
        this.trangThai = trangThai;
    }

    public PhongView(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(long dienTich) {
        this.dienTich = dienTich;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(long giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhongView{" + "maPhong=" + maPhong + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{maPhong, khuVuc,loaiPhong,soLuongNguoi,dienTich,giaPhong,trangThai};
    }
}
