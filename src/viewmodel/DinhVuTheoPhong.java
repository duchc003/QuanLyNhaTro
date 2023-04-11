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
    
    private String name;
    
    private long donGia;
    
    private String donVi;

    public DinhVuTheoPhong() {
    }

    public DinhVuTheoPhong(String name, long donGia, String donVi) {
        this.name = name;
        this.donGia = donGia;
        this.donVi = donVi;
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
    
    
}
