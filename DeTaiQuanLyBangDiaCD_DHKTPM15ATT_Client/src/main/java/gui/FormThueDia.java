package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DanhSachBDThueDao;
import entity.BangDiaThue;

public class FormThueDia extends JFrame implements ActionListener {
	JLabel lblTitle, lblID, lblNgayThue, lblMaTV, lblTenTV, lblMaBD, lblTenBD, lblTheLoai, lblNgayTra, lblSoLuong;
	JTextField txtID, txtNgayThue, txtMaTV, txtMaBD, txtTenBD, txtTheLoai, txtSoLuong, txtTenTV, txtNgayTra;
	JButton btnDangKy, btnDanhSachKHDK, btnMenu;
	DanhSachBDThueDao bdThueDao;
	Font font = new Font("Times New Roman", Font.BOLD, 30);

	public FormThueDia() throws RemoteException, MalformedURLException, NotBoundException {
		super("Đăng ký thuê băng đĩa");

		bdThueDao = (DanhSachBDThueDao) Naming.lookup("rmi://192.168.1.107:1990/bdThueDao");

		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("ĐĂNG KÝ THUÊ BĂNG ĐĨA");
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		pnTitle.add(lblTitle);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout(FlowLayout.LEFT));

		lblID = new JLabel("ID:");
		lblMaBD = new JLabel("Mã băng đĩa:");
		lblTenBD = new JLabel("Tên băng đĩa:");
		lblMaTV = new JLabel("Mã thành viên:");
		lblTenTV = new JLabel("Tên thành viên:");
		lblNgayThue = new JLabel("Ngày thuê:");
		lblNgayTra = new JLabel("Ngày trả:");
		lblSoLuong = new JLabel("Số lượng:");
		lblTheLoai = new JLabel("Thể loại:");
		txtID = new JTextField(16);
		txtMaBD = new JTextField(16);
		txtMaTV = new JTextField(16);
		txtTenTV = new JTextField(16);
		txtNgayThue = new JTextField(16);
		txtNgayTra = new JTextField(16);
		txtSoLuong = new JTextField(16);
		txtTenBD = new JTextField(16);
		txtTheLoai = new JTextField(16);
		btnDangKy = new JButton("Đăng ký");
		btnMenu = new JButton("Menu");

