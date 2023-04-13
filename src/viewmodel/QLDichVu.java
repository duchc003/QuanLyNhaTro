/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class QLDichVu {

    private int id;
    private int loai;
    private String name;
    private long gia;
    private String donVi;
    private String moTa;
    private String trangThai;

    public QLDichVu() {
    }

    public QLDichVu(int id, int loai, String name, long gia, String donVi, String moTa, String trangThai) {
        this.id = id;
        this.loai = loai;
        this.name = name;
        this.gia = gia;
        this.donVi = donVi;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public QLDichVu(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] rowData() {
        return new Object[]{loai == 1 ? "Cố Định" : "Không Cố Định", name, donVi, gia, moTa};
    }
}
