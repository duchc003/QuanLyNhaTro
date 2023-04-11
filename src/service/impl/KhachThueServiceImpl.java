/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.KhachThue;
import repository.KhachThueRepository;
import service.KhachThueService;
import viewmodel.KhachThueView;

/**
 *
 * @author ASUS
 */
public class KhachThueServiceImpl implements KhachThueService{

    private KhachThueRepository impl = new KhachThueRepository();
    
    @Override
    public List<KhachThueView> getALL() {
        return impl.getALL();
    }

    @Override
    public List<KhachThueView> getKhuVuc(String ten) {
        return impl.getKhuVuc(ten);
    }

    @Override
    public KhachThue getKhachThue(int id) {
        return impl.getKhachThue(id);
    }
    
}
