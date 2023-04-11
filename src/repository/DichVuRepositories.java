/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import model.DichVu;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectDB;
/**
 *
 * @author Admin
 */
public class DichVuRepositories {
    public List<DichVu> getAll(){
        String querry = """
                        SELECT [ID]
                              ,[IDLoai]
                              ,[Name]
                              ,[Gia]
                              ,[DonVi]
                              ,[MoTa]
                              ,[TrangThai]
                          FROM [dbo].[DinhVu]
                        """;
        try { Connection con = ConnectDB.getConnection();
        PreparedStatement ps = con.prepareStatement(querry);
         ResultSet rs = ps.executeQuery();
         List<DichVu> list = new ArrayList<>();
            while (rs.next()) {                
                DichVu dv = new DichVu(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(dv);
            }
            return list;           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     public void them(DichVu dv){
        String querry = """
                        INSERT INTO [dbo].[DinhVu]
                                   ([IDLoai]
                                   ,[Name]
                                   ,[Gia]
                                   ,[DonVi]
                                   ,[MoTa]
                                   ,[TrangThai])
                             VALUES
                                   (?,?,?,?,?,?)
                        """;
        try { Connection con = ConnectDB.getConnection();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setObject(1,dv.getLoai());
        ps.setObject(2,dv.getName());
        ps.setObject(3,dv.getGia());
        ps.setObject(4,dv.getDonVi());
        ps.setObject(5,dv.getMoTa());
        ps.setObject(6, dv.getTrangThai());
        ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public void xoa(String id){
        String querry = """
                        DELETE FROM [dbo].[DinhVu]
                              WHERE ID = ?
                        """;
        try { Connection con = ConnectDB.getConnection();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setString(1,id);
        ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    
 }
    public void sua(DichVu dv ,String Id){
        String querry = """
                        UPDATE [dbo].[DinhVu]
                            SET [IDLoai] = ?
                               ,[Name] = ?
                               ,[Gia] = ?
                               ,[DonVi] =? 
                               ,[MoTa] = ?
                               ,[TrangThai] = ? 
                          WHERE ID = ?
                        """;
        try { Connection con = ConnectDB.getConnection();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setObject(1,dv.getLoai());
        ps.setObject(2,dv.getName());
        ps.setObject(3,dv.getGia());
        ps.setObject(4,dv.getDonVi());
        ps.setObject(5,dv.getMoTa());
        ps.setObject(6,dv.getTrangThai());
        ps.setObject(7, Id);
        ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    
  }
}
