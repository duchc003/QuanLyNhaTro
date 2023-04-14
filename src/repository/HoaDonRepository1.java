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
import viewmodel.HoaDonViewModel;

/**
 *
 * @author HP
 */
public class HoaDonRepository1 {

    public List<HoaDonViewModel> getAll() {

        String querry = """
                      SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.LoaiPhong.GiaThue,
                      CASE
                          WHEN KiThanhToan = N'Tháng' THEN DATEADD(month, 1, NgayChotTienPhong)
                          WHEN KiThanhToan = N'Quý' THEN DATEADD(month, 3, NgayChotTienPhong)
                          WHEN KiThanhToan = N'Năm' THEN DATEADD(year, 1, NgayChotTienPhong)
                      END AS NgayThanhToan
                      FROM dbo.HopDong 
                      INNER JOIN dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID 
                      INNER JOIN dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID 
                      INNER JOIN dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID
                      WHERE NgayChotTienPhong <= DATEADD(day, -7, GETDATE())
                      """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getDate(5));
                list.add(hd);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

//    public List<HoaDonViewModel> getSearch(String phong) {
//        String query = """
//                       SELECT dbo.HoaDon.MaHoaDon, dbo.PhongTro.TenPhong, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.NgayKetThuc, dbo.HoaDon.TienPhong, dbo.HoaDon.TienKhachDua, dbo.HoaDon.GhiChu
//                                             FROM dbo.HoaDon INNER JOIN 
//                                             dbo.PhongTro ON dbo.HoaDon.ID = dbo.PhongTro.ID
//                       WHERE dbo.PhongTro.TenPhong like concat ('%',?,'%')
//                       """;
//        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, phong);
//            ResultSet rs = ps.executeQuery();
//
//            List<HoaDonViewModel> lists = new ArrayList<>();
//
//            while (rs.next()) {
//                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getString(2), rs.getDate(3),
//                        rs.getDate(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7));
//                lists.add(hd);
//            }
//            return lists;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }

    public List<String> getTenPhong() {
        List<String> listData = new ArrayList<>();
        String sql = "select TenPhong from PhongTro";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(rs.getString(1));
            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(HoaDonViewModel hoaDonViewModel) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[HoaDon]
                                  ([MaHoaDon]
                                  ,[NgayTaoHoaDon]
                                  ,[NgayKetThuc]
                                  ,[TienPhong]
                                  ,[GhiChu]
                                  ,[TrangThai])
                            VALUES
                                  (?,?,?,?,?,?)
                       """;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDonViewModel.getMaHoaDon());
            ps.setObject(2, hoaDonViewModel.getNgayTao());
            ps.setObject(3, hoaDonViewModel.getNgayKetThuc());
            ps.setObject(4, hoaDonViewModel.getTienPhong());
            ps.setObject(5, hoaDonViewModel.getGhiChu());
            ps.setObject(6, hoaDonViewModel.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String id, HoaDonViewModel hoaDonViewModel) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[HoaDon]
                          SET [MaHoaDon] = ?
                             ,[NgayTaoHoaDon] = ?
                             ,[NgayKetThuc] = ?
                             ,[TienPhong] = ?
                             ,[TienKhachDua] = ?
                             ,[GhiChu] = ?
                             ,[TrangThai] = ?
                        WHERE ID = ?
                       """;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDonViewModel.getMaHoaDon());
            ps.setObject(2, hoaDonViewModel.getNgayTao());
            ps.setObject(3, hoaDonViewModel.getNgayKetThuc());
            ps.setObject(4, hoaDonViewModel.getTienPhong());
            ps.setObject(5, hoaDonViewModel.getTienKhachDua());
            ps.setObject(6, hoaDonViewModel.getGhiChu());
            ps.setObject(7, hoaDonViewModel.getTrangThai());
            ps.setObject(8, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

//    public List<HoaDonViewModel> getSearchTheoNgayTao(String ngay) {
//        String query = """
//                       SELECT [ID]
//                             ,[IDHopDong]
//                             ,[IDKhachThue]
//                             ,[IDPhongTro]
//                             ,[MaHoaDon]
//                             ,[NgayTaoHoaDon]
//                             ,[NgayKetThuc]
//                             ,[TienPhong]
//                             ,[TienKhachDua]
//                             ,[SoDien]
//                             ,[SoNuoc]
//                             ,[GhiChu]
//                             ,[TrangThai]
//                         FROM [dbo].[HoaDon]
//                         WHERE NgayTaoHoaDon like ?
//                       """;
//        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, "%" + ngay + "%");
//            ResultSet rs = ps.executeQuery();
//
//            List<HoaDonViewModel> lists = new ArrayList<>();
//
//            while (rs.next()) {
//                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getString(2), rs.getDate(3),
//                        rs.getDate(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7));
//                lists.add(hd);
//            }
//            return lists;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
}
