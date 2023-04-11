/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.Date;
import java.util.List;
import model.DinhVu;
import model.HopDong;
import model.KhachThue;
import model.Phong;
import model.PhongThue;
import model.ThietBi;
import repository.HopDongRepository;
import service.HopDongService;
import viewmodel.DinhVuView;
import viewmodel.HopDongViewModel;
import viewmodel.ThietBiView;

/**
 *
 * @author ASUS
 */
public class HopDongServiceInpl implements HopDongService {

    private HopDongRepository repo = new HopDongRepository();

    @Override
    public List<DinhVuView> getAllDinhVu() {
        return repo.getAllDinhVu();
    }

    @Override
    public List<ThietBiView> getAllThietBi() {
        return repo.getAllThietBi();
    }

    @Override
    public String addKhach(KhachThue KhachThue) {
        boolean addKhach = repo.addKhach(KhachThue);
        if (addKhach) {
            return "Add thành công khách";
        }
        return "Add thất bại";
    }

    @Override
    public String addHopDong(HopDong hopDong) {
        boolean addHopDong = repo.addHopDong(hopDong);
        if (addHopDong) {
            return "Tạo Hợp Đồng Thành Công";
        }
        return "Add thất bại";
    }

    @Override
    public String addChiTietDinhVu(DinhVu dinhVu) {
        boolean addChiTietDinhVu = repo.addChiTietDinhVu(dinhVu);
        if (addChiTietDinhVu) {
            return "Add thành công dịnh vụ";
        }
        return "Add thất bại";
    }

    @Override
    public String addChiTietThietBi(ThietBi thietBi) {
        boolean addChiTietThietBi = repo.addChiTietThietBi(thietBi);
        if (addChiTietThietBi) {
            return "Add thành công Thiết Bị  ";
        }
        return "Add thất bại";
    }

    @Override
    public String addPhongThue(PhongThue phongThue) {
        boolean addPhongThue = repo.addPhongThue(phongThue);
        if (addPhongThue) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public KhachThue findByID(String ten) {
        return repo.findByID(ten);
    }

    @Override
    public Phong findByIDPhong(String ten) {
        return repo.findByIDPhong(ten);
    }

    @Override
    public HopDong findByIDHopDong(int id) {
        return repo.findByIDHopDong(id);
    }

    @Override
    public ThietBi findByIDThietBi(String id) {
        return repo.findByIDThietBi(id);
    }

    @Override
    public DinhVu findByIDDinhVu(String id) {
        return repo.findByIDDinhVu(id);
    }

    @Override
    public String updateSoLuongThietBi(ThietBi thietBi, int id) {
        boolean updateSoLuongThietBi = repo.updateSoLuongThietBi(thietBi, id);
        if (updateSoLuongThietBi) {
            return "Update Thành Công";
        } else {
            return "Update Thất bại";
        }
    }

    @Override
    public List<HopDongViewModel> getAllHopDong() {
        return repo.getAllHopDong();
    }

    @Override
    public List<HopDongViewModel> findByMaPhong(String ten) {
        return repo.findByMaPhong(ten);
    }

    @Override
    public List<HopDongViewModel> locHopDong(Date star, Date end) {
        return repo.locHopDong(star, end);
    }

    @Override
    public List<HopDongViewModel> trangThai(String ten) {
        return repo.trangThai(ten);
    }

    @Override
    public String addPhongThueKhachPhuThuoc(PhongThue phongThue) {
        boolean addPhongThue = repo.addPhongThueKhachPhuThuoc(phongThue);
        if (addPhongThue) {
            return "Add thành công";
        }
        return "Add thất bại";
    }
}
