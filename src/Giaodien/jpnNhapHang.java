/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import Entity.ChiTietPhieuNhap;
import Entity.PhieuNhap;
import Entity.Sua;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author G-up
 */
public class jpnNhapHang extends javax.swing.JPanel {

    /**
     * Creates new form jpnNhapHang
     */
    
    
    //truyen ma nv
    public jpnNhapHang(String data) throws ClassNotFoundException, SQLException {
        initComponents();
        LoadDataTable_SanPham();
        LoadDataTable_ChiTietPhieuNhap();
        Date date = new Date();
        dpk_NgayLap.setDate(date); 
        List<PhieuNhap> lstPhieuNhap = DAO.DAOPhieuNhap.getAllPN();
        boolean ktra=true;
        int i=1;
        while(ktra){
        for (PhieuNhap _PhieuNhap : lstPhieuNhap){
                if(_PhieuNhap.getMaPN().equals("PN"+i)){
                    ktra=true;
                    break;
                }
                else ktra=false;
        }
        if(ktra==true)
        i++;
        }
        txt_MaPN.setText("PN"+i);
        txt_MaNV.setText(data);
    }
    
    int delete_ctpn=0;
    
    List<ChiTietPhieuNhap> listCTPN = new ArrayList<>();

    jpnNhapHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void addCTPN(String MaPN , String MaSP , String SoLuong, String DonGia ){
        ChiTietPhieuNhap ctpn= new ChiTietPhieuNhap();
            ctpn.setMaPN(MaPN);
            ctpn.setMaSP(MaSP);
            ctpn.setSoLuong(Integer.valueOf(SoLuong));
            ctpn.setDonGia(Float.valueOf(DonGia));
            listCTPN.add(ctpn);
    }
    
    private void LoadDataControl_SanPham() throws SQLException, ClassNotFoundException
    {
        ImageIcon icon;
        if (tbl_SanPham.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tbl_SanPham.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<Sua> lstSanPham = DAO.DAOSua.getALL();
            //-- Xác định là sản phẩm  nào đang được click
            
            Sua sp1 = lstSanPham.get(i);
            //--- Set giá trị cho các control
            txt_MaSP.setText(sp1.getMaSP());
            txt_TenSP.setText(sp1.getTenSP());
            txt_DonGia.setText(String.valueOf(sp1.getDonGia()));
            txt_HinhAnh.setText(sp1.getHinhAnh()); 
            icon = new ImageIcon("C:\\Users\\G-up\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSua\\src\\anhSua\\"+sp1.getHinhAnh());            
            txt_HinhAnh.setIcon(icon);
            txt_HinhAnh.setText("");
        }
    }
    
    private void LoadDataControl_SanPhamByMaSP(String masp) throws SQLException, ClassNotFoundException
    {
        ImageIcon icon;
            
            //-- Lấy được danh sách sinh viên
            List<Sua> lstSanPham = DAO.DAOSua.getALL();
            //-- Xác định là sản phẩm  nào đang được click
            for (Sua _SanPham : lstSanPham){
                if (_SanPham.getMaSP().equals(masp)){
                    txt_MaSP.setText(_SanPham.getMaSP());
                    txt_TenSP.setText(_SanPham.getTenSP());
                    txt_DonGia.setText(String.valueOf(_SanPham.getDonGia()));
                    txt_SoLuong.setText("");
                    txt_HinhAnh.setText(_SanPham.getHinhAnh()); 
                    icon = new ImageIcon("C:\\Users\\G-up\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSua\\src\\anhSua\\"+_SanPham.getHinhAnh());            
                    txt_HinhAnh.setIcon(icon);
                    txt_HinhAnh.setText("");
                    break;
                }
            }
    }
    
    private int GetIndex_ChiTietPhieuNhap() throws SQLException, ClassNotFoundException
    {
        int i=0;
        if (tbl_ChiTietPhieuNhap.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            i = tbl_ChiTietPhieuNhap.getSelectedRow();
        }
        return i;
    }
    
