/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class KhachThueView {
    
    private String maPhong;
    
    private String khuVuc;

    private String loaiPhong;
    
    private String hoVaTen;
    
    private int soDienThoai; 
    
    private long tienPhong;
    
    private long datCoc;
    
    private String kiThanhToan;

    public KhachThueView() {
    }

    public KhachThueView(String maPhong, String khuVuc, String loaiPhong, String hoVaTen, int soDienThoai, long tienPhong, long datCoc, String kiThanhToan) {
        this.maPhong = maPhong;
        this.khuVuc = khuVuc;
        this.loaiPhong = loaiPhong;
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.tienPhong = tienPhong;
        this.datCoc = datCoc;
        this.kiThanhToan = kiThanhToan;
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

    public float getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(long tienPhong) {
        this.tienPhong = tienPhong;
    }

    public float getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(long datCoc) {
        this.datCoc = datCoc;
    }

    public String getKiThanhToan() {
        return kiThanhToan;
    }

    public void setKiThanhToan(String kiThanhToan) {
        this.kiThanhToan = kiThanhToan;
    }
    
    public Object[] toDataRow(){
        return new Object[]{maPhong, khuVuc,loaiPhong,hoVaTen,soDienThoai,tienPhong,datCoc,kiThanhToan};
    }
}
