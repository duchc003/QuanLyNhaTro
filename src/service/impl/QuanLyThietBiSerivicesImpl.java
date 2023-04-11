/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.ThietBi;
import java.util.ArrayList;
import java.util.List;
import model.ThietBi1;
import repository.ThietBiRepositoris;
import service.QuanLyThietBiSerivices;
import view.ThietBivaDichVu;
import viewmodel.QLThietBi;

/**
 *
 * @author Admin
 */
public class QuanLyThietBiSerivicesImpl implements QuanLyThietBiSerivices {

     private ThietBiRepositoris tbr = new ThietBiRepositoris();

    @Override
    public List<QLThietBi> getAll() {
        List<QLThietBi> list = new ArrayList<>();
        List<ThietBi1> ds = tbr.getAll();
        for (ThietBi1 d : ds) {
            QLThietBi qltb = new QLThietBi(Integer.parseInt(d.getId()), d.getTen(), d.getSoluong(), d.getGiaTien(), d.getMoTa(), d.getTinhTrang());
            list.add(qltb);
        }
        return list;
    }

    @Override
    public void them(QLThietBi tb) {
        ThietBi1 them = new ThietBi1("", tb.getTen(), tb.getSoLuong(), tb.getGiaTien(), tb.getMoTa(), tb.getTinhTrang());
        tbr.them(them);
    }

    @Override
    public void sua(QLThietBi tb, String id) {
        ThietBi1 sua = new ThietBi1("", tb.getTen(), tb.getSoLuong(), tb.getGiaTien(), tb.getMoTa(), tb.getTinhTrang());
        tbr.sua(sua, id);
    }

    @Override
    public void xoa(String ten) {
        tbr.xoa(ten);
    }

    @Override
    public List<QLThietBi> SapXep() {
        List<QLThietBi> list = new ArrayList<>();
        List<ThietBi1> ds = tbr.SapXep();
        for (ThietBi1 d : ds) {
            QLThietBi qltb = new QLThietBi(Integer.parseInt(d.getId()), d.getTen(), d.getSoluong(), d.getGiaTien(), d.getMoTa(), d.getTinhTrang());
            list.add(qltb);
        }
        return list;
    }

}
