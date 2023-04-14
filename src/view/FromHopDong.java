package view;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.DinhVu;
import model.HopDong;
import model.KhachThue;
import model.Phong;
import model.PhongThue;
import model.ThietBi;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.BorderFactory;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import service.HopDongService;
import service.PhongServce;
import service.impl.HopDongServiceInpl;
import service.impl.PhongServceImpl;
import viewmodel.DinhVuView;
import viewmodel.KhachThuePhong;
import viewmodel.PhongView;
import viewmodel.ThietBiView;

public class FromHopDong extends javax.swing.JFrame {

    private HopDongService hopDongService = new HopDongServiceInpl();
    private PhongServce phongServce = new PhongServceImpl();
    private DefaultTableModel dtmDinhVu = new DefaultTableModel();
    private DefaultTableModel dtmThietBi = new DefaultTableModel();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int INVOICE_LENGTH = 6;

    public FromHopDong() {
        initComponents();
        loadTableDinhVu(hopDongService.getAllDinhVu());
        loadTableThietBị(hopDongService.getAllThietBi());

    }

    private void loadTableDinhVu(List<DinhVuView> list) {
        dtmDinhVu = (DefaultTableModel) tblDinhVu.getModel();
        dtmDinhVu.setRowCount(0);
        for (DinhVuView dinhVu : list) {
            dtmDinhVu.addRow(new Object[]{
                dinhVu.getTen(),
                dinhVu.getGia(),
                dinhVu.getDonVi()});
        }
    }

    private void loadTableThietBị(List<ThietBiView> list) {
        dtmThietBi = (DefaultTableModel) tblThietBi.getModel();
        dtmThietBi.setRowCount(0);
        for (ThietBiView ThietBi : list) {
            dtmThietBi.addRow(new Object[]{
                ThietBi.getTen(),
                ThietBi.getGia(),
                ThietBi.getSoLuong()});
        }
    }

