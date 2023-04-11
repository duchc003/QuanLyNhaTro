/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Phong {

    private int id;

    private int idTang;
    
    private int idLoaiPhong;
    
    private String tenPhong;
    
    private int soDien;
    
    private int soNuoc;

    private int soLuong;
    
    private String moTa;

    private String trangThai;

    public Phong() {
    }

    public Phong(int id, int idTang, int idLoaiPhong, String tenPhong, int soDien, int soNuoc, int soLuong, String moTa, String trangThai) {
        this.id = id;
        this.idTang = idTang;
        this.idLoaiPhong = idLoaiPhong;
        this.tenPhong = tenPhong;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Phong(int id, int idTang, int idLoaiPhong, String tenPhong, int soLuong, String moTa, String trangThai) {
        this.id = id;
        this.idTang = idTang;
        this.idLoaiPhong = idLoaiPhong;
        this.tenPhong = tenPhong;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Phong(int id) {
        this.id = id;
    }

    public Phong(String moTa) {
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTang() {
        return idTang;
    }

    public void setIdTang(int idTang) {
        this.idTang = idTang;
    }

    public int getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(int idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public int getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
