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
import model.HoaDonDinhVuAdd;
import util.ConnectDB;
import view.HoaDon;
import viewmodel.DinhVuTheoPhong;
import viewmodel.HoaDonDinhVu;

/**
 *
 * @author ASUS
 */
public class HoaDonRepository {

    public List<HoaDonDinhVu> getALL() {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.PhongTro.SoDien, dbo.PhongTro.SoNuoc\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "                  dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN\n"
                + "                  dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<HoaDonDinhVu> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonDinhVu(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<DinhVuTheoPhong> finByDinhVu(String ten) {
        String query = "SELECT dbo.DinhVu.Name, dbo.DinhVu.Gia, dbo.DinhVu.DonVi\n"
                + "FROM     dbo.ChiTietDinhVu INNER JOIN\n"
                + "                  dbo.DinhVu ON dbo.ChiTietDinhVu.IDDinhVu = dbo.DinhVu.ID INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.ChiTietDinhVu.IDPhongTro = dbo.PhongTro.ID\n"
                + "where TenPhong =  ? ";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<DinhVuTheoPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DinhVuTheoPhong(
                        rs.getString(1),
                        rs.getLong(2),
                        rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean addHoaDonDien(HoaDonDinhVuAdd hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IDPhongTro]\n"
                + "           ,[MaHoaDon]\n"
                + "           ,[NgayTaoHoaDon]\n"
                + "           ,[NgayKetThuc]\n"
                + "           ,[SoTien]\n"
                + "           ,[SoDien]\n"
                + "           ,[GhiChu])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIDPhong());
            ps.setObject(2, hoaDon.getMaHoaDon());
            ps.setObject(3, hoaDon.getNgayTaoHoaDon());
            ps.setObject(4, hoaDon.getNgayKetThuc());
            ps.setObject(5, hoaDon.getSoTien());
            ps.setObject(6, hoaDon.getSoDien());
            ps.setObject(7, hoaDon.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean addHoaDonNuoc(HoaDonDinhVuAdd hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IDPhongTro]\n"
                + "           ,[MaHoaDon]\n"
                + "           ,[NgayTaoHoaDon]\n"
                + "           ,[NgayKetThuc]\n"
                + "           ,[SoTien]\n"
                + "           ,[SoNuoc]\n"
                + "           ,[GhiChu])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIDPhong());
            ps.setObject(2, hoaDon.getMaHoaDon());
            ps.setObject(3, hoaDon.getNgayTaoHoaDon());
            ps.setObject(4, hoaDon.getNgayKetThuc());
            ps.setObject(5, hoaDon.getSoTien());
            ps.setObject(6, hoaDon.getSoNuoc());
            ps.setObject(7, hoaDon.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean addHoaDonAll(HoaDonDinhVuAdd hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IDPhongTro]\n"
                + "           ,[MaHoaDon]\n"
                + "           ,[NgayTaoHoaDon]\n"
                + "           ,[NgayKetThuc]\n"
                + "           ,[SoTien]\n"
                + "           ,[GhiChu])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIDPhong());
            ps.setObject(2, hoaDon.getMaHoaDon());
            ps.setObject(3, hoaDon.getNgayTaoHoaDon());
            ps.setObject(4, hoaDon.getNgayKetThuc());
            ps.setObject(5, hoaDon.getSoTien());
            ps.setObject(6, hoaDon.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
