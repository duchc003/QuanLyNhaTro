/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhachThue;
import viewmodel.KhachThueView;

/**
 *
 * @author ASUS
 */
public interface KhachThueService {
    
    List<KhachThueView> getALL();
    
    List<KhachThueView> getKhuVuc(String ten);
    
    KhachThue getKhachThue(int id);
}
