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
public class CocPhongView {

    private String maPhong;

    private String khuVuc;

    private String loaiPhong;

    private String hoVaTen;

    private int soDienThoai;

    private Date ngayDat;

    private Date ngayDuKienDen;

    private String trangThai;

    public CocPhongView() {
    }

    public CocPhongView(String maPhong, String khuVuc, String loaiPhong, String hoVaTen, int soDienThoai, Date ngayDat, Date ngayDuKienDen, String trangThai) {
        this.maPhong = maPhong;
        this.khuVuc = khuVuc;
        this.loaiPhong = loaiPhong;
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.ngayDat = ngayDat;
        this.ngayDuKienDen = ngayDuKienDen;
        this.trangThai = trangThai;
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

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayDuKienDen() {
        return ngayDuKienDen;
    }

    public void setNgayDuKienDen(Date ngayDuKienDen) {
        this.ngayDuKienDen = ngayDuKienDen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Object[] toDateRow() {
        return new Object[]{maPhong, khuVuc, loaiPhong, hoVaTen, soDienThoai, ngayDat, ngayDuKienDen, trangThai};
    }
}
