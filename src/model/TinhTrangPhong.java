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
public class TinhTrangPhong {
   
  private String Tang;
  private String phong;
  private String tinhTrang;
  private String thang;
  private String nam;

    public TinhTrangPhong(String Tang, String phong, String tinhTrang, String thang, String nam) {
        this.Tang = Tang;
        this.phong = phong;
        this.tinhTrang = tinhTrang;
        this.thang = thang;
        this.nam = nam;
    }

    public TinhTrangPhong() {
    }

    public String getTang() {
        return Tang;
    }

    public void setTang(String Tang) {
        this.Tang = Tang;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

   

  
  
   
}
