/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.ChiTietPhieuNhap;
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
public class DAOChiTietPhieuNhap {
    public static List<ChiTietPhieuNhap> getAllCTPN() throws SQLException, ClassNotFoundException
    {
        List<ChiTietPhieuNhap> lstChiTietPhieuNhap = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from ChiTietPhieuNhap";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            ChiTietPhieuNhap ctpn= new ChiTietPhieuNhap();
            ctpn.setMaPN(rs.getString("MaPN"));
            ctpn.setMaSP(rs.getString("MaSP"));
            ctpn.setSoLuong(rs.getInt("SoLuong"));
            ctpn.setDonGia(rs.getFloat("DonGia"));
            lstChiTietPhieuNhap.add(ctpn);
        }
        return lstChiTietPhieuNhap;
    }
    
    public static List<ChiTietPhieuNhap> getCTPN(String _MaPN) throws SQLException, ClassNotFoundException
    {
        List<ChiTietPhieuNhap> lstChiTietPhieuNhap = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from ChiTietPhieuNhap where MaPN = '"+_MaPN+"' ";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            ChiTietPhieuNhap ctpn= new ChiTietPhieuNhap();
            ctpn.setMaPN(rs.getString("MaPN"));
            ctpn.setMaSP(rs.getString("MaSP"));
            ctpn.setSoLuong(rs.getInt("SoLuong"));
            ctpn.setDonGia(rs.getFloat("DonGia"));
            lstChiTietPhieuNhap.add(ctpn);
        }
        return lstChiTietPhieuNhap;
    }
    
    public static void InsertPN(ChiTietPhieuNhap ctpn) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into ChiTietPhieuNhap(MaPN,MaSP,SoLuong,DonGia) values ('"+ctpn.getMaPN()+"', '"+ctpn.getMaSP()+"', '"+ctpn.getSoLuong()+"','"+ctpn.getDonGia()+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
        
    }
    
    public static void DeletePN(String _MaPN) throws SQLException, ClassNotFoundException
    {      
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from ChiTietPhieuNhap where MaPN = '"+_MaPN+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
}
