/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachThue;
import model.LoaiPhong;
import model.Phong;
import model.Tang;
import repository.LoaiPhongRepository;
import service.CocPhongService;
import service.KhachThueService;
import service.LoaiPhongService;
import service.PhongServce;
import service.impl.CocPhongServiceImpl;
import service.impl.KhachThueServiceImpl;
import service.impl.LoaiPhongServiceImpl;
import service.impl.PhongServceImpl;
import viewmodel.CocPhongView;
import viewmodel.KhachThuePhong;
import viewmodel.KhachThueView;
import viewmodel.PhongView;
import viewmodel.TraPhong;

/**
 *
 * @author ASUS
 */
public class PhongJframe extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmKhachTra = new DefaultTableModel();
    private DefaultTableModel dtmKhachThue = new DefaultTableModel();
    private DefaultTableModel dtmLoaiPhong = new DefaultTableModel();
    private PhongServce phongServce = new PhongServceImpl();
    private KhachThueService khachThueService = new KhachThueServiceImpl();
    private CocPhongService cocPhongService = new CocPhongServiceImpl();
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel();
    private LoaiPhongService loaiPhongService = new LoaiPhongServiceImpl();
    String duongDanAnh = "";

    private PhongJframe instance;

    public PhongJframe() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        cbbKbv.setModel(dcbm1);
        cbbLoaiPhong.setModel(dcbm2);
        loadPhong(phongServce.getALL());
        loadPhongTrong(phongServce.countPhongTrong());
        loadPhongDaThue(phongServce.countPhongDaThue());
        loadCbbTang(phongServce.getAllTang());
        loadCbbLoaiPhong(phongServce.getAllLoaiPhong());
        tblLoaiPhong.setModel(dtmLoaiPhong);
        dtmLoaiPhong.setColumnIdentifiers(new Object[]{"Id", "Tên Loại Phòng", "Giá Phòng", "Diện Tích", "Hình Ảnh", "Trạng Thái"});
        loadLoaiPhong(loaiPhongService.getALL());
