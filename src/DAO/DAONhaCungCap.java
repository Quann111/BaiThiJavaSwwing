/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhaCungCap;
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
public class DAONhaCungCap {

    //GetAll
    public static List<NhaCungCap> getAllNCC() throws SQLException, ClassNotFoundException {
        List<NhaCungCap> lstNhaCungCap = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from NhaCungCap";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while (rs.next()) {
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(rs.getString("MaNCC"));
            ncc.setTenNCC(rs.getString("TenNCC"));
            ncc.setDiaChi(rs.getString("DiaChi"));
            ncc.setSDT(rs.getString("SDT"));
            lstNhaCungCap.add(ncc);
        }
        return lstNhaCungCap;
    }
    public static void InsertNCC(NhaCungCap ncc) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into NhaCungCap(MaNCC,TenNCC,DiaChi,SDT) values ('"+ ncc.getMaNCC()+"',N'"+ncc.getTenNCC()+"', N'"+ncc.getDiaChi()+"','"+ncc.getSDT()+"') ";
        PreparedStatement pStmt =  conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
        
    }
     
     public static void DeleteNCC(String _MaKH) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from NhaCungCap where MaNCC = '"+_MaKH+"' ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
     
     public static void UpdatenCC(NhaCungCap ncc) throws SQLException, ClassNotFoundException
    {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "update NhaCungCap set TenNCC = N'"+ncc.getTenNCC()+"', DiaChi = N'"+ncc.getDiaChi()+"', SDT =  '"+ncc.getSDT()+"'  where MaNCC = '"+ncc.getMaNCC()+"'   ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
}
