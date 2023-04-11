/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.LoaiPhong;
import repository.LoaiPhongRepository;
import service.LoaiPhongService;

/**
 *
 * @author ASUS
 */
public class LoaiPhongServiceImpl implements LoaiPhongService {

    private LoaiPhongRepository repository = new LoaiPhongRepository();

    @Override
    public String add(LoaiPhong loaiPhong) {
        String ma = loaiPhong.getTenLoaiPhong();
        String maTrung = repository.maTrung(ma);
        if (maTrung != null) {
            return "Tên Trùng";
        } 
        boolean add = repository.add(loaiPhong);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(LoaiPhong loaiPhong, int id) {
        boolean update = repository.update(loaiPhong, id);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(int id) {
        boolean delete = repository.delete(id);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public List<LoaiPhong> getALL() {
        return repository.getALL();
    }

    @Override
    public List<LoaiPhong> getConTrong() {
        return repository.getConTrong();
    }

    @Override
    public List<LoaiPhong> getDaDu() {
        return repository.getDaDu();
    }

    @Override
    public List<LoaiPhong> getTenLoaiPhong(String ten) {
        return repository.getTenLoaiPhong(ten);
    }
}
