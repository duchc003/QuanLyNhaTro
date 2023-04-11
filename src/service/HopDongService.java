/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import model.DinhVu;
import model.HopDong;
import model.KhachThue;
import model.Phong;
import model.PhongThue;
import model.ThietBi;
import viewmodel.DinhVuView;
import viewmodel.HopDongViewModel;
import viewmodel.ThietBiView;

/**
 *
 * @author ASUS
 */
public interface HopDongService {

    List<DinhVuView> getAllDinhVu();

    List<ThietBiView> getAllThietBi();

    String addKhach(KhachThue KhachThue);

    String addHopDong(HopDong hopDong);

    String addChiTietDinhVu(DinhVu dinhVu);

    String addChiTietThietBi(ThietBi thietBi);

    String addPhongThue(PhongThue phongThue);

    KhachThue findByID(String ten);

    Phong findByIDPhong(String ten);

    HopDong findByIDHopDong(int id);

    ThietBi findByIDThietBi(String id);

    DinhVu findByIDDinhVu(String id);
    
    String updateSoLuongThietBi(ThietBi thietBi,int id);
    
    List<HopDongViewModel> getAllHopDong();
    
    List<HopDongViewModel> findByMaPhong(String ten);
    
    List<HopDongViewModel> locHopDong(Date star, Date end);
    
    List<HopDongViewModel> trangThai(String ten);

    String addPhongThueKhachPhuThuoc(PhongThue phongThue);
}
