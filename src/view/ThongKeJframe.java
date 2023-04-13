/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.TinhTrangPhong;
import model.khachSapHetHanHopDong;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.PieChartDemo1;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import service.impl.khachSapHethanHopdongsev;
import util.ConnectDB;

public class ThongKeJframe extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm1 = new DefaultTableModel();
    khachSapHethanHopdongsev sv = new khachSapHethanHopdongsev();
    
    public ThongKeJframe() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        dtm.setColumnIdentifiers(new Object[]{"Tầng", "Phòng", "Khách", "Tháng", "Số Tiền"});
        dtm1.setColumnIdentifiers(new Object[]{"Tầng", "Phòng", "Tình Trạng"});
        tblKhachThue.setModel(dtm);
        tblPhong.setModel(dtm1);
        bieudo();
        fillKhachSapHethanHopDong();
        filltotable("", "");
        fillkhachnotien();
        cbo.setSelectedIndex(0);
    }
    
        public void filltotable(String month, String Year) {
        ArrayList<TinhTrangPhong> list = new ArrayList<>();
        Connection cnn = ConnectDB.getConnection();
        TinhTrangPhong tt = new TinhTrangPhong();
        PreparedStatement ps;
        ResultSet rs;
        try {
            if (Year.equals("") && month.equals("")) {

                ps = cnn.prepareStatement("select PhongTro.IDTang,PhongTro.TenPhong,Phong_Thue.tinh_trang from"
                        + " Phong_Thue inner join PhongTro on Phong_Thue.IDPhong=PhongTro.ID");

            } else {
                String sql = "select PhongTro.IDTang,PhongTro.TenPhong,Phong_Thue.tinh_trang from Phong_Thue inn"
                        + "er join PhongTro on Phong_Thue.IDPhong=PhongTro.ID where Month(ngay_bat_dau)=? and YEar(ngay_bat_dau)=?";

                ps = cnn.prepareCall(sql);
                ps.setString(1, month);
                ps.setString(2, Year);

            }
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
            model.setRowCount(0);
            Object[] row;
            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }

    }

    public void fillkhachnotien() {

        Connection cnn = ConnectDB.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = cnn.prepareStatement("select tang.TenTang,PhongTro.ID,KhachThue.HoVaTen,Month(HoaDon.NgayTaoHoaDon),SoTien-TienKhachDua as'tien khach no' from HoaDon\n"
                    + "inner join KhachThue on HoaDon.IDKhachThue=KhachThue.ID inner join PhongTro on \n"
                    + "HoaDon.IDPhongTro=PhongTro.ID inner join Tang on PhongTro.IDTang=Tang.ID where SoTien-TienKhachDua>0");

            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblKhachThue.getModel();
            model.setRowCount(0);
            Object[] row;
            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getDouble(5);
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillKhachSapHethanHopDong() {
        for (khachSapHetHanHopDong kt : sv.getall()) {
            lbl30.setText(kt.getSl());
        }
        for (khachSapHetHanHopDong kt : sv.getall60()) {
            lbl60.setText(kt.getSl());
        }
        for (khachSapHetHanHopDong kt : sv.getall90()) {
            lbl90.setText(kt.getSl());
        }

    }

//    public void lineChart() {
//        String choose=(String )cbo.getSelectedItem();
//        if(choose.equals("Thang")){
//                    String query = "select concat_ws('-',MONTH(NgayTaoHoaDon),Year(NgayTaoHoaDon)) as 'thoi gian'   ,sum(SoTien) as 'tong tien' from HoaDon group by MONTH(NgayTaoHoaDon),Year(NgayTaoHoaDon) having COUNT(NgayTaoHoaDon)>0";
//        try {
//            JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectDB.getConnection());
//            dataset.executeQuery(query);
//            JFreeChart chart = ChartFactory.createBarChart("thong ke", "Thoi gian", "Tổng tiền", dataset, PlotOrientation.VERTICAL, true, true, false);
//            BarRenderer reder = null;
//            CategoryPlot plot = null;
//            reder = new BarRenderer();
//            ChartPanel frame = new ChartPanel(chart);
//            line.add(frame);
//            line.setSize(600, 400);
//
//            line.setVisible(true);
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        }else if(choose.equals("Nam")){
//             String query = "select Year(NgayTaoHoaDon) as 'thoi gian'   ,sum(SoTien) as 'tong tien' from HoaDon group by YEar(NgayTaoHoaDon) having COUNT(NgayTaoHoaDon)>0";
//        try {
//            JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectDB.getConnection());
//            dataset.executeQuery(query);
//            JFreeChart chart = ChartFactory.createBarChart("thong ke", "Thoi gian", "Tổng tiền", dataset, PlotOrientation.VERTICAL, true, true, false);
//            BarRenderer reder = null;
//            CategoryPlot plot = null;
//            reder = new BarRenderer();
//            ChartPanel frame = new ChartPanel(chart);
//            line.add(frame);
//            line.setSize(600, 400);
//
//            line.setVisible(true);
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        }
//        
//
//
//    }
    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ trạng thái phòng", dataset, true, true, true);
        return chart;
    }

    public void bieudo() {

        try {
            Connection cnn = ConnectDB.getConnection();
            String sql = "select count(TrangThai) as 'số lượng',TrangThai from PhongTro group by TrangThai having count(TrangThai)>0";
            PreparedStatement ps = cnn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            DefaultPieDataset dataset = new DefaultPieDataset();
            while (rs.next()) {
                dataset.setValue(rs.getString("TrangThai"), rs.getDouble("số lượng"));

            }

            JFreeChart pieChart = createChart(dataset);
            ChartPanel chartPanel = new ChartPanel(pieChart);

            bieudoPanel.add(chartPanel);

            bieudoPanel.setSize(600, 400);

            bieudoPanel.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bieudoPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachThue = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        txtthang = new javax.swing.JTextField();
        txtNam = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl30 = new javax.swing.JLabel();
        lbl60 = new javax.swing.JLabel();
        lbl90 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbo = new javax.swing.JComboBox<>();
        line1 = new javax.swing.JPanel();
        Quy = new javax.swing.JPanel();
        Line = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(186, 215, 233));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(604, 300));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 46, 596, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Trạng Thái Phòng");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, -1, -1));

        bieudoPanel.setLayout(new java.awt.BorderLayout());
        jPanel2.add(bieudoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 560, 280));

        jPanel4.setBackground(new java.awt.Color(186, 215, 233));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setInheritsPopupMenu(true);

        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Danh sách khách nợ tiền phòng");

        tblKhachThue.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKhachThue);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel5.setBackground(new java.awt.Color(186, 215, 233));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Tình trạng phòng");

        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblPhong);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSearch.setText("tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setText("tháng");

        jLabel18.setText("năm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtthang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnSearch)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(174, 174, 174))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel4)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(186, 215, 233));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setPreferredSize(new java.awt.Dimension(600, 300));

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Khách sắp hết hạn hợp đồng");

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Nội Dung");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Số Hợp Đồng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10)
                .addComponent(jLabel11))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Số hợp đồng hết hạn trong vòng 30 ngày");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Số hợp đồng hết hạn trong vòng 60 ngày");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Số hợp đồng hết hạn trong vòng 90 ngày");

        lbl30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl30.setText("0");

        lbl60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl60.setText("0");

        lbl90.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl90.setText("0");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl60, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl90, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbl30)
                        .addGap(60, 60, 60)
                        .addComponent(lbl60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl90)
                        .addGap(58, 58, 58))))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(186, 215, 233));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setPreferredSize(new java.awt.Dimension(600, 300));

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Doanh Thu");

        cbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thang", "Nam", "Quy" }));
        cbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActionPerformed(evt);
            }
        });

        line1.setLayout(new java.awt.BorderLayout());

        Quy.setLayout(new java.awt.BorderLayout());

        Line.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Quy, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(53, Short.MAX_VALUE)
                    .addComponent(Quy, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 614, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String thang = txtthang.getText();
        String nam = txtNam.getText();
        filltotable(thang, nam);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActionPerformed

        int choose = cbo.getSelectedIndex();
        if (choose == 0) {

            try {
                String query = "select concat_ws('-',MONTH(NgayTaoHoaDon),Year(NgayTaoHoaDon)) as 'thoi gian'   ,sum(SoTien) as 'tong tien' from HoaDon group by MONTH(NgayTaoHoaDon),Year(NgayTaoHoaDon) having COUNT(NgayTaoHoaDon)>0";
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectDB.getConnection());
                dataset.executeQuery(query);
                JFreeChart chart = ChartFactory.createBarChart("thong ke", "Thoi gian", "Tổng tiền", dataset, PlotOrientation.VERTICAL, true, true, false);
                BarRenderer reder = null;
                CategoryPlot plot = null;
                reder = new BarRenderer();
                ChartPanel frame = new ChartPanel(chart);
                Line.add(frame);
                Line.setSize(600, 400);
                Quy.setVisible(false);
                Line.setVisible(true);
                line1.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (choose == 1) {

            try {
                String query = "select Year(NgayTaoHoaDon) as 'thoi gian'   ,sum(SoTien) as 'tong tien' from HoaDon group by YEar(NgayTaoHoaDon) having COUNT(NgayTaoHoaDon)>0";
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectDB.getConnection());
                dataset.executeQuery(query);
                JFreeChart chart = ChartFactory.createBarChart("thong ke", "Thoi gian", "Tổng tiền", dataset, PlotOrientation.VERTICAL, true, true, false);
                BarRenderer reder = null;
                CategoryPlot plot = null;
                reder = new BarRenderer();
                ChartPanel frame = new ChartPanel(chart);
                line1.add(frame);
                line1.setSize(600, 400);
                Quy.setVisible(false);
                Line.setVisible(false);
                line1.setVisible(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            try {
                String query = "select concat_ws('-',DATEPART(QUARTER, NgayTaoHoaDon),Year(NgayTaoHoaDon))  as 'quy'   ,sum(SoTien) as 'tong tien' from HoaDon group by DATEPART(QUARTER, NgayTaoHoaDon),Year(NgayTaoHoaDon) having COUNT(NgayTaoHoaDon)>0";
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectDB.getConnection());
                dataset.executeQuery(query);
                JFreeChart chart = ChartFactory.createBarChart("thong ke", "Thoi gian", "Tổng tiền", dataset, PlotOrientation.VERTICAL, true, true, false);
                BarRenderer reder = null;
                CategoryPlot plot = null;
                reder = new BarRenderer();
                ChartPanel frame = new ChartPanel(chart);
                Quy.add(frame);
                Quy.setSize(600, 400);
                Quy.setVisible(true);
                Line.setVisible(false);
                line1.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_cboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Quy;
    private javax.swing.JPanel bieudoPanel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl30;
    private javax.swing.JLabel lbl60;
    private javax.swing.JLabel lbl90;
    private javax.swing.JPanel line1;
    private javax.swing.JTable tblKhachThue;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtthang;
    // End of variables declaration//GEN-END:variables
}
