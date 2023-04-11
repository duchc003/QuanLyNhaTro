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
public class DSNgayDongTienPhongViewModel {

    private String tenPhong;
    private String tenTang;
    private String tenLoaiPhong;
    private double giaThue;

    public DSNgayDongTienPhongViewModel() {
    }

    public DSNgayDongTienPhongViewModel(String tenPhong, String tenTang, String tenLoaiPhong, double giaThue) {
        this.tenPhong = tenPhong;
        this.tenTang = tenTang;
        this.tenLoaiPhong = tenLoaiPhong;
        this.giaThue = giaThue;
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

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    @Override
    public String toString() {
        return "DSNgayDongTienPhongViewModel{" + "tenPhong=" + tenPhong + ", tenTang=" + tenTang + ", tenLoaiPhong=" + tenLoaiPhong + ", giaThue=" + giaThue + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{tenPhong, tenTang, tenLoaiPhong, giaThue};
    }

}
