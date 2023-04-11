/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.khachSapHetHanHopDong;
import repository.KhachSapHetHanHDRepo;

/**
 *
 * @author HoangKimDong
 */
public class khachSapHethanHopdongsev {
    KhachSapHetHanHDRepo rp=new KhachSapHetHanHDRepo();
    public ArrayList<khachSapHetHanHopDong>getall(){
        return this.rp.getall();
    }
    public ArrayList<khachSapHetHanHopDong>getall60(){
        return this.rp.getall60();
    }
    public ArrayList<khachSapHetHanHopDong>getall90(){
        return this.rp.getall90();
    }
}
