/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.KhachThue;
import model.LoaiPhong;
import model.Phong;
import model.Tang;
import model.ThongTInHooaDon;
import util.ConnectDB;
import viewmodel.DinhVuPhong;
import viewmodel.KhachThuePhong;
import viewmodel.PhongView;
import viewmodel.QLDichVu;
import viewmodel.ThietBiPhong;
import viewmodel.TraPhong;

/**
 *
 * @author ASUS
 */
public class PhongRepository {

    // Hiển thị thông tin Phòng
    public List<PhongView> getALL() {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.PhongTro.SoLuongNguoi, dbo.LoaiPhong.DienTich, dbo.LoaiPhong.GiaThue, dbo.PhongTro.TrangThai\n"
                + "FROM     dbo.LoaiPhong INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.LoaiPhong.ID = dbo.PhongTro.IDLoaiPhong INNER JOIN\n"
                + "                  dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<PhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // Hiển thị thông tin Phòng
    public PhongView getOne(String ten) {
        String query = "SELECT [TenPhong]\n"
                + "                  ,[Tang] \n"
                + "              	  ,[LoaiPhong]\n"
                + "             	  ,[SoLuong]\n"
                + "                  ,[DienTich]\n"
                + "                 ,[GiaPhong]\n"
                + "                  ,[TrangThai]\n"
                + "           FROM [dbo].[PhongTro]\n"
                + "		   where TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new PhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    // Chỉnh Sửa Phòng
    public boolean update(Phong phongView, int id) {
        String query = "UPDATE [dbo].[PhongTro]\n"
                + "   SET [IDTang] = ?\n"
                + "      ,[IDLoaiPhong] = ?\n"
                + "      ,[TenPhong] = ?\n"
                + "      ,[SoLuongNguoi] = ? \n"
                + "      ,[MoTa] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phongView.getIdTang());
            ps.setObject(2, phongView.getIdLoaiPhong());
            ps.setObject(3, phongView.getTenPhong());
            ps.setObject(4, phongView.getSoLuong());
            ps.setObject(5, phongView.getMoTa());
            ps.setObject(6, phongView.getTrangThai());
            ps.setObject(7, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
    
    public Phong getOneTang(String ten) {
        String query = "Select id From Tang where TenTang = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Phong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Phong getOneLoaiPhong(String ten) {
        String query = "Select id From LoaiPhong where TenLoaiPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Phong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm Phòng
    public boolean add(Phong phongView) {
        String query = "INSERT INTO [dbo].[PhongTro]\n"
                + "           ([IDTang]\n"
                + "           ,[IDLoaiPhong]\n"
                + "           ,[TenPhong]\n"
                + "           ,[SoLuongNguoi]\n"
                + "           ,[SoDien]\n"
                + "           ,[SoNuoc]\n"
                + "           ,[MoTa]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phongView.getIdTang());
            ps.setObject(2, phongView.getIdLoaiPhong());
            ps.setObject(3, phongView.getTenPhong());
            ps.setObject(4, phongView.getSoLuong());
            ps.setObject(5, phongView.getSoDien());
            ps.setObject(6, phongView.getSoNuoc());
            ps.setObject(7, phongView.getMoTa());
            ps.setObject(8, phongView.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    //Lấy Ra id Của phòng tìm theo tên phòng để update phòng
    public Phong getOneHang(String ten) {
        String query = "select id from PhongTro where TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Phong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Hiển thị thông tin khách thuê phòng trong form chi tiết phòng trọ
    public List<KhachThuePhong> getKhachThuePhong(String ten) {
        String query = "SELECT dbo.KhachThue.HoVaTen, dbo.KhachThue.GioiTinh, dbo.KhachThue.SDT, dbo.Phong_Thue.tinh_trang\n"
                + "FROM     dbo.KhachThue INNER JOIN\n"
                + "                  dbo.Phong_Thue ON dbo.KhachThue.ID = dbo.Phong_Thue.IDKhachThue INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.Phong_Thue.IDPhong = dbo.PhongTro.ID\n"
                + "where PhongTro.TenPhong = ? ";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<KhachThuePhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachThuePhong(rs.getString(1), rs.getBoolean(2), rs.getInt(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // Hiển thị thông tin dịnh vụ phòng trong form chi tiết phòng trọ
    public List<DinhVuPhong> getDinhVuPhong(String ten) {
        String query = "SELECT dbo.DinhVu.Name, dbo.DinhVu.Gia, dbo.LoaiDinhVu.TenLoaiDinhVu\n"
                + "FROM     dbo.ChiTietDinhVu INNER JOIN\n"
                + "dbo.DinhVu ON dbo.ChiTietDinhVu.IDDinhVu = dbo.DinhVu.ID INNER JOIN\n"
                + "dbo.PhongTro ON dbo.ChiTietDinhVu.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "dbo.LoaiDinhVu ON dbo.DinhVu.IDLoai = dbo.LoaiDinhVu.ID\n"
                + "where dbo.PhongTro.TenPhong =  ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<DinhVuPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DinhVuPhong(rs.getString(1), rs.getLong(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // Hiển thị thông tin dịnh vụ phòng trong form chi tiết phòng trọ
    public List<ThietBiPhong> getThietBiPhong(String ten) {
        String query = "SELECT dbo.Thiet_Bi.Ten, dbo.ChiTietThietBi.SoLuong, dbo.Thiet_Bi.GiaTien\n"
                + "FROM dbo.ChiTietThietBi INNER JOIN\n"
                + "dbo.PhongTro ON dbo.ChiTietThietBi.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "dbo.Thiet_Bi ON dbo.ChiTietThietBi.IDThietBi = dbo.Thiet_Bi.ID\n"
                + "where dbo.PhongTro.TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<ThietBiPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThietBiPhong(rs.getString(1), rs.getInt(2), rs.getLong(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // tìm kiếm theo trạng thái
    public List<PhongView> findByStatus(String ten) {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.PhongTro.SoLuongNguoi, dbo.LoaiPhong.DienTich, dbo.LoaiPhong.GiaThue, dbo.PhongTro.TrangThai\n"
                + "FROM     dbo.LoaiPhong INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.LoaiPhong.ID = dbo.PhongTro.IDLoaiPhong INNER JOIN\n"
                + "                  dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID\n"
                + "where PhongTro.TrangThai = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<PhongView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // lấy ra mô tả của phòng theo tên phòng
    public Phong getOneMoTa(String ten) {
        String query = "select Mota From PhongTro where TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Phong(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // đếm số phòng còn trống
    public List<PhongView> countPhongTrong() {
        String query = " Select COUNT(TrangThai)  FROM [dbo].[PhongTro] where TrangThai = N'Còn Trống'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<PhongView> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // đếm số phòng đã thue
    public List<PhongView> countPhongDaThue() {
        String query = " Select COUNT(TrangThai)  FROM [dbo].[PhongTro] where TrangThai = N'Đã Đủ'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<PhongView> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1))
                );
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // đếm số phòng đang bảo trì
    public List<PhongView> countPhongBaoTri() {
        String query = " Select COUNT(TrangThai)  FROM [dbo].[PhongTro] where TrangThai = N'Đang Bảo Trì'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<PhongView> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1))
                );
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<PhongView> getOnePhong(String ten) {
        String query = "SELECT dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.PhongTro.SoLuongNguoi, dbo.LoaiPhong.DienTich, dbo.LoaiPhong.GiaThue, dbo.PhongTro.TrangThai\n"
                + "FROM     dbo.LoaiPhong INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.LoaiPhong.ID = dbo.PhongTro.IDLoaiPhong INNER JOIN\n"
                + "                  dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID\n"
                + "where PhongTro.TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            List<PhongView> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new PhongView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public KhachThuePhong findSoLuong(String ten) {
        String query = "select SoLuong from PhongTro where TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            List<PhongView> list = new ArrayList<>();
            while (rs.next()) {
                return new KhachThuePhong(
                        rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean updateStatus(Phong phongView, int id) {
        String query = "UPDATE [dbo].[PhongTro]\n"
                + "   SET [TrangThai] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phongView.getTrangThai());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
    
    public KhachThuePhong getByEmail(String ten) {
        String query = "select Email from KhachThue where HoVaTen = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<KhachThuePhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhachThuePhong(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Tang> getAllTang() {
        String query = "Select TenTang from Tang";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<Tang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Tang(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<LoaiPhong> getAllLoaiPhong() {
        String query = "Select TenLoaiPhong from LoaiPhong";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<LoaiPhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiPhong(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Tang findByIdTang(String ten) {
        String query = "Select ID from Tang where TenTang = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Tang(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public LoaiPhong findByIdLoaiPhong(String ten) {
        String query = "Select ID from LoaiPhong where TenLoaiPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new LoaiPhong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public LoaiPhong findByIdPhong(String ten) {
        String query = "Select id From PhongTro where TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new LoaiPhong(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<KhachThuePhong> getSoNguoi(String ten) {
        String query = "SELECT count(dbo.KhachThue.ID)\n"
                + "FROM     dbo.KhachThue INNER JOIN\n"
                + "                  dbo.Phong_Thue ON dbo.KhachThue.ID = dbo.Phong_Thue.IDKhachThue INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.Phong_Thue.IDPhong = dbo.PhongTro.ID\n"
                + "				  where PhongTro.TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<KhachThuePhong> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachThuePhong(rs.getInt(1)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public String maTrung(String ma) {
        String query = "SELECT [TenPhong] FROM [QLNT].[dbo].[PhongTro] where [TenPhong] = ? ";
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
    
    public List<ThongTInHooaDon> getALLHoaDonPhong() {
        String query = "SELECT dbo.HoaDon.MaHoaDon, dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.LoaiPhong.GiaThue, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.NgayKetThuc, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.HoaDon.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "                  dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN\n"
                + "                  dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<ThongTInHooaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongTInHooaDon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getLong(5),
                        rs.getDate(6),
                        rs.getDate(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongTInHooaDon> getALLHoaDonDinhVu() {
        String query = "SELECT dbo.HoaDon.MaHoaDon, dbo.PhongTro.TenPhong, dbo.Tang.TenTang, dbo.LoaiPhong.TenLoaiPhong, dbo.DinhVu.Name, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.NgayKetThuc,\n"
                + "dbo.HoaDon.SoTien, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.ChiTietDinhVu INNER JOIN\n"
                + "dbo.HoaDon ON dbo.ChiTietDinhVu.IDHoaDon = dbo.HoaDon.ID INNER JOIN\n"
                + "dbo.PhongTro ON dbo.ChiTietDinhVu.IDPhongTro = dbo.PhongTro.ID AND dbo.HoaDon.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "dbo.DinhVu ON dbo.ChiTietDinhVu.IDDinhVu = dbo.DinhVu.ID INNER JOIN\n"
                + "dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN\n"
                + "dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<ThongTInHooaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongTInHooaDon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getLong(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongTInHooaDon> getALLHoaDonThietBi() {
        String query = "SELECT dbo.HoaDon.MaHoaDon, dbo.Thiet_Bi.Ten, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.NgayKetThuc, dbo.HoaDon.SoTien\n"
                + "FROM     dbo.ChiTietThietBi INNER JOIN\n"
                + "                  dbo.Thiet_Bi ON dbo.ChiTietThietBi.IDThietBi = dbo.Thiet_Bi.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietThietBi.IDHoaDon = dbo.HoaDon.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<ThongTInHooaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongTInHooaDon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getLong(5)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public QLDichVu getALLID(String name) {
        String query = "select ID from LoaiDinhVu where TenLoaiDinhVu =?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new QLDichVu(
                        rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Admin getTaiKhoan() {
        String query = "select TenTaiKhoan,MatKhau from TaiKhoan";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Admin(
                        rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new PhongRepository().getALLHoaDonThietBi().toString());
    }
}
