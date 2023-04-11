/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import model.DatPhong;
import model.KhachThue;
import viewmodel.CocPhongView;
import viewmodel.KhachThueView;
import viewmodel.PhongView;

/**
 *
 * @author ASUS
 */
public interface CocPhongService {
    
    List<CocPhongView> getALL();
    
    List<CocPhongView> locNgay(Date star, Date end);
    
    List<CocPhongView> findKhuVuc(String ten);
    
    List<CocPhongView> findTenPhong(String ten);
    
    String update(CocPhongView cocPhongView, int ten);
    
    String addDatCoc(KhachThueView khachThueView);
    
    String addDatPhong(DatPhong datPhong);
        
    List<PhongView> getALLTenPhong();
    
    KhachThue findByID(String ten);
}
