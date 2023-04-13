/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class DinhVuTheoPhong {
    
    private int id;
    
    private String name;
    
    private long donGia;
    
    private String donVi;

    public DinhVuTheoPhong() {
    }

    public DinhVuTheoPhong(int id, String name, long donGia, String donVi) {
        this.id = id;
        this.name = name;
        this.donGia = donGia;
        this.donVi = donVi;
    }

    public DinhVuTheoPhong(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DinhVuTheoPhong{" + "id=" + id + ", name=" + name + ", donGia=" + donGia + ", donVi=" + donVi + '}';
    }
    
    
}
