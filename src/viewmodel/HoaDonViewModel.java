/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author HP
 */
public class HoaDonViewModel {

    private String maHoaDon;
    private String tenPhong;
    private Date ngayTao;
    private Date ngayKetThuc;
    private double tienPhong;
    private double tienKhachDua;    
    private String ghiChu;
    String  tenTang;
    String tenLoaiPhong;
    long giaThue;
    Date nt;

    public HoaDonViewModel() {
    }

//    public HoaDonViewModel(String maHoaDon, String tenPhong, Date ngayTao, Date ngayKetThuc, double tienPhong, double tienKhachDua, String ghiChu) {
//        this.maHoaDon = maHoaDon;
//        this.tenPhong = tenPhong;
//        this.ngayTao = ngayTao;
//        this.ngayKetThuc = ngayKetThuc;
//        this.tienPhong = tienPhong;
//        this.tienKhachDua = tienKhachDua;
//        this.ghiChu = ghiChu;

    public HoaDonViewModel(String tenPhong, String tenTang, String tenLoaiPhong, long giaThue, Date nt) {
        this.tenPhong = tenPhong;
        this.tenTang = tenTang;
        this.tenLoaiPhong = tenLoaiPhong;
        this.giaThue = giaThue;
        this.nt = nt;
    }

//    }
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(double tienPhong) {
        this.tienPhong = tienPhong;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "maHoaDon=" + maHoaDon + ", tenPhong=" + tenPhong + ", ngayTao=" + ngayTao + ", ngayKetThuc=" + ngayKetThuc + ", tienPhong=" + tienPhong + ", tienKhachDua=" + tienKhachDua + ", ghiChu=" + ghiChu + '}';
    }

    public double getThieu() {
        return tienPhong - tienKhachDua;
    }

    public String getTrangThai() {
        if (getThieu() == 0) {
            return "Đã thanh toán";
        } else if (getThieu() > 0) {
            return "Thiếu";
        } else {
            return "Chưa thanh toán";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{tenPhong,tenTang,tenLoaiPhong,tenPhong};
    }

}
