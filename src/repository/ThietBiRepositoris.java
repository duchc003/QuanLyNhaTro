/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.ThietBi;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ThietBi1;
import util.ConnectDB;

/**
 *
 * @author Admin
 */
public class ThietBiRepositoris {

    public List<ThietBi1> getAll() {
        String querry = """
                        SELECT [ID]
                              ,[Ten]
                              ,[SoLuong]
                              ,[GiaTien]
                              ,[MoTa]
                              ,[TrangThai]
                          FROM [dbo].[Thiet_Bi]
                        """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            List<ThietBi1> list = new ArrayList<>();
            while (rs.next()) {
                ThietBi1 tb = new ThietBi1(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getLong(4), rs.getString(5), rs.getString(6));
                list.add(tb);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public void them(ThietBi1 tb) {
        String querry = """
                        INSERT INTO [dbo].[Thiet_Bi]
                                   ([Ten]
                                   ,[SoLuong]
                                   ,[GiaTien]
                                   ,[MoTa]
                                   ,[TrangThai])
                             VALUES
                                   (?,?,?,?,?)
                        """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, tb.getTen());
            ps.setObject(2, tb.getSoluong());
            ps.setObject(3, tb.getGiaTien());
            ps.setObject(4, tb.getMoTa());
            ps.setObject(5, tb.getTinhTrang());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void xoa(String id) {
        String querry = """
                        DELETE FROM [dbo].[Thiet_Bi]
                              WHERE id = ?
                        """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    public void sua(ThietBi1 tb, String Id) {
        String querry = """
                        UPDATE [dbo].[Thiet_Bi]
                           SET [Ten] = ?
                              ,[SoLuong] = ?
                              ,[GiaTien] =?
                              ,[MoTa] =?
                              ,[TrangThai] = ?
                         WHERE ID = ?
                        """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, tb.getTen());
            ps.setObject(2, tb.getSoluong());
            ps.setObject(3, tb.getGiaTien());
            ps.setObject(4, tb.getMoTa());
            ps.setObject(5, tb.getTinhTrang());
            ps.setObject(6, Id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    public List<ThietBi1> SapXep() {
        String querry = """
                        SELECT [ID]
                                                      ,[Ten]
                                                      ,[SoLuong]
                                                      ,[GiaTien]
                                                      ,[MoTa]
                                                      ,[TrangThai]
                                                  FROM [dbo].[Thiet_Bi]
                            order by GiaTien asc
                        """;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            List<ThietBi1> list = new ArrayList<>();
            while (rs.next()) {
                ThietBi1 tb = new ThietBi1(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getLong(4), rs.getString(5), rs.getString(6));
                list.add(tb);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new ThietBiRepositoris().getAll().toString());
    }
}