    private void LoadDataTable_ChiTietPhieuNhap() throws ClassNotFoundException, SQLException
    {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã phiếu nhập");
        tblModel.addColumn("Mã sản phẩm");
        tblModel.addColumn("Số lượng");
        tblModel.addColumn("Đơn giá");
        // Add lần lượt các hàng
        for(ChiTietPhieuNhap _ChiTietPhieuNhap : listCTPN)
        {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(_ChiTietPhieuNhap.getMaPN()));
            row.addElement(String.valueOf(_ChiTietPhieuNhap.getMaSP()));
            row.addElement(String.valueOf(_ChiTietPhieuNhap.getSoLuong()));
            row.addElement(String.valueOf(_ChiTietPhieuNhap.getDonGia()));            
            tblModel.addRow(row);
        }
        tbl_ChiTietPhieuNhap.setModel(tblModel);
    }
    
    private void LoadDataTable_SanPham() throws ClassNotFoundException, SQLException
    {
        List<Sua> lstSanPham = DAO.DAOSua.getALL();
        // Thêm các tiêu đề cho bảng hiẻn thị
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã sản phẩm");
        tblModel.addColumn("Tên sản phẩm");
        tblModel.addColumn("Đơn giá");
        tblModel.addColumn("Số lượng");
        tblModel.addColumn("Hình ảnh");
        // Add lần lượt các hàng
        for(Sua _sanpham : lstSanPham)
        {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(_sanpham.getMaSP()));
            row.addElement(String.valueOf(_sanpham.getTenSP()));
            row.addElement(String.valueOf(_sanpham.getDonGia()));            
            row.addElement(String.valueOf(_sanpham.getSoLuong()));
            row.addElement(String.valueOf(_sanpham.getHinhAnh()));
            tblModel.addRow(row);
        }
        tbl_SanPham.setModel(tblModel); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SanPham = new org.jdesktop.swingx.JXTable();
        btn_Them = new javax.swing.JButton();
        txt_HinhAnh = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_TenSP = new javax.swing.JTextField();
        txt_MaSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txt_MaNCC = new javax.swing.JTextField();
        btn_ChonNCC = new javax.swing.JButton();
        txt_MaPN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_TongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dpk_NgayLap = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ChiTietPhieuNhap = new org.jdesktop.swingx.JXTable();
        btn_NhapHang = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1170, 700));
        setMinimumSize(new java.awt.Dimension(1170, 700));
        setPreferredSize(new java.awt.Dimension(1170, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_SanPham);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 676, 192));

        btn_Them.setText("Thêm");
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 90, 40));

        txt_HinhAnh.setText("jLabel7");
        jPanel1.add(txt_HinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 214, 300, 300));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tên sản phẩm:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 257, 110, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã sản phẩm:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 217, 90, -1));

        txt_TenSP.setEnabled(false);
        jPanel1.add(txt_TenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 289, 310, -1));

        txt_MaSP.setEnabled(false);
        jPanel1.add(txt_MaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 50, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Đơn giá(triệu)");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 85, -1));

        txt_DonGia.setEnabled(false);
        jPanel1.add(txt_DonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 80, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nhập số lượng:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 371, 100, -1));
        jPanel1.add(txt_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 80, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 700));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txt_MaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 71, 84, -1));

        btn_ChonNCC.setText("*");
        btn_ChonNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ChonNCCMouseClicked(evt);
            }
        });
        jPanel2.add(btn_ChonNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        txt_MaPN.setEnabled(false);
        jPanel2.add(txt_MaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 36, 105, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày lập:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txt_TongTien.setEnabled(false);
        jPanel2.add(txt_TongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 71, 84, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tổng tiền:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        txt_MaNV.setEnabled(false);
        txt_MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaNVActionPerformed(evt);
            }
        });
        jPanel2.add(txt_MaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 36, 84, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã nhân viên:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 34, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã NCC:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 74, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã phiếu nhập:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 34, 100, -1));
        jPanel2.add(dpk_NgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 113, 220, -1));

        tbl_ChiTietPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_ChiTietPhieuNhap);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 160, 480, 280));

        btn_NhapHang.setText("Nhập hàng");
        btn_NhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NhapHangMouseClicked(evt);
            }
        });
        jPanel2.add(btn_NhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 90, 40));

        btn_Xoa.setText("Xoá");
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });
        jPanel2.add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 90, 40));

        btn_Sua.setText("Sửa");
        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaMouseClicked(evt);
            }
        });
        jPanel2.add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 90, 40));

        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LamMoiMouseClicked(evt);
            }
        });
        jPanel2.add(btn_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 100, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 480, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ChonNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ChonNCCMouseClicked
        // TODO add your handling code here:///cai (*)
//        frmChonNCC frm= null;
//        try {
//            frm = new frmChonNCC();
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        frm.pack();
//        frm.setVisible(true);
    }//GEN-LAST:event_btn_ChonNCCMouseClicked

    private void txt_MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaNVActionPerformed

    private void btn_NhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NhapHangMouseClicked
        // TODO add your handling code here:
        if (txt_MaNCC.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lỗi - Số mã nhà cung cấp chưa được nhập!");
        }
        else{
            List<Sua> lstSanPham = null;
            try {
                lstSanPham = DAO.DAOSua.getALL();
            } catch (SQLException ex) {
                Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (ChiTietPhieuNhap _ChiTietPhieuNhap : listCTPN){
                for (Sua _SanPham : lstSanPham){
                    if (_ChiTietPhieuNhap.getMaSP().equals(_SanPham.getMaSP()))
                    try {
                        DAO.DAOSua.UpdateSPByMaSP(_ChiTietPhieuNhap.getMaSP(), (_SanPham.getSoLuong()+_ChiTietPhieuNhap.getSoLuong()));
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            Date dtn = dpk_NgayLap.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                DAO.DAOPhieuNhap.InsertPNNhapHang(txt_MaPN.getText(), txt_MaNCC.getText(), txt_MaNV.getText(), String.valueOf(dateFormat.format(dtn)), Float.valueOf(txt_TongTien.getText()));
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (ChiTietPhieuNhap _ChiTietPhieuNhap : listCTPN){
                try {
                    DAO.DAOChiTietPhieuNhap.InsertPN(_ChiTietPhieuNhap);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(this, "Nhập hàng thành công!");
        }

    }//GEN-LAST:event_btn_NhapHangMouseClicked

    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        // TODO add your handling code here:
        listCTPN.remove(delete_ctpn);

        try {
            LoadDataTable_ChiTietPhieuNhap();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_XoaMouseClicked

    private void btn_SuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaMouseClicked
        // TODO add your handling code here:
        String masp = listCTPN.get(delete_ctpn).getMaSP();
        listCTPN.remove(delete_ctpn);
        try {
            LoadDataControl_SanPhamByMaSP(masp);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SuaMouseClicked

    private void btn_LamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LamMoiMouseClicked

        Date a = new Date();

        List<PhieuNhap> lstPhieuNhap = null;
        try {
            lstPhieuNhap = DAO.DAOPhieuNhap.getAllPN();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean ktra=true;
        int i=1;
        while(ktra){
            for (PhieuNhap _PhieuNhap : lstPhieuNhap){
                if(_PhieuNhap.getMaPN().equals("PN"+i)){
                    ktra=true;
                    break;
                }
                else ktra=false;
            }
            if(ktra==true)
            i++;
        }
        txt_MaPN.setText("PN"+i);
        txt_MaNCC.setText("");
        txt_MaSP.setText("");
        txt_TongTien.setText("");
        dpk_NgayLap.setDate(a);
        txt_DonGia.setText("");
        txt_HinhAnh.setText("");
        txt_SoLuong.setText("");
        txt_TenSP.setText("");
        listCTPN.clear();
        try {
            // TODO add your handling code here:
            //            LoadDataTable_HoaDon();
            //            LoadDataTable_KhachHang();
            LoadDataTable_ChiTietPhieuNhap();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_LamMoiMouseClicked

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        if(txt_SoLuong.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Lỗi - Số lượng mua chưa được nhập!");
        }
        else{
            boolean ktra = true;
            for (ChiTietPhieuNhap _ChiTietPhieuNhap : listCTPN){
                if(txt_MaSP.getText().equals(_ChiTietPhieuNhap.getMaSP())){
                    ktra = false;
                    break;
                }
            }
            List<Sua> lstSanPham = null;
            try {
                lstSanPham = DAO.DAOSua.getALL();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ktra){
                addCTPN(txt_MaPN.getText(), txt_MaSP.getText(),txt_SoLuong.getText(), txt_DonGia.getText());
            }
            else{
                for (ChiTietPhieuNhap _ChiTietPhieuNhap : listCTPN){
                    if(txt_MaSP.getText().equals(_ChiTietPhieuNhap.getMaSP())){
                        int tongsoluong = Integer.valueOf(txt_SoLuong.getText())+_ChiTietPhieuNhap.getSoLuong();
                        _ChiTietPhieuNhap.setSoLuong(tongsoluong);
                    }
                }
            }
            float tongtien=0;
            for (ChiTietPhieuNhap _ChiTietPhieuNhap : listCTPN){
                tongtien = tongtien + _ChiTietPhieuNhap.getSoLuong()*_ChiTietPhieuNhap.getDonGia();
            }
            txt_TongTien.setText(String.valueOf(tongtien));
            try {
                LoadDataTable_ChiTietPhieuNhap();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txt_SoLuong.setText("");
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        try {
            LoadDataControl_SanPham();
        } catch (SQLException ex) {
            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_SanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChonNCC;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_NhapHang;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private org.jdesktop.swingx.JXDatePicker dpk_NgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tbl_ChiTietPhieuNhap;
    private org.jdesktop.swingx.JXTable tbl_SanPham;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JLabel txt_HinhAnh;
    private javax.swing.JTextField txt_MaNCC;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_MaPN;
    private javax.swing.JTextField txt_MaSP;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TenSP;
    private javax.swing.JTextField txt_TongTien;
    // End of variables declaration//GEN-END:variables
}
