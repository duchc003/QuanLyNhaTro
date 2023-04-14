/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.KhachThue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import model.KhachThueThongKe;
import util.ConnectDB;
/**
 *
 * @author HoangKimDong
 */
public class KhachthueRepo {
    public ArrayList<KhachThueThongKe> getall(){
        ArrayList<KhachThueThongKe>list= new ArrayList<>();
        try {
            Connection cnn= ConnectDB.getConnection();
            String sql= "Select*  from KhachThue";
            PreparedStatement ps= cnn.prepareCall(sql);
            ps.execute();
            ResultSet rs =ps.getResultSet();
            while(rs.next()){
                int id =rs.getInt("ID");
                String name=rs.getString("HoVaTen");
                String ns=  rs.getString("NgaySinh");
                int gt=rs.getInt("GioiTinh");
                int sdt= rs.getInt("SDT");
                String email=rs.getString("Email");
                String cmt=rs.getString("CMND");
                String quequan=rs.getString("QueQuan");
                String ghichu=rs.getString("GhiChu");
                String img =rs.getString("Image");
                KhachThueThongKe kt =new KhachThueThongKe(id, name, ns, gt, sdt, email, cmt, quequan, ghichu, img);
                list.add(kt);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
         return list;
}  
    public  boolean insert(KhachThueThongKe kt){
        try {
            Connection cnn= ConnectDB.getConnection();
            String sql="insert into KhachThue(HoVaTen,NgaySinh,GioiTinh,SDT,Email,CMND,QueQuan,GhiChu,Image) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= cnn.prepareCall(sql);
            ps.setString(1,kt.getHoten());
            ps.setString(2,  kt.getNgaysinh());
            ps.setInt(3,kt.getGioitinh());
            ps.setInt(4,kt.getSdt());
            ps.setString(5, kt.getEmail());
            ps.setString(6, kt.getCmt());
            ps.setString(7,kt.getQuequan());
            ps.setString(8,kt.getGhichu());
            ps.setString(9,kt.getImg());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public  boolean update(KhachThueThongKe kt ){
        try {
            Connection cnn =ConnectDB.getConnection();
            String sql="update KhachThue set HoVaTen=?,NgaySinh=?"
                    + ",GioiTinh=?,SDT=?,Email=?,CMND=?,QueQuan=?,GhiChu=?,Image=? where ID=?";
            PreparedStatement ps =cnn.prepareCall(sql);
            ps.setString(1,kt.getHoten());
            ps.setString(2, kt.getNgaysinh());
            ps.setInt(3,kt.getGioitinh());
            ps.setInt(4,kt.getSdt());
            ps.setString(5, kt.getEmail());
            ps.setString(6, kt.getCmt());
            ps.setString(7,kt.getQuequan());
            ps.setString(8,kt.getGhichu());
            ps.setString(9,kt.getImg());
            ps.setInt(10, kt.getID());
            ps.execute();
            return true;
            
        } catch (Exception e) {
          e.printStackTrace();
        }
        return false;
    }
    public  ArrayList<KhachThueThongKe> tim(String ten){
        ArrayList<KhachThueThongKe>list= new ArrayList<>();
        try {
            Connection cnn = ConnectDB.getConnection();
            String sql="select* from KhachThue where HoVaTen=?";
            PreparedStatement ps= cnn.prepareCall(sql);
            ps.setString(1,ten);
            ps.execute();
            
            ResultSet rs= ps.getResultSet();
            
            while(rs.next()){
                int ID = rs.getInt("ID");
                String name = rs.getString("HoVaTen");
                String ns = rs.getString("NgaySinh");
                int gt = rs.getInt("GioiTinh");
                int sdt = rs.getInt("SDT");
                String email = rs.getString("Email");
                String cmt = rs.getString("CMND");
                String quequan = rs.getString("QueQuan");
                String ghichu = rs.getString("GhiChu");
                String img = rs.getString("Image");
                KhachThueThongKe kt = new KhachThueThongKe(ID, name, ns, gt, sdt, email, cmt, quequan, ghichu, img);
                list.add(kt);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
