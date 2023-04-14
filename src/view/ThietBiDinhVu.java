/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.ThietBi1;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import repository.PhongRepository;
import service.QuanLyDichVuSevires;
import service.QuanLyThietBiSerivices;
import service.impl.QuanLyDichVuSeviresImpl;
import service.impl.QuanLyThietBiSerivicesImpl;
import viewmodel.QLDichVu;
import viewmodel.QLThietBi;

public class ThietBiDinhVu extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<QLThietBi> list = new ArrayList<>();
    private DefaultTableModel dtmdv = new DefaultTableModel();
    private List<QLDichVu> listdv = new ArrayList<>();
    private QuanLyDichVuSevires qldv = new QuanLyDichVuSeviresImpl();
    private QuanLyThietBiSerivices qltb = new QuanLyThietBiSerivicesImpl();
    private PhongRepository phongRepository = new PhongRepository();

    public ThietBiDinhVu() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        dodulieu(qltb.getAll());
        dodulieuDv(qldv.getAll());
    }

    private void dodulieu(List<QLThietBi> list) {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tbllistbang.getModel();
        for (QLThietBi qLThietBi : list) {
            dtm.addRow(qLThietBi.rowData());
        }
    }

    private void dodulieuDv(List<QLDichVu> listdv) {
        dtmdv.setRowCount(0);
        dtmdv = (DefaultTableModel) tbllistbangDv.getModel();
        for (QLDichVu qLDichVu : listdv) {
            dtmdv.addRow(qLDichVu.rowData());
        }
    }

    private QLThietBi laydulieutuform() {
        QLThietBi tb = new QLThietBi();
        tb.setSoLuong(Integer.parseInt(txtsoluong.getText()));
        tb.setTen(txtTenTb.getText());
        tb.setGiaTien(Long.parseLong(txtGiaTien.getText()));
        tb.setMoTa(txtMota.getText());
        tb.setTinhTrang(cboTinhtrang.getSelectedItem().toString());
        return tb;
    }

    private QLDichVu layDuLieuTuFormDv() {
        QLDichVu dv = new QLDichVu();
        dv.setName(txttendv.getText());
        dv.setGia(Long.parseLong(txtgiaDv.getText()));
        dv.setMoTa(txtMotaDv.getText());
        dv.setDonVi(cboDonvi.getSelectedItem().toString());
        dv = phongRepository.getALLID((String) jComboBox1.getSelectedItem());
        dv.setLoai(dv.getId());
        return dv;
    }

    private void dodulieulenform(int index) {
        QLThietBi tb = qltb.getAll().get(index);
        txtId.setText(String.valueOf(tb.getId()));
        txtGiaTien.setText(String.valueOf(tb.getGiaTien()));
        txtTenTb.setText(tb.getTen());
        txtMota.setText(tb.getMoTa());
        txtsoluong.setText(String.valueOf(tb.getSoLuong()));
        cboTinhtrang.setSelectedItem(tb.getTinhTrang());
    }

    private void dodulieulenformDv(int index) {
        QLDichVu dv = qldv.getAll().get(index);
        txtmaDV.setText(String.valueOf(dv.getId()));
        txtgiaDv.setText(String.valueOf(dv.getGia()));
        txttendv.setText(dv.getName());
        txtMotaDv.setText(dv.getMoTa());
        cboDonvi.setSelectedItem(dv.getDonVi());
        if (dv.getLoai() == 1) {
            jComboBox1.setSelectedIndex(0);
        } else {
            jComboBox1.setSelectedIndex(1);
        }
    }

    private boolean kiemTraDuLieutb() {
        if (txtTenTb.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không để tên trống");
            return false;
        } else if (!txtsoluong.getText().trim().replace(".", "").matches("\\d+") || Long.parseLong(txtsoluong.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, " Số lượng xin mời nhập số và > 0");
            return false;
        } else if (!txtGiaTien.getText().trim().replace(".", "").matches("\\d+") || Long.parseLong(txtGiaTien.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Gía phải là số và > 0");
            return false;
        }
        return true;
    }

    private boolean kiemTraDuLieuDv() {
        if (txttendv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không để tên trống");
            return false;
        } else if (!txtgiaDv.getText().trim().replace(".", "").matches("\\d+") || Long.parseLong(txtgiaDv.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "can năng phải là số và > 0");
            return false;
        }
        return true;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenTb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboTinhtrang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        btnxoaDv = new javax.swing.JButton();
        btnSuaDv = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmaDV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttendv = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMotaDv = new javax.swing.JTextArea();
        txtgiaDv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cboDonvi = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnThemDv = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbllistbang = new javax.swing.JTable();
        btnsapxep = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbllistbangDv = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Thiết Bị");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("ID");

        jLabel3.setBackground(new java.awt.Color(51, 204, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên thiết bị");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tình trạng");

        cboTinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn ", "Không Còn" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Gía tiền");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mô tả");

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane2.setViewportView(txtMota);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Số lượng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenTb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel5))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtGiaTien)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(33, 33, 33))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        btnxoaDv.setBackground(new java.awt.Color(51, 204, 255));
        btnxoaDv.setText("Xóa");
        btnxoaDv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnxoaDv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaDvActionPerformed(evt);
            }
        });

        btnSuaDv.setBackground(new java.awt.Color(51, 204, 255));
        btnSuaDv.setText("Sửa");
        btnSuaDv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaDv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDvActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Quản Lý Dịch Vụ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ID");

        jLabel9.setBackground(new java.awt.Color(51, 204, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Loại");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Gia");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tên");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Mô tả");

        txtMotaDv.setColumns(20);
        txtMotaDv.setRows(5);
        jScrollPane3.setViewportView(txtMotaDv);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("DonVi");

        cboDonvi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "khối", "lit" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cố Định ", "Không Cố Định" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtgiaDv, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(59, 59, 59))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDonvi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtmaDV, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addComponent(txttendv)))))
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtmaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cboDonvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtgiaDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txttendv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnThemDv.setBackground(new java.awt.Color(51, 204, 255));
        btnThemDv.setText("Thêm");
        btnThemDv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemDv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDvActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbllistbang.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tbllistbang.setForeground(new java.awt.Color(0, 51, 255));
        tbllistbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "SoLuong", "Gía tiền", "Mô tả", "Tình Trạng"
            }
        ));
        tbllistbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbllistbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbllistbang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsapxep.setBackground(new java.awt.Color(51, 204, 255));
        btnsapxep.setText("Sắp xếp");
        btnsapxep.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsapxepActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 204, 255));
        jButton3.setText("Xóa");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 204, 255));
        btnSua.setText("Sửa");
        btnSua.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(51, 204, 255));
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 204, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        tbllistbangDv.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tbllistbangDv.setForeground(new java.awt.Color(51, 153, 255));
        tbllistbangDv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loai", "Tên", "ĐơnVi", "Gía", "Mô tả"
            }
        ));
        tbllistbangDv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbllistbangDvMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbllistbangDv);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnThemDv, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnSuaDv, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnxoaDv, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemDv)
                            .addComponent(btnSuaDv)
                            .addComponent(btnxoaDv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(jButton3)
                            .addComponent(btnsapxep)
                            .addComponent(btnSua))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnxoaDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaDvActionPerformed
        // TODO add your handling code here:
        int row = tbllistbangDv.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table");
        } else {
            int index = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa");
            if (index == 0) {
                String id = txtmaDV.getText();
                qldv.xoa(id);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                listdv = qldv.getAll();
                dodulieuDv(listdv);
            } else if (index == 1) {
                JOptionPane.showMessageDialog(this, "Đã hủy");
            }
        }
    }//GEN-LAST:event_btnxoaDvActionPerformed

    private void btnSuaDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDvActionPerformed
        // TODO add your handling code here:
        int row = tbllistbangDv.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table");
        } else {
            if (kiemTraDuLieuDv()) {
                int index = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn Sửa");
                if (index == 0) {
                    String id = txtmaDV.getText();
                    QLDichVu dv = layDuLieuTuFormDv();
                    qldv.sua(dv, id);
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    listdv = qldv.getAll();
                    dodulieuDv(listdv);
                } else if (index == 1) {
                    JOptionPane.showMessageDialog(this, "Đã hủy");
                }
            }
        }
    }//GEN-LAST:event_btnSuaDvActionPerformed

    private void btnThemDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDvActionPerformed
        // TODO add your handling code here:
        if (kiemTraDuLieuDv()) {
            int index = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm");
            if (index == 0) {
                QLDichVu dv = layDuLieuTuFormDv();
                qldv.them(dv);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                listdv = qldv.getAll();
                dodulieuDv(listdv);
            } else if (index == 1) {
                JOptionPane.showMessageDialog(this, "Đã hủy");
            }
        }
    }//GEN-LAST:event_btnThemDvActionPerformed

    private void tbllistbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbllistbangMouseClicked
        int index = tbllistbang.getSelectedRow();
        dodulieulenform(index);
    }//GEN-LAST:event_tbllistbangMouseClicked

    private void btnsapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsapxepActionPerformed
        // TODO add your handling code here:
        list = qltb.SapXep();
        dodulieu(list);
    }//GEN-LAST:event_btnsapxepActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = tbllistbang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table");
        } else {
            int index = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa");
            if (index == 0) {
                String id = txtId.getText();
                qltb.xoa(id);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                list = qltb.getAll();
                dodulieu(list);
            } else if (index == 1) {
                JOptionPane.showMessageDialog(this, "Đã hủy");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbllistbang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table");
        } else {
            if (kiemTraDuLieutb()) {
                int index = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn Sửa");
                if (index == 0) {
                    String id = txtId.getText();
                    QLThietBi tb = laydulieutuform();
                    qltb.sua(tb, id);
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    list = qltb.getAll();
                    dodulieu(list);
                } else if (index == 1) {
                    JOptionPane.showMessageDialog(this, "Đã hủy");
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (kiemTraDuLieutb()) {
            int index = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm");
            if (index == 0) {
                QLThietBi tb = laydulieutuform();
                qltb.them(tb);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                list = qltb.getAll();
                dodulieu(list);
            } else if (index == 1) {
                JOptionPane.showMessageDialog(this, "Đã hủy");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbllistbangDvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbllistbangDvMouseClicked
        // TODO add your handling code here:
        int index = tbllistbangDv.getSelectedRow();
        dodulieulenformDv(index);
    }//GEN-LAST:event_tbllistbangDvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaDv;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDv;
    private javax.swing.JButton btnsapxep;
    private javax.swing.JButton btnxoaDv;
    private javax.swing.JComboBox<String> cboDonvi;
    private javax.swing.JComboBox<String> cboTinhtrang;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbllistbang;
    private javax.swing.JTable tbllistbangDv;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextArea txtMotaDv;
    private javax.swing.JTextField txtTenTb;
    private javax.swing.JTextField txtgiaDv;
    private javax.swing.JTextField txtmaDV;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttendv;
    // End of variables declaration//GEN-END:variables
}
