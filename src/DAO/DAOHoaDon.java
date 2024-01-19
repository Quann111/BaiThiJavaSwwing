/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HoaDon;
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
public class DAOHoaDon {
    public static List<HoaDon> getAllHD() throws SQLException, ClassNotFoundException
    {
        List<HoaDon> lsthoadon = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from HoaDon";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            HoaDon hd= new HoaDon();
            hd.setMaHD(rs.getString("MaHD"));
            hd.setMaNV(rs.getString("MaNV"));
            hd.setMaKH(rs.getString("MaKH"));
            hd.setNgayLap(rs.getString("NgayLap"));
            hd.setTongTien(rs.getFloat("TongTien"));
            lsthoadon.add(hd);
        }
        return lsthoadon;
    }
    public static void InsertHD(HoaDon hd) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into HoaDon(MaHD,MaKH,MaNV,NgayLap,TongTien) values ('"+ hd.getMaHD()+"','"+hd.getMaKH()+"', '"+hd.getMaNV()+"','"+hd.getNgayLap()+"',N'"+hd.getTongTien()+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
        
    }
    
    public static void DeleteHD(String _MaHD) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();       
        String sql = "delete from ChiTietHoaDon where MaHD= '"+_MaHD+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
    
        String sql1 = "delete from HoaDon where MaHD= '"+_MaHD+"'";
        PreparedStatement pStmt1 = conn.prepareStatement(sql1);
        pStmt1.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt1);
        
        TienIch.TienIch.closeConnection(conn);
    }
    
    public static void UpdateHD(HoaDon hd) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "update HoaDon set TongTien = '"+hd.getTongTien()+"',  MaKH = '"+hd.getMaKH()+"', MaNV =  '"+hd.getMaNV()+"' , NgayLap = '"+hd.getNgayLap()+"' where MaHD = '"+hd.getMaHD()+"'   ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }

     
    public static void InsertHDBanHang(String _MaHD ,String _MaKH , String _MaNV , String _NgayLap , float _TongTien) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into HoaDon(MaHD,MaKH,MaNV,NgayLap,TongTien) values ('"+ _MaHD+"','"+_MaKH+"', '"+_MaNV+"','"+_NgayLap+"',N'"+_TongTien+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);       
    }
}
