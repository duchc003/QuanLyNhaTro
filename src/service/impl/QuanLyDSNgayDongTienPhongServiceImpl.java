/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.DSNgayDongTienPhongRepository;
import viewmodel.DSNgayDongTienPhongViewModel;
import service.QuanLyDSNgayDongTienPhongService;

/**
 *
 * @author HP
 */
public class QuanLyDSNgayDongTienPhongServiceImpl implements QuanLyDSNgayDongTienPhongService {

    private DSNgayDongTienPhongRepository ds = new DSNgayDongTienPhongRepository();

    @Override
    public List<DSNgayDongTienPhongViewModel> getAll() {
        return ds.getAll();
    }

    @Override
    public List<DSNgayDongTienPhongViewModel> getSearch(String phong) {
        return ds.getSearch(phong);
    }
}