    // add hợp đồng
    private void addHopDong() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < INVOICE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        try {
            if (txtHoTenKhach.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Họ Và Tên");
            } else if (txtSoDienThoai.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Điện Thoại");
            } else if (txtCmnd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Căn Cước Công Dâc hoặc chứng minh nhân dân");
            } else if (buttonGroup1.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Giới Tính");
            } else if (txtNgaySinh.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Ngày Sinh");
            } else if (txtDiaChi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Địa Chỉ");
            } else if (txtGmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Gmail");
            } else if (txtNgayBatDau.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Ngày Bắt Đầu");
            } else if (txtNgayKetThuc.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Ngày Kết Thúc");
            } else if (txtTienCoc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Tiền Cọc");
            } else if (txtGmail.getText().length() > 50) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập gmail quá 50 kí tự");
                SwingUtilities.invokeLater(() -> {
                    if (!txtGmail.getText().isEmpty()) {
                        txtGmail.setText(txtGmail.getText().substring(0, 50));
                    }
                });
            } else if (txtDiaChi.getText().length() > 50) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập địa chỉ quá 200 kí tự");
                SwingUtilities.invokeLater(() -> {
                    if (!txtDiaChi.getText().isEmpty()) {
                        txtDiaChi.setText(txtDiaChi.getText().substring(0, 200));
                    }
                });
            } else if (txtSoDienThoai.getText().length() > 10) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập số điện thoại quá 10 kí tự");
                SwingUtilities.invokeLater(() -> {
                    if (!txtSoDienThoai.getText().isEmpty()) {
                        txtSoDienThoai.setText(txtSoDienThoai.getText().substring(0, 10));
                    }
                });
            } else if (txtHoTenKhach.getText().length() > 50) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập họ và tên quá 50 kí tự");
                SwingUtilities.invokeLater(() -> {
                    if (!txtHoTenKhach.getText().isEmpty()) {
                        txtHoTenKhach.setText(txtHoTenKhach.getText().substring(0, 50));
                    }
                });
            } else if (txtCmnd.getText().length() > 15) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập chứng minh nhân dân/ căn cước công dân quá 15 kí tự");
                SwingUtilities.invokeLater(() -> {
                    if (!txtCmnd.getText().isEmpty()) {
                        txtCmnd.setText(txtCmnd.getText().substring(0, 50));
                    }
                });
            } else if (txtTienCoc.getText().length() > 10) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập tiền cọc quá 10 kí tự");
                SwingUtilities.invokeLater(() -> {
                    if (!txtTienCoc.getText().isEmpty()) {
                        txtTienCoc.setText(txtTienCoc.getText().substring(0, 10));
                    }
                });
            } else if (!txtSoDienThoai.getText().matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            } else if (!txtCmnd.getText().matches("\\d{8,12}")) {
                JOptionPane.showMessageDialog(this, "cmnd/cccd không hợp lệ");
            } else if (txtHoTenKhach.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
            } else if (txtSoDienThoai.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
            } else if (txtCmnd.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
            } else if (txtDiaChi.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
            } else if (txtTienCoc.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập kí tự đặc biệt");
            } else if (Long.parseLong(txtSoDienThoai.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập số điện thoại âm");
            } else if (Long.parseLong(txtCmnd.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng không nhập cmnd/cccd âm");
            } else if (Integer.parseInt(txtTienCoc.getText()) == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lớn hơn 0");
            } else if (Long.parseLong(txtTienCoc.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng không tiền cọc âm");
            } else {
                KhachThue k = new KhachThue();
                boolean isGender = rdoNam.isSelected();
                k.setGioiTinh(isGender); // fix gender assignment issue
                int soDienThoai = Integer.parseInt(txtSoDienThoai.getText());
                String cmnd = txtCmnd.getText();

                k = new KhachThue(
                        0,
                        txtHoTenKhach.getText(),
                        txtNgaySinh.getDate(),
                        k.isGioiTinh(),
                        soDienThoai,
                        txtGmail.getText(),
                        cmnd,
                        txtDiaChi.getText());
                hopDongService.addKhach(k);

                KhachThue kt = hopDongService.findByID(txtHoTenKhach.getText());
                Phong p = hopDongService.findByIDPhong(txtPhong.getText());
                HopDong hopDong = new HopDong();
                String maHD = UUID.randomUUID().toString();
                hopDong.setMaHD(maHD);

                String sdsd = (String) cbbNgayChot.getSelectedItem();
                hopDong = new HopDong(
                        0,
                        kt.getId(),
                        p.getId(),
                        sb.toString(),
                        txtNgayBatDau.getDate(),
                        txtNgayKetThuc.getDate(),
                        Long.parseLong(txtTienCoc.getText()),
                        Integer.parseInt(sdsd),
                        (String) cbbKiThanhToan.getSelectedItem(),
                        cbbThanhToanMoiLan.getSelectedIndex(),
                        "Còn Hạn");
                JOptionPane.showMessageDialog(this, hopDongService.addHopDong(hopDong));
                int count = 0;
                for (int i = 0; i < tblDinhVu.getRowCount(); i++) {
                    Boolean checked = (Boolean) tblDinhVu.getValueAt(i, 3);
                    if (checked != null && checked) {
                        count++;
                        DinhVu dv = hopDongService.findByIDDinhVu((String) tblDinhVu.getValueAt(i, 0));
                        HopDong hd = hopDongService.findByIDHopDong(kt.getId());
                        DinhVu dinhVu = new DinhVu(hd.getId(), dv.getIdDinhVu(), p.getId(), kt.getId(), 1, (long) tblDinhVu.getValueAt(i, 1), (long) tblDinhVu.getValueAt(i, 1));
                        hopDongService.addChiTietDinhVu(dinhVu);
                    }
                }
                for (int i = 0; i < tblThietBi.getRowCount(); i++) {
                    Object obj = tblThietBi.getValueAt(i, 3);
                    int soLuong = obj != null ? Integer.parseInt(obj.toString()) : 0;
                    Boolean checked = (Boolean) tblThietBi.getValueAt(i, 4);
                    if (checked != null && checked) {
                        long gia = (long) tblThietBi.getValueAt(i, 1);
                        long donGia = soLuong * gia;
                        int quantity = (int) tblThietBi.getValueAt(i, 2);
                        int soLuongSauUpdate = quantity - soLuong;
                        ThietBi bi = hopDongService.findByIDThietBi((String) tblThietBi.getValueAt(i, 0));
                        HopDong hd = hopDongService.findByIDHopDong(kt.getId());
                        ThietBi thietBi = new ThietBi();
                        ThietBi tb = new ThietBi();
                        tb.setSoLuong(soLuongSauUpdate);
                        thietBi = new ThietBi(hd.getId(), bi.getIdThietBi(), kt.getId(), p.getId(), soLuong, txtNgayBatDau.getDate(), txtNgayKetThuc.getDate(), "Đang Sử Dụng", donGia);
                        hopDongService.addChiTietThietBi(thietBi);
                        hopDongService.updateSoLuongThietBi(tb, bi.getIdThietBi());
                    }
                }
                loadTableThietBị(hopDongService.getAllThietBi());
                PhongThue phongThue = new PhongThue();
                phongThue = new PhongThue(kt.getId(), p.getId(), txtNgayBatDau.getDate(), txtNgayKetThuc.getDate(), Float.parseFloat(txtTienPhong.getText()), "Đại diện hợp đồng");
                hopDongService.addPhongThue(phongThue);

                DongHoaDon dhd1 = new DongHoaDon();
                dhd1.txtTenPhong().setText(txtPhong.getText());
                dhd1.txtTenKhach().setText(txtHoTenKhach.getText());
                dhd1.txtTien().setText(txtTienPhong.getText());
                dhd1.txtTienCoc().setText(txtTienCoc.getText());
                dhd1.getTxtNgayBatDau().setDate(txtNgayBatDau.getDate());
                dhd1.getTxtNgayKT().setDate(txtNgayKetThuc.getDate());
                dhd1.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        cbbKiThanhToan = new javax.swing.JComboBox<>();
        cbbThanhToanMoiLan = new javax.swing.JComboBox<>();
        btnTaoHopDong = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cbbNgayChot = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtTienCoc = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtHoTenKhach = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel77 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCmnd = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel23 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        txtPhong = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txtLoaPhong = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        txtKhuVuc = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        txtDienTich = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txtTienPhong = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblDinhVu = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblThietBi = new javax.swing.JTable();
        jLabel88 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1177, 588));

        jPanel21.setBackground(new java.awt.Color(186, 215, 233));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setText("Thông Tin Hợp Đồng");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setText("Ngày Bắt Đầu");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setText("Tiền Cọc");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel71.setText("Kì Thanh Toán");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel72.setText("Thanh Toán Mỗi lần");

        cbbKiThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbKiThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Tháng", "Quý", "Năm" }));
        cbbKiThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKiThanhToanItemStateChanged(evt);
            }
        });
        cbbKiThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKiThanhToanActionPerformed(evt);
            }
        });

        cbbThanhToanMoiLan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbThanhToanMoiLan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1 ", "3 ", "12 " }));
        cbbThanhToanMoiLan.setEnabled(false);

        btnTaoHopDong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHopDong.setText("Tạo Hợp Đồng");
        btnTaoHopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHopDongActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tháng");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setText("Ngày Kết Thúc");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày Chốt Tiền Phòng");

        cbbNgayChot.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbNgayChot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cập Nhập");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel67))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(txtTienCoc))
                .addGap(79, 79, 79)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbKiThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addGap(79, 79, 79)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jLabel3))
                .addGap(59, 59, 59)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(cbbThanhToanMoiLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(cbbNgayChot, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoHopDong)))
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel66)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTaoHopDong)
                        .addComponent(cbbNgayChot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(cbbKiThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(cbbThanhToanMoiLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jLabel69))
                .addGap(22, 22, 22))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(186, 215, 233));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel73.setText("Thông Tin Khách");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setText("Họ Và Tên");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setText("Ngày Sinh");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setText("SĐT");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setText("Cmnd");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setText("Địa Chỉ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane13.setViewportView(txtDiaChi);

        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel80.setText("Thông Tin Phòng");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel81.setText("Tên Phòng");

        txtPhong.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setText("Loại Phòng");

        txtLoaPhong.setEnabled(false);

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel83.setText("Khu Vực");

        txtKhuVuc.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel84.setText("Diện Tích");

        txtDienTich.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel85.setText("Giá Phòng");

        txtTienPhong.setEnabled(false);

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel86.setText("Mô Tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        txtMoTa.setEnabled(false);
        jScrollPane14.setViewportView(txtMoTa);

        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1145, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel87.setText("Thông Tin Dịnh Vụ");

        tblDinhVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giá", "Đơn Vị", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(tblDinhVu);

        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giá ", "Số Lượng", "Nhập Số Lượng", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(tblThietBi);

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel88.setText("Thông Tin Thiết Bị");

        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel89.setText("Số Lượng");

        txtSoLuong.setEnabled(false);

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel90.setText("Gmail");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel73)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(26, 26, 26)
                        .addComponent(txtHoTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(34, 34, 34)
                        .addComponent(rdoNam)
                        .addGap(4, 4, 4)
                        .addComponent(rdoNu))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(59, 59, 59)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addGap(50, 50, 50)
                        .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(jLabel75))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel80)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addGap(21, 21, 21)
                        .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(34, 34, 34)
                        .addComponent(txtKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel84)
                        .addGap(27, 27, 27)
                        .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addGap(27, 27, 27)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel85)
                        .addGap(18, 18, 18)
                        .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addComponent(jLabel88)
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane16)
                            .addComponent(jScrollPane15))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel74))
                                    .addComponent(txtHoTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel76))
                                    .addComponent(rdoNam)
                                    .addComponent(rdoNu))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel77))
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel78))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel90))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel79)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(19, 19, 19)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel81))
                                    .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel82))
                                    .addComponent(txtLoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel83))
                                    .addComponent(txtKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel84))
                                    .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel89))
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel85))
                                    .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel86)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hợp Đồng", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHopDongActionPerformed
        addHopDong();

        guiMail1();
    }//GEN-LAST:event_btnTaoHopDongActionPerformed

    private void cbbKiThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKiThanhToanItemStateChanged
        int selectedItem = (int) cbbKiThanhToan.getSelectedIndex();
        if (selectedItem == 1) {
            cbbThanhToanMoiLan.setSelectedIndex(1);
        } else if (selectedItem == 2) {
            cbbThanhToanMoiLan.setSelectedIndex(2);
        } else if (selectedItem == 3) {
            cbbThanhToanMoiLan.setSelectedIndex(3);
        } else {
            cbbThanhToanMoiLan.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbbKiThanhToanItemStateChanged

    private void cbbKiThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKiThanhToanActionPerformed
        if (cbbKiThanhToan.getSelectedIndex() == 1) {
            // Nếu chọn thanh toán theo tháng, tiền cọc là một tháng giá phòng
            txtTienCoc.setText(txtTienPhong.getText());
        } else if (cbbKiThanhToan.getSelectedIndex() == 2) {
            // Nếu chọn thanh toán theo quý, tiền cọc sẽ là 3 tháng giá phòng
            double giaPhong = Double.parseDouble(txtTienPhong.getText());
            int tienCoc = (int) Math.round(giaPhong * 3);
            txtTienCoc.setText(String.valueOf(tienCoc));
        } else if (cbbKiThanhToan.getSelectedIndex() == 3) {
            // Nếu chọn thanh toán theo năm, tiền cọc là 6 tháng giá phòng
            double giaPhong = Double.parseDouble(txtTienPhong.getText());
            int tienCoc = (int) Math.round(giaPhong * 6);
            txtTienCoc.setText(String.valueOf(tienCoc));
        } else {
            // Nếu không chọn kiểu thanh toán nào, tiền cọc là 0
            txtTienCoc.setText("0");
        }
    }//GEN-LAST:event_cbbKiThanhToanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FromHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromHopDong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHopDong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbKiThanhToan;
    private javax.swing.JComboBox<String> cbbNgayChot;
    private javax.swing.JComboBox<String> cbbThanhToanMoiLan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDinhVu;
    private javax.swing.JTable tblThietBi;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDienTich;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtHoTenKhach;
    private javax.swing.JTextField txtKhuVuc;
    private javax.swing.JTextField txtLoaPhong;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtPhong;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTienCoc;
    private javax.swing.JTextField txtTienPhong;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getMaPhong() {
        return txtPhong;
    }

    public javax.swing.JComboBox<String> cbbKiThanhToan() {
        return cbbKiThanhToan;
    }

    public javax.swing.JTextField getKhuVuc() {
        return txtKhuVuc;
    }

    public javax.swing.JTextField getSoNguoiToiDa() {
        return txtSoLuong;
    }

    public javax.swing.JTextField getGiaPhong() {
        return txtTienPhong;
    }

    public javax.swing.JTextField getLoaiPhong() {
        return txtLoaPhong;
    }

    public javax.swing.JTextField getDienTich() {
        return txtDienTich;
    }

    public javax.swing.JTextField getTienCoc() {
        return txtTienCoc;
    }

    public javax.swing.JTextArea getMoTa() {
        return txtMoTa;
    }

    private void guiMail1() {
//        String host = "smtp.gmail.com"; // SMTP server của Gmail
//        int port = 587; // Cổng SMTP của Gmail
////        String username = "donghkph43840@fpt.edu.vn"; // Tên đăng nhập của bạn
////        String password = "Dong17112003"; // Mật khẩu của bạn
//        String username = "duchcph22577@fpt.edu.vn"; // Tên đăng nhập của bạn
//        String password = "congduc003"; // Mật khẩu của bạn
//        String from = "donghkph43840@fpt.edu.vn"; // Địa chỉ email người gửi
//        String to = "acevip3871@gmail.com"; // Địa chỉ email người nhận
//        String subject = "Subject of the Email";
//        String body = "Hoàng Công Đức";
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });

        try {
            // Tạo file word
            XWPFDocument document = new XWPFDocument();
//            FileOutputStream outt = new FileOutputStream(new File("c.docx"));
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run.setText("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
            run.setFontSize(12);
            run.setBold(true);

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            paragraph2.setAlignment(ParagraphAlignment.CENTER);
            run2.setText("Độc lập – Tự do – Hạnh phúc");
            run2.setFontSize(12);
            paragraph2 = document.createParagraph();
            paragraph2 = document.createParagraph();

            XWPFParagraph paragraph4 = document.createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("HỢP ĐỒNG THUÊ PHÒNG TRỌ");
            run4.setFontSize(12);
            run4.setItalic(true);
            run4.setBold(true);
            paragraph4 = document.createParagraph();

            XWPFParagraph paragraph5 = document.createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.CENTER);

// Lấy ngày tháng năm hiện tại
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = today.format(formatter);

// Đưa ngày tháng năm vào đoạn văn bản
            run5.setText("Hôm nay ngày " + formattedDate + "; tại địa chỉ: phố Trịnh Văn Bô, phường Phương Canh, quận Nam Từ Liêm, TP Hà Nội\n");
            run5.setFontSize(12);

            XWPFParagraph paragraph6 = document.createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            run6.setText("Chúng tôi gồm: ");
            run6.setFontSize(12);
            run6.setBold(true);

            XWPFParagraph paragraph7 = document.createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            run7.setText("1.Đại diện bên cho thuê phòng trọ (Bên A):");
            run7.setFontSize(12);

            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            run3.setText("Ông/bà: Hoàng Công Đức");
            run3.setFontSize(12);

            XWPFParagraph paragraph8 = document.createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            run8.setText("Quê Quán: Phố Trịnh Văn Bô, phường Phương Canh, quận Nam Từ Liêm, TP Hà Nội");
            run8.setFontSize(12);
            XWPFParagraph paragraph9 = document.createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            run9.setText("Số điện thoại: 0971066455");
            run9.setFontSize(12);

            XWPFParagraph paragraph10 = document.createParagraph();
            XWPFRun run10 = paragraph10.createRun();
            run10.setText("CMND số: 025203001482");
            run10.setFontSize(12);

            XWPFParagraph paragrap11 = document.createParagraph();
            XWPFRun run11 = paragrap11.createRun();
            run11.setText("2. Bên thuê phòng trọ (Bên B):");
            run11.setFontSize(12);

            XWPFParagraph paragrap111 = document.createParagraph();
            XWPFRun run111 = paragrap111.createRun();
            run111.setText("Ông/bà:" + txtHoTenKhach.getText() + "");
            run111.setFontSize(12);

            Date ngaySinh = txtNgaySinh.getDate();
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate1 = formatter1.format(ngaySinh);

            XWPFParagraph paragraph12 = document.createParagraph();
            XWPFRun run12 = paragraph12.createRun();
            run12.setText("Sinh ngày: " + formattedDate1 + "");
            run12.setFontSize(12);

            XWPFParagraph paragraph13 = document.createParagraph();
            XWPFRun run13 = paragraph13.createRun();
            run13.setText("Quê Quán : " + txtDiaChi.getText() + "");
            run13.setFontSize(12);

            XWPFParagraph paragraph14 = document.createParagraph();
            XWPFRun run14 = paragraph14.createRun();
            run14.setText("Số CMND: " + txtCmnd.getText() + "");
            run14.setFontSize(12);

            XWPFParagraph paragraph15 = document.createParagraph();
            XWPFRun run15 = paragraph15.createRun();
            run15.setText("Sau khi bàn bạc trên tinh thần dân chủ, hai bên cùng có lợi, cùng thống nhất như sau:");
            run15.setFontSize(12);
            run15.setBold(true);

            XWPFParagraph paragraph16 = document.createParagraph();
            XWPFRun run16 = paragraph16.createRun();
            run16.setText("Bên A đồng ý cho bên B thuê phòng " + txtPhong.getText() + " ở tại địa chỉ: phố Trịnh Văn Bô, phường Phương Canh, quận Nam Từ Liêm, TP Hà Nội");
            run16.setFontSize(12);

            XWPFParagraph paragraph17 = document.createParagraph();
            XWPFRun run17 = paragraph17.createRun();
            run17.setText("Giá thuê: " + txtTienPhong.getText() + " đ/tháng");
            run17.setFontSize(12);

            XWPFParagraph paragraph18 = document.createParagraph();
            XWPFRun run18 = paragraph18.createRun();
            run18.setText("Tiền điện: " + tblDinhVu.getValueAt(0, 1) + " đ/số tính theo chỉ số công tơ, thanh toán vào cuối các tháng.");
            run18.setFontSize(12);

            XWPFParagraph paragraph19 = document.createParagraph();
            XWPFRun run19 = paragraph19.createRun();
            run19.setText("Tiền nước: " + tblDinhVu.getValueAt(1, 1) + " đ/khối thanh toán vào đầu các tháng.");
            run19.setFontSize(12);

            Date ngayBatDau = txtNgayBatDau.getDate();
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate2 = formatter2.format(ngayBatDau);

            Date ngayKetThuc = txtNgayKetThuc.getDate();
            SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate3 = formatter3.format(ngaySinh);

            XWPFParagraph paragraph20 = document.createParagraph();
            XWPFRun run20 = paragraph20.createRun();
            run20.setText("Tiền đặt cọc: " + txtTienCoc.getText() + "");
            run20.setFontSize(12);

            XWPFParagraph paragraph2022 = document.createParagraph();
            XWPFRun run2022 = paragraph2022.createRun();
            run2022.setText("Hợp đồng có giá trị kể từ " + formattedDate2 + " đến " + formattedDate3 + "");
            run2022.setFontSize(12);

            LocalDate startDate = txtNgayBatDau.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = txtNgayKetThuc.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);

            double tienPhong = Double.parseDouble(txtTienPhong.getText());

// Tính số ngày trong tháng bắt đầu từ startDate
            LocalDate endOfMonth = startDate.withDayOfMonth(startDate.lengthOfMonth());
            int numberOfDaysInMonth = (int) (startDate.until(endOfMonth, ChronoUnit.DAYS) + 1);

// Tính số tiền phòng mỗi ngày
            int tienPhongMoiNgay = (int) Math.ceil(tienPhong / numberOfDaysInMonth);

// Tính tổng số tiền phòng
            int tongTienPhong = (int) (tienPhongMoiNgay * numberOfDays);

            XWPFParagraph paragraph202 = document.createParagraph();
            XWPFRun run202 = paragraph202.createRun();
            run202.setText("Tổng sô tiền phong mà khách phải thanh toán trong quá trình ở tại nhà trọ: " + tongTienPhong + " " + "VND");
            run202.setFontSize(12);

            XWPFParagraph paragraph21 = document.createParagraph();
            XWPFRun run21 = paragraph21.createRun();
            run21.setText("TRÁCH NHIỆM CỦA CÁC BÊN");
            run21.setFontSize(12);
            run21.setBold(true);

            XWPFParagraph paragraph22 = document.createParagraph();
            XWPFRun run22 = paragraph22.createRun();
            run22.setText("*Trách nhiệm của bên A:");
            run22.setFontSize(12);
            run22.setBold(true);

            XWPFParagraph paragraph23 = document.createParagraph();
            XWPFRun run23 = paragraph23.createRun();
            run23.setText("- Tạo mọi điều kiện thuận lợi để bên B thực hiện theo hợp đồng");
            run23.setFontSize(12);

            XWPFParagraph paragraph24 = document.createParagraph();
            XWPFRun run24 = paragraph24.createRun();
            run24.setText("- Cung cấp nguồn điện, nước, wifi cho bên B sử dụng.");
            run24.setFontSize(12);

            XWPFParagraph paragraph25 = document.createParagraph();
            XWPFRun run25 = paragraph25.createRun();
            run25.setText("* Trách nhiệm của bên B:");
            run25.setFontSize(12);
            run25.setBold(true);

            XWPFParagraph paragraph26 = document.createParagraph();
            XWPFRun run26 = paragraph26.createRun();
            run26.setText("- Thanh toán đầy đủ các khoản tiền theo đúng thỏa thuận");
            run26.setFontSize(12);

            XWPFParagraph paragraph27 = document.createParagraph();
            XWPFRun run27 = paragraph27.createRun();
            run27.setText("- Bảo quản các trang thiết bị và cơ sở vật chất của bên A trang bị cho ban đầu và cho thuê (làm hỏng phải sửa, mất phải đền).");
            run27.setFontSize(12);

            XWPFParagraph paragraph28 = document.createParagraph();
            XWPFRun run28 = paragraph28.createRun();
            run28.setText("- Không được tự ý sửa chữa, cải tạo cơ sở vật chất khi chưa được sự đồng ý của bên A.");
            run28.setFontSize(12);

            XWPFParagraph paragraph29 = document.createParagraph();
            XWPFRun run29 = paragraph29.createRun();
            run29.setText("- Giữ gìn vệ sinh trong và ngoài khuôn viên của phòng trọ");
            run29.setFontSize(12);

            XWPFParagraph paragraph30 = document.createParagraph();
            XWPFRun run30 = paragraph30.createRun();
            run30.setText("- Bên B phải chấp hành mọi quy định của pháp luật Nhà nước và quy định của địa phương");
            run30.setFontSize(12);

            XWPFParagraph paragraph31 = document.createParagraph();
            XWPFRun run31 = paragraph31.createRun();
            run31.setText("- Nếu bên B cho khách ở qua đêm thì phải báo và được sự đồng ý của chủ nhà đồng thời phải chịu trách nhiệm về các hành vi vi phạm pháp luật của khách trong thời gian ở lại.");
            run31.setFontSize(12);

            XWPFParagraph paragraph32 = document.createParagraph();
            XWPFRun run32 = paragraph32.createRun();
            run32.setText("- TRÁCH NHIỆM CHUNG");
            run32.setFontSize(12);
            run32.setBold(true);

            XWPFParagraph paragraph33 = document.createParagraph();
            XWPFRun run33 = paragraph33.createRun();
            run33.setText("- Trong thời gian hợp đồng còn hiệu lực nếu bên nào vi phạm các điều khoản đã thỏa thuận thì bên còn lại có quyền đơn phương chấm dứt hợp đồng; nếu sự vi phạm hợp đồng đó gây tổn thất cho bên bị vi phạm hợp đồng thì bên vi phạm hợp đồng phải bồi thường thiệt hại.");
            run33.setFontSize(12);

            XWPFParagraph paragraph34 = document.createParagraph();
            XWPFRun run34 = paragraph34.createRun();
            run34.setText("- Một trong hai bên muốn chấm dứt hợp đồng trước thời hạn thì phải báo trước cho bên kia ít nhất 30 ngày và hai bên phải có sự thống nhất.- Bên A phải trả lại tiền đặt cọc cho bên B.");
            run34.setFontSize(12);

            XWPFParagraph paragraph35 = document.createParagraph();
            XWPFRun run35 = paragraph35.createRun();
            run35.setText(" Bên nào vi phạm điều khoản chung thì phải chịu trách nhiệm trước pháp luật");
            run35.setFontSize(12);

            XWPFParagraph paragraph36 = document.createParagraph();
            XWPFRun run36 = paragraph36.createRun();
            run36.setText("- Hợp đồng được lập thành 02 bản có giá trị pháp lý như nhau, mỗi bên giữ một bản.");
            run36.setFontSize(12);
            paragraph36 = document.createParagraph();

            XWPFParagraph paragraph37 = document.createParagraph();
            XWPFRun run37 = paragraph37.createRun();
            run37.setText("                                 ĐẠI DIỆN BÊN A                                 ĐẠI DIỆN BÊN B"
                    + "                                                    Hoàng Công Đức                        " + txtHoTenKhach.getText() + "                            ");
            run37.setFontSize(12);
            run37.setBold(true);

            // Tạo file tạm để lưu trữ file word
//            File tempFile = File.createTempFile("HopDong", ".docx");
            FileOutputStream out = new FileOutputStream("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\QuanLyNhaTro\\Hợp Đồng" + " " + txtHoTenKhach.getText() + ".docx");
            document.write(out);
//            run.setFontSize(16);
//            run.setColor("000000");
            out.close();
        } catch (IOException iOException) {
        }
//
//            // Đính kèm file word vào email
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(txtGmail.getText()));
//            message.setSubject(subject);
//
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText(body);
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//
//            messageBodyPart = new MimeBodyPart();
//            DataSource source = new FileDataSource(tempFile);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(tempFile.getName());
//            multipart.addBodyPart(messageBodyPart);
//
//            message.setContent(multipart);
//
//            // Gửi email
//            Transport.send(message);
//
//            System.out.println("Email sent successfully.");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    public void taoHoaDon() {
        DongHoaDon dhd = new DongHoaDon();
        dhd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dhd.setVisible(false);
            }
        });
        dhd.setVisible(true);
    }
}
