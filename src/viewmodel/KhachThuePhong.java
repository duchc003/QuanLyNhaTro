/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class KhachThuePhong {
    
    private int id;
    
    private String hoVaTen;

    private boolean gioiTinh;
    
    private int soDienThoai;
    
    private String email;

    public KhachThuePhong() {
    }

    public KhachThuePhong(String hoVaTen, boolean gioiTinh, int soDienThoai, String email) {
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public KhachThuePhong(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhachThuePhong(String email) {
        this.email = email;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Object[] toDataRow(){
        return new Object[] {hoVaTen,gioiTinh == true ? "Nam" : "Nữ",soDienThoai,email};
    }

    @Override
    public String toString() {
        return "KhachThuePhong{" + "id=" + id + ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + ", email=" + email + '}';
    }
    
}
