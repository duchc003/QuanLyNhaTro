/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import repository.TaoHoaDonTBRepo;
import model.TaoHoaDonTB;

/**
 *
 * @author HoangKimDong
 */
public class TaoHoaDonTBSev {
    TaoHoaDonTBRepo rp =new TaoHoaDonTBRepo();
    public boolean insert(TaoHoaDonTB tb){
        return this.rp.insert(tb);
    }
}
