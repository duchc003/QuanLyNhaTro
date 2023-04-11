/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DatPhong;
import model.KhachThue;
import model.Phong;
import util.ConnectDB;
import viewmodel.CocPhongView;
import viewmodel.KhachThueView;
import viewmodel.PhongView;

/**
 *
 * @author ASUS
 */
public class CocGiuPhongRepository {

    public List<CocPhongView> getALL() {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.PhongTro.Tang, dbo.PhongTro.LoaiPhong, dbo.KhachThue.HoVaTen, dbo.KhachThue.SDT, dbo.DatPhong.ThoiGianDatPhong, dbo.DatPhong.ThoiGianCheck_in, dbo.DatPhong.TrangThai\n"
                + "FROM     dbo.KhachThue INNER JOIN\n"
                + "                 dbo.DatPhong ON dbo.KhachThue.ID = dbo.DatPhong.IDKhachThue INNER JOIN\n"
                + "                 dbo.PhongTro ON dbo.DatPhong.IDPhong = dbo.PhongTro.ID\n"
                + "				 where  dbo.DatPhong.TrangThai = N'Đang Cọc'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<CocPhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CocPhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // lọc theo ngày bắt đầu và ngày kết thúc
    public List<CocPhongView> locNgay(Date star, Date end) {
        String query = "	SELECT dbo.PhongTro.TenPhong, dbo.PhongTro.Tang, dbo.PhongTro.LoaiPhong, dbo.KhachThue.HoVaTen, dbo.KhachThue.SDT, dbo.DatPhong.ThoiGianDatPhong, dbo.DatPhong.ThoiGianCheck_in, dbo.DatPhong.TrangThai\n"
                + "	FROM     dbo.KhachThue INNER JOIN\n"
                + "	dbo.DatPhong ON dbo.KhachThue.ID = dbo.DatPhong.IDKhachThue INNER JOIN\n"
                + "	dbo.PhongTro ON dbo.DatPhong.IDPhong = dbo.PhongTro.ID\n"
                + "	where  dbo.DatPhong.ThoiGianDatPhong >= ? AND  dbo.DatPhong.ThoiGianCheck_in <= ? and dbo.DatPhong.TrangThai = N'Đang Cọc'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setDate(1, new java.sql.Date(star.getTime()));
            ps.setDate(2, new java.sql.Date(end.getTime()));
            List<CocPhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CocPhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<CocPhongView> findKhuVuc(String ten) {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.PhongTro.Tang, dbo.PhongTro.LoaiPhong, dbo.KhachThue.HoVaTen, dbo.KhachThue.SDT, dbo.DatPhong.ThoiGianDatPhong, dbo.DatPhong.ThoiGianCheck_in, dbo.DatPhong.TrangThai\n"
                + "	FROM     dbo.KhachThue INNER JOIN\n"
                + "	dbo.DatPhong ON dbo.KhachThue.ID = dbo.DatPhong.IDKhachThue INNER JOIN\n"
                + "	dbo.PhongTro ON dbo.DatPhong.IDPhong = dbo.PhongTro.ID\n"
                + "	where  dbo.PhongTro.Tang =? and dbo.DatPhong.TrangThai = N'Đang Cọc'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<CocPhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CocPhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<CocPhongView> findTenPhong(String ten) {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.PhongTro.Tang, dbo.PhongTro.LoaiPhong, dbo.KhachThue.HoVaTen, dbo.KhachThue.SDT, dbo.DatPhong.ThoiGianDatPhong, dbo.DatPhong.ThoiGianCheck_in, dbo.DatPhong.TrangThai\n"
                + "	FROM     dbo.KhachThue INNER JOIN\n"
                + "	dbo.DatPhong ON dbo.KhachThue.ID = dbo.DatPhong.IDKhachThue INNER JOIN\n"
                + "	dbo.PhongTro ON dbo.DatPhong.IDPhong = dbo.PhongTro.ID\n"
                + "	where  dbo.PhongTro.TenPhong =? and dbo.DatPhong.TrangThai = N'Đang Cọc'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<CocPhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CocPhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // Chỉnh Sửa Phòng
    public boolean update(CocPhongView cocPhongView, int ten) {
        String query = "UPDATE [dbo].[DatPhong]\n"
                + "   SET [TrangThai] = ?\n"
                + " WHERE IDPhong = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, cocPhongView.getTrangThai());
            ps.setObject(2, ten);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // add khách đặt cọc phong
    public boolean addDatCoc(KhachThueView khachThueView) {
        String query = "INSERT INTO [dbo].[KhachThue]\n"
                + "           ([HoVaTen]\n"
                + "           ,[SDT])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, khachThueView.getHoVaTen());
            ps.setObject(2, khachThueView.getSoDienThoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // add đặt phòng
    public boolean addDatPhong(DatPhong datPhong) {
        String query = "INSERT INTO [dbo].[DatPhong]\n"
                + "           ([IDPhong]\n"
                + "           ,[IDKhachThue]\n"
                + "           ,[ThoiGianDatPhong]\n"
                + "           ,[ThoiGianCheck_in]\n"
                + "           ,[ThoiGianCheck_out]\n"
                + "           ,[TrangThai]\n"
                + "           ,[TienCoc]\n"
                + "           ,[MoTa])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, datPhong.getIdPhong());
            ps.setObject(2, datPhong.getIdKhachThue());
            ps.setObject(3, datPhong.getThoiGianDatPhong());
            ps.setObject(4, datPhong.getThoiGianCheckIn());
            ps.setObject(5, datPhong.getThoiGianCheckOut());
            ps.setObject(6, datPhong.getTrangThai());
            ps.setObject(7, datPhong.getTienCoc());
            ps.setObject(8, datPhong.getMota());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // load tên phòng lên comboxbox
    public List<PhongView> getALLTenPhong() {
        String query = "select TenPhong from PhongTro";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<PhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public KhachThue findByID(String ten) {
        String query = "SELECT [ID]\n"
                + "  FROM [dbo].[KhachThue]\n"
                + "  where HoVaTen = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhachThue(
                        rs.getInt(1)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

}
