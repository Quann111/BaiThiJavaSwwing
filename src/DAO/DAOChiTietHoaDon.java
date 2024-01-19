/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.ChiTietHoaDon;
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
public class DAOChiTietHoaDon {
    public static List<ChiTietHoaDon> getAllCTHD() throws SQLException, ClassNotFoundException
    {
        List<ChiTietHoaDon> lstcthoadon = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from ChiTietHoaDon";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            ChiTietHoaDon cthd= new ChiTietHoaDon();
            cthd.setMaHD(rs.getString("MaHD"));
            cthd.setMaSP(rs.getString("MaSP"));
            cthd.setSoLuong(rs.getInt("SoLuong"));
            cthd.setDonGia(rs.getFloat("DonGia"));
            lstcthoadon.add(cthd);
        }
        return lstcthoadon;
    }
    
    public static List<ChiTietHoaDon> getCTHD(String _MaHD) throws SQLException, ClassNotFoundException
    {
        List<ChiTietHoaDon> lstcthoadon = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from ChiTietHoaDon where MaHD = '"+_MaHD+"' ";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            ChiTietHoaDon cthd= new ChiTietHoaDon();
            cthd.setMaHD(rs.getString("MaHD"));
            cthd.setMaSP(rs.getString("MaSP"));
            cthd.setSoLuong(rs.getInt("SoLuong"));
            cthd.setDonGia(rs.getFloat("DonGia"));
            lstcthoadon.add(cthd);
        }
        return lstcthoadon;
    }
    
    public static void InsertHD(ChiTietHoaDon cthd) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into ChiTietHoaDon(MaHD,MaSP,SoLuong,DonGia) values ('"+cthd.getMaHD()+"', '"+cthd.getMaSP()+"', '"+cthd.getSoLuong()+"','"+cthd.getDonGia()+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
        
    }
    
    public static void DeleteHD(String _MaHD) throws SQLException, ClassNotFoundException
    {
       
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from ChiTietHoaDon where MaHD = '"+_MaHD+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
}
