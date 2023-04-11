/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.DSNgayDongTienPhongViewModel;

/**
 *
 * @author HP
 */
public interface QuanLyDSNgayDongTienPhongService {

    List<DSNgayDongTienPhongViewModel> getAll();

    List<DSNgayDongTienPhongViewModel> getSearch(String phong);
}