		pnCenter.add(lblID);
		pnCenter.add(txtID);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblMaTV);
		pnCenter.add(txtMaTV);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblTenTV);
		pnCenter.add(txtTenTV);
		pnCenter.add(lblMaBD);
		pnCenter.add(txtMaBD);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblTenBD);
		pnCenter.add(txtTenBD);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblTheLoai);
		pnCenter.add(txtTheLoai);
		pnCenter.add(lblSoLuong);
		pnCenter.add(txtSoLuong);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblNgayThue);
		pnCenter.add(txtNgayThue);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblNgayTra);
		pnCenter.add(txtNgayTra);

		lblID.setPreferredSize(lblTenTV.getPreferredSize());
		lblMaBD.setPreferredSize(lblTenTV.getPreferredSize());
		lblNgayThue.setPreferredSize(lblTenTV.getPreferredSize());
		lblNgayTra.setPreferredSize(lblTenTV.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTenTV.getPreferredSize());
		lblTenBD.setPreferredSize(lblTenTV.getPreferredSize());
		lblTheLoai.setPreferredSize(lblTenTV.getPreferredSize());

		JPanel pnButton = new JPanel();
		btnDangKy = new JButton("Đăng ký");
		btnDanhSachKHDK = new JButton("Danh sách khách hàng đang thuê băng đĩa");
		pnButton.add(btnDangKy);
		pnButton.add(btnDanhSachKHDK);
		pnButton.add(btnMenu);

		add(pnTitle, BorderLayout.NORTH);
		add(pnCenter);
		add(pnButton, BorderLayout.SOUTH);

		btnDangKy.addActionListener(this);
		btnDanhSachKHDK.addActionListener(this);
		btnMenu.addActionListener(this);

		bdThueDao.getDSBangDia();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnDangKy)) {
			try {
				them();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (src.equals(btnDanhSachKHDK)) {
			setVisible(false);
			GiaoDienDSKHDangThueDia dSKHDangThueDia = null;
			try {
				dSKHDangThueDia = new GiaoDienDSKHDangThueDia();
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
			dSKHDangThueDia.setVisible(true);
		} else if (src.equals(btnMenu)) {
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
		String maTV = txtMaTV.getText();
		String tenTV = txtTenTV.getText();
		String maBD = txtMaBD.getText();
		String tenBD = txtTenBD.getText();
		String theLoai = txtTheLoai.getText();
		LocalDate ngayThue;
		try {
			int iD = Integer.parseInt(txtID.getText());
			if (iD < 0) {
				JOptionPane.showMessageDialog(this, "ID phải từ 0 trở đi!");
				txtID.selectAll();
				txtID.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ID phải là số nguyên!");
			txtID.selectAll();
			txtID.requestFocus();
			return false;
		}
		if (!(maTV.length() > 0 && maTV.matches("TV[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this,
					"Mã thành viên phải nhập theo định dạng TVXXX(3 ký số) và không được bỏ trống!");
			txtMaTV.selectAll();
			txtMaTV.requestFocus();
			return false;
		}
		if (!(tenTV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên không được bỏ trống!");
			txtTenTV.selectAll();
			txtTenTV.requestFocus();
			return false;
		}
		if (!(maBD.length() > 0 && maBD.matches("BD[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this,
					"Mã băng đĩa phải nhập theo định dạng BDXXX(3 ký số) và không được bỏ trống!");
			txtMaBD.selectAll();
			txtMaBD.requestFocus();
			return false;
		}
		if (!(tenBD.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên không được bỏ trống!");
			txtTenBD.selectAll();
			txtTenBD.requestFocus();
			return false;
		}
		if (!(theLoai.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Thể loại không được bỏ trống!");
			txtTheLoai.selectAll();
			txtTheLoai.requestFocus();
			return false;
		}
		try {
			int sL = Integer.parseInt(txtSoLuong.getText());
			if (sL < 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
				txtSoLuong.selectAll();
				txtSoLuong.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Số lượng phải là số!");
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return false;
		}
		try {
			ngayThue = LocalDate.parse(txtNgayThue.getText());
			if (!(ngayThue.isBefore(LocalDate.now()) || ngayThue.isEqual(LocalDate.now()))) {
				JOptionPane.showMessageDialog(this, "Ngày thuê phải trước hoặc là ngày hiện tại!");
				txtNgayThue.selectAll();
				txtNgayThue.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ngày phải nhập theo định dạng yyyy-mm-dd!");
			txtNgayThue.selectAll();
			txtNgayThue.requestFocus();
			return false;
		}
		try {
			LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText());
			if (!(ngayTra.isAfter(ngayThue) || ngayTra.isEqual(LocalDate.now()))) {
				JOptionPane.showMessageDialog(this, "Ngày trả phải sau ngày thuê hoặc là ngày hiện tại!");
				txtNgayTra.selectAll();
				txtNgayTra.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ngày phải nhập theo định dạng yyyy-mm-dd!");
			txtNgayTra.selectAll();
			txtNgayTra.requestFocus();
			return false;
		}
		return true;
	}

	private void them() throws HeadlessException, RemoteException {
		if (validData()) {
			int iD = Integer.parseInt(txtID.getText());
			String maTV = txtMaTV.getText();
			String tenTV = txtTenTV.getText();
			String maBD = txtMaBD.getText();
			String tenBD = txtTenBD.getText();
			String theLoai = txtTheLoai.getText();
			int sL = Integer.parseInt(txtSoLuong.getText());
			LocalDate ngayThue = LocalDate.parse(txtNgayThue.getText());
			LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText());
			BangDiaThue bDThue = new BangDiaThue(iD, maTV, tenTV, maBD, tenBD, theLoai, theLoai, sL, ngayThue, ngayTra,
					null, null, null);
			if (bdThueDao.addBangDiaThue(bDThue)) {
				bdThueDao.addBangDiaThue(bDThue);
				JOptionPane.showMessageDialog(this, "Đã lưu!");
			} else {
				JOptionPane.showMessageDialog(this, "Trùng ID!");
				txtID.selectAll();
				txtID.requestFocus();
			}
		}
	}

	private void menu() throws MalformedURLException, RemoteException, NotBoundException {
		setVisible(false);
		new Menu().setVisible(true);
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		new FormThueDia();
	}
}