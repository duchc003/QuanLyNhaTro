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
import model.KhachThue;
import util.ConnectDB;
import viewmodel.KhachThueView;

public class KhachThueRepository {

    public List<KhachThueView> getALL() {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.PhongTro.Tang, dbo.PhongTro.LoaiPhong, dbo.KhachThue.HoVaTen, dbo.KhachThue.SDT, dbo.Phong_Thue.gia_thue, dbo.HopDong.TienCoc, dbo.HopDong.KiThanhToan\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + "                  dbo.KhachThue ON dbo.HopDong.IDKhachThue = dbo.KhachThue.ID INNER JOIN\n"
                + "                  dbo.Phong_Thue ON dbo.KhachThue.ID = dbo.Phong_Thue.IDKhachThue INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID AND dbo.Phong_Thue.IDPhong = dbo.PhongTro.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<KhachThueView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachThueView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getLong(6),
                        rs.getLong(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<KhachThueView> getKhuVuc(String ten) {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.PhongTro.Tang, dbo.PhongTro.LoaiPhong, dbo.KhachThue.HoVaTen, dbo.KhachThue.SDT, dbo.Phong_Thue.gia_thue, dbo.HopDong.TienCoc, dbo.HopDong.KiThanhToan\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + "                  dbo.KhachThue ON dbo.HopDong.IDKhachThue = dbo.KhachThue.ID INNER JOIN\n"
                + "                  dbo.Phong_Thue ON dbo.KhachThue.ID = dbo.Phong_Thue.IDKhachThue INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID AND dbo.Phong_Thue.IDPhong = dbo.PhongTro.ID\n"
                + "where dbo.PhongTro.Tang = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<KhachThueView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachThueView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getLong(6),
                        rs.getLong(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public KhachThue getKhachThue(int id) {
        String query = "SELECT [HoVaTen]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "      ,[CMND]\n"
                + "      ,[QueQuan]\n"
                + "  FROM [QLNT].[dbo].[KhachThue]\n"
                + "  where id = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhachThue(
                        rs.getString(1),
                        rs.getDate(2),
                        rs.getBoolean(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new KhachThueRepository().getKhachThue(1).toString());
    }
}
