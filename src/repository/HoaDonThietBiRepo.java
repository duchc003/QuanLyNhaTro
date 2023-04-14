/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.HoaDonThietBi;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.DinhVu;
import util.ConnectDB;
import viewmodel.HoaDonDinhVu;

/**
 *
 * @author HoangKimDong
 */
public class HoaDonThietBiRepo {

    public ArrayList<HoaDonThietBi> getall() {
        ArrayList<HoaDonThietBi> list = new ArrayList<>();
        try {
            Connection cnn = ConnectDB.getConnection();
            String sql = " select PhongTro.TenPhong,Tang.TenTang,LoaiPhong.TenLoaiPhong,KhachThue.HoVaTen from Tang inner join PhongTro on Tang.ID=PhongTro.IDTang inner join LoaiPhong on \n"
                    + " LoaiPhong.ID=PhongTro.IDLoaiPhong inner join Phong_Thue on Phong_Thue.IDPhong=PhongTro.ID inner join KhachThue on KhachThue.ID=Phong_Thue.IDKhachThue";
            PreparedStatement ps = cnn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String tenphong = rs.getString("TenPhong");
                String TenTang = rs.getString("TenTang");
                String tenloaiPhong = rs.getString("TenLoaiPhong");
                String tenKhach = rs.getString("HoVaTen");
                HoaDonThietBi hd = new HoaDonThietBi(tenphong, TenTang, tenloaiPhong, tenKhach, null, 0, null);
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDonThietBi> getallTB(String ten) {
        ArrayList<HoaDonThietBi> list = new ArrayList<>();
        try {

            Connection cnn = ConnectDB.getConnection();
            String sql = "select Thiet_Bi.Ten, Count(ChiTietThietBi.SoLuong) as 'soluong',Thiet_Bi.GiaTien,PhongTro.TenPhong from ChiTietThietBi inner join Thiet_Bi on Thiet_Bi.ID=ChiTietThietBi.IDThietBi\n"
                    + "                    inner join PhongTro on PhongTro.ID=ChiTietThietBi.IDPhongTro\n"
                    + "                     group by Thiet_Bi.Ten,ChiTietThietBi.SoLuong,Thiet_Bi.GiaTien,PhongTro.TenPhong  having  Count(PhongTro.TenPhong)>0  and PhongTro.TenPhong=?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, ten);

            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String tentb = rs.getString("Ten");
                int solluong = rs.getInt("soluong");
                long gia = rs.getLong("GiaTien");
                String tenphong = rs.getString("TenPhong");
                HoaDonThietBi TB = new HoaDonThietBi(tenphong, null, null, null, tentb, solluong, gia);
                list.add(TB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public HoaDonDinhVu findByIdThietBI(String ten) {
        String query = "select ID from Thiet_Bi where Ten = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<DinhVu> list = new ArrayList<>();
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new HoaDonDinhVu(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public HoaDonDinhVu findByIdThietBIChiTiet(int id) {
        String query = "select ID from ChiTietThietBi where IDHopDong = ?";
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
        System.out.println(new HoaDonThietBiRepo().getallTB("P02").toString());
    }
}
