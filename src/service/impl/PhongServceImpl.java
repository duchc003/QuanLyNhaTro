/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.HoaDonPhong;
import model.KhachThue;
import model.LoaiPhong;
import model.Phong;
import model.Tang;
import model.ThongTInHooaDon;
import repository.HoaDonRepository;
import repository.PhongRepository;
import service.PhongServce;
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
public class PhongServceImpl implements PhongServce {

    private PhongRepository repo = new PhongRepository();

    private HoaDonRepository hoaDonRe = new HoaDonRepository();

    @Override
    public List<PhongView> getALL() {
        return repo.getALL();
    }

    @Override
    public String update(Phong phongView, int id) {
        boolean update = repo.update(phongView, id);
        if (update) {
            return "Update Thành Công";
        }
        return "Update Thất Bại";
    }

    @Override
    public String add(Phong phongView) {
        String ma = phongView.getTenPhong();
        String maTrung = repo.maTrung(ma);
        if (maTrung != null) {
            return "Tên Trùng";
        }
        boolean add = repo.add(phongView);
        if (add) {
            return "add Thành Công";
        }
        return "add Thất Bại";
    }

    @Override
    public Phong getOneHang(String ten) {
        return repo.getOneHang(ten);
    }

    @Override
    public List<KhachThuePhong> getKhachThuePhong(String ten) {
        return repo.getKhachThuePhong(ten);
    }

    @Override
    public List<DinhVuPhong> getDinhVuPhong(String ten) {
        return repo.getDinhVuPhong(ten);
    }

    @Override
    public List<ThietBiPhong> getThietBiPhong(String ten) {
        return repo.getThietBiPhong(ten);
    }

    @Override
    public List<PhongView> findByStatus(String ten) {
        return repo.findByStatus(ten);
    }

    @Override
    public List<PhongView> countPhongTrong() {
        return repo.countPhongTrong();
    }

    @Override
    public List<PhongView> countPhongDaThue() {
        return repo.countPhongDaThue();
    }

    @Override
    public List<PhongView> countPhongBaoTri() {
        return repo.countPhongBaoTri();
    }

    @Override
    public List<PhongView> getOnePhong(String ten) {
        return repo.getOnePhong(ten);
    }

    @Override
    public KhachThuePhong findSoLuong(String ten) {
        return repo.findSoLuong(ten);
    }

    @Override
    public String updateStatus(Phong phongView, int id) {
        boolean updateStatus = repo.updateStatus(phongView, id);
        if (updateStatus) {
            return "Update Thành Công";
        }
        return "Update Thất Bại";
    }

    @Override
    public PhongView getOne(String ten) {
        return repo.getOne(ten);
    }

    @Override
    public KhachThuePhong getByEmail(String ten) {
        return repo.getByEmail(ten);
    }

    @Override
    public List<Tang> getAllTang() {
        return repo.getAllTang();
    }

    @Override
    public List<LoaiPhong> getAllLoaiPhong() {
        return repo.getAllLoaiPhong();
    }

    @Override
    public Tang findByIdTang(String ten) {
        return repo.findByIdTang(ten);
    }

    @Override
    public LoaiPhong findByIdLoaiPhong(String ten) {
        return repo.findByIdLoaiPhong(ten);
    }

    @Override
    public List<KhachThuePhong> getSoNguoi(String ten) {
        return repo.getSoNguoi(ten);
    }

    @Override
    public Phong getOneTang(String ten) {
        return repo.getOneTang(ten);
    }

    @Override
    public Phong getOneLoaiPhong(String ten) {
        return repo.getOneLoaiPhong(ten);
    }

    @Override
    public LoaiPhong findByIdPhong(String ten) {
        return repo.findByIdPhong(ten);
    }

    @Override
    public Phong getOneMoTa(String ten) {
        return repo.getOneMoTa(ten);
    }

    @Override
    public List<ThongTInHooaDon> getALLHoaDonPhong() {
        return repo.getALLHoaDonPhong();
    }

    @Override
    public String addHoaDonPhong(HoaDonPhong hoaDon) {
        boolean addHoaDonPhong = hoaDonRe.addHoaDonPhong(hoaDon);
        if (addHoaDonPhong) {
            return "add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public List<ThongTInHooaDon> getALLHoaDonDinhVu() {
        return repo.getALLHoaDonDinhVu();
    }

    @Override
    public List<ThongTInHooaDon> getALLHoaDonThietBi() {
        return repo.getALLHoaDonThietBi();
    }

}
