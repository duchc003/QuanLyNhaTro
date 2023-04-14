/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.KhachThue;
import model.KhachThueThongKe;
import repository.KhachthueRepo;

/**
 *
 * @author HoangKimDong
 */
public class KhachThueSev {
     KhachthueRepo rp= new KhachthueRepo();
     
    public ArrayList<KhachThueThongKe>getall(){
        return this.rp.getall();
    }
    public  boolean insert(KhachThueThongKe kt){
        return this.rp.insert(kt);
        
    }
    public  boolean update(KhachThueThongKe kt){
       return this.rp.update(kt);
       
    }
   public  ArrayList<KhachThueThongKe> tim(String id){
       return rp.tim(id);
    }
}
