/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import repository.HoaDonThietBiRepo;
import model.HoaDonThietBi;
import java.util.ArrayList;



/**
 *
 * @author HoangKimDong
 */
public class HoaDonThietBiSEv {
    HoaDonThietBiRepo rp =new HoaDonThietBiRepo();
    public  ArrayList<HoaDonThietBi> getAll(){
       return  this.rp.getall();
    }
    public ArrayList<HoaDonThietBi>getallTB(String ten){
        return this.rp.getallTB(ten);
    }
}
