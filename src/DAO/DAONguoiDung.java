/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G-up
 */
public class DAONguoiDung {
    public static List<NguoiDung> getAllND() throws SQLException, ClassNotFoundException
    {
        List<NguoiDung> lstNguoiDung = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NguoiDung";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();//thuc thi cau lenh
        while(rs.next())
        {
            NguoiDung nd =  new NguoiDung();
            nd.setMaNV(rs.getString("MaNV"));
            nd.setTaiKhoan(rs.getString("TaiKhoan"));
            nd.setMatKhau(rs.getString("Matkhau"));
            lstNguoiDung.add(nd);
        }
        return lstNguoiDung;
    }
    
    public static List<NguoiDung> getOneND(String _taikhoan,String _pass) throws SQLException, ClassNotFoundException
    {
        List<NguoiDung> lstNguoiDung = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NguoiDung where TaiKhoan = '"+ _taikhoan +"' and MatKhau = '"+_pass+"' ";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            NguoiDung nd =  new NguoiDung();
            nd.setMaNV(rs.getString("MaNV"));
            nd.setTaiKhoan(rs.getString("TaiKhoan"));
            nd.setMatKhau(rs.getString("MatKhau"));            
            lstNguoiDung.add(nd);
        }
        return lstNguoiDung;
    }
    
    public static String SearchTK(String _taikhoan, String _pass) throws SQLException, ClassNotFoundException
    {
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NguoiDung,NhanVien where TaiKhoan = '"+_taikhoan+"' and MatKhau = '"+_pass+"' and NguoiDung.MaNV=NhanVien.MaNV";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        String pq="";
        while(rs.next())
        {
            String x =  rs.getString("PhanQuyen");
            pq=x;
        }
       
        return pq;
    }
    
    public static String SearchMaNV(String _taikhoan, String _pass) throws SQLException, ClassNotFoundException
    {
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NguoiDung,NhanVien where TaiKhoan = '"+_taikhoan+"' and MatKhau = '"+_pass+"' and NguoiDung.MaNV=NhanVien.MaNV";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        String manv="";
        while(rs.next())
        {
            String x =  rs.getString("MaNV");
            manv=x;
        }
       
        return manv;
    }
    
    public static String Searchten(String _taikhoan, String _pass) throws SQLException, ClassNotFoundException
    {
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NguoiDung,NhanVien where TaiKhoan = '"+_taikhoan+"' and MatKhau = '"+_pass+"' and NguoiDung.MaNV=NhanVien.MaNV";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        String ten="";
        while(rs.next())
        {
            String x =  rs.getString("TenNV");
            ten=x;
        }
        return ten;
    }
}
