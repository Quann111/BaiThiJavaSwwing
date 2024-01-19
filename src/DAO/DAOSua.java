/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NguoiDung;
import Entity.Sua;
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
public class DAOSua {
    public static List<Sua> getALL() throws SQLException, ClassNotFoundException{
        List<Sua> lstSanPham = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from SanPham";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();//thuc thi cau lenh
        while(rs.next())
        {
            Sua sp =  new Sua();
            sp.setMaSP(rs.getString("MaSP"));
            sp.setTenSP(rs.getString("TenSP"));
            sp.setLoai(rs.getString("Loai"));
            sp.setHangSD(rs.getString("HangSD"));
            sp.setDonGia(rs.getFloat("DonGia"));
            sp.setSoLuong(rs.getInt("SoLuong"));
            sp.setHinhAnh(rs.getString("HinhAnh"));
            lstSanPham.add(sp);
        }
        return lstSanPham;
    }
    public static List<Sua> getSP(String _giadau,String _giacuoi) throws SQLException, ClassNotFoundException{
        List<Sua> lstSanPham = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from SanPham where  DonGia <=  '"+_giacuoi+"' and DonGia >= '"+_giadau+"' ";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();//thuc thi cau lenh
        while(rs.next())
        {
            Sua sp =  new Sua();
            sp.setMaSP(rs.getString("MaSP"));
            sp.setTenSP(rs.getString("TenSP"));
            sp.setLoai(rs.getString("Loai"));
            sp.setHangSD(rs.getString("HangSD"));
            sp.setDonGia(rs.getFloat("DonGia"));
            sp.setSoLuong(rs.getInt("SoLuong"));
            sp.setHinhAnh(rs.getString("HinhAnh"));
            lstSanPham.add(sp);
        }
        return lstSanPham;
    }
    public static void InsertSP(Sua sp) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into SanPham(MaSP,TenSP,Loai,HangSD,DonGia,SoLuong,HinhAnh) values ('"+ sp.getMaSP()+"',N'"+sp.getTenSP()+"','"+sp.getLoai()+"','"+sp.getHangSD()+"', '"+sp.getDonGia()+"','"+sp.getSoLuong()+"','"+sp.getHinhAnh()+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
    public static void DeleteSP(String _MaSP) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from SanPham where MaSP = '"+_MaSP+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
    
    public static void UpdateSP(Sua sp) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "update SanPham set TenSP = N'"+sp.getTenSP()+"',Loai = N'"+sp.getLoai()+"',HangSD = '"+sp.getHangSD()+"', DonGia = '"+sp.getDonGia()+"', SoLuong =  '"+sp.getSoLuong()+"' where MaSP = '"+sp.getMaSP()+"'   ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
    
    public static void UpdateSPByMaSP(String _MaSP ,int _SoLuong) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "update SanPham set  SoLuong =  '"+_SoLuong+"'  where MaSP = '"+_MaSP+"' ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
}
