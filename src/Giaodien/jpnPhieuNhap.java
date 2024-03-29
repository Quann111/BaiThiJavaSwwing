/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import Entity.PhieuNhap;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author G-up
 */
public class jpnPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form jpnPhieuNhap
     */
    public jpnPhieuNhap() throws ClassNotFoundException, SQLException {
        initComponents();
        LoadDataTable();
    }
    
    private void LoadDataTable() throws ClassNotFoundException, SQLException
    {
        List<PhieuNhap> lstPhieuNhap = DAO.DAOPhieuNhap.getAllPN();
        // Thêm các tiêu đề cho bảng hiẻn thị
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã phiếu nhập");
        tblModel.addColumn("Mã nhà cung cấp ");
        tblModel.addColumn("Mã nhân viên");
        tblModel.addColumn("Tổng tiền");
        
        // Add lần lượt các hàng
        for(PhieuNhap _PhieuNhap : lstPhieuNhap)
        {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(_PhieuNhap.getMaPN()));
            row.addElement(String.valueOf(_PhieuNhap.getMaNCC()));
            row.addElement(String.valueOf(_PhieuNhap.getMaNV())); 
            row.addElement(String.valueOf(_PhieuNhap.getTongTien()));
            tblModel.addRow(row);
        }
        tbl_PN.setModel(tblModel);   
    }
    
    private void LoadDataControl() throws SQLException, ClassNotFoundException
    {
        if (tbl_PN.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tbl_PN.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<PhieuNhap> lstPhieuNhap = DAO.DAOPhieuNhap.getAllPN();
            //-- Xác định là sản phẩm  nào đang được click
            
            PhieuNhap sp1 = lstPhieuNhap.get(i);
            //--- Set giá trị cho các control
            txt_MaPN.setText(sp1.getMaPN());
            txt_MaNCC.setText(sp1.getMaNCC());
            txt_MaNV.setText(sp1.getMaNV());
            txt_TongTien.setText(String.valueOf(sp1.getTongTien()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_PN = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_CTPN = new javax.swing.JButton();
        btn_XuatFile = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_TongTien = new javax.swing.JTextField();
        txt_MaNV = new javax.swing.JTextField();
        txt_MaNCC = new javax.swing.JTextField();
        txt_MaPN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1170, 700));
        setPreferredSize(new java.awt.Dimension(1170, 700));

        tbl_PN.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_PN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_PN);

        jButton1.setText("Làm mới");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btn_Xoa.setText("Xoá");
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });

        btn_CTPN.setText("CTPN");
        btn_CTPN.setEnabled(false);
        btn_CTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CTPNMouseClicked(evt);
            }
        });

        btn_XuatFile.setText("Xuất file");
        btn_XuatFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XuatFileMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        txt_TongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_MaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaNVActionPerformed(evt);
            }
        });

        txt_MaNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_MaPN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã phiếu nhập:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhà cung cấp:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã nhân viên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tổng tiền:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_MaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Phiếu Nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(btn_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(btn_XuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_XuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaNVActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        txt_MaNCC.setText("");
        txt_MaNV.setText("");
        txt_MaPN.setText("");
        txt_TongTien.setText("");
        btn_CTPN.setEnabled(false);

    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        try {
            // TODO add your handling code here:
            DAO.DAOPhieuNhap.DeletePN(txt_MaPN.getText());
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } catch (SQLException ex) {
            Logger.getLogger(jpnPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_XoaMouseClicked

    private void btn_CTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CTPNMouseClicked

        try {
            frmCTPN  frm = new frmCTPN(txt_MaPN.getText());
            frm.pack();
            frm.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jpnHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_CTPNMouseClicked

    private void btn_XuatFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatFileMouseClicked
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Phiếu Nhập");

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);//xuong hang thu 3
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);//viet ds phieu nhap vao cot 0
            cell.setCellValue("DANH SÁCH PHIẾU NHẬP");

            row = spreadsheet.createRow((short) 3);//Xuong hang 4 
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã phiếu nhập");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã nhà cung cấp");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Mã nhân viên");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Ngày Lập");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Tổng tiền");


            List<PhieuNhap> listItem = DAO.DAOPhieuNhap.getAllPN();
            for (int i = 0; i < listItem.size(); i++) {
                PhieuNhap _phieunhap = listItem.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(_phieunhap.getMaPN());
                row.createCell(2).setCellValue(_phieunhap.getMaNCC());
                row.createCell(3).setCellValue(_phieunhap.getMaNV());
                row.createCell(4).setCellValue(_phieunhap.getNgayLap());
                row.createCell(5).setCellValue(_phieunhap.getTongTien());
            }
            
            FileOutputStream out = new FileOutputStream(new File("C:\\java_luu\\Dspn.xlsx"));
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(this, "Xuất file thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_XuatFileMouseClicked

    private void tbl_PNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PNMouseClicked
        btn_CTPN.setEnabled(true);
        try {
            LoadDataControl();
        } catch (SQLException ex) {
            Logger.getLogger(jpnPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_PNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CTPN;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XuatFile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tbl_PN;
    private javax.swing.JTextField txt_MaNCC;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_MaPN;
    private javax.swing.JTextField txt_TongTien;
    // End of variables declaration//GEN-END:variables
}
