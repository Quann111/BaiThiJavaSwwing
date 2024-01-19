/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import Entity.ChiTietHoaDon;
import Entity.HoaDon;
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
public class jpnBanHang extends javax.swing.JPanel {

    /**
     * Creates new form jpnBanHang
     * @param data
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public jpnBanHang(String data) throws ClassNotFoundException, SQLException {
        initComponents();
        LoadDataTable_SanPham();
        LoadDataTable_ChiTietHoaDon();
        Date date = new Date();
        dpk_NgayLap.setDate(date); 
        List<HoaDon> lstHoaDon = DAO.DAOHoaDon.getAllHD();
        txt_MaNV.setText(data);     
        boolean ktra=true;
        int i=1;
        while(ktra){
        for (HoaDon _HoaDon : lstHoaDon){
                if(_HoaDon.getMaHD().equals("HD"+i)){
                    ktra=true;
                    break;
                }
                else ktra=false;
        }
        if(ktra==true)
        i++;
        }
        txt_MaHD.setText("HD"+i);
    }
    
    int delete_cthd=0;
    //
    List<ChiTietHoaDon> listCTHD = new ArrayList<>();
    private void addCTHD(String MaHD , String MaSP , String SoLuong, String DonGia ){
        ChiTietHoaDon sp1= new ChiTietHoaDon();
            sp1.setMaHD(MaHD);
            sp1.setMaSP(MaSP);
            sp1.setSoLuong(Integer.valueOf(SoLuong));
            sp1.setDonGia(Float.valueOf(DonGia));
            listCTHD.add(sp1);
    }
    //
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
            
            //-- Lấy được danh sách 
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
    
    private int GetIndex_ChiTietHoaDon() throws SQLException, ClassNotFoundException
    {
        int i=0;
        if (tbl_ChiTietHoaDon.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            i = tbl_ChiTietHoaDon.getSelectedRow();
        }
        return i;
    }
    
    private void LoadDataTable_ChiTietHoaDon() throws ClassNotFoundException, SQLException
    {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã hóa đơn");
        tblModel.addColumn("Mã sản phẩm");
        tblModel.addColumn("Số lượng");
        tblModel.addColumn("Đơn giá");
        // Add lần lượt các hàng
        for(ChiTietHoaDon _ChiTietHoaDon : listCTHD)
        {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(_ChiTietHoaDon.getMaHD()));
            row.addElement(String.valueOf(_ChiTietHoaDon.getMaSP()));
            row.addElement(String.valueOf(_ChiTietHoaDon.getSoLuong()));
            row.addElement(String.valueOf(_ChiTietHoaDon.getDonGia()));            
            tblModel.addRow(row);
        }
        tbl_ChiTietHoaDon.setModel(tblModel); 
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SanPham = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        btn_TimKiem = new javax.swing.JButton();
        txt_giadau = new javax.swing.JTextField();
        txt_GiaCuoi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_LamMoitbsp = new javax.swing.JButton();
        txt_HinhAnh = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_MaSP = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_TenSP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txt_MaHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_MaKH = new javax.swing.JTextField();
        txt_MaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_ChonKH = new javax.swing.JButton();
        txt_TongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dpk_NgayLap = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ChiTietHoaDon = new org.jdesktop.swingx.JXTable();
        btn_ThanhToan = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1170, 700));
        setPreferredSize(new java.awt.Dimension(1170, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane1.setViewportView(tbl_SanPham);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn khoảng giá"));

        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });

        txt_giadau.setText("Từ");
        txt_giadau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_giadauMouseClicked(evt);
            }
        });

        txt_GiaCuoi.setText("Đến");
        txt_GiaCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_GiaCuoiMouseClicked(evt);
            }
        });

        jLabel7.setText("-->");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_giadau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(txt_GiaCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_giadau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_GiaCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_LamMoitbsp.setText("Làm mới");
        btn_LamMoitbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LamMoitbspMouseClicked(evt);
            }
        });

        txt_HinhAnh.setText("jLabel7");

        jLabel10.setText("Đơn giá(triệu)");

        txt_DonGia.setEnabled(false);

        jLabel11.setText("Nhập số lượng:");

        jLabel1.setText("Mã sản phẩm:");

        txt_MaSP.setEnabled(false);

        btn_Them.setText("Thêm");
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });

        jLabel8.setText("Tên sản phẩm:");

        txt_TenSP.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txt_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(29, 29, 29)
                                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(txt_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_LamMoitbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btn_LamMoitbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_MaHD.setEnabled(false);

        jLabel6.setText("Mã nhân viên:");

        txt_MaNV.setEnabled(false);
        txt_MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaNVActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã khách hàng:");

        jLabel3.setText("Mã hoá đơn:");

        btn_ChonKH.setText("*");
        btn_ChonKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ChonKHMouseClicked(evt);
            }
        });

        txt_TongTien.setEnabled(false);

        jLabel4.setText("Ngày lập:");

        jLabel5.setText("Tổng tiền:");

        tbl_ChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_ChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_ChiTietHoaDon);

        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThanhToanMouseClicked(evt);
            }
        });

        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LamMoiMouseClicked(evt);
            }
        });

        btn_Xoa.setText("Xoá");
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpk_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn_ChonKH)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txt_MaNV)))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ChonKH)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dpk_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 0, 410, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked

        try {
            List<Sua> lstSanPham = DAO.DAOSua.getSP(txt_giadau.getText(), txt_GiaCuoi.getText());
            if (!lstSanPham.isEmpty()) {
                // Thêm các tiêu đề cho bảng hiẻn thị
                DefaultTableModel tblModel = new DefaultTableModel();
                tblModel.addColumn("Mã sản phẩm");
                tblModel.addColumn("Tên sản phẩm");
                tblModel.addColumn("Đơn giá");
                tblModel.addColumn("Số lượng");
                tblModel.addColumn("Hình ảnh");
                // Add lần lượt các hàng
                for (Sua _sanpham : lstSanPham) {
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
            else
            {
                JOptionPane.showMessageDialog(this, "Không có sản phẩm trong khoảng giá này");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void txt_giadauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_giadauMouseClicked
        // TODO add your handling code here:
        txt_giadau.setText("");
    }//GEN-LAST:event_txt_giadauMouseClicked

    private void txt_GiaCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_GiaCuoiMouseClicked
        // TODO add your handling code here:
        txt_GiaCuoi.setText("");
    }//GEN-LAST:event_txt_GiaCuoiMouseClicked
    
    
    //btnThem ben trai
    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        if(txt_SoLuong.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Lỗi - Số lượng mua chưa được nhập!");
        }
        else{
            boolean ktra = true;
            for (ChiTietHoaDon _ChiTietHoaDon : listCTHD){
                if(txt_MaSP.getText().equals(_ChiTietHoaDon.getMaSP())){
                    ktra = false;
                    break;
                }
            }
            List<Sua> lstSanPham = null;
            try {
                lstSanPham = DAO.DAOSua.getALL();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ktra){

                for(Sua _SanPham : lstSanPham){
                    if(txt_MaSP.getText().equals(_SanPham.getMaSP()) && Integer.valueOf(txt_SoLuong.getText())>_SanPham.getSoLuong()){
                        JOptionPane.showMessageDialog(this, "Lỗi - Số lượng mua lớn hơn số lượng trong kho!");
                        break;
                    }
                    else if (txt_MaSP.getText().equals(_SanPham.getMaSP()) && Integer.valueOf(txt_SoLuong.getText())<=_SanPham.getSoLuong()) {
                        addCTHD(txt_MaHD.getText(), txt_MaSP.getText(),txt_SoLuong.getText(), txt_DonGia.getText());
                        break;
                    }
                }
            }
            else{
                for (ChiTietHoaDon _ChiTietHoaDon : listCTHD){
                    if(txt_MaSP.getText().equals(_ChiTietHoaDon.getMaSP())){
                        int tongsoluong = Integer.valueOf(txt_SoLuong.getText())+_ChiTietHoaDon.getSoLuong();
                        for(Sua _SanPham : lstSanPham){
                            if(txt_MaSP.getText().equals(_SanPham.getMaSP()) && tongsoluong>_SanPham.getSoLuong()){
                                JOptionPane.showMessageDialog(this, "Lỗi - Số lượng mua lớn hơn số lượng trong kho!");
                                break;
                            }
                            else if (txt_MaSP.getText().equals(_SanPham.getMaSP()) && tongsoluong<=_SanPham.getSoLuong()) {
                                _ChiTietHoaDon.setSoLuong(tongsoluong);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            float tongtien=0;
            for (ChiTietHoaDon _ChiTietHoaDon : listCTHD){
                tongtien = tongtien + _ChiTietHoaDon.getSoLuong()*_ChiTietHoaDon.getDonGia();
            }
            txt_TongTien.setText(String.valueOf(tongtien));
            try {
                LoadDataTable_ChiTietHoaDon();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txt_SoLuong.setText("");
    }//GEN-LAST:event_btn_ThemMouseClicked
    
    //btnchonKH
    private void btn_ChonKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ChonKHMouseClicked
        frmChonKH frm1 = null;
        try {
            frm1 = new frmChonKH();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        frm1.pack();                               
        frm1.setVisible(true);  
    }//GEN-LAST:event_btn_ChonKHMouseClicked

    private void txt_MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaNVActionPerformed

    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
        // TODO add your handling code here:
        if (txt_MaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lỗi - Số mã khách hàng chưa được nhập!");
        }
        else{
            List<Sua> lstSanPham = null;
            try {
                lstSanPham = DAO.DAOSua.getALL();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (ChiTietHoaDon _ChiTietHoaDon : listCTHD){
                for (Sua _SanPham : lstSanPham){
                    if (_ChiTietHoaDon.getMaSP().equals(_SanPham.getMaSP()))
                    try {
                        DAO.DAOSua.UpdateSPByMaSP(_ChiTietHoaDon.getMaSP(), (_SanPham.getSoLuong()-_ChiTietHoaDon.getSoLuong()));
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            Date dtn = dpk_NgayLap.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                DAO.DAOHoaDon.InsertHDBanHang(txt_MaHD.getText(), txt_MaKH.getText(), txt_MaNV.getText(), String.valueOf(dateFormat.format(dtn)), Float.valueOf(txt_TongTien.getText()));
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (ChiTietHoaDon _ChiTietHoaDon : listCTHD){
                try {
                    DAO.DAOChiTietHoaDon.InsertHD(_ChiTietHoaDon);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
        }
    }//GEN-LAST:event_btn_ThanhToanMouseClicked

    //btn lam moi ben phai
    private void btn_LamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LamMoiMouseClicked

        Date a = new Date();

        List<HoaDon> lstHoaDon = null;
        try {
            lstHoaDon = DAO.DAOHoaDon.getAllHD();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean ktra=true;
        int i=1;
        while(ktra){
            for (HoaDon _HoaDon : lstHoaDon){
                if(_HoaDon.getMaHD().equals("HD"+i)){
                    ktra=true;
                    break;
                }
                else ktra=false;
            }
            if(ktra==true)
            i++;
        }
        txt_MaHD.setText("HD"+i);
        txt_MaKH.setText("");
        txt_MaSP.setText("");
        txt_TongTien.setText("");
        dpk_NgayLap.setDate(a);
        txt_DonGia.setText("");
        ImageIcon icon = new ImageIcon("");
        txt_HinhAnh.setIcon(icon);
        //txt_HinhAnh.setText("A");
        txt_SoLuong.setText("");
        txt_TenSP.setText("");
        listCTHD.clear();
        
        try {
            // TODO add your handling code here:
            //            LoadDataTable_HoaDon();
            //            LoadDataTable_KhachHang();
            LoadDataTable_ChiTietHoaDon();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_LamMoiMouseClicked
    
    //xoa mouse click
    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        // TODO add your handling code here:
        //tongtien=tongtien-  listCTHD[delete_cthd].;
        
        listCTHD.remove(delete_cthd);

        try {
            LoadDataTable_ChiTietHoaDon();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        float tongtien=0;
            for (ChiTietHoaDon _ChiTietHoaDon : listCTHD){
                tongtien = tongtien + _ChiTietHoaDon.getSoLuong()*_ChiTietHoaDon.getDonGia();
            }
            txt_TongTien.setText(String.valueOf(tongtien));
            try {
                LoadDataTable_ChiTietHoaDon();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btn_XoaMouseClicked

    private void btn_LamMoitbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LamMoitbspMouseClicked
        try {
            LoadDataTable_SanPham();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_LamMoitbspMouseClicked

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        try {
            LoadDataControl_SanPham();
        } catch (SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void tbl_ChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ChiTietHoaDonMouseClicked
        try {
            LoadDataControl_SanPhamByMaSP(listCTHD.get(delete_cthd).getMaSP());
        } catch (SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            delete_cthd = GetIndex_ChiTietHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_ChiTietHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChonKH;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_LamMoitbsp;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tbl_ChiTietHoaDon;
    private org.jdesktop.swingx.JXTable tbl_SanPham;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_GiaCuoi;
    private javax.swing.JLabel txt_HinhAnh;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_MaSP;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TenSP;
    private javax.swing.JTextField txt_TongTien;
    private javax.swing.JTextField txt_giadau;
    // End of variables declaration//GEN-END:variables
}
