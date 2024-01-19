/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.KhachHang;
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
public class DAOKhachHang {

    public static List<KhachHang> getAllKH() throws SQLException, ClassNotFoundException {
        List<KhachHang> lstKhachHang = new ArrayList<>();
        Connection cnn = TienIch.TienIch.getConnection();
        String sql = "select * from KhachHang";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while (rs.next()) {
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("MaKH"));
            kh.setTenKH(rs.getString("TenKH"));
            kh.setDiaChi(rs.getString("DiaChi"));
            kh.setSDT(rs.getString("SDT"));
            lstKhachHang.add(kh);
        }
        return lstKhachHang;
    }
    //Them

    public static void InsertKH(KhachHang kh) throws SQLException, ClassNotFoundException {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "insert into KhachHang(MaKH,TenKH,DiaChi,SDT) values ('" + kh.getMaKH() + "',N'" + kh.getTenKH() + "', N'" + kh.getDiaChi() + "','" + kh.getSDT() + "') ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);

    }
    //Xoa

    public static void DeleteKH(String _MaKH) throws SQLException, ClassNotFoundException {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "delete from KhachHang where MaKH = '" + _MaKH + "' ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }

    //Sua
    public static void UpdateKH(KhachHang kh) throws SQLException, ClassNotFoundException {
        Connection conn = TienIch.TienIch.getConnection();
        String sql = "update KhachHang set TenKH = N'" + kh.getTenKH() + "', DiaChi = N'" + kh.getDiaChi() + "', SDT =  '" + kh.getSDT() + "'  where MaKH = '" + kh.getMaKH() + "'   ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        TienIch.TienIch.closePreparedStatement(pStmt);
        TienIch.TienIch.closeConnection(conn);
    }
}
