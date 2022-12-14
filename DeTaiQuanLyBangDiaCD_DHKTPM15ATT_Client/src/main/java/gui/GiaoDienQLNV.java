package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DanhSachNhanVienDao;
import entity.NhanVien;

public class GiaoDienQLNV extends JFrame implements ActionListener, MouseListener {
	JLabel lblMaNV, lblTenNV, lblSDT, lblGhiChu, lblTitle, lblTim;
	JTextField txtMaNV, txtTenNV, txtSDT, txtTimKiem;
	JTextArea txtGhiChu;
	JButton btnThem, btnXoa, btnXoaRong, btnSua, btnTimKiem, btnLuu, btnMenu;
	JTable tblDSNV;
	DefaultTableModel tblmdl;
	Font font;
	DanhSachNhanVienDao danhSachNhanVienDao;

	public GiaoDienQLNV() throws MalformedURLException, RemoteException, NotBoundException {
		super("Quản lý nhân viên");

		danhSachNhanVienDao = (DanhSachNhanVienDao) Naming.lookup("rmi://192.168.1.107:1990/danhSachNhanVienDao");

		JPanel pnNorth = new JPanel();
		lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		font = new Font("Times New Roman", Font.BOLD, 30);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		pnNorth.add(lblTitle);
		add(pnNorth, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel pn1 = new JPanel();
		pn1.setLayout(new FlowLayout(FlowLayout.CENTER));
		lblMaNV = new JLabel("Mã nhân viên:");
		txtMaNV = new JTextField(50);
		pn1.add(lblMaNV);
		pn1.add(txtMaNV);

		JPanel pn2 = new JPanel();
		pn2.setLayout(new FlowLayout(FlowLayout.CENTER));
		lblTenNV = new JLabel("Tên nhân viên:");
		txtTenNV = new JTextField(50);
		pn2.add(lblTenNV);
		pn2.add(txtTenNV);

		JPanel pn3 = new JPanel();
		pn3.setLayout(new FlowLayout(FlowLayout.CENTER));
		lblSDT = new JLabel("Số điện thoại:");
		txtSDT = new JTextField(50);
		pn3.add(lblSDT);
		pn3.add(txtSDT);

		JPanel pn4 = new JPanel();
		pn4.setLayout(new FlowLayout(FlowLayout.CENTER));
		lblGhiChu = new JLabel("Ghi chú:");
		txtGhiChu = new JTextArea(5, 50);
		JScrollPane scrollGhiChu = new JScrollPane(txtGhiChu);
		pn4.add(lblGhiChu);
		pn4.add(scrollGhiChu);

		JPanel pn5 = new JPanel();
		pn5.setLayout(new FlowLayout(FlowLayout.CENTER));
		String[] col = { "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Ghi chú" };
		tblmdl = new DefaultTableModel(col, 0);
		tblDSNV = new JTable(tblmdl);
		tblDSNV.setRowHeight(20);
		JScrollPane scroll = new JScrollPane(tblDSNV);
		scroll.setPreferredSize(new Dimension(880, 250));
		pn5.add(scroll);

		pnCenter.add(pn1);
		pnCenter.add(pn2);
		pnCenter.add(pn3);
		pnCenter.add(pn4);
		pnCenter.add(pn5);

		add(pnCenter);

		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xoá");
		btnXoaRong = new JButton("Xoá trắng");
		btnSua = new JButton("Sửa");
		btnLuu = new JButton("Lưu");
		btnMenu = new JButton("Menu");
		btnTimKiem = new JButton("Tìm");
		txtTimKiem = new JTextField(20);
		lblTim = new JLabel("Nhập mã nhân viên cần tìm:");

		JPanel pnSouthLeft = new JPanel();
		pnSouthLeft.add(lblTim);
		pnSouthLeft.add(txtTimKiem);
		pnSouthLeft.add(btnTimKiem);

		JPanel pnSouthRight = new JPanel();
		pnSouthRight.add(btnThem);
		pnSouthRight.add(btnSua);
		pnSouthRight.add(btnXoa);
		pnSouthRight.add(btnXoaRong);
		pnSouthRight.add(btnLuu);
		pnSouthRight.add(btnMenu);

		JSplitPane pnSouth = new JSplitPane();
		pnSouth.setLeftComponent(pnSouthLeft);
		pnSouth.setRightComponent(pnSouthRight);

		add(pnSouth, BorderLayout.SOUTH);

		lblSDT.setPreferredSize(lblTenNV.getPreferredSize());
		lblMaNV.setPreferredSize(lblSDT.getPreferredSize());
		lblGhiChu.setPreferredSize(lblMaNV.getPreferredSize());

		tblDSNV.addMouseListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnMenu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnTimKiem.addActionListener(this);

		hienLenTable();

		setVisible(true);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void hienLenTable() throws MalformedURLException, RemoteException, NotBoundException {
		DanhSachNhanVienDao danhSachNhanVienDao = danhSachNhanVienDao = (DanhSachNhanVienDao) Naming
				.lookup("rmi://192.168.1.107:1990/danhSachNhanVienDao");
		for (NhanVien nV : danhSachNhanVienDao.getDSNhanVien()) {
			String[] row = { nV.getMaNhanVien(), nV.getTenNhanVien(), nV.getSoDienThoai(), nV.getGhiChu() };
			tblmdl.addRow(row);
		}
	}

	public void mouseClicked(MouseEvent e) {
		txtMaNV.setEditable(false);
		int row = tblDSNV.getSelectedRow();
		if (row != -1) {
			txtMaNV.setText((String) tblDSNV.getValueAt(row, 0));
			txtTenNV.setText((String) tblDSNV.getValueAt(row, 1));
			txtSDT.setText((String) tblDSNV.getValueAt(row, 2));
			txtGhiChu.setText((String) tblDSNV.getValueAt(row, 3));
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnThem)) {
			try {
				themNV();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (src.equals(btnSua)) {
			try {
				sua();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (src.equals(btnXoa)) {
			try {
				xoaNV();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (src.equals(btnXoaRong)) {
			xoaTrang();
		} else if (src.equals(btnTimKiem)) {
			try {
				timNV();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
//		else if (src.equals(btnLuu)) {
//			luu();
//		} 
		else if (src.equals(btnMenu)) {
			try {
				menu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private boolean validData() {
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		String sDT = txtSDT.getText();
		String ghiChu = txtGhiChu.getText();
		if (!(maNV.length() > 0 && maNV.matches("NV[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên phải nhập theo định dạng NVXXX và không được bỏ trống!");
			txtMaNV.selectAll();
			txtMaNV.requestFocus();
			return false;
		}
		if (!(tenNV.length() > 0 && tenNV.matches("^[A-Z].+([A-Z].*[A-Z].)*"))) {
			JOptionPane.showMessageDialog(this,
					"Tên không được bỏ trống, chữ cái đầu phải viết hoa và phải nhập đầy đủ họ tên!");
			txtTenNV.selectAll();
			txtTenNV.requestFocus();
			return false;
		}
		if (!(sDT.length() > 0 && sDT.matches("[0-9]{10}"))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại chỉ 10 số và không được bỏ trống!");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		if (!(ghiChu.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập ghi chú!");
			txtGhiChu.selectAll();
			txtGhiChu.requestFocus();
			return false;
		}
		return true;
	}

	public void themNV() throws HeadlessException, RemoteException {
		if (validData()) {
			String maNV = txtMaNV.getText();
			String tenNV = txtTenNV.getText();
			String sDT = txtSDT.getText();
			String ghiChu = txtGhiChu.getText();
			NhanVien nhanVien = new NhanVien(maNV, tenNV, sDT, ghiChu);
			if (danhSachNhanVienDao.addNhanVien(nhanVien)) {
				String[] row = { maNV, tenNV, sDT, ghiChu };
				tblmdl.addRow(row);
				JOptionPane.showMessageDialog(this, "Đã thêm thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Trùng mã nhân viên!");
				txtMaNV.selectAll();
				txtMaNV.requestFocus();
			}
		}
	}

	private void sua() throws HeadlessException, RemoteException {
		int row = tblDSNV.getSelectedRow();
		if (row != -1) {
			if (validData()) {
				String maNV = (String) tblDSNV.getValueAt(row, 0);
				String tenNV = txtTenNV.getText();
				String sDT = txtSDT.getText();
				String ghiChu = txtGhiChu.getText();
				NhanVien nhanVienNew = new NhanVien(maNV, tenNV, sDT, ghiChu);
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật lại không", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					if (danhSachNhanVienDao.updateNhanVien(nhanVienNew)) {
						tblDSNV.setValueAt(tenNV, row, 1);
						tblDSNV.setValueAt(sDT, row, 2);
						tblDSNV.setValueAt(ghiChu, row, 3);
						JOptionPane.showMessageDialog(this, "Đã sửa thành công!");
					} else
						JOptionPane.showMessageDialog(this, "Không sửa được!");
				}
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên!");
	}

	private void xoaNV() throws HeadlessException, RemoteException {
		int row = tblDSNV.getSelectedRow();
		if (row != -1) {
			String maNV = (String) tblDSNV.getValueAt(row, 0);
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá không?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				if (danhSachNhanVienDao.deleteNV(maNV)) {
					tblmdl.removeRow(row);
					JOptionPane.showMessageDialog(this, "Đã xoá thành công!");
				} else
					JOptionPane.showMessageDialog(this, "Xoá thất bại!");
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên!");
	}

	private void xoaTrang() {
		tblDSNV.clearSelection();
		txtMaNV.setEditable(true);
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtSDT.setText("");
		txtGhiChu.setText("");
		txtMaNV.requestFocus();
	}

	private void timNV() throws RemoteException {
		tblDSNV.clearSelection();
		txtMaNV.setEditable(false);
		String maNV = txtTimKiem.getText();
		NhanVien nV = danhSachNhanVienDao.getNhanVienTheoMa(maNV);
		if (nV != null) {
			txtMaNV.setText(nV.getMaNhanVien());
			txtTenNV.setText(nV.getTenNhanVien());
			txtSDT.setText(nV.getSoDienThoai());
			txtGhiChu.setText(nV.getGhiChu());
			for (int i = 0; i < tblDSNV.getRowCount(); i++) {
				if (tblDSNV.getValueAt(i, 0).equals(nV.getMaNhanVien())) {
					tblDSNV.addRowSelectionInterval(i, i);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên mã " + maNV);
			txtTimKiem.selectAll();
			txtTimKiem.requestFocus();
		}
	}

//	private void luu() {
//		if (dSNV.luuNVDatabase())
//			JOptionPane.showMessageDialog(this, "Đã lưu!");
//		else
//			JOptionPane.showMessageDialog(this, "Không lưu được!");
//	}

	private void menu() throws MalformedURLException, RemoteException, NotBoundException {
		setVisible(false);
		new Menu().setVisible(true);
	}
}