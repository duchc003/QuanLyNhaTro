/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import java.util.List;
import repository.ChiTietHoaDonRepository;
import service.QuanLyChiTietHoaDonService;
import viewmodel.ChiTietHoaDonViewModel;

/**
 *
 * @author HP
 */
public class QuanLyChiTietHoaDonServiceImpl implements QuanLyChiTietHoaDonService {

    private ChiTietHoaDonRepository cthd = new ChiTietHoaDonRepository();

    @Override
    public List<ChiTietHoaDonViewModel> getAll() {
        return cthd.getAll();
    }

    @Override
    public String add(ChiTietHoaDonViewModel chiTietHoaDonViewModel) {
        boolean add = cthd.add(chiTietHoaDonViewModel);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(String id, ChiTietHoaDonViewModel chiTietHoaDonViewModel) {
        boolean update = cthd.update(id, chiTietHoaDonViewModel);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }
}
