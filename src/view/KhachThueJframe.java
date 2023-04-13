/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachThue;
import model.KhachThueThongKe;
import service.impl.KhachThueSev;

public class KhachThueJframe extends javax.swing.JInternalFrame {

     KhachThueSev sv = new KhachThueSev();
    int index;
    String DuongdanAnh = "";
    
    public KhachThueJframe() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        filltotable();
    }

    public void filltotable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (KhachThueThongKe kt : sv.getall()) {
            Object[] row = new Object[]{
                kt.getID(), kt.getHoten(), kt.getNgaysinh(), kt.getGioitinh(), kt.getEmail(), kt.getCmt(), kt.getQuequan(), kt.getSdt(), kt.getGhichu(), kt.getImg()
            };
            model.addRow(row);
        }
    }
    
    private ImageIcon reSizeImage(String imagePart) {
        ImageIcon imageIcon = new ImageIcon(imagePart);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newImage);
        return image1;
    }
    
    public void add() {
        String name = txtTen.getText();
        String ngay = txtNgay.getText();
        int gt = RdoNam.isSelected() == true ? 1 : 0;
        String email = txtEmail.getText();
        String cmt = txtCMND.getText();
        String quequan = txtQue.getText();
        int sdt = Integer.parseInt(txtsodienthoai.getText());

        String imgStr = DuongdanAnh;
        String ghichu = txtGhichu.getText();
        KhachThueThongKe kt = new KhachThueThongKe(0, name, ngay, gt, sdt, email, cmt, quequan, ghichu, imgStr);
        sv.insert(kt);
        filltotable();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        RdoNam = new javax.swing.JRadioButton();
        RdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQue = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtsodienthoai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        btnaddimg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setForeground(new java.awt.Color(255, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(186, 215, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setText("Xóa");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setText("Sửa");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnadd)
                .addGap(18, 18, 18)
                .addComponent(btnupdate)
                .addGap(30, 30, 30)
                .addComponent(jButton5)
                .addGap(41, 41, 41)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(jButton5)
                    .addComponent(btnupdate)
                    .addComponent(btndelete))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, -1, -1));

        jPanel2.setBackground(new java.awt.Color(186, 215, 233));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Ngày sinh", "Giới tính", "Email", "CMND", "Quê quán", "SDT", "Ghi chú", "Ảnh"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 337, -1, -1));

        jPanel4.setBackground(new java.awt.Color(186, 215, 233));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ID");

        lblID.setText("-");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giới tính");

        RdoNam.setSelected(true);
        RdoNam.setText("Nam");

        RdoNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Quê quán");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("CMND");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("SDT");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Hình ảnh");

        lblanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnaddimg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnaddimg.setText("Thêm ảnh");
        btnaddimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddimgActionPerformed(evt);
            }
        });

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane2.setViewportView(txtGhichu);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Ghi chú");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(RdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(RdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNgay)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQue, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnaddimg, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(lblID)
                                .addComponent(jLabel6)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(jLabel10))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtQue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(RdoNam)
                                    .addComponent(RdoNu)
                                    .addComponent(jLabel5)
                                    .addComponent(txtsodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnaddimg)
                                .addContainerGap(34, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 1210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        index = table.getSelectedRow();
        lblID.setText(table.getValueAt(index, 0) + "");
        txtTen.setText(table.getValueAt(index, 1) + "");
        txtNgay.setText(table.getValueAt(index, 2) + "");
        if (table.getValueAt(index, 3).equals(1)) {
            RdoNam.setSelected(true);
        } else {
            RdoNu.setSelected(true);
        }
        txtEmail.setText(table.getValueAt(index, 4) + "");
        txtCMND.setText(table.getValueAt(index, 5) + "");
        txtQue.setText(table.getValueAt(index, 6) + "");
        txtsodienthoai.setText(table.getValueAt(index, 7) + "");
        txtGhichu.setText(table.getValueAt(index, 8) + "");
        String hinh = table.getValueAt(index, 9) + "";
        lblanh.setIcon(reSizeImage(hinh));
    }//GEN-LAST:event_tableMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        index = table.getSelectedRow();
        int id = Integer.parseInt(lblID.getText());
        String name = txtTen.getText();
        String ngay = txtNgay.getText();
        int gt = RdoNam.isSelected() == true ? 1 : 0;
        String email = txtEmail.getText();
        String cmt = txtCMND.getText();
        String quequan = txtQue.getText();
        int sdt = Integer.parseInt(txtsodienthoai.getText());
        Icon img = lblanh.getIcon();
        String imgStr = img.toString();
        String ghichu = txtGhichu.getText();
        KhachThueThongKe kt = new KhachThueThongKe(id, name, ngay, gt, sdt, email, cmt, quequan, ghichu, imgStr);
        int choose = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa khách thuê này không");
        if (choose == JOptionPane.YES_OPTION) {
            sv.delete(kt);
            filltotable();
            JOptionPane.showMessageDialog(this, "xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "bạn đã không xóa");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        index = table.getSelectedRow();
        int id = Integer.parseInt(lblID.getText());
        String name = txtTen.getText();
        String ngay = txtNgay.getText();
        int gt = RdoNam.isSelected() == true ? 1 : 0;
        String email = txtEmail.getText();
        String cmt = txtCMND.getText();
        String quequan = txtQue.getText();
        int sdt = Integer.parseInt(txtsodienthoai.getText());
        String imgStr = DuongdanAnh;
        String ghichu = txtGhichu.getText();
        KhachThueThongKe kt = new KhachThueThongKe(id, name, ngay, gt, sdt, email, cmt, quequan, ghichu, imgStr);
        sv.update(kt);
        filltotable();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");

        } else if (txtCMND.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "chứng minh thư không được để trống");
        } else if (txtNgay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ngày sinh không được để trống");
        } else if (txtsodienthoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
        } else if (txtsodienthoai.getText().matches("[a-zA-Z]")) {
            JOptionPane.showMessageDialog(this, "sdt không được chứa kí tự");
        } else {
            add();
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String tk = JOptionPane.showInputDialog("xin moi ban nhap ma khach thue");
        for (KhachThueThongKe kt : sv.getall()) {
            if (tk.equals(kt.getID() + "")) {
                lblID.setText(kt.getID() + "");
                txtTen.setText(kt.getHoten());
                txtNgay.setText(kt.getNgaysinh());
                if (kt.getGioitinh() == 1) {
                    RdoNam.setSelected(true);
                } else {
                    RdoNu.setSelected(true);
                }
                txtEmail.setText(kt.getEmail());
                txtCMND.setText(kt.getCmt());
                txtQue.setText(kt.getQuequan());
                txtsodienthoai.setText(kt.getSdt() + "");
                txtGhichu.setText(kt.getGhichu());
                String hinh = kt.getImg();

                this.lblanh.setIcon(reSizeImage(hinh));
                break;

            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnaddimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddimgActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser("D:\\Du_an_1\\QuanLiNhaTro\\src\\img");
            fileChooser.setDialogTitle("Mở File");
            fileChooser.showOpenDialog(null);
            File f = fileChooser.getSelectedFile();
            DuongdanAnh = f.getAbsolutePath();
            if (DuongdanAnh != null) {
                lblanh.setIcon(reSizeImage(DuongdanAnh));
                System.out.println(DuongdanAnh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa Chọn ảnh");
        }
    }//GEN-LAST:event_btnaddimgActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RdoNam;
    private javax.swing.JRadioButton RdoNu;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnaddimg;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtQue;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtsodienthoai;
    // End of variables declaration//GEN-END:variables
}
