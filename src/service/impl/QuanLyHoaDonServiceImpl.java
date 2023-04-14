/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.HoaDonRepository;
import repository.HoaDonRepository1;
import service.QuanLyHoaDonService;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author HP
 */
public class QuanLyHoaDonServiceImpl implements QuanLyHoaDonService {

    private HoaDonRepository1 hoaDonRepository = new HoaDonRepository1();

    @Override
    public List<HoaDonViewModel> getAll() {
        return hoaDonRepository.getAll();
    }

//    @Override
//    public List<HoaDonViewModel> getSearch(String phong) {
//        return hoaDonRepository.getSearch(phong);
//    }

    @Override
    public String add(HoaDonViewModel hoaDonViewModel) {
        boolean add = hoaDonRepository.add(hoaDonViewModel);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(String id, HoaDonViewModel hoaDonViewModel) {
        boolean update = hoaDonRepository.update(id, hoaDonViewModel);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

//    @Override
//    public List<HoaDonViewModel> getSearchTheoNgayTao(String ngay) {
//        return hoaDonRepository.getSearchTheoNgayTao(ngay);
//    }

    @Override
    public String dateTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss aa");
        String date = dateFormat.format(now);
        return date;
    }

    @Override
    public List<String> getTenPhong() {
        return hoaDonRepository.getTenPhong();
    }

    @Override
    public List<HoaDonViewModel> getSearch(String phong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonViewModel> getSearchTheoNgayTao(String ngay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
