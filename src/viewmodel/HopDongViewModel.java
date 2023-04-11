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
public class HopDongViewModel {
    
    private String maHopDong;
    
    private String tenTang;
    
    private String tenPhong;
    
    private String tenLoaiPhong;
    
    private String tenKhachHang;
    
    private Date ngayBd;
    
    private Date ngayKT;
    
    private Long giaThue;
    
    private long tienCoc;
    
    private String kiThanhToan;
    
    private String trangThai;

    public HopDongViewModel() {
    }

    public HopDongViewModel(String maHopDong, String tenTang, String tenPhong, String tenLoaiPhong, String tenKhachHang, Date ngayBd, Date ngayKT, Long giaThue, long tienCoc, String kiThanhToan, String trangThai) {
        this.maHopDong = maHopDong;
        this.tenTang = tenTang;
        this.tenPhong = tenPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.tenKhachHang = tenKhachHang;
        this.ngayBd = ngayBd;
        this.ngayKT = ngayKT;
        this.giaThue = giaThue;
        this.tienCoc = tienCoc;
        this.kiThanhToan = kiThanhToan;
        this.trangThai = trangThai;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getTenTang() {
        return tenTang;
    }

    public void setTenTang(String tenTang) {
        this.tenTang = tenTang;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayBd() {
        return ngayBd;
    }

    public void setNgayBd(Date ngayBd) {
        this.ngayBd = ngayBd;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public Long getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(Long giaThue) {
        this.giaThue = giaThue;
    }

    public long getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(long tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getKiThanhToan() {
        return kiThanhToan;
    }

    public void setKiThanhToan(String kiThanhToan) {
        this.kiThanhToan = kiThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HopDongViewModel{" + "maHopDong=" + maHopDong + ", tenTang=" + tenTang + ", tenPhong=" + tenPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", tenKhachHang=" + tenKhachHang + ", ngayBd=" + ngayBd + ", ngayKT=" + ngayKT + ", giaThue=" + giaThue + ", tienCoc=" + tienCoc + ", kiThanhToan=" + kiThanhToan + ", trangThai=" + trangThai + '}';
    }

}
