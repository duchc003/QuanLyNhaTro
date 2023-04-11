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
import viewmodel.ChiTietHoaDonViewModel;

/**
 *
 * @author HP
 */
public class ChiTietHoaDonRepository {

    public List<ChiTietHoaDonViewModel> getAll() {
        String query = """
                       SELECT [ID]
                             ,[IDDinhVu]
                             ,[IDHoaDon]
                             ,[IDThietBi]
                             ,[TenPhong]
                             ,[TienPhong]
                             ,[GhiChu]
                         FROM [dbo].[ChiTietHoaDon]
                       """;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();

            List<ChiTietHoaDonViewModel> lists = new ArrayList<>();

            while (rs.next()) {
                ChiTietHoaDonViewModel hdct = new ChiTietHoaDonViewModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                        rs.getString(5), rs.getDouble(6), rs.getString(7));
                lists.add(hdct);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(ChiTietHoaDonViewModel chiTietHoaDonViewModel) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[ChiTietHoaDon]
                                  ([TenPhong]
                                  ,[TienPhong]
                                  ,[GhiChu])
                            VALUES
                                  (?,?,?)
                       """;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, chiTietHoaDonViewModel.getTenPhong());
            ps.setObject(2, chiTietHoaDonViewModel.getTienPhong());
            ps.setObject(3, chiTietHoaDonViewModel.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

//    public boolean delete(String ten) {
//        int check = 0;
//        String query = """
//                       DELETE FROM [dbo].[ChiTietHoaDon]
//                             WHERE TenPhong = ?
//                       """;
//        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, ten);
//            check = ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return check > 0;
//    }
    public boolean update(String id, ChiTietHoaDonViewModel chiTietHoaDonViewModel) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[ChiTietHoaDon]
                          SET [TenPhong] = ?
                             ,[TienPhong] = ?
                             ,[GhiChu] = ?
                        WHERE ID = ?
                       """;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, chiTietHoaDonViewModel.getTenPhong());
            ps.setObject(2, chiTietHoaDonViewModel.getTienPhong());
            ps.setObject(3, chiTietHoaDonViewModel.getGhiChu());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
