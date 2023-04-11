/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.DichVu;
import java.util.ArrayList;
import java.util.List;
import repository.DichVuRepositories;
import service.QuanLyDichVuSevires;
import viewmodel.QLDichVu;

/**
 *
 * @author Admin
 */
public class QuanLyDichVuSeviresImpl implements QuanLyDichVuSevires {

    private DichVuRepositories dvr = new DichVuRepositories();

    @Override
    public List<QLDichVu> getAll() {
        List<QLDichVu> list = new ArrayList<>();
        List<DichVu> ds = dvr.getAll();
        for (DichVu d : ds) {
            QLDichVu qltb = new QLDichVu(Integer.parseInt(d.getId()), d.getLoai(), d.getName(), d.getGia(), d.getDonVi(), d.getMoTa(), d.getTrangThai());
            list.add(qltb);
        }
        return list;
    }

    @Override
    public void them(QLDichVu dv) {
        DichVu them = new DichVu("", dv.getLoai(), dv.getName(), dv.getGia(), dv.getDonVi(), dv.getMoTa(), dv.getTrangThai());
        dvr.them(them);
    }

    @Override
    public void sua(QLDichVu dv, String id) {
        DichVu sua = new DichVu("", dv.getLoai(), dv.getName(), dv.getGia(), dv.getDonVi(), dv.getMoTa(), dv.getTrangThai());
        dvr.sua(sua, id);
    }

    @Override
    public void xoa(String id) {
        dvr.xoa(id);
    }

}
