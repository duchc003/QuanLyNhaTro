/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.DinhVu;
import model.HoaDonPhong;
import model.KhachThue;
import model.LoaiPhong;
import model.Phong;
import model.Tang;
import model.ThietBi;
import model.ThongTInHooaDon;
import viewmodel.DinhVuPhong;
import viewmodel.KhachThuePhong;
import viewmodel.KhachThueView;
import viewmodel.PhongView;
import viewmodel.ThietBiPhong;
import viewmodel.TraPhong;

/**
 *
 * @author ASUS
 */
public interface PhongServce {
    
    List<PhongView> getALL();
    
    String update(Phong phongView, int id);
    
    String add(Phong phongView);
    
    Phong getOneHang(String ten);
    
    List<KhachThuePhong> getKhachThuePhong(String ten);
    
    List<DinhVuPhong> getDinhVuPhong(String ten);
    
    List<ThietBiPhong> getThietBiPhong(String ten);
    
    List<PhongView> findByStatus(String ten);
    
    List<PhongView> countPhongTrong();
    
    List<PhongView> countPhongDaThue();
    
    List<PhongView> countPhongBaoTri();
    
    List<PhongView> getOnePhong(String ten);
    
    KhachThuePhong findSoLuong(String ten);
    
    String updateStatus(Phong phongView, int id);
    
    PhongView getOne(String ten);
    
    KhachThuePhong getByEmail(String ten);
    
    List<Tang> getAllTang();
    
    List<LoaiPhong> getAllLoaiPhong();
    
    Tang findByIdTang(String ten);
    
    LoaiPhong findByIdLoaiPhong(String ten);
    
    List<KhachThuePhong> getSoNguoi(String ten);
    
    Phong getOneTang(String ten);
    
    Phong getOneLoaiPhong(String ten);
    
    LoaiPhong findByIdPhong(String ten);
    
    Phong getOneMoTa(String ten);
    
    List<ThongTInHooaDon> getALLHoaDonPhong();
    
    String addHoaDonPhong(HoaDonPhong hoaDon);
    
    List<ThongTInHooaDon> getALLHoaDonDinhVu();
    
    List<ThongTInHooaDon> getALLHoaDonThietBi();
    
}
