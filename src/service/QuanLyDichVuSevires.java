/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLDichVu;
import viewmodel.QLDichVu;

/**
 *
 * @author Admin
 */
public interface QuanLyDichVuSevires {

    List<QLDichVu> getAll();

    void them(QLDichVu dv);

    void sua(QLDichVu dv, String id);

    void xoa(String id);
}
