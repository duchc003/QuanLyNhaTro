/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class DinhVuPhong {

    private String tenDinhVu;
    
    private long gia;
    
    private String loaiDinhVu;

    public DinhVuPhong() {
    }

    public DinhVuPhong(String tenDinhVu, long gia, String loaiDinhVu) {
        this.tenDinhVu = tenDinhVu;
        this.gia = gia;
        this.loaiDinhVu = loaiDinhVu;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getLoaiDinhVu() {
        return loaiDinhVu;
    }

    public void setLoaiDinhVu(String loaiDinhVu) {
        this.loaiDinhVu = loaiDinhVu;
    }

    public String getTenDinhVu() {
        return tenDinhVu;
    }

    public void setTenDinhVu(String tenDinhVu) {
        this.tenDinhVu = tenDinhVu;
    }

    public Object[] toDataRow() {
        return new Object[]{tenDinhVu,gia,loaiDinhVu};
    }

    @Override
    public String toString() {
        return "DinhVuPhong{" + "tenDinhVu=" + tenDinhVu + ", loaiDinhVu=" + loaiDinhVu + ", gia=" + gia + '}';
    }
}
