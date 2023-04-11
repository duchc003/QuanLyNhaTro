/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ChiTietHoaDonViewModel;

/**
 *
 * @author HP
 */
public interface QuanLyChiTietHoaDonService {

    List<ChiTietHoaDonViewModel> getAll();

    String add(ChiTietHoaDonViewModel chiTietHoaDonViewModel);

    String update(String id, ChiTietHoaDonViewModel chiTietHoaDonViewModel);
}
