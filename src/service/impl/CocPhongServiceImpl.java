/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.Date;
import java.util.List;
import model.DatPhong;
import model.KhachThue;
import repository.CocGiuPhongRepository;
import service.CocPhongService;
import viewmodel.CocPhongView;
import viewmodel.KhachThueView;
import viewmodel.PhongView;

/**
 *
 * @author ASUS
 */
public class CocPhongServiceImpl implements CocPhongService {

    private CocGiuPhongRepository impl = new CocGiuPhongRepository();

    @Override
    public List<CocPhongView> getALL() {
        return impl.getALL();
    }

    @Override
    public List<CocPhongView> locNgay(Date star, Date end) {
        return impl.locNgay(star, end);
    }

    @Override
    public List<CocPhongView> findKhuVuc(String ten) {
        return impl.findKhuVuc(ten);
    }

    @Override
    public List<CocPhongView> findTenPhong(String ten) {
        return impl.findTenPhong(ten);
    }

    @Override
    public String update(CocPhongView cocPhongView, int ten) {
        boolean update = impl.update(cocPhongView, ten);
        if (update) {
            return "Hủy Đặt Phòng Thành Công";
        }
        return "Hủy Đặt Phòng Thất Bại";
    }

    @Override
    public List<PhongView> getALLTenPhong() {
        return impl.getALLTenPhong();
    }

    @Override
    public String addDatCoc(KhachThueView khachThueView) {
        boolean addDatCoc = impl.addDatCoc(khachThueView);
        if (addDatCoc) {
            return "Thành Công";
        }
        return "Thất Bại";
    }

    @Override
    public String addDatPhong(DatPhong datPhong) {
        boolean addDatPhong = impl.addDatPhong(datPhong);
        if (addDatPhong) {
            return "Thành Công";
        }
        return "Thất Bại";
    }

    @Override
    public KhachThue findByID(String ten) {
        return impl.findByID(ten);
    }

}
