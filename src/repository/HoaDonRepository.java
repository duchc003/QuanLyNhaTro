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
import model.DinhVu;
import model.HoaDonDinhVuAdd;
import model.HoaDonPhong;
import model.Phong;
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
        String query = "SELECT dbo.DinhVu.ID, dbo.DinhVu.Name, dbo.DinhVu.Gia, dbo.DinhVu.DonVi\n"
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
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getString(4)));
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
                + "           ,[GhiChu]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIDPhong());
            ps.setObject(2, hoaDon.getMaHoaDon());
            ps.setObject(3, hoaDon.getNgayTaoHoaDon());
            ps.setObject(4, hoaDon.getNgayKetThuc());
            ps.setObject(5, hoaDon.getSoTien());
            ps.setObject(6, hoaDon.getSoDien());
            ps.setObject(7, hoaDon.getGhiChu());
            ps.setObject(8, hoaDon.getTrangThai());
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
                + "           ,[GhiChu]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIDPhong());
            ps.setObject(2, hoaDon.getMaHoaDon());
            ps.setObject(3, hoaDon.getNgayTaoHoaDon());
            ps.setObject(4, hoaDon.getNgayKetThuc());
            ps.setObject(5, hoaDon.getSoTien());
            ps.setObject(6, hoaDon.getSoNuoc());
            ps.setObject(7, hoaDon.getGhiChu());
            ps.setObject(8, hoaDon.getTrangThai());
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
                + "           ,[GhiChu]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIDPhong());
            ps.setObject(2, hoaDon.getMaHoaDon());
            ps.setObject(3, hoaDon.getNgayTaoHoaDon());
            ps.setObject(4, hoaDon.getNgayKetThuc());
            ps.setObject(5, hoaDon.getSoTien());
            ps.setObject(6, hoaDon.getGhiChu());
            ps.setObject(7, hoaDon.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean addHoaDonPhong(HoaDonPhong hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IDKhachThue]\n"
                + "           ,[IDPhongTro]\n"
                + "           ,[MaHoaDon]\n"
                + "           ,[NgayTaoHoaDon]\n"
                + "           ,[NgayKetThuc]\n"
                + "           ,[TienKhachDua]\n"
                + "           ,[TienPhong]\n"
                + "           ,[GhiChu]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDon.getIdKhachThue());
            ps.setObject(2, hoaDon.getIdPhong());
            ps.setObject(3, hoaDon.getMaHoaDon());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayKT());
            ps.setObject(6, hoaDon.getTienKhachDua());
            ps.setObject(7, hoaDon.getTienPhong());
            ps.setObject(8, hoaDon.getGhiChu());
            ps.setObject(9, hoaDon.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateSoDien(Phong phong, String ten) {
        String query = "UPDATE [dbo].[PhongTro]\n"
                + "   SET [SoDien] = ?\n"
                + " WHERE TenPhong = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phong.getSoDien());
            ps.setObject(2, ten);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean updateSoNuoc(Phong phong, String ten) {
        String query = "UPDATE [dbo].[PhongTro]\n"
                + "   SET [SoNuoc] = ?\n"
                + " WHERE TenPhong = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phong.getSoNuoc());
            ps.setObject(2, ten);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean updateDinhVuChiTiet(HoaDonDinhVu phong, int id) {
        String query = "UPDATE [dbo].[ChiTietDinhVu]\n"
                + "   SET [IDHoaDon] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phong.getId());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean updateThietBiChiTiet(HoaDonDinhVu phong, int id) {
        String query = "UPDATE [dbo].[ChiTietThietBi]\n"
                + "   SET [IDHoaDon] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phong.getId());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public DinhVuTheoPhong findByIdDinhVu(int id) {
        String query = "Select ID From ChiTietDinhVu Where IDHopDong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new DinhVuTheoPhong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public DinhVuTheoPhong findByIDHopDong(int id) {
        String query = "select ID from HopDong where IDPhongTro = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new DinhVuTheoPhong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDonDinhVu findByIdDinhVu1(String id) {
        String query = "select ID from HoaDon where MaHoaDon = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<DinhVu> list = new ArrayList<>();
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new HoaDonDinhVu(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonRepository().finByDinhVu("P01"));
    }
}