//        loadTraPhong(phongServce.getListTraPhong());
    }

    public void loadPhong(List<PhongView> view) {
        pnlPhong.removeAll();
        pnlPhong.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (PhongView phongView : view) {
            RoomCard roomCard = new RoomCard(phongView);
            pnlPhong.add(roomCard);
            roomCard.repaint();
        }
    }

    private void loadCbbTang(List<Tang> view) {
        for (Tang x : view) {
            dcbm1.addElement(x.getTenTang());
        }
    }

    private void loadLoaiPhong(List<LoaiPhong> view) {
        dtmLoaiPhong.setRowCount(0);
        for (LoaiPhong x : view) {
            dtmLoaiPhong.addRow(new Object[]{x.getId(), x.getTenLoaiPhong(), x.getGiaThue(), x.getDienTich(), x.getHinhAnh(), x.getTrangThai()});
        }
    }

    private void loadCbbLoaiPhong(List<LoaiPhong> view) {
        for (LoaiPhong x : view) {
            dcbm2.addElement(x.getTenLoaiPhong());
        }
    }

    // load lable phongf trongos
    private void loadPhongTrong(List<PhongView> listStatus) {
        for (PhongView listStatu : listStatus) {
            jLabel2.setText(listStatu.getMaPhong());
        }
    }

    // load lable phongf dadx cho thuee
    private void loadPhongDaThue(List<PhongView> listStatus) {
        for (PhongView listStatu : listStatus) {
            lblDaChoThue.setText(listStatu.getMaPhong());
        }
    }

    private ImageIcon reSizeImage(String imagePart) {
        ImageIcon imageIcon = new ImageIcon(imagePart);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newImage);
        return image1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPhong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbbKbv = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDaChoThue = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLoaiPhong = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTimKiemLoai = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        rdoConPhong = new javax.swing.JRadioButton();
        rdoHetPhong = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTenLoaiPhong = new javax.swing.JTextField();
        txtGiaThue = new javax.swing.JTextField();
        txtDienTich = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        rdoConPhong1 = new javax.swing.JRadioButton();
        rdoHetPhong1 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1380, 800));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 153));

        pnlPhong.setBackground(new java.awt.Color(204, 204, 204));
        pnlPhong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPhong.setToolTipText("");
        pnlPhong.setLayout(new java.awt.GridLayout(3, 3, 10, 10));
        jScrollPane1.setViewportView(pnlPhong);

        jTabbedPane2.addTab("", jScrollPane1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBackground(new java.awt.Color(186, 215, 233));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Tìm Kiếm: ");

        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tên Phòng");

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Khu Vực");

        cbbKbv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Loại Phòng");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Số Người ");

        cbbLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(29, 29, 29)
                        .addComponent(txtSoLuong))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbLoaiPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cbbKbv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2)))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbKbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))
                    .addComponent(cbbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)))
        );

        jPanel8.setBackground(new java.awt.Color(186, 215, 233));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Còn Trống:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Đã Đủ:");

        lblDaChoThue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDaChoThue.setText("jLabel4");

        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--ALL--", "Còn Trống", "Đã Đủ", "Đang Bảo Trì" }));
        cbbTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTrangThaiItemStateChanged(evt);
            }
        });
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDaChoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblDaChoThue))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Phòng", jPanel3);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(186, 215, 233));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiPhongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLoaiPhong);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update.png"))); // NOI18N
        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-bin.png"))); // NOI18N
        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cleaning (1).png"))); // NOI18N
        jButton6.setText("Mới");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton2))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5))
                        .addGap(0, 164, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(186, 215, 233));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTimKiemLoai.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemLoaiCaretUpdate(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton1.setText("Tất cả");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        rdoConPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoConPhong.setText("Còn Phòng");

        rdoHetPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoHetPhong.setText("Đã Đủ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(rdoConPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(rdoHetPhong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(txtTimKiemLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(rdoConPhong)
                    .addComponent(rdoHetPhong))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(186, 215, 233));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("ID");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tên Loại Phòng");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Diện Tích");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Giá Thuê");

        txtID.setEnabled(false);

        rdoConPhong1.setText("Còn Phòng");

        rdoHetPhong1.setText("Đã Đủ");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Hình Ảnh");

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(rdoConPhong1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoHetPhong1))
                            .addComponent(txtGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel23)))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoConPhong1)
                            .addComponent(rdoHetPhong1)
                            .addComponent(jLabel22))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Loại Phòng", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        String ten = txtSearch.getText();
        if (!ten.matches("[a-zA-Z0-9]*")) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập ký tự đặc biệt");
            SwingUtilities.invokeLater(() -> {
                txtSearch.setText(ten.replaceAll("[^a-zA-Z0-9]", ""));
            });
        } else if (ten.length() > 10) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập quá 10 kí tự");
            SwingUtilities.invokeLater(() -> {
                txtSearch.setText(ten.substring(0, 10));
            });
        } else {
            List<PhongView> listt = phongServce.getOnePhong(ten);
            loadPhong(listt);
        }
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtTenPhong.getText().isEmpty()
                || txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Được Để Trống");
        } else if (txtTenPhong.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập tên phòng quá 50 kí tự");
            SwingUtilities.invokeLater(() -> {
                txtTenPhong.setText(txtTenPhong.getText().substring(0, 50));
            });
        } else if (txtSoLuong.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập số lượng người quá 10 kí tự");
            SwingUtilities.invokeLater(() -> {
                txtSoLuong.setText(txtSoLuong.getText().substring(0, 10));
            });
        } else if (Long.parseLong(txtSoLuong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập số người âm");
        } else if (Integer.parseInt(txtSoLuong.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lớn hơn 0");
        } else {
            Tang tang = phongServce.findByIdTang((String) cbbKbv.getSelectedItem());
            LoaiPhong loaiPhong = phongServce.findByIdLoaiPhong((String) cbbLoaiPhong.getSelectedItem());
            Phong phong = new Phong(
                    0,
                    tang.getId(),
                    loaiPhong.getId(),
                    txtTenPhong.getText(),
                    Integer.parseInt(txtSoLuong.getText()),
                    txtMoTa.getText(),
                    "Còn Trống");
            JOptionPane.showMessageDialog(this, phongServce.add(phong));
            List<PhongView> view = phongServce.getALL();
            for (PhongView phongView : view) {
                RoomCard roomCard = new RoomCard(phongView);
                pnlPhong.add(roomCard);
            }
            clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTrangThaiItemStateChanged

    }//GEN-LAST:event_cbbTrangThaiItemStateChanged

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        if (cbbTrangThai.getSelectedItem().equals("--ALL--")) {
            loadPhong(phongServce.getALL());
        } else {
            String status = (String) cbbTrangThai.getSelectedItem();
            List<PhongView> lisst = phongServce.findByStatus(status);
            loadPhong(lisst);
        }
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtTenLoaiPhong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Được Để Trống Tên Loại Phòng");
        } else if (txtDienTich.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Được Để Trống Diện Tích");
        } else if (txtGiaThue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Được Để Trống Giá Thuê");
        } else if (txtTenLoaiPhong.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập tên quá 50 kí tự");
            SwingUtilities.invokeLater(() -> {
                if (!txtTenLoaiPhong.getText().isEmpty()) {
                    txtTenLoaiPhong.setText(txtTenLoaiPhong.getText().substring(0, 50));
                }
            });
        } else if (txtDienTich.getText().length() > 5) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập diện tích quá 5 kí tự");
            SwingUtilities.invokeLater(() -> {
                if (!txtDienTich.getText().isEmpty()) {
                    txtDienTich.setText(txtTenLoaiPhong.getText().substring(0, 5));
                }
            });
        } else if (txtGiaThue.getText().length() > 15) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập giá thuê quá 15 kí tự");
            SwingUtilities.invokeLater(() -> {
                if (!txtGiaThue.getText().isEmpty()) {
                    txtGiaThue.setText(txtGiaThue.getText().substring(0, 15));
                }
            });
        } else if (Long.parseLong(txtDienTich.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập diện tích âm");
        } else if (Integer.parseInt(txtDienTich.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lớn hơn 0");
        } else if (Long.parseLong(txtGiaThue.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập giá thuê âm");
        } else if (Integer.parseInt(txtGiaThue.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lớn hơn 0");
        } else if (txtTenLoaiPhong.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
        } else if (txtDienTich.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
        } else if (txtGiaThue.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
        } else {
            LoaiPhong loaiPhong = new LoaiPhong();
            if (rdoConPhong.isSelected()) {
                loaiPhong.setTrangThai("Còn Trống");
            } else {
                loaiPhong.setTrangThai("Đã Đủ");
            }
            String imgName = duongDanAnh;
            loaiPhong = new LoaiPhong(
                    0,
                    txtTenLoaiPhong.getText(),
                    Long.parseLong(txtGiaThue.getText()),
                    Integer.parseInt(txtDienTich.getText()),
                    imgName,
                    loaiPhong.getTrangThai());
            JOptionPane.showMessageDialog(this, loaiPhongService.add(loaiPhong));
            loadLoaiPhong(phongServce.getAllLoaiPhong());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = tblLoaiPhong.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn 1 dòng trên table");
        } else {
            LoaiPhong loaiPhong = new LoaiPhong();
            if (rdoConPhong.isSelected()) {
                loaiPhong.setTrangThai("Còn Trống");
            } else {
                loaiPhong.setTrangThai("Đã Đủ");
            }
            String imgName = duongDanAnh;
            loaiPhong = new LoaiPhong(
                    0,
                    txtTenLoaiPhong.getText(),
                    Long.parseLong(txtGiaThue.getText()),
                    Integer.parseInt(txtDienTich.getText()),
                    imgName,
                    loaiPhong.getTrangThai());
            JOptionPane.showMessageDialog(this, loaiPhongService.update(loaiPhong, Integer.parseInt(txtID.getText())));
            loadLoaiPhong(loaiPhongService.getALL());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = tblLoaiPhong.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn 1 dòng trên table");
        } else {
            JOptionPane.showMessageDialog(this, loaiPhongService.delete(Integer.parseInt(txtID.getText())));
            loadLoaiPhong(loaiPhongService.getALL());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        loadLoaiPhong(loaiPhongService.getALL());
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void txtTimKiemLoaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemLoaiCaretUpdate
        List<LoaiPhong> list = loaiPhongService.getTenLoaiPhong(txtTimKiemLoai.getText());
        loadLoaiPhong(list);
    }//GEN-LAST:event_txtTimKiemLoaiCaretUpdate

    private void tblLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiPhongMouseClicked
        int row = tblLoaiPhong.getSelectedRow();
        int id = (int) tblLoaiPhong.getValueAt(row, 0);
        String ten = (String) tblLoaiPhong.getValueAt(row, 1);
        long gia = (long) tblLoaiPhong.getValueAt(row, 2);
        int dienTich = (int) tblLoaiPhong.getValueAt(row, 3);
        String ha = (String) tblLoaiPhong.getValueAt(row, 4);
        txtID.setText(String.valueOf(id));
        txtTenLoaiPhong.setText(String.valueOf(ten));
        txtGiaThue.setText(String.valueOf(gia));
        txtDienTich.setText(String.valueOf(dienTich));
        if (tblLoaiPhong.getValueAt(row, 5).toString().equalsIgnoreCase("Còn Trống")) {
            rdoConPhong1.setSelected(true);
        } else {
            rdoConPhong1.setSelected(true);
        }
        lblAnh.setIcon(reSizeImage(ha));
    }//GEN-LAST:event_tblLoaiPhongMouseClicked

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\QuanLyNhaTro\\image");
            fileChooser.setDialogTitle("Mở File");
            fileChooser.showOpenDialog(null);
            File f = fileChooser.getSelectedFile();
            duongDanAnh = f.getAbsolutePath();
            if (duongDanAnh != null) {
                lblAnh.setIcon(reSizeImage(duongDanAnh));
                System.out.println(duongDanAnh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa Chọn ảnh");
        }
    }//GEN-LAST:event_lblAnhMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadPhong(phongServce.getALL());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbKbv;
    private javax.swing.JComboBox<String> cbbLoaiPhong;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblDaChoThue;
    private javax.swing.JPanel pnlPhong;
    private javax.swing.JRadioButton rdoConPhong;
    private javax.swing.JRadioButton rdoConPhong1;
    private javax.swing.JRadioButton rdoHetPhong;
    private javax.swing.JRadioButton rdoHetPhong1;
    private javax.swing.JTable tblLoaiPhong;
    private javax.swing.JTextField txtDienTich;
    private javax.swing.JTextField txtGiaThue;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenLoaiPhong;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTimKiemLoai;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        txtSoLuong.setText("");
        txtTenPhong.setText("");
        cbbKbv.setSelectedIndex(0);
        cbbLoaiPhong.setSelectedIndex(0);
        txtMoTa.setText("");
    }

    public javax.swing.JPanel getPanel() {
        return pnlPhong;
    }

    public void setInstance(PhongJframe instance) {
        this.instance = instance;
    }

}
