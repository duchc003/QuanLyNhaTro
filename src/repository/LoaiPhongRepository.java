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
import model.LoaiPhong;
import util.ConnectDB;
import viewmodel.PhongView;

/**
 *
 * @author ASUS
 */
public class LoaiPhongRepository {

    public boolean add(LoaiPhong loaiPhong) {
        String query = "INSERT INTO [dbo].[LoaiPhong]\n"
                + "           ([TenLoaiPhong]\n"
                + "           ,[GiaThue]\n"
                + "           ,[DienTich]\n"
                + "           ,[HinhAnh]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, loaiPhong.getTenLoaiPhong());
            ps.setObject(2, loaiPhong.getGiaThue());
            ps.setObject(3, loaiPhong.getDienTich());
            ps.setObject(4, loaiPhong.getHinhAnh());
            ps.setObject(5, loaiPhong.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(LoaiPhong loaiPhong, int id) {
        String query = "UPDATE [dbo].[LoaiPhong]\n"
                + "   SET [TenLoaiPhong] = ?\n"
                + "      ,[GiaThue] = ?\n"
                + "      ,[DienTich] = ?\n"
                + "      ,[HinhAnh] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, loaiPhong.getTenLoaiPhong());
            ps.setObject(2, loaiPhong.getGiaThue());
            ps.setObject(3, loaiPhong.getDienTich());
            ps.setObject(4, loaiPhong.getHinhAnh());
            ps.setObject(5, loaiPhong.getTrangThai());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM [dbo].[LoaiPhong]\n"
                + "      WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<LoaiPhong> getALL() {
        String query = "SELECT TOP (1000) [ID]\n"
                + "      ,[TenLoaiPhong]\n"
                + "      ,[GiaThue]\n"
                + "      ,[DienTich]\n"
                + "      ,[HinhAnh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [QLNT].[dbo].[LoaiPhong]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<LoaiPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiPhong(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<LoaiPhong> getConTrong() {
        String query = "SELECT [ID]\n"
                + "      ,[TenLoaiPhong]\n"
                + "      ,[GiaThue]\n"
                + "      ,[DienTich]\n"
                + "      ,[HinhAnh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [QLNT].[dbo].[LoaiPhong]\n"
                + "  where TrangThai = N'Còn Trống'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<LoaiPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiPhong(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<LoaiPhong> getDaDu() {
        String query = "SELECT [ID]\n"
                + "      ,[TenLoaiPhong]\n"
                + "      ,[GiaThue]\n"
                + "      ,[DienTich]\n"
                + "      ,[HinhAnh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [QLNT].[dbo].[LoaiPhong]\n"
                + "  where TrangThai = N'Đã Đủ'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<LoaiPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiPhong(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<LoaiPhong> getTenLoaiPhong(String ten) {
        String query = "SELECT [ID]\n"
                + "      ,[TenLoaiPhong]\n"
                + "      ,[GiaThue]\n"
                + "      ,[DienTich]\n"
                + "      ,[HinhAnh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [QLNT].[dbo].[LoaiPhong]\n"
                + "  where TenLoaiPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<LoaiPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiPhong(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public String maTrung(String ma) {
        String query = "SELECT TenLoaiPhong FROM LoaiPhong where TenLoaiPhong = ?";
        String text = null;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                text = rs.getString(1);
            }
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new LoaiPhongRepository().getALL().toString());
    }
}
