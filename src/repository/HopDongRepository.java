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
import model.HopDong;
import model.KhachThue;
import model.DinhVu;
import model.HoaDonDinhVuAdd;
import model.Phong;
import model.PhongThue;
import model.ThietBi;
import util.ConnectDB;
import viewmodel.DinhVuView;
import viewmodel.HopDongViewModel;
import viewmodel.ThietBiView;

/**
 *
 * @author ASUS
 */
public class HopDongRepository {

    // load table dịnh vụ trong hợp đồng
    public List<DinhVuView> getAllDinhVu() {
        String query = "SELECT [Name]\n"
                + "      ,[Gia]\n"
                + "      ,[DonVi]\n"
                + "  FROM [QLNT].[dbo].[DinhVu]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<DinhVuView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DinhVuView(rs.getString(1), rs.getLong(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // load table thiết bị trong hợp đồng
    public List<ThietBiView> getAllThietBi() {
        String query = "SELECT [Ten]\n"
                + "      ,[SoLuong]\n"
                + "      ,[GiaTien]\n"
                + "  FROM [QLNT].[dbo].[Thiet_Bi]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<ThietBiView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThietBiView(rs.getString(1), rs.getInt(2), rs.getLong(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    //thêm khách mới vào hợp đồng
    public boolean addKhach(KhachThue KhachThue) {
        String query = "INSERT INTO [dbo].[KhachThue]\n"
                + "           ([HoVaTen]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[SDT]\n"
                + "           ,[Email]\n"
                + "           ,[CMND]\n"
                + "           ,[QueQuan])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, KhachThue.getHoVaTen());
            ps.setObject(2, KhachThue.getNgaySinh());
            ps.setObject(3, KhachThue.isGioiTinh());
            ps.setObject(4, KhachThue.getSdt());
            ps.setObject(5, KhachThue.getEmail());
            ps.setObject(6, KhachThue.getCmnd());
            ps.setObject(7, KhachThue.getQueQuan());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // thêm mới hợp đồng
    public boolean addHopDong(HopDong hopDong) {
        String query = "INSERT INTO [dbo].[HopDong]\n"
                + "           ([IDKhachThue]\n"
                + "           ,[IDPhongTro]\n"
                + "           ,[MaHopDong]\n"
                + "           ,[NgayBatDau]\n"
                + "           ,[NgayKT]\n"
                + "           ,[TienCoc]\n"
                + "           ,[NgayChotTienPhong]\n"
                + "           ,[KiThanhToan]\n"
                + "           ,[ThanhToanMoiLan]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hopDong.getIdKhach());
            ps.setObject(2, hopDong.getIdPhong());
            ps.setObject(3, hopDong.getMaHD());
            ps.setObject(4, hopDong.getNgayBD());
            ps.setObject(5, hopDong.getNgayKT());
            ps.setObject(6, hopDong.getTienCoc());
            ps.setObject(7, hopDong.getNgayChotTienPhong());
            ps.setObject(8, hopDong.getKiThanhToan());
            ps.setObject(9, hopDong.getThanhToanMoiLan());
            ps.setObject(10, hopDong.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // thêm mới dịnh vụ vào hợp đồng
    public boolean addChiTietDinhVu(DinhVu dinhVu) {
        String query = "INSERT INTO [dbo].[ChiTietDinhVu]\n"
                + "           ([IDHopDong]\n"
                + "           ,[IDDinhVu]\n"
                + "           ,[IDPhongTro]\n"
                + "           ,[IDKhachThue]\n"
                + "           ,[SoLuong]\n"
                + "           ,[ThanhTien]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, dinhVu.getIdHopDong());
            ps.setObject(2, dinhVu.getIdDinhVu());
            ps.setObject(3, dinhVu.getIdPhongTro());
            ps.setObject(4, dinhVu.getIdKhachThue());
            ps.setObject(5, dinhVu.getSoLuong());
            ps.setObject(6, dinhVu.getThanhTien());
            ps.setObject(7, dinhVu.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // thêm mới thiết bị vào hợp đồng
    public boolean addChiTietThietBi(ThietBi thietBi) {
        String query = "INSERT INTO [dbo].[ChiTietThietBi]\n"
                + "           ([IDHopDong]\n"
                + "           ,[IDThietBi]\n"
                + "           ,[IDKhachThue]\n"
                + "           ,[IDPhongTro]\n"
                + "           ,[SoLuong]\n"
                + "           ,[NgaySuDung]\n"
                + "           ,[NgayTraLai]\n"
                + "           ,[TrangThai]\n"
                + "           ,[ChiPhi])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, thietBi.getIdHopDong());
            ps.setObject(2, thietBi.getIdThietBi());
            ps.setObject(3, thietBi.getIdKhachThue());
            ps.setObject(4, thietBi.getIdPhong());
            ps.setObject(5, thietBi.getSoLuong());
            ps.setObject(6, thietBi.getNgaySuDung());
            ps.setObject(7, thietBi.getNgayTraLai());
            ps.setObject(8, thietBi.getTrangThai());
            ps.setObject(9, thietBi.getChiPhi());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // thêm mới phòng thuê
    public boolean addPhongThue(PhongThue phongThue) {
        String query = "INSERT INTO [dbo].[Phong_Thue]\n"
                + "           ([IDKhachThue]\n"
                + "           ,[IDPhong]\n"
                + "           ,[ngay_bat_dau]\n"
                + "           ,[ngay_ket_thuc]\n"
                + "           ,[gia_thue]\n"
                + "           ,[tinh_trang])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phongThue.getIdKhachThue());
            ps.setObject(2, phongThue.getIdPhong());
            ps.setObject(3, phongThue.getNgayBD());
            ps.setObject(4, phongThue.getNgayKt());
            ps.setObject(5, phongThue.getGiaPhong());
            ps.setObject(6, phongThue.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean addPhongThueKhachPhuThuoc(PhongThue phongThue) {
        String query = "INSERT INTO [dbo].[Phong_Thue]\n"
                + "           ([IDKhachThue]\n"
                + "           ,[IDPhong]\n"
                + "           ,[gia_thue]\n"
                + "           ,[tinh_trang])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, phongThue.getIdKhachThue());
            ps.setObject(2, phongThue.getIdPhong());
            ps.setObject(3, phongThue.getGiaPhong());
            ps.setObject(4, phongThue.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    // lấy id khách thue
    public KhachThue findByID(String ten) {
        String query = "select id From KhachThue where HoVaTen = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhachThue(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Phong findByIDPhong(String ten) {
        String query = "select id From PhongTro where TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Phong(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public HopDong findByIDHopDong(int id) {
        String query = "select id from HopDong where IDKhachThue = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new HopDong(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ThietBi findByIDThietBi(String id) {
        String query = "select id from Thiet_Bi where Ten = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new ThietBi(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public DinhVu findByIDDinhVu(String id) {
        String query = "select id from DinhVu where Name = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new DinhVu(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean updateSoLuongThietBi(ThietBi thietBi, int id) {
        String query = "UPDATE [dbo].[Thiet_Bi]\n"
                + "   SET [SoLuong] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, thietBi.getSoLuong());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public List<HopDongViewModel> getAllHopDong() {
        String query = "SELECT dbo.HopDong.MaHopDong, dbo.Tang.TenTang, dbo.PhongTro.TenPhong, dbo.LoaiPhong.TenLoaiPhong,KhachThue.HoVaTen, dbo.HopDong.NgayBatDau, dbo.HopDong.NgayKT, dbo.LoaiPhong.GiaThue, dbo.HopDong.TienCoc, \n"
                + "                  dbo.HopDong.KiThanhToan,HopDong.TrangThai\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + "                  dbo.KhachThue ON dbo.HopDong.IDKhachThue = dbo.KhachThue.ID INNER JOIN\n"
                + "                  dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "                  dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN\n"
                + "                  dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<HopDongViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HopDongViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HopDongViewModel> findByMaPhong(String ten) {
        String query = "SELECT dbo.HopDong.MaHopDong, dbo.Tang.TenTang, dbo.PhongTro.TenPhong, dbo.LoaiPhong.TenLoaiPhong,KhachThue.HoVaTen, dbo.HopDong.NgayBatDau, dbo.HopDong.NgayKT, dbo.LoaiPhong.GiaThue, dbo.HopDong.TienCoc, \n"
                + "dbo.HopDong.KiThanhToan,HopDong.TrangThai\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + " dbo.KhachThue ON dbo.HopDong.IDKhachThue = dbo.KhachThue.ID INNER JOIN\n"
                + "dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID INNER JOIN\n"
                + "dbo.LoaiPhong ON dbo.PhongTro.IDLoaiPhong = dbo.LoaiPhong.ID INNER JOIN\n"
                + "dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID\n"
                + "where PhongTro.TenPhong = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<HopDongViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HopDongViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HopDongViewModel> locHopDong(Date star, Date end) {
        String query = "SELECT dbo.HopDong.MaHopDong, dbo.Tang.TenTang, dbo.PhongTro.TenPhong, dbo.LoaiPhong.TenLoaiPhong, dbo.KhachThue.HoVaTen, dbo.HopDong.NgayBatDau, dbo.HopDong.NgayKT, dbo.LoaiPhong.GiaThue, dbo.HopDong.TienCoc, \n"
                + "dbo.HopDong.KiThanhToan, dbo.HopDong.TrangThai\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + "dbo.KhachThue ON dbo.HopDong.IDKhachThue = dbo.KhachThue.ID INNER JOIN\n"
                + "dbo.LoaiPhong ON dbo.HopDong.ID = dbo.LoaiPhong.ID INNER JOIN\n"
                + "dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID AND dbo.LoaiPhong.ID = dbo.PhongTro.IDLoaiPhong INNER JOIN\n"
                + "dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID\n"
                + "where dbo.HopDong.NgayBatDau >= ? AND dbo.HopDong.NgayKT <= ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setDate(1, new java.sql.Date(star.getTime()));
            ps.setDate(2, new java.sql.Date(end.getTime()));
            List<HopDongViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HopDongViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HopDongViewModel> trangThai(String ten) {
        String query = "SELECT dbo.HopDong.MaHopDong, dbo.Tang.TenTang, dbo.PhongTro.TenPhong, dbo.LoaiPhong.TenLoaiPhong, dbo.KhachThue.HoVaTen, dbo.HopDong.NgayBatDau, dbo.HopDong.NgayKT, dbo.LoaiPhong.GiaThue, dbo.HopDong.TienCoc, \n"
                + "dbo.HopDong.KiThanhToan, dbo.HopDong.TrangThai\n"
                + "FROM     dbo.HopDong INNER JOIN\n"
                + "dbo.KhachThue ON dbo.HopDong.IDKhachThue = dbo.KhachThue.ID INNER JOIN\n"
                + "dbo.LoaiPhong ON dbo.HopDong.ID = dbo.LoaiPhong.ID INNER JOIN\n"
                + "dbo.PhongTro ON dbo.HopDong.IDPhongTro = dbo.PhongTro.ID AND dbo.LoaiPhong.ID = dbo.PhongTro.IDLoaiPhong INNER JOIN\n"
                + "dbo.Tang ON dbo.PhongTro.IDTang = dbo.Tang.ID\n"
                + "where dbo.HopDong.TrangThai = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            List<HopDongViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HopDongViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getLong(8),
                        rs.getLong(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new HopDongRepository().getAllHopDong().toString());
    }
}
