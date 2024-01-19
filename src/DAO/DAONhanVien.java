/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NguoiDung;
import Entity.NhanVien;
import Entity.Sua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAONhanVien {

    //GetAll
    public static List<NhanVien> getALLnhanvien() throws SQLException, ClassNotFoundException {
        List<NhanVien> lsketqua = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NhanVien";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();//thuc thi cau lenh
        while (rs.next()) {
            NhanVien nv1 = new NhanVien();
            nv1.setMaNV(rs.getString("manv"));
            nv1.setTenNV(rs.getString("tennv"));
            nv1.setNgaySinh(rs.getString("ngaysinh"));
            nv1.setDiaChi(rs.getString("diachi"));
            nv1.setSDT(rs.getString("SDT"));
            nv1.setPhanQuyen(rs.getString("phanquyen"));
            lsketqua.add(nv1);
        }
        return lsketqua;
    }

    //get one
    public static List<NhanVien> getOnenhanvien(int _manv) throws SQLException, ClassNotFoundException {
        List<NhanVien> lsketqua = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NhanVien where manv='" + _manv + "'";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();//thuc thi cau lenh
        while (rs.next()) {
            NhanVien nv1 = new NhanVien();
            nv1.setMaNV(rs.getString("manv"));
            nv1.setTenNV(rs.getString("tennv"));
            nv1.setNgaySinh(rs.getString("ngaysinh"));
            nv1.setDiaChi(rs.getString("diachi"));
            nv1.setSDT(rs.getString("SDT"));
            nv1.setPhanQuyen(rs.getString("phanquyen"));
            lsketqua.add(nv1);
        }
        return lsketqua;
    }
    //Delete one
    //update one
    //insert one

    public static void InsertSP(NhanVien _sp) throws SQLException, ClassNotFoundException {
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "insert into NhanVien(MaNV,TenNV,NgaySinh,DiaChi,SDT,PhanQuyen)  values ('" + _sp.getMaNV() + "','" + _sp.getTenNV() + "','" + _sp.getNgaySinh() + "','" + _sp.getDiaChi() + "', '" + _sp.getSDT() + "','" + _sp.getPhanQuyen() + "')";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(cnn);
    }

    public static void DeleteSP(String _MaNV) throws SQLException, ClassNotFoundException {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from NhanVien where MaNV = '" + _MaNV + "'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }

    public static void UpdateSP(NhanVien sp) throws SQLException, ClassNotFoundException {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "update NhanVien set TenNV = N'" + sp.getTenNV() + "',NgaySinh = N'" + sp.getNgaySinh() + "',DiaChi = '" + sp.getDiaChi() + "', SDT = '" + sp.getSDT() + "', MaNV =  '" + sp.getMaNV() + "' where MaNV = '" + sp.getMaNV() + "' ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
}
