/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author HP
 */
public interface QuanLyHoaDonService {

    List<HoaDonViewModel> getAll();

    List<HoaDonViewModel> getSearch(String phong);

    String add(HoaDonViewModel hoaDonViewModel);

    String update(String id, HoaDonViewModel hoaDonViewModel);

    List<HoaDonViewModel> getSearchTheoNgayTao(String ngay);

    List<String> getTenPhong();

    String dateTime();

}
