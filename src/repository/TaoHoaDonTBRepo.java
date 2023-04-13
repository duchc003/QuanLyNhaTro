/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.TaoHoaDonTB;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectDB;

/**
 *
 * @author HoangKimDong
 */
public class TaoHoaDonTBRepo {

    public boolean insert(TaoHoaDonTB tb) {

        try {
            Connection cnn = ConnectDB.getConnection();
            String sql = "insert into HoaDon(IDPhongTro,MaHoaDon,NgayTaoHoaDon,NgayKetThuc,SoTien,GhiChu) values(?,?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareCall(sql);
            ps.setInt(1,tb.getIdkhachThue());
            ps.setObject(2, tb.getIdPhong());
            ps.setObject(3, tb.getMaHD());
            ps.setObject(4, tb.getNgaytao());
            ps.setObject(5, tb.getNgaykt());
            ps.setObject(6, tb.getSoTien());
            ps.setObject(7, tb.getGhichu());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
