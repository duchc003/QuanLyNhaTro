/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HP
 */
public class ChiTietHoaDonViewModel {

    private int id;
    private int idDichVu;
    private int idHoaDon;
    private int idThietBi;
    private String tenPhong;
    private double tienPhong;
    private String ghiChu;

    public ChiTietHoaDonViewModel() {
    }

    public ChiTietHoaDonViewModel(int id, int idDichVu, int idHoaDon, int idThietBi, String tenPhong, double tienPhong, String ghiChu) {
        this.id = id;
        this.idDichVu = idDichVu;
        this.idHoaDon = idHoaDon;
        this.idThietBi = idThietBi;
        this.tenPhong = tenPhong;
        this.tienPhong = tienPhong;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdThietBi() {
        return idThietBi;
    }

    public void setIdThietBi(int idThietBi) {
        this.idThietBi = idThietBi;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public double getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(double tienPhong) {
        this.tienPhong = tienPhong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonViewModel{" + "id=" + id + ", idDichVu=" + idDichVu + ", idHoaDon=" + idHoaDon + ", idThietBi=" + idThietBi + ", tenPhong=" + tenPhong + ", tienPhong=" + tienPhong + ", ghiChu=" + ghiChu + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{id, tenPhong, tienPhong, ghiChu};
    }
}
