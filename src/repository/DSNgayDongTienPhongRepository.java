/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectDB;
import viewmodel.DSNgayDongTienPhongViewModel;

/**
 *
 * @author HP
 */
public class DSNgayDongTienPhongRepository {

    public List<DSNgayDongTienPhongViewModel> getAll() {

        String querry = """
                      SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.LoaiPhong.GiaThue
                      FROM     dbo.HopDong INNER JOIN
                      dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID INNER JOIN
                      dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN
                      dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID
                      WHERE NgayChotTienPhong <= DATEDIFF(day, DATEADD(day, -7, GETDATE()), GETDATE())
                      """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            List<DSNgayDongTienPhongViewModel> list = new ArrayList<>();
            while (rs.next()) {
                DSNgayDongTienPhongViewModel ds = new DSNgayDongTienPhongViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4));
                list.add(ds);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<DSNgayDongTienPhongViewModel> getSearch(String phong) {
        String query = """
                       SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.LoaiPhong.GiaThue
                       FROM     dbo.HopDong INNER JOIN
                       dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID INNER JOIN
                       dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN
                       dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID
                       WHERE dbo.PhongTro.TenPhong like concat ('%',?,'%')
                       """;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, phong);
            ResultSet rs = ps.executeQuery();

            List<DSNgayDongTienPhongViewModel> lists = new ArrayList<>();

            while (rs.next()) {
                DSNgayDongTienPhongViewModel ds = new DSNgayDongTienPhongViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4));
                lists.add(ds);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
