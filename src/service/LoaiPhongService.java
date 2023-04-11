/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.LoaiPhong;

/**
 *
 * @author ASUS
 */
public interface LoaiPhongService {
    
    String add(LoaiPhong loaiPhong);
    
    String update(LoaiPhong loaiPhong, int id);
    
    String delete(int id);
    
    List<LoaiPhong> getALL();
        
    List<LoaiPhong> getConTrong();
    
    List<LoaiPhong> getDaDu();
    
    List<LoaiPhong> getTenLoaiPhong(String ten);
}
