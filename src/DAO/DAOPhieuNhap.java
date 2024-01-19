/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.PhieuNhap;
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
public class DAOPhieuNhap {
    public static List<PhieuNhap> getAllPN() throws SQLException, ClassNotFoundException
    {
        List<PhieuNhap> lstphieunhap = new ArrayList<>();   
        Connection cnn = TienIch.TienIch.getConnection();   
        String sql = "select * from PhieuNhap";
        PreparedStatement  pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            PhieuNhap pn = new PhieuNhap();
            pn.setMaPN(rs.getString("MaPN"));
            pn.setMaNCC(rs.getString("MaNCC"));
            pn.setMaNV(rs.getString("MaNV"));
            pn.setNgayLap(rs.getString("NgayLap"));
            pn.setTongTien(rs.getFloat("TongTien"));
            lstphieunhap.add(pn);
        }
        return lstphieunhap;
    }
    
    public static void InsertPN(PhieuNhap pn) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into PhieuNhap(MaPN,MaNNC,MaNV,MaSP,TongTien) values ('"+ pn.getMaPN()+"','"+pn.getMaNCC()+"', '"+pn.getMaNV()+"', '"+pn.getNgayLap()+"','"+pn.getTongTien()+"' ) ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
        
    }
    
    public static void DeletePN(String _MaPN) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from ChiTietPhieuNhap where MaPN= '"+_MaPN+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);  
        String sql1 = "delete from PhieuNhap where MaPN= '"+_MaPN+"'";
        PreparedStatement pStmt1 = conn.prepareStatement(sql1);
        pStmt1.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt1);
    }
    
    public static void InsertPNNhapHang(String _MaPN ,String _MaNCC , String _MaNV , String _NgayLap , float _TongTien) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into PhieuNhap(MaPN,MaNCC,MaNV,NgayLap,TongTien) values ('"+ _MaPN+"','"+_MaNCC+"', '"+_MaNV+"','"+_NgayLap+"',N'"+_TongTien+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);       
    }
}
