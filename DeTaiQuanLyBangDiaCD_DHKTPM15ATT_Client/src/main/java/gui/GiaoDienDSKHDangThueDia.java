package gui;

import dao.*;
import entity.*;

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
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GiaoDienDSKHDangThueDia extends JFrame implements ActionListener, MouseListener {
	JLabel lblID, lblMaTV, lblTenTV, lblTenBD, lblMaBD, lblTheLoai, lblSL, lblNgayTra, lblNgayThue, lblTitle;
	JTextField txtID, txtNgayThue, txtMaTV, txtMaBD, txtTenBD, txtTheLoai, txtSL, txtTenTV, txtNgayTra;
	JButton btnDangKy, btnSua, btnXoa, btnXoaTrang, btnLuu, btnMenu;
	JTable tbl;
	DefaultTableModel tblmdel;
	Font font = new Font("Times New Roman", Font.BOLD, 30);
	DanhSachBDThueDao bdThueDao;

	public GiaoDienDSKHDangThueDia() throws MalformedURLException, RemoteException, NotBoundException {
		super("DANH SÁCH KHÁCH HÀNG ĐANG THUÊ BĂNG ĐĨA");

		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("DANH SÁCH KHÁCH HÀNG ĐANG THUÊ BĂNG ĐĨA");
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		pnTitle.add(lblTitle);
		bdThueDao = (DanhSachBDThueDao) Naming.lookup("rmi://192.168.1.107:1990/bdThueDao");
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblID = new JLabel("ID:");
		lblMaBD = new JLabel("Mã băng đĩa:");
		lblTenBD = new JLabel("Tên băng đĩa:");
		lblMaTV = new JLabel("Mã thành viên:");
		lblTenTV = new JLabel("Tên thành viên:");
		lblNgayThue = new JLabel("Ngày thuê:");
		lblNgayTra = new JLabel("Ngày trả:");
		lblSL = new JLabel("Số lượng:");
		lblTheLoai = new JLabel("Thể loại:");
		txtID = new JTextField(16);
		txtMaBD = new JTextField(16);
		txtMaTV = new JTextField(16);
		txtTenTV = new JTextField(16);
		txtNgayThue = new JTextField(16);
		txtNgayTra = new JTextField(16);
		txtSL = new JTextField(16);
		txtTenBD = new JTextField(16);
		txtTheLoai = new JTextField(16);

		btnDangKy = new JButton("Đăng ký");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xoá");
		btnXoaTrang = new JButton("Xoá trắng");
		btnLuu = new JButton("Lưu");
		btnMenu = new JButton("Menu");

		String[] col = { "ID", "Mã thành viên", "Mã băng đĩa", "Tên thành viên", "Tên băng đĩa", "Thể loại", "Số lượng",
				"Ngày thuê", "Ngày trả" };
		tblmdel = new DefaultTableModel(col, 0);
		tbl = new JTable(tblmdel);
		tbl.setRowHeight(20);
		JScrollPane scrolltbl = new JScrollPane(tbl);
		scrolltbl.setPreferredSize(new Dimension(880, 300));

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
		pnCenter.add(lblSL);
		pnCenter.add(txtSL);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblNgayThue);
		pnCenter.add(txtNgayThue);
		pnCenter.add(Box.createHorizontalStrut(15));
		pnCenter.add(lblNgayTra);
		pnCenter.add(txtNgayTra);
		pnCenter.add(scrolltbl);
		pnCenter.add(Box.createVerticalStrut(50));
		pnCenter.add(btnDangKy);
		pnCenter.add(btnSua);
		pnCenter.add(btnXoa);
		pnCenter.add(btnXoaTrang);
		pnCenter.add(btnLuu);
		pnCenter.add(btnMenu);

		lblID.setPreferredSize(lblTenTV.getPreferredSize());
		lblMaBD.setPreferredSize(lblTenTV.getPreferredSize());
		lblNgayThue.setPreferredSize(lblTenTV.getPreferredSize());
		lblNgayTra.setPreferredSize(lblTenTV.getPreferredSize());
		lblSL.setPreferredSize(lblTenTV.getPreferredSize());
		lblTenBD.setPreferredSize(lblTenTV.getPreferredSize());
		lblTheLoai.setPreferredSize(lblTenTV.getPreferredSize());

		add(pnTitle, BorderLayout.NORTH);
		add(pnCenter);

		btnDangKy.addActionListener(this);
		btnLuu.addActionListener(this);
		btnMenu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tbl.addMouseListener(this);

		hienLenTable();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void hienLenTable() throws MalformedURLException, RemoteException, NotBoundException {
		DanhSachBDThueDao bdThueDao = (DanhSachBDThueDao) Naming.lookup("rmi://192.168.1.107:1990/bdThueDao");
		for (BangDiaThue bangDiaThue : bdThueDao.getDSBangDia()) {
			String[] row = { bangDiaThue.getiD() + "", bangDiaThue.getMaThanhVien(), bangDiaThue.getMaCD(),
					bangDiaThue.getTenThanhVien(), bangDiaThue.getTenCD(), bangDiaThue.getTheLoai(),
					bangDiaThue.getSoLuong() + "", bangDiaThue.getNgayThue() + "", bangDiaThue.getNgayTra() + "" };
			tblmdel.addRow(row);
		}
	}

	public void mouseClicked(MouseEvent e) {
		txtID.setEditable(false);
		int row = tbl.getSelectedRow();
		if (row != -1) {
			txtID.setText((String) tbl.getValueAt(row, 0));
			txtMaTV.setText((String) tbl.getValueAt(row, 1));
			txtMaBD.setText((String) tbl.getValueAt(row, 2));
			txtTenTV.setText((String) tbl.getValueAt(row, 3));
			txtTenBD.setText((String) tbl.getValueAt(row, 4));
			txtTheLoai.setText((String) tbl.getValueAt(row, 5));
			txtSL.setText((String) tbl.getValueAt(row, 6));
			txtNgayThue.setText((String) tbl.getValueAt(row, 7));
			txtNgayTra.setText((String) tbl.getValueAt(row, 8));
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnDangKy)) {
			FormThueDia fTD = null;
			try {
				fTD = new FormThueDia();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fTD.setVisible(true);
			setVisible(false);
		} else if (src.equals(btnSua))
			try {
				sua();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (src.equals(btnXoa))
			try {
				xoa();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (src.equals(btnXoaTrang))
			xoaTrang();
		/*
		 * else if (src.equals(btnLuu)) luu();
		 */
		else if (src.equals(btnMenu))
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
			int sL = Integer.parseInt(txtSL.getText());
			if (sL < 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
				txtSL.selectAll();
				txtSL.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên!");
			txtSL.selectAll();
			txtSL.requestFocus();
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

	private void sua() throws HeadlessException, RemoteException {
		int row = tbl.getSelectedRow();
		if (row != -1) {
			if (validData()) {
				int iD = Integer.parseInt(txtID.getText().trim());
				String tenTV = txtTenTV.getText();
				String maTV = txtMaTV.getText();
				String maBD = txtMaBD.getText();
				String tenBD = txtTenBD.getText();
				String theLoai = txtTheLoai.getText();
				int sL = Integer.parseInt(txtSL.getText().trim());
				LocalDate ngayThue = LocalDate.parse(txtNgayThue.getText());
				LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText());
				BangDiaThue bDThueNew = new BangDiaThue(iD, maTV, tenTV, maBD, tenBD, tenBD, theLoai, sL, ngayThue, ngayTra, null, null, null);
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật lại không", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					if (bdThueDao.updateBDT(bDThueNew)) {
						tbl.setValueAt(maTV, row, 1);
						tbl.setValueAt(maBD, row, 2);
						tbl.setValueAt(tenTV, row, 3);
						tbl.setValueAt(tenBD, row, 4);
						tbl.setValueAt(theLoai, row, 5);
						tbl.setValueAt(sL, row, 6);
						tbl.setValueAt(ngayThue, row, 7);
						tbl.setValueAt(ngayTra, row, 8);
						JOptionPane.showMessageDialog(this, "Đã sửa thành công!");
					} else
						JOptionPane.showMessageDialog(this, "Không sửa được!");
				}
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng cần sửa!");
	}

	private void xoa() throws HeadlessException, RemoteException {
		int row = tbl.getSelectedRow();
		if (row != -1) {
			int iD = Integer.parseInt(txtID.getText().trim());
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá không?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				if (bdThueDao.deleteBDT(iD)) {
					tblmdel.removeRow(row);
					JOptionPane.showMessageDialog(this, "Đã xoá thành công!");
				} else
					JOptionPane.showMessageDialog(this, "Xoá thất bại!");
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng cần xoá!");
	}

	private void xoaTrang() {
		tbl.clearSelection();
		txtID.setEditable(true);
		txtID.setText("");
		txtNgayThue.setText("");
		txtTenBD.setText("");
		txtMaBD.setText("");
		txtMaTV.setText("");
		txtNgayTra.setText("");
		txtSL.setText("");
		txtTenTV.setText("");
		txtTheLoai.setText("");
	}
	/*
	 * private void luu() { if (bdThueDao.luuDatabase())
	 * JOptionPane.showMessageDialog(this, "Đã lưu!"); else
	 * JOptionPane.showMessageDialog(this, "Không lưu được!"); }
	 */

	private void menu() throws MalformedURLException, RemoteException, NotBoundException {
		setVisible(false);
		new Menu().setVisible(true);
	}
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		new GiaoDienDSKHDangThueDia();
	}
}