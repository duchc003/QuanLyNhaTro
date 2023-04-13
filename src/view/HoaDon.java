/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.HoaDonDinhVuAdd;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import repository.HoaDonRepository;
import viewmodel.DinhVuTheoPhong;
import viewmodel.HoaDonDinhVu;
import repository.HoaDonThietBiRepo;
import service.impl.HoaDonThietBiSEv;
import service.impl.TaoHoaDonTBSev;
import model.HoaDonThietBi;
import model.TaoHoaDonTB;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.QuanLyHoaDonServiceImpl;
import service.QuanLyHoaDonService;
import viewmodel.HoaDonViewModel;
import javax.swing.DefaultComboBoxModel;
import model.DinhVu;
import model.LoaiPhong;
import model.Phong;
import model.ThongTInHooaDon;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import service.Impl.QuanLyChiTietHoaDonServiceImpl;
import service.PhongServce;
//import service.Impl.QuanLyDSNgayDongTienPhongServiceImpl;
import service.QuanLyDSNgayDongTienPhongService;
import service.impl.PhongServceImpl;
import service.impl.QuanLyDSNgayDongTienPhongServiceImpl;
import viewmodel.DSNgayDongTienPhongViewModel;

/**
 *
 * @author ASUS
 */
public class HoaDon extends javax.swing.JInternalFrame {

    private HoaDonRepository donRepository = new HoaDonRepository();
    private DefaultTableModel dtmPhongDinhVu = new DefaultTableModel();
    private DefaultTableModel dtmDinhVu = new DefaultTableModel();
    private HoaDonThietBiSEv sv = new HoaDonThietBiSEv();
    private HoaDonThietBiRepo rp = new HoaDonThietBiRepo();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int INVOICE_LENGTH = 6;
    private PhongServce phongServce = new PhongServceImpl();

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    private List<HoaDonViewModel> listHD;
    private QuanLyHoaDonService quanLyHoaDonService;
    private List<DSNgayDongTienPhongViewModel> listDS;
    private QuanLyDSNgayDongTienPhongService quanLyDSService;
    private DefaultTableModel dtmHoaDonPhong = new DefaultTableModel();
    private DefaultTableModel dtmHoaDonDinhVu = new DefaultTableModel();
    private DefaultTableModel dtmHoaDonThietBi = new DefaultTableModel();

    public HoaDon() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadTablePhongDinhVu(donRepository.getALL());
        fillHoaDonThietBi();

        dtm = new DefaultTableModel();
        dcbm = new DefaultComboBoxModel();

        quanLyHoaDonService = new QuanLyHoaDonServiceImpl();
        listHD = quanLyHoaDonService.getAll();

        showDataTable(quanLyHoaDonService.getAll());
        cboTenPhong();

        quanLyDSService = new QuanLyDSNgayDongTienPhongServiceImpl();
        listDS = quanLyDSService.getAll();

        dtm = (DefaultTableModel) this.tbDSHienThi.getModel();

        showDataTable2(quanLyDSService.getAll());
        loadTableHoaDonPhong(phongServce.getALLHoaDonPhong());
    }

    void loadTableHoaDonPhong(List<ThongTInHooaDon> lisst) {
        dtmHoaDonPhong = (DefaultTableModel) jTable3.getModel();
        for (ThongTInHooaDon x : lisst) {
            dtmHoaDonPhong.addRow(new Object[]{
                x.getMaHoaDon(),
                x.getTenPhong(),
                x.getTenTang(),
                x.getTenLoaiPhong(),
                x.getSoTien(),
                x.getNgayBD(),
                x.getNgayKT(),
                x.getTrangThai()
            });
        }
    }

    void loadTableHoaDonDinhVu(List<ThongTInHooaDon> lisst) {
        dtmHoaDonDinhVu = (DefaultTableModel) jTable1.getModel();
        for (ThongTInHooaDon x : lisst) {
            dtmHoaDonDinhVu.addRow(new Object[]{
                x.getMaHoaDon(),
                x.getTenPhong(),
                x.getTenTang(),
                x.getTenLoaiPhong(),
                x.getTenDinhVu(),
                x.getNgayBD(),
                x.getNgayKT(),
                x.getSoTien(),
                x.getNgayKT(),
                x.getTrangThai()
            });
        }
    }

    void loadTableHoaDonThietBi(List<ThongTInHooaDon> lisst) {
        dtmHoaDonThietBi = (DefaultTableModel) jTable2.getModel();
        for (ThongTInHooaDon x : lisst) {
            dtmHoaDonThietBi.addRow(new Object[]{
                x.getMaHoaDon(),
                x.getTenPhong(),
                x.getTenTang(),
                x.getTenLoaiPhong(),
                x.getTenThietBi(),
                x.getNgayBD(),
                x.getNgayKT(),
                x.getSoTien(),
                x.getNgayKT(),
                x.getTrangThai()
            });
        }
    }

    private void showDataTable(List<HoaDonViewModel> list) {
        dtm.setRowCount(0);
        for (HoaDonViewModel hoaDonViewModel : list) {
            dtm.addRow(hoaDonViewModel.toDataRow());
        }
    }

    private void showDataTable2(List<DSNgayDongTienPhongViewModel> list) {
        dtm.setRowCount(0);
        for (DSNgayDongTienPhongViewModel ds : list) {
            dtm.addRow(ds.toDataRow());
        }
    }

    public void cboTenPhong() {
        cboTenPhong.removeAllItems();

        dcbm = (DefaultComboBoxModel) this.cboTenPhong.getModel();
        var o = quanLyHoaDonService.getTenPhong();
        for (String h : o) {
            dcbm.addElement(h);
        }
    }

    private void loadTablePhongDinhVu(List<HoaDonDinhVu> hoaDonDinhVus) {
        dtmPhongDinhVu.setRowCount(0);
        dtmPhongDinhVu = (DefaultTableModel) tblPhongDinhVu.getModel();
        for (HoaDonDinhVu x : hoaDonDinhVus) {
            dtmPhongDinhVu.addRow(new Object[]{
                x.getTenPhong(),
                x.getTenTang(),
                x.getLoaiPhong(),
                x.getSoDien(),
                x.getSoNuoc()
            });
        }
    }

    private void loadTableDinhVu(List<DinhVuTheoPhong> hoaDonDinhVus) {
        dtmDinhVu.setRowCount(0);
        dtmDinhVu = (DefaultTableModel) tblDinhVu.getModel();
        for (DinhVuTheoPhong x : hoaDonDinhVus) {
            dtmDinhVu.addRow(new Object[]{
                x.getName(),
                x.getDonGia(),
                x.getDonVi()
            });
        }
    }

    public void fillHoaDonThietBi() {
        DefaultTableModel model = (DefaultTableModel) tblThietBiPhong.getModel();
        model.setRowCount(0);
        for (HoaDonThietBi hd : sv.getAll()) {
            Object[] row = new Object[]{
                hd.getTenPhong(), hd.getTenTang(), hd.getLoaiPhong(), hd.getTenKhach()
            };
            model.addRow(row);
        }
    }

    private void loadTableTB(List<HoaDonThietBi> hoaDonTb) {
        DefaultTableModel model = (DefaultTableModel) tblThietBi.getModel();
        model.setRowCount(0);
        for (HoaDonThietBi x : hoaDonTb) {
            model.addRow(new Object[]{
                x.getTenTB(),
                x.getSoluong(),
                x.getGiaTien(),
                x.tongtien()
            });
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPhongDinhVu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDinhVu = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        ngayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        ngayKetThuc = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblThietBiPhong = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblThietBi = new javax.swing.JTable();
        txtTongTien = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        allThietBi = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboTenPhong = new javax.swing.JComboBox<>();
        txtTienPhong = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        btnTaoHoaDon1 = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChu1 = new javax.swing.JTextArea();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDSHienThi = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(186, 215, 233));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblPhongDinhVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Phòng", "Tên Tầng", "Loại Phòng ", "Số Điện ", "Số Nước"
            }
        ));
        tblPhongDinhVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongDinhVuMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblPhongDinhVu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(186, 215, 233));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblDinhVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Dịnh Vụ", "Giá", "Đơn Vị", "Số Nước/Điện Tháng Này", "Số Nước/Điện Tháng Trước", "Tổng Tiền", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDinhVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDinhVuMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDinhVu);

        jLabel30.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel29.setText("Ngày Bắt Đầu");

        jLabel32.setText("Ngày Kết Thúc");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ngayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hóa Đơn Dịnh Vụ", jPanel1);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBackground(new java.awt.Color(186, 215, 233));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblThietBiPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Phòng", "Tên Tầng", "Loại Phòng ", "Tên Khách"
            }
        ));
        tblThietBiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThietBiPhongMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblThietBiPhong);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(186, 215, 233));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setInheritsPopupMenu(true);

        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Thiết Bị", "Số Lượng", "Giá Tiền", "Tổng Tiền", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThietBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThietBiMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblThietBi);

        jLabel31.setText("Tổng Tiền");

        jLabel33.setText("Ghi Chú");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setText("Tạo Hóa Đơn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        allThietBi.setText("ALL");
        allThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allThietBiActionPerformed(evt);
            }
        });

        jLabel1.setText("Ngày Bắt Đầu");

        jLabel2.setText("Ngày Kết Thúc");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane2)))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(152, 152, 152)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(allThietBi)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(allThietBi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1284, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hóa Đơn Thiết Bị", jPanel4);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jPanel14.setBackground(new java.awt.Color(186, 215, 233));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Mã Hóa Đơn");

        lbl.setText("Ngày tạo");

        jLabel5.setText("Tiền phòng");

        jLabel16.setText("Tên phòng");

        txtTienPhong.setEditable(false);

        btnTaoHoaDon1.setBackground(new java.awt.Color(102, 255, 102));
        btnTaoHoaDon1.setText("Tạo Hóa Đơn");
        btnTaoHoaDon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDon1MouseClicked(evt);
            }
        });
        btnTaoHoaDon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDon1ActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(102, 153, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseClicked(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 204, 0));
        btnClear.setText("Clear");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        jLabel13.setText("Tiền Khách đưa");

        jLabel14.setText("Ghi chú");

        lbl1.setText("Ngày kết thúc");

        txtGhiChu1.setColumns(20);
        txtGhiChu1.setRows(5);
        jScrollPane3.setViewportView(txtGhiChu1);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTaoHoaDon1)
                        .addGap(37, 37, 37)
                        .addComponent(btnCapNhat)
                        .addGap(48, 48, 48)
                        .addComponent(btnClear))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16)
                            .addComponent(lbl1))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTienPhong)
                            .addComponent(txtMaHoaDon)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(cboTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon1)
                    .addComponent(btnCapNhat)
                    .addComponent(btnClear))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(186, 215, 233));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setInheritsPopupMenu(true);

        tbDSHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên phòng", "Tên tầng", "Tên loại phòng", "Giá thuê"
            }
        ));
        tbDSHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSHienThiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbDSHienThi);

        jLabel4.setText("Tìm Kiếm");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton1)
                        .addGap(0, 136, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hóa Đơn Phòng", jPanel8);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        jPanel11.setBackground(new java.awt.Color(186, 215, 233));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Tên Phòng", "Tầng", "Loại Phòng", "Tên Dịnh Vụ", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Tổng Tiền", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Tên Phòng", "Tầng", "Loại Phòng", "Khách Thuê", "Tên Thiết Bị", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Tổng Tiền", "TrangThai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Tên Phòng", "Tầng", "Loại Phòng", "Tiền Phòng", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable3);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Hóa Đơn Phòng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Hóa Đơn Dịnh Vụ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Hóa Đơn Thiết Bị");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Xem Thông Tin Hóa Đơn", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhongDinhVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongDinhVuMouseClicked
        int row = tblPhongDinhVu.getSelectedRow();
        List<DinhVuTheoPhong> dinhVu = donRepository.finByDinhVu((String) tblPhongDinhVu.getValueAt(row, 0));
        loadTableDinhVu(dinhVu);
    }//GEN-LAST:event_tblPhongDinhVuMouseClicked

    private void tblDinhVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDinhVuMouseClicked
        long tongTienTatCa = 0;
        for (int i = 0; i < tblDinhVu.getRowCount(); i++) {
            Boolean checked = (Boolean) tblDinhVu.getValueAt(i, 6);
            if (checked != null && checked) {
                String tenDinhVu = (String) tblDinhVu.getValueAt(i, 0);
                long gia = (long) tblDinhVu.getValueAt(i, 1);
                if (tenDinhVu.contains("Điện") || tenDinhVu.contains("Nước")) {
                    int soNuocDien = (int) tblDinhVu.getValueAt(i, 3);
                    long tongTien = gia * soNuocDien;
                    tblDinhVu.setValueAt(tongTien, i, 5);
                } else {
                    tblDinhVu.setValueAt(gia, i, 5);
                }
            }
        }
    }//GEN-LAST:event_tblDinhVuMouseClicked

    private void tblThietBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThietBiMouseClicked
        long tongTienTatCa = 0;
        for (int i = 0; i < tblThietBi.getRowCount(); i++) {
            Boolean checked = (Boolean) tblThietBi.getValueAt(i, 4);
            if (checked != null && checked) {
                String tentb = (String) tblThietBi.getValueAt(i, 0);
                long gia = (long) tblThietBi.getValueAt(i, 2);
//                if (tenDinhVu.contains("Điện") && tenDinhVu.contains("Nước")) {
//                    int soNuocDien = (int) tblDinhVu.getValueAt(i, 3);
//                    long tongTien = gia * soNuocDien;
//                    tblDinhVu.setValueAt(tongTien, i, 5); 
//                } else {
                int sl = (int) tblThietBi.getValueAt(i, 1);
                long tongTien = gia * sl;
                tblThietBi.setValueAt(tongTien, i, 3);

//                }
                long tongTienDinhVu = (long) tblThietBi.getValueAt(i, 3);
                tongTienTatCa += tongTienDinhVu;
                txtTongTien.setText(String.valueOf(tongTienTatCa));
            }
        }
    }//GEN-LAST:event_tblThietBiMouseClicked

    private void tblThietBiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThietBiPhongMouseClicked
        int row = tblThietBiPhong.getSelectedRow();
        List<HoaDonThietBi> hd = rp.getallTB((String) tblThietBiPhong.getValueAt(row, 0));
        loadTableTB(hd);
    }//GEN-LAST:event_tblThietBiPhongMouseClicked

    private void allThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allThietBiActionPerformed
        boolean selected = allThietBi.isSelected();
        for (int i = 0; i < tblThietBi.getRowCount(); i++) {
            tblThietBi.setValueAt(selected, i, 3);
        }
    }//GEN-LAST:event_allThietBiActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        int dong = tblPhongDinhVu.getSelectedRow();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < INVOICE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        for (int i = 0; i < tblDinhVu.getRowCount(); i++) {
            Boolean checked = (Boolean) tblDinhVu.getValueAt(i, 6);
            if (checked != null && checked) {
                // add hóa đơn điện 
                String tenDinhVu = (String) tblDinhVu.getValueAt(i, 0);
                int soDien = 0;
                int soNuoc = 0;
                long all = (long) tblDinhVu.getValueAt(i, 5);
                if (tenDinhVu.contains("Điện")) {
                    soDien = (int) tblDinhVu.getValueAt(i, 3); // retrieve "so dien" value from the 4th column
                    HoaDonDinhVu donDinhVu = new HoaDonDinhVu();
                    HoaDonDinhVuAdd dinhVuAddDien = new HoaDonDinhVuAdd();
                    dinhVuAddDien.setIDPhong(1);
                    dinhVuAddDien.setMaHoaDon(sb.toString());
                    dinhVuAddDien.setNgayTaoHoaDon(ngayBatDau.getDate());
                    dinhVuAddDien.setNgayKetThuc(ngayKetThuc.getDate());
                    dinhVuAddDien.setSoTien((long) tblDinhVu.getValueAt(i, 5));
                    dinhVuAddDien.setSoDien(soDien);
                    dinhVuAddDien.setGhiChu(txtGhiChu.getText());
                    donRepository.addHoaDonDien(dinhVuAddDien);
                    Phong p = new Phong();
                    p.setSoDien(soDien);
                    donRepository.updateSoDien(p, (String) tblPhongDinhVu.getValueAt(dong, 0));
//                    donDinhVu = donRepository.findByIdDinhVu(sb.toString());
//                    donDinhVu.setId(donDinhVu.getIdHoaDon());
//                    List<DinhVu> list = donRepository.findByIdDinhVu1((int) tblPhongDinhVu.getValueAt(dong, 0));
//                    donRepository.updateDinhVuChiTiet(donDinhVu, list.get(i).getIdDinhVu());
                    loadTablePhongDinhVu(donRepository.getALL());
                    try {
                        XWPFDocument document = new XWPFDocument();
                        XWPFParagraph paragraph = document.createParagraph();
                        paragraph.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run = paragraph.createRun();
                        run.setText("Hóa đơn điện");
                        run.setFontSize(12);
                        run.setBold(true);

                        XWPFTable table = document.createTable(tblDinhVu.getRowCount() + 0, 4); // Số dòng của bảng = số bản ghi trong JTable + 1 (dòng tiêu đề)

                        XWPFTableRow row = table.getRow(0);
                        XWPFParagraph paragraph10 = row.getCell(0).addParagraph();
                        paragraph10.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run10 = paragraph10.createRun();
                        run10.setText("Tên");
                        run10.setBold(true);
                        run10.setTextPosition(20);

                        XWPFParagraph paragraph11 = row.getCell(1).addParagraph();
                        paragraph11.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run11 = paragraph11.createRun();
                        run11.setText("Chỉ Số Mới");
                        run11.setBold(true);
                        run11.setTextPosition(20);

                        XWPFParagraph paragraph12 = row.getCell(2).addParagraph();
                        paragraph12.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run12 = paragraph12.createRun();
                        run12.setText("Chỉ Số Cũ");
                        run12.setBold(true);
                        run12.setTextPosition(20);

                        XWPFParagraph paragraph13 = row.getCell(3).addParagraph();
                        paragraph13.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run13 = paragraph13.createRun();
                        run13.setText("Tiêu Thụ");
                        run13.setBold(true);
                        run13.setTextPosition(20);

                        table.setWidth("100%");

                        for (int j = 0; j < tblDinhVu.getRowCount(); j++) {
                            Boolean checked2 = (Boolean) tblDinhVu.getValueAt(j, 6);
                            if (checked2 != null && checked2) {
                                String tenDinhVu1 = tblDinhVu.getValueAt(j, 0).toString();
                                if (tenDinhVu1.contains("Điện")) {
                                    String ten = tblDinhVu.getValueAt(j, 0).toString();
                                    int chiSoMoi = (int) tblDinhVu.getValueAt(j, 3);
                                    int chiSoCu = (int) tblDinhVu.getValueAt(j, 4);
                                    int tieuThu = chiSoMoi - chiSoCu;
                                    // Tạo một dòng mới cho bảng
                                    // Thêm giá trị vào từng ô trong dòng mới của bảng
                                    table.getRow(j + 1).getCell(0).setText(ten);
                                    table.getRow(j + 1).getCell(1).setText(String.valueOf(chiSoMoi));
                                    table.getRow(j + 1).getCell(2).setText(String.valueOf(chiSoCu));
                                    table.getRow(j + 1).getCell(3).setText(String.valueOf(tieuThu));
                                }
                            }
                        }

                        Date ngayBatDau = this.ngayBatDau.getDate();
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate1 = formatter1.format(ngayBatDau);

                        XWPFParagraph paragraph33 = document.createParagraph();
                        XWPFRun run33 = paragraph33.createRun();
                        run33.setText("Ngày lập hóa đơn: " + formattedDate1);
                        run33.setFontSize(12);

                        XWPFParagraph paragraph1 = document.createParagraph();
                        XWPFRun run1 = paragraph1.createRun();
                        long tienDien = (long) tblDinhVu.getValueAt(i, 1);
                        run1.setText("Giá tiền điện: " + tienDien + "/số");
                        run1.setFontSize(12);

                        XWPFParagraph paragraph2 = document.createParagraph();
                        XWPFRun run2 = paragraph2.createRun();
                        long tongTienDien = (long) tblDinhVu.getValueAt(i, 5);
                        run2.setText("Tổng tiền điện: " + tongTienDien + " VNĐ");
                        run2.setFontSize(12);

                        XWPFParagraph paragraph3 = document.createParagraph();
                        XWPFRun run3 = paragraph3.createRun();
                        run3.setText("Tổng tiền thanh toán: " + tongTienDien + " VNĐ");
                        run3.setFontSize(12);

                        Date ngaySinh = ngayKetThuc.getDate();
                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate2 = formatter1.format(ngaySinh);

                        XWPFParagraph paragraph222 = document.createParagraph();
                        XWPFRun run222 = paragraph222.createRun();
                        run222.setText("Phương thức thanh toán: 1. Chuyển Khoản: TP bank : 05832572701 | 2. Đến Đóng Tiền Trực Tiếp Cho Chủ Trọ");
                        run222.setFontSize(12);

                        XWPFParagraph paragraph32 = document.createParagraph();
                        XWPFRun run32 = paragraph32.createRun();
                        run32.setText("Hạn Thanh Toán: " + formattedDate2);
                        run32.setFontSize(12);

                        XWPFParagraph paragraph4 = document.createParagraph();
                        XWPFRun run4 = paragraph4.createRun();
                        run4.setText("Ghi chú: Vui lòng thanh toán trước " + formattedDate2 + "");
                        run4.setFontSize(12);

                        XWPFParagraph paragraph5 = document.createParagraph();
                        XWPFRun run5 = paragraph5.createRun();
                        run5.setText("Xin cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi!");
                        run5.setFontSize(12);

                        FileOutputStream out = new FileOutputStream("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\QuanLyNhaTro\\Hóa Đơn Điện" + " " + tblPhongDinhVu.getValueAt(dong, 0) + ".docx");
                        document.write(out);
                        out.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("File created successfully!");
                } else if (tenDinhVu.contains("Nước")) {
                    soNuoc = (int) tblDinhVu.getValueAt(i, 3); // retrieve "so nuoc" value from the 4th column
                    HoaDonDinhVuAdd dinhVuAddNuoc = new HoaDonDinhVuAdd();
                    dinhVuAddNuoc.setIDPhong(1);
                    dinhVuAddNuoc.setMaHoaDon(sb.toString());
                    dinhVuAddNuoc.setNgayTaoHoaDon(ngayBatDau.getDate());
                    dinhVuAddNuoc.setNgayKetThuc(ngayKetThuc.getDate());
                    dinhVuAddNuoc.setSoTien((long) tblDinhVu.getValueAt(i, 5));
                    dinhVuAddNuoc.setSoNuoc(soNuoc);
                    dinhVuAddNuoc.setGhiChu(txtGhiChu.getText());
                    donRepository.addHoaDonNuoc(dinhVuAddNuoc);
                    Phong p = new Phong();
                    p.setSoNuoc(soNuoc);
                    donRepository.updateSoNuoc(p, (String) tblPhongDinhVu.getValueAt(dong, 0));
                    loadTablePhongDinhVu(donRepository.getALL());
                    try {
                        XWPFDocument document1 = new XWPFDocument();
                        XWPFParagraph paragraph = document1.createParagraph();
                        paragraph.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run = paragraph.createRun();
                        run.setText("Hóa đơn nước");
                        run.setFontSize(12);
                        run.setBold(true);

                        XWPFTable tableNuoc = document1.createTable(tblDinhVu.getRowCount() + 1, 4); // Số dòng của bảng = số bản ghi trong JTable + 1 (dòng tiêu đề)

                        XWPFTableRow row = tableNuoc.getRow(0);
                        if (row == null) {
                            row = tableNuoc.createRow();
                        }
                        row.getCell(0).setText("Tên");
                        row.getCell(1).setText("Số đồng hồ nước mới");
                        row.getCell(2).setText("Số đồng hồ nước Cũ");
                        row.getCell(3).setText("Số mét khối nước tiêu thụ");

                        tableNuoc.setWidth("100%");

                        for (int j = 0; j < tblDinhVu.getRowCount(); j++) {
                            Boolean checked3 = (Boolean) tblDinhVu.getValueAt(j, 6);
                            if (checked3 != null && checked3) {
                                String tenDinhVu1 = tblDinhVu.getValueAt(j, 0).toString();
                                if (tenDinhVu1.contains("Nước")) {
                                    System.out.println("Ok");
                                    String ten = tblDinhVu.getValueAt(j, 0).toString();
                                    System.out.println(ten);
                                    int chiSoMoi = (int) tblDinhVu.getValueAt(j, 3);
                                    int chiSoCu = (int) tblDinhVu.getValueAt(j, 4);
                                    int tieuThu = chiSoMoi - chiSoCu;
                                    // Thêm giá trị vào từng ô trong dòng mới của bảng
                                    XWPFTableRow tableRow = tableNuoc.getRow(j + 1);
                                    if (tableRow == null) {
                                        tableRow = tableNuoc.createRow();
                                    }
                                    tableRow.getCell(0).setText(ten);
                                    tableRow.getCell(1).setText(String.valueOf(chiSoMoi));
                                    tableRow.getCell(2).setText(String.valueOf(chiSoCu));
                                    tableRow.getCell(3).setText(String.valueOf(tieuThu));
                                }
                            }
                        }

                        Date ngayBatDau = this.ngayBatDau.getDate();
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate1 = formatter1.format(ngayBatDau);

                        XWPFParagraph paragraph33 = document1.createParagraph();
                        XWPFRun run33 = paragraph33.createRun();
                        run33.setText("Ngày lập hóa đơn: " + formattedDate1);
                        run33.setFontSize(12);

                        XWPFParagraph paragraph1 = document1.createParagraph();
                        XWPFRun run1 = paragraph1.createRun();
                        long tienNuoc = (long) tblDinhVu.getValueAt(i, 1);
                        run1.setText("Giá tiền nước/mét khối: " + tienNuoc + "/mét khối");
                        run1.setFontSize(12);

                        XWPFParagraph paragraph2 = document1.createParagraph();
                        XWPFRun run2 = paragraph2.createRun();
                        long tongTienNuoc = (long) tblDinhVu.getValueAt(i, 5);
                        run2.setText("Tổng tiền nước: " + tongTienNuoc + " VNĐ");
                        run2.setFontSize(12);

                        XWPFParagraph paragraph3 = document1.createParagraph();
                        XWPFRun run3 = paragraph3.createRun();
                        run3.setText("Tổng tiền thanh toán: " + tongTienNuoc + " VNĐ");
                        run3.setFontSize(12);

                        XWPFParagraph paragraph222 = document1.createParagraph();
                        XWPFRun run222 = paragraph222.createRun();
                        run222.setText("Phương thức thanh toán: 1. Chuyển Khoản: TP bank : 05832572701 | 2. Đến Đóng Tiền Trực Tiếp Cho Chủ Trọ");
                        run222.setFontSize(12);

                        Date ngaySinh = ngayKetThuc.getDate();
                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate2 = formatter2.format(ngaySinh);

                        XWPFParagraph paragraph32 = document1.createParagraph();
                        XWPFRun run32 = paragraph32.createRun();
                        run32.setText("Hạn Thanh Toán: " + formattedDate2);
                        run32.setFontSize(12);

                        XWPFParagraph paragraph4 = document1.createParagraph();
                        XWPFRun run4 = paragraph4.createRun();
                        run4.setText("Ghi chú: Vui lòng thanh toán trước " + formattedDate2 + "");
                        run4.setFontSize(12);

                        XWPFParagraph paragraph5 = document1.createParagraph();
                        XWPFRun run5 = paragraph5.createRun();
                        run5.setText("Xin cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi!");
                        run5.setFontSize(12);

                        FileOutputStream outt = new FileOutputStream("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\QuanLyNhaTro\\Hóa Đơn Nước Phòng" + " " + tblPhongDinhVu.getValueAt(dong, 0) + ".docx");
                        document1.write(outt);
                        outt.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("File created successfully!");
                } else {
                    HoaDonDinhVuAdd dinhVuAdd = new HoaDonDinhVuAdd();
                    dinhVuAdd.setIDPhong(1);
                    dinhVuAdd.setMaHoaDon(sb.toString());
                    dinhVuAdd.setNgayTaoHoaDon(ngayBatDau.getDate());
                    dinhVuAdd.setNgayKetThuc(ngayKetThuc.getDate());
                    dinhVuAdd.setSoTien((long) tblDinhVu.getValueAt(i, 5));
                    dinhVuAdd.setGhiChu(txtGhiChu.getText());
                    donRepository.addHoaDonAll(dinhVuAdd);
                    loadTablePhongDinhVu(donRepository.getALL());
                    try {
                        XWPFDocument document2 = new XWPFDocument();
                        XWPFParagraph paragraph = document2.createParagraph();
                        paragraph.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun run = paragraph.createRun();
                        run.setText("Hóa đơn " + tblDinhVu.getValueAt(i, 0) + "");
                        run.setFontSize(12);
                        run.setBold(true);

                        XWPFParagraph paragraph5 = document2.createParagraph();
                        XWPFRun run5 = paragraph5.createRun();
                        paragraph5.setAlignment(ParagraphAlignment.CENTER);
                        run5.setText("Mã Hóa Đơn:" + sb.toString());
                        run5.setFontSize(12);
                        run5.setTextPosition(50);

                        XWPFParagraph paragraph2 = document2.createParagraph();
                        XWPFRun run2 = paragraph2.createRun();
                        run2.setText("Tên phòng: " + tblPhongDinhVu.getValueAt(dong, 0) + "");
                        run2.setFontSize(12);

                        Date ngayBatDau = this.ngayBatDau.getDate();
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate1 = formatter1.format(ngayBatDau);

                        XWPFParagraph paragraph33 = document2.createParagraph();
                        XWPFRun run33 = paragraph33.createRun();
                        run33.setText("Ngày lập hóa đơn: " + formattedDate1);
                        run33.setFontSize(12);

                        XWPFParagraph paragraph22 = document2.createParagraph();
                        XWPFRun run22 = paragraph22.createRun();
                        run22.setText("Tổng Tiền: " + tblDinhVu.getValueAt(i, 5) + "");
                        run22.setFontSize(12);

                        XWPFParagraph paragraph222 = document2.createParagraph();
                        XWPFRun run222 = paragraph222.createRun();
                        run222.setText("Phương thức thanh toán: 1. Chuyển Khoản: TP bank : 05832572701 | 2. Đến Đóng Tiền Trực Tiếp Cho Chủ Trọ");
                        run222.setFontSize(12);

                        Date ngaySinh = ngayKetThuc.getDate();
                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate2 = formatter2.format(ngaySinh);

                        XWPFParagraph paragraph32 = document2.createParagraph();
                        XWPFRun run32 = paragraph32.createRun();
                        run32.setText("Hạn Thanh Toán: " + formattedDate2);
                        run32.setFontSize(12);

                        XWPFParagraph paragraph4 = document2.createParagraph();
                        XWPFRun run4 = paragraph4.createRun();
                        run4.setText("Ghi chú: Vui lòng thanh toán trước " + formattedDate2 + "");
                        run4.setFontSize(12);

                        XWPFParagraph paragraph10 = document2.createParagraph();
                        XWPFRun run10 = paragraph10.createRun();
                        run10.setText("Xin cảm ơn đã sử dụng dịch vụ của chúng tôi. Nếu có bất kỳ câu hỏi hoặc thắc mắc nào, "
                                + "xin vui lòng liên hệ với chúng tôi theo thông tin sau đây:");
                        run10.setFontSize(12);

                        XWPFParagraph paragraph333 = document2.createParagraph();
                        XWPFRun run323 = paragraph333.createRun();
                        run323.setText("Thông tin liên hệ: 0971066455");
                        run323.setFontSize(12);

                        FileOutputStream outt = new FileOutputStream("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\QuanLyNhaTro\\Hóa Đơn" + " " + tblDinhVu.getValueAt(i, 0) + "Phòng" + " " + " " + tblPhongDinhVu.getValueAt(dong, 0) + ".docx");
                        document2.write(outt);
                        outt.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("File created successfully!");
                }
                clearDinhVu();
                JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thành Công");
            }
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int rowW = tblThietBiPhong.getSelectedRow();
        LoaiPhong lp = phongServce.findByIdPhong((String) tblThietBiPhong.getValueAt(rowW, 0));
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < INVOICE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        for (int i = 0; i < tblThietBi.getRowCount(); i++) {
            Boolean checked = (Boolean) tblThietBi.getValueAt(i, 4);
            if (checked != null && checked) {
                String tenTB = (String) tblThietBi.getValueAt(i, 0);
                long all = (long) tblThietBi.getValueAt(i, 3);
                TaoHoaDonTB tbAdd = new TaoHoaDonTB();
                tbAdd.setIdPhong(lp.getId());
                tbAdd.setMaHD(sb.toString());
                tbAdd.setNgaytao(txtNgayBatDau.getDate());
                tbAdd.setNgaykt(txtNgayKetThuc.getDate());
                tbAdd.setSoTien((long) tblThietBi.getValueAt(i, 3));
                tbAdd.setGhichu(txtGhiChu.getText());
                TaoHoaDonTBSev sv = new TaoHoaDonTBSev();
                sv.insert(tbAdd);
                JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thành Công");
                try {
                    //in hóa đơn
                    XWPFDocument document = new XWPFDocument();
                    XWPFParagraph paragraph = document.createParagraph();
                    paragraph.setAlignment(ParagraphAlignment.CENTER);
                    XWPFRun run = paragraph.createRun();
                    run.setText("Hóa đơn thiết bị");
                    run.setFontSize(12);
                    run.setBold(true);

                    XWPFTable table = document.createTable(tblDinhVu.getRowCount() + 0, 5); // Số dòng của bảng = số bản ghi trong JTable + 1 (dòng tiêu đề)

                    // Định dạng cột bảng
                    table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));
                    table.getCTTbl().getTblPr().addNewTblBorders().addNewBottom().setVal(STBorder.SINGLE);
                    table.getCTTbl().getTblPr().getTblBorders().addNewTop().setVal(STBorder.SINGLE);
                    table.getCTTbl().getTblPr().getTblBorders().addNewLeft().setVal(STBorder.SINGLE);
                    table.getCTTbl().getTblPr().getTblBorders().addNewRight().setVal(STBorder.SINGLE);
                    table.getCTTbl().getTblPr().getTblBorders().addNewInsideH().setVal(STBorder.SINGLE);
                    table.getCTTbl().getTblPr().getTblBorders().addNewInsideV().setVal(STBorder.SINGLE);

                    XWPFTableRow rowTitle = table.getRow(0);
                    rowTitle.addNewTableCell().setText("Tên thiết bị");
                    rowTitle.addNewTableCell().setText("Số lượng");
                    rowTitle.addNewTableCell().setText("Đơn giá");
                    rowTitle.addNewTableCell().setText("Thành tiền");

                    table.setWidth("100%");

                    for (int j = 0; j < tblThietBi.getRowCount(); j++) {
                        Boolean checked3 = (Boolean) tblThietBi.getValueAt(j, 4);
                        if (checked3 != null && checked3) {
                            XWPFTableRow tableRow = table.getRow(j + 1);
                            if (tableRow == null) {
                                tableRow = table.createRow();
                            }
                            int soLuong = (int) tblThietBi.getValueAt(j, 1);
                            tableRow.getCell(1).setText((String) tblThietBi.getValueAt(j, 0));
                            tableRow.getCell(2).setText(String.valueOf(soLuong));
                            tableRow.getCell(3).setText(Long.toString((Long) tblThietBi.getValueAt(j, 2)));
                            tableRow.getCell(4).setText(Long.toString((Long) tblThietBi.getValueAt(j, 3)));
                        }
                    }

                    // Tạo hàng tổng cộng
                    XWPFTableRow rowTotal = table.createRow();
                    rowTotal.getCell(0).setText("Tổng cộng:");
                    rowTotal.getCell(4).setText(txtTongTien.getText());

                    // Định dạng hàng tổng cộng
                    for (XWPFTableCell cell : rowTotal.getTableCells()) {
                        cell.getCTTc().addNewTcPr().addNewNoWrap();
                        cell.getCTTc().getTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
                    }

                    // Thêm dòng trống giữa bảng và ngày lập hóa đơn
                    document.createParagraph().createRun().addBreak();

                    Date ngaySinh = txtNgayBatDau.getDate();
                    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate2 = formatter2.format(ngaySinh);
                    // Thêm ngày lập hóa đơn
                    XWPFParagraph datePara = document.createParagraph();
                    datePara.setAlignment(ParagraphAlignment.RIGHT);
                    datePara.createRun().setText("Ngày lập hóa đơn: " + formattedDate2);

                    Date ngaySinh1 = txtNgayKetThuc.getDate();
                    SimpleDateFormat formatter22 = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate22 = formatter22.format(ngaySinh1);
                    // Thêm hạn thanh toán
                    XWPFParagraph deadlinePara = document.createParagraph();
                    deadlinePara.setAlignment(ParagraphAlignment.RIGHT);
                    deadlinePara.createRun().setText("Hạn thanh toán trước: " + formattedDate22);

                    XWPFParagraph deadlinePara1 = document.createParagraph();
                    deadlinePara1.setAlignment(ParagraphAlignment.RIGHT);
                    deadlinePara1.createRun().setText("Ghi chú:" + jTextArea2.getText());

                    XWPFParagraph deadlinePara11 = document.createParagraph();
                    deadlinePara11.setAlignment(ParagraphAlignment.RIGHT);
                    deadlinePara11.createRun().setText("Xin cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi!");

                    // Tạo file và lưu tài liệu vào file
                    FileOutputStream out = new FileOutputStream("" + tblDinhVu.getValueAt(i, 0) + ".docx");
                    document.write(out);
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thành Công");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTaoHoaDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDon1MouseClicked
        // TODO add your handling code here:
//        if (kiemTraDuLieu()) {
//            HoaDonViewModel hd = getDuLieuTuForm();
//            quanLyHoaDonService.add(hd);
//            showDataTable2(quanLyDSService.getAll());
//            JOptionPane.showMessageDialog(this, "Thêm thành công");
//
//           
//        }
    }//GEN-LAST:event_btnTaoHoaDon1MouseClicked

    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked
        // TODO add your handling code here:
//        int rowSeleted = tbHienThi.getSelectedRow();
//        String ma = txtMaHoaDon.getText();
//        if (rowSeleted >= 0) {
//            HoaDonViewModel item = getDuLieuTuForm();
//            quanLyHoaDonService.update(ma, item);
//            showDataTable(quanLyHoaDonService.getAll());
//        } else {
//            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
//        }
    }//GEN-LAST:event_btnCapNhatMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        // TODO add your handling code here:
        txtMaHoaDon.setText(null);
        txtTienPhong.setText(null);
        txtTienKhachDua.setText(null);
        txtGhiChu.setText(null);
        cboTenPhong.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearMouseClicked

    private void tbDSHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSHienThiMouseClicked
//         TODO add your handling code here:
        int rowIndex = tbDSHienThi.getSelectedRow();
        doDuLieuLenForm2(rowIndex);
    }//GEN-LAST:event_tbDSHienThiMouseClicked

    private void btnTaoHoaDon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDon1ActionPerformed
        if (kiemTraDuLieu()) {
            HoaDonViewModel hd = new HoaDonViewModel();
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < INVOICE_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            hd.setMaHoaDon(sb.toString());
            hd.setNgayTao(txtNgayTao.getDate());
            hd.setNgayKetThuc(txtNgayKetThuc.getDate());
            hd.setTienPhong(Double.parseDouble(txtTienPhong.getText()));
            hd.setTienKhachDua(Double.parseDouble(txtTienKhachDua.getText()));
            hd.setGhiChu(txtGhiChu.getText());
            hd.setTenPhong(cboTenPhong.getSelectedItem().toString());
            quanLyHoaDonService.add(hd);
            showDataTable2(quanLyDSService.getAll());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            try {

                XWPFDocument document = new XWPFDocument();
                XWPFParagraph paragraph = document.createParagraph();
                paragraph.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun run = paragraph.createRun();
                run.setText("Hóa đơn tiền phòng");
                run.setFontSize(12);
                run.setBold(true);

                XWPFParagraph paragraph5 = document.createParagraph();
                XWPFRun run5 = paragraph5.createRun();
                paragraph5.setAlignment(ParagraphAlignment.CENTER);
                run5.setText("Mã Hóa Đơn:" + sb.toString());
                run5.setFontSize(12);
                run5.setTextPosition(50);

                XWPFParagraph paragraph6 = document.createParagraph();
                XWPFRun run6 = paragraph6.createRun();
                run6.setText("Tên Phòng:" + cboTenPhong.getSelectedItem());
                run6.setFontSize(12);
                run6.setTextPosition(50);

                Date ngaySinh = txtNgayTao.getDate();
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate2 = formatter2.format(ngaySinh);
                XWPFParagraph paragraph9 = document.createParagraph();
                XWPFRun run9 = paragraph9.createRun();
                run9.setText("Ngày lập: " + formattedDate2);
                run9.setFontSize(12);
                run9.setTextPosition(20);

                XWPFParagraph paragraph91 = document.createParagraph();
                XWPFRun run91 = paragraph91.createRun();
                run91.setText("Tiền Phòng:" + txtTienPhong.getText());
                run91.setFontSize(12);
                run91.setTextPosition(20);

                Date ngaySinh1 = txtNgayKT.getDate();
                SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
                String formatter12 = formatter3.format(ngaySinh1);
                XWPFParagraph paragraph93 = document.createParagraph();
                XWPFRun run93 = paragraph93.createRun();
                run93.setText("Hạn thanh toán trước: " + formatter12);
                run93.setFontSize(12);
                run93.setTextPosition(20);

                XWPFParagraph deadlinePara11 = document.createParagraph();
                deadlinePara11.setAlignment(ParagraphAlignment.RIGHT);
                deadlinePara11.createRun().setText("Xin cảm ơn quý khách hãy nhớ đóng tiền phòng đúng hạn!");
                FileOutputStream out = new FileOutputStream("hoa-don-phong.docx");
                document.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnTaoHoaDon1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allThietBi;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnTaoHoaDon1;
    private javax.swing.JComboBox<String> cboTenPhong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private com.toedter.calendar.JDateChooser ngayBatDau;
    private com.toedter.calendar.JDateChooser ngayKetThuc;
    private javax.swing.JTable tbDSHienThi;
    private javax.swing.JTable tblDinhVu;
    private javax.swing.JTable tblPhongDinhVu;
    private javax.swing.JTable tblThietBi;
    private javax.swing.JTable tblThietBiPhong;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextArea txtGhiChu1;
    private javax.swing.JTextField txtMaHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienPhong;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private boolean kiemTraDuLieu() {
        if (txtTienPhong.getText().trim().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập tiền phòng");
            return false;
        } else if (!txtTienPhong.getText().trim().replace(".", "").matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền phòng phải là số dương");
            return false;
        } else if (txtTienKhachDua.getText().trim().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập tiền khách đưa");
            return false;
        } else if (!txtTienKhachDua.getText().trim().replace(".", "").matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền khách đưa phải là số dương");
            return false;
        } else if (Double.parseDouble(txtTienKhachDua.getText()) >= Double.parseDouble(txtTienPhong.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền phòng phải lớn hoặc bằng tiền khách đưa");
            return false;
        }

        return true;
    }

    private void doDuLieuLenForm2(int rowIndex) {
        int row = tbDSHienThi.getSelectedRow();
        DSNgayDongTienPhongViewModel ds = listDS.get(rowIndex);
        cboTenPhong.setSelectedItem(ds.getTenPhong());
        double gia = (double) tbDSHienThi.getValueAt(row, 3);
        txtTienPhong.setText(String.valueOf(gia));
    }

    private void clearDinhVu() {
        dtmDinhVu.setRowCount(0);
        txtGhiChu.setText("");
        ngayBatDau.setDate(null);
        ngayKetThuc.setDate(null);
    }
}
