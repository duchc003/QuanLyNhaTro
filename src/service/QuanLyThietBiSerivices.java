/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLThietBi;
import viewmodel.QLThietBi;

/**
 *
 * @author Admin
 */
public interface QuanLyThietBiSerivices {

    List<QLThietBi> getAll();

    List<QLThietBi> SapXep();

    void them(QLThietBi d);

    void sua(QLThietBi tb, String d);

    void xoa(String id);
}
