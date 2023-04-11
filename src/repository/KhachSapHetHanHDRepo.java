/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.khachSapHetHanHopDong;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import util.ConnectDB;
/**
 *
 * @author HoangKimDong
 */
public class KhachSapHetHanHDRepo {
     
     public  ArrayList<khachSapHetHanHopDong>getall(){
     ArrayList<khachSapHetHanHopDong>list= new ArrayList<>();
         try {
             Connection cnn =ConnectDB.getConnection();
             String sql= "select count(DATEDIFF(day, GETDATE(), NgayKT)) as 'so luong' from HopDong where DATEDIFF(day, GETDATE(), NgayKT) BETWEEN 0 AND 30";
             PreparedStatement ps =cnn.prepareCall(sql);
             ps.execute();
             ResultSet rs =ps.getResultSet();
             while(rs.next()){
                 String sl=rs.getString("so luong");
                 khachSapHetHanHopDong kh= new khachSapHetHanHopDong(sl);
                 list.add(kh);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return list;
     }
     public  ArrayList<khachSapHetHanHopDong>getall60(){
     ArrayList<khachSapHetHanHopDong>list= new ArrayList<>();
         try {
             Connection cnn =ConnectDB.getConnection();
             String sql= "select count(DATEDIFF(day, GETDATE(), NgayKT)) as 'so luong' from HopDong where DATEDIFF(day, GETDATE(), NgayKT) BETWEEN 0 AND 60";
             PreparedStatement ps =cnn.prepareCall(sql);
             ps.execute();
             ResultSet rs =ps.getResultSet();
             while(rs.next()){
                 String sl=rs.getString("so luong");
                 khachSapHetHanHopDong kh= new khachSapHetHanHopDong(sl);
                 list.add(kh);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return list;
     }
     public  ArrayList<khachSapHetHanHopDong>getall90(){
     ArrayList<khachSapHetHanHopDong>list= new ArrayList<>();
         try {
             Connection cnn =ConnectDB.getConnection();
             String sql= "select count(DATEDIFF(day, GETDATE(), NgayKT)) as 'so luong' from HopDong where DATEDIFF(day, GETDATE(), NgayKT) BETWEEN 0 AND 90";
             PreparedStatement ps =cnn.prepareCall(sql);
             ps.execute();
             ResultSet rs =ps.getResultSet();
             while(rs.next()){
                 String sl=rs.getString("so luong");
                 khachSapHetHanHopDong kh= new khachSapHetHanHopDong(sl);
                 list.add(kh);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return list;
     }
     
}
