/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class ThietBiPhong {

    private String tenThietBi;

    private int soLong;
    
    private long gia;
    
    public ThietBiPhong() {
    }

    public ThietBiPhong(String tenThietBi, int soLong, long gia) {
        this.tenThietBi = tenThietBi;
        this.soLong = soLong;
        this.gia = gia;
    }
    
    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

     public Object[] toDataRow() {
        return new Object[]{tenThietBi,soLong,gia};
    }

    public void setSoLong(int soLong) {
        this.soLong = soLong;
    }

    public int getSoLong() {
        return soLong;
    }

}
