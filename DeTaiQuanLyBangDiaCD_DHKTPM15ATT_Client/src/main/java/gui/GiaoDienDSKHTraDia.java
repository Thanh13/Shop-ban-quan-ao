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
import java.time.LocalDate;

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

import dao.DanhSachBDTraDao;
import entity.BangDiaTra;
import entity.ThanhVien;

public class GiaoDienDSKHTraDia extends JFrame implements ActionListener, MouseListener {
	JLabel lblTitle, lblID, lblTenTV, lblMaTV, lblMaBD, lblSL, lblThanhTien, lblPhiTraThem, lblNgayTra, lblGhiChu,
			lblMaNV;
	JTextField txtID, txtTenTV, txtMaTV, txtMaBD, txtSL, txtThanhTien, txtPhiTraThem, txtNgayTra, txtGhiChu, txtMaNV;
	JButton btnThem, btnSua, btnXoa, btnXoaTrang, btnLuu, btnDSKHQuaHanTraDia, btnTongDoanhThu, btnMenu;
	DefaultTableModel tblmdl;
	JTable tbl;
	DanhSachBDTraDao bdTraDao;
	Font font = new Font("Times New Roman", Font.BOLD, 30);

	public GiaoDienDSKHTraDia() throws MalformedURLException, RemoteException, NotBoundException {
		super("Danh sách khách hàng đã trả đĩa");

		bdTraDao = (DanhSachBDTraDao) Naming.lookup("rmi://192.168.1.107:1990/bdTraDao");

		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("DANH SÁCH KHÁCH HÀNG ĐÃ TRẢ ĐĨA");
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		pnTitle.add(lblTitle);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblID = new JLabel("ID:");
		txtID = new JTextField(20);
		lblMaNV = new JLabel("Mã nhân viên:");
		txtMaNV = new JTextField(20);
		lblTenTV = new JLabel("Tên thành viên:");
		txtTenTV = new JTextField(20);
		lblMaTV = new JLabel("Mã thành viên:");
		txtMaTV = new JTextField(20);
		lblMaBD = new JLabel("Mã băng đĩa:");
		txtMaBD = new JTextField(20);
		lblSL = new JLabel("Số lượng:");
		txtSL = new JTextField(20);
		lblThanhTien = new JLabel("Thành tiền:");
		txtThanhTien = new JTextField(20);
		lblPhiTraThem = new JLabel("Phí trả thêm:");
		txtPhiTraThem = new JTextField(20);
		lblNgayTra = new JLabel("Ngày trả:");
		txtNgayTra = new JTextField(20);
		lblGhiChu = new JLabel("Ghi chú:");
		txtGhiChu = new JTextField(20);
		String[] col = { "ID", "Mã nhân viên", "Tên thành viên", "Mã thành viên", "Mã băng đĩa", "Số lượng",
				"Thành tiền", "Phí trả thêm", "Ngày trả", "Ghi chú" };
		tblmdl = new DefaultTableModel(col, 0);
		tbl = new JTable(tblmdl);
		tbl.setRowHeight(20);
		JScrollPane scrollTbl = new JScrollPane(tbl);
		scrollTbl.setPreferredSize(new Dimension(880, 300));
		btnDSKHQuaHanTraDia = new JButton("Danh sách khách hàng quá hạn trả đĩa");
		btnTongDoanhThu = new JButton("Tổng doanh thu");
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xoá");
		btnXoaTrang = new JButton("Xoá rỗng");
		btnLuu = new JButton("Lưu");
		btnMenu = new JButton("Menu");
		pnCenter.add(lblID);
		pnCenter.add(txtID);
		pnCenter.add(Box.createHorizontalStrut(5));
		pnCenter.add(lblMaNV);
		pnCenter.add(txtMaNV);
		pnCenter.add(Box.createHorizontalStrut(5));
		pnCenter.add(lblTenTV);
		pnCenter.add(txtTenTV);
		pnCenter.add(lblMaTV);
		pnCenter.add(txtMaTV);
		pnCenter.add(Box.createHorizontalStrut(5));
		pnCenter.add(lblMaBD);
		pnCenter.add(txtMaBD);
		pnCenter.add(Box.createHorizontalStrut(5));
		pnCenter.add(lblSL);
		pnCenter.add(txtSL);
		pnCenter.add(lblThanhTien);
		pnCenter.add(txtThanhTien);
		pnCenter.add(Box.createHorizontalStrut(5));
		pnCenter.add(lblPhiTraThem);
		pnCenter.add(txtPhiTraThem);
		pnCenter.add(Box.createHorizontalStrut(5));
		pnCenter.add(lblNgayTra);
		pnCenter.add(txtNgayTra);
		pnCenter.add(lblGhiChu);
		pnCenter.add(txtGhiChu);
		pnCenter.add(scrollTbl);
		pnCenter.add(Box.createVerticalStrut(100));
		pnCenter.add(btnDSKHQuaHanTraDia);
		pnCenter.add(btnTongDoanhThu);
		pnCenter.add(Box.createHorizontalStrut(50));
		pnCenter.add(btnThem);
		pnCenter.add(btnSua);
		pnCenter.add(btnXoa);
		pnCenter.add(btnXoaTrang);
		pnCenter.add(btnLuu);
		pnCenter.add(btnMenu);

		lblID.setPreferredSize(lblTenTV.getPreferredSize());
		lblMaNV.setPreferredSize(lblTenTV.getPreferredSize());
		lblGhiChu.setPreferredSize(lblTenTV.getPreferredSize());
		lblMaBD.setPreferredSize(lblTenTV.getPreferredSize());
		lblNgayTra.setPreferredSize(lblTenTV.getPreferredSize());
		lblPhiTraThem.setPreferredSize(lblTenTV.getPreferredSize());
		lblSL.setPreferredSize(lblTenTV.getPreferredSize());
		lblThanhTien.setPreferredSize(lblTenTV.getPreferredSize());

		add(pnTitle, BorderLayout.NORTH);
		add(pnCenter);

		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnMenu.addActionListener(this);
		btnDSKHQuaHanTraDia.addActionListener(this);
		btnTongDoanhThu.addActionListener(this);
		tbl.addMouseListener(this);

		hienLenTable();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void hienLenTable() throws MalformedURLException, RemoteException, NotBoundException {
		DanhSachBDTraDao bdTraDao = (DanhSachBDTraDao) Naming.lookup("rmi://192.168.1.107:1990/bdTraDao");
		for (BangDiaTra bangDiaTra : bdTraDao.getDSBangDia()) {
			String[] row = { bangDiaTra.getiD() + "", bangDiaTra.getMaNV(), bangDiaTra.getTenTV(), bangDiaTra.getMaTV(),
					bangDiaTra.getMaCD(), bangDiaTra.getsL() + "", bangDiaTra.getThanhTien() + "",
					bangDiaTra.getPhiTraThem() + "", bangDiaTra.getNgayTra() + "", bangDiaTra.getGhiChu() };
			tblmdl.addRow(row);
		}
	}

	
	public void mouseClicked(MouseEvent e) {
		txtID.setEditable(false);
		int row = tbl.getSelectedRow();
		if (row != -1) {
			txtID.setText((String) tbl.getValueAt(row, 0));
			txtMaNV.setText((String) tbl.getValueAt(row, 1));
			txtTenTV.setText((String) tbl.getValueAt(row, 2));
			txtMaTV.setText((String) tbl.getValueAt(row, 3));
			txtMaBD.setText((String) tbl.getValueAt(row, 4));
			txtSL.setText((String) tbl.getValueAt(row, 5));
			txtThanhTien.setText((String) tbl.getValueAt(row, 6));
			txtPhiTraThem.setText((String) tbl.getValueAt(row, 7));
			txtNgayTra.setText((String) tbl.getValueAt(row, 8));
			txtGhiChu.setText((String) tbl.getValueAt(row, 9));
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
		if (src.equals(btnThem))
			try {
				them();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (src.equals(btnSua))
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
		String tenTV = txtTenTV.getText();
		String maTV = txtMaTV.getText();
		String maBD = txtMaBD.getText();
		String maNV = txtMaNV.getText();
		String ghiChu = txtGhiChu.getText();
		if (!(ghiChu.equals("Trả muộn") || ghiChu.length() == 0)) {
			JOptionPane.showMessageDialog(this, "Ghi chú chỉ được nhập trả muộn hoặc để trống!");
			txtGhiChu.selectAll();
			txtGhiChu.requestFocus();
			return false;
		}
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
		if (!(tenTV.length() > 0 && tenTV.matches("^[A-Z].+([A-Z].*[A-Z].)*"))) {
			JOptionPane.showMessageDialog(this,
					"Tên không được bỏ trống, chữ cái đầu phải viết hoa và phải nhập đầy đủ họ tên!");
			txtTenTV.selectAll();
			txtTenTV.requestFocus();
			return false;
		}
		if (!(maTV.length() > 0 && maTV.matches("TV[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this,
					"Mã thành viên phải nhập theo định dạng TVXXX(3 ký số) và không được bỏ trống!");
			txtMaTV.selectAll();
			txtMaTV.requestFocus();
			return false;
		}
		if (!(maBD.length() > 0 && maBD.matches("BD[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this,
					"Mã băng đĩa phải nhập theo định dạng BDXXX(3 ký số) và không được bỏ trống!");
			txtMaBD.selectAll();
			txtMaBD.requestFocus();
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
			JOptionPane.showMessageDialog(this, "Số lượng phải là số!");
			txtSL.selectAll();
			txtSL.requestFocus();
			return false;
		}
		try {
			double thanhTien = Double.parseDouble(txtThanhTien.getText());
			if (thanhTien < 0) {
				JOptionPane.showMessageDialog(this, "Số tiền phải lớn hơn 0!");
				txtThanhTien.selectAll();
				txtThanhTien.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Tiền phải là số!");
			txtThanhTien.selectAll();
			txtThanhTien.requestFocus();
			return false;
		}
		try {
			double phiTraThem = Double.parseDouble(txtPhiTraThem.getText());
			if (phiTraThem < 0) {
				JOptionPane.showMessageDialog(this, "Số tiền phải lớn hơn 0!");
				txtPhiTraThem.selectAll();
				txtPhiTraThem.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Tiền phải là số!");
			txtPhiTraThem.selectAll();
			txtPhiTraThem.requestFocus();
			return false;
		}
		try {
			LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText());
			if (!(ngayTra.isBefore(LocalDate.now()) || ngayTra.isEqual(LocalDate.now()))) {
				JOptionPane.showMessageDialog(this, "Ngày trả phải trước hoặc là ngày hiện tại!");
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
		if (!(maNV.length() > 0 && maNV.matches("NV[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this,
					"Mã nhân viên phải nhập theo định dạng NVXXX(3 ký số) và không được bỏ trống!");
			txtMaNV.selectAll();
			txtMaNV.requestFocus();
			return false;
		}
		return true;
	}

	private void them() throws HeadlessException, RemoteException {
		if (validData()) {
			int iD = Integer.parseInt(txtID.getText());
			String tenTV = txtTenTV.getText();
			String maTV = txtMaTV.getText();
			String maBD = txtMaBD.getText();
			String maNV = txtMaNV.getText();
			int sL = Integer.parseInt(txtSL.getText());
			double thanhTien = Double.parseDouble(txtThanhTien.getText());
			double phiTraThem = Double.parseDouble(txtPhiTraThem.getText());
			LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText());
			String ghiChu = txtGhiChu.getText();
			String nhavie=null;
			String thanhvien=null;
			String thongtin=null;
			BangDiaTra bDT = new BangDiaTra(iD, tenTV, maTV, maBD, maNV, sL, thanhTien, phiTraThem, ngayTra, ghiChu, null, null, null);
			if (bdTraDao.addBangDiaThue(bDT)) {
				String[] row = { bDT.getiD() + "", bDT.getMaNV(), bDT.getTenTV(), bDT.getMaTV(), bDT.getMaCD(),
						bDT.getsL() + "", bDT.getThanhTien() + "", bDT.getPhiTraThem() + "", bDT.getNgayTra() + "",
						bDT.getGhiChu() };
				tblmdl.addRow(row);
			} else {
				JOptionPane.showMessageDialog(this, "Trùng ID!");
				txtID.selectAll();
				txtID.requestFocus();
			}
		}
	}

	private void sua() throws HeadlessException, RemoteException {
		int row = tbl.getSelectedRow();
		if (row != -1) {
			if (validData()) {
				int iD = Integer.parseInt(txtID.getText());
				String tenTV = txtTenTV.getText();
				String maTV = txtMaTV.getText();
				String maBD = txtMaBD.getText();
				String maNV = txtMaNV.getText();
				int sL = Integer.parseInt(txtSL.getText());
				double thanhTien = Double.parseDouble(txtThanhTien.getText());
				double phiTraThem = Double.parseDouble(txtPhiTraThem.getText());
				LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText());
				String ghiChu = txtGhiChu.getText();
				BangDiaTra bDTNew = new BangDiaTra(iD, tenTV, maTV, maBD, maNV, sL, thanhTien, phiTraThem, ngayTra, ghiChu, null, null, null);
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật lại không", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					if (bdTraDao.updateBDTra(bDTNew)) {
						tbl.setValueAt(maNV, row, 1);
						tbl.setValueAt(tenTV, row, 2);
						tbl.setValueAt(maTV, row, 3);
						tbl.setValueAt(maBD, row, 4);
						tbl.setValueAt(sL, row, 5);
						tbl.setValueAt(thanhTien, row, 6);
						tbl.setValueAt(phiTraThem, row, 7);
						tbl.setValueAt(ngayTra, row, 8);
						tbl.setValueAt(ghiChu, row, 9);
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
			int iD = Integer.parseInt(tbl.getValueAt(row, 0).toString().trim());
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá không?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				if (bdTraDao.deleteBDTra(iD)) {
					tblmdl.removeRow(row);
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
		txtMaNV.setText("");
		txtGhiChu.setText("");
		txtID.setText("");
		txtMaBD.setText("");
		txtMaTV.setText("");
		txtNgayTra.setText("");
		txtPhiTraThem.setText("");
		txtSL.setText("");
		txtTenTV.setText("");
		txtThanhTien.setText("");
	}

//	private void luu() {
//		if(dSBDTra.luuDatabase()) 
//			JOptionPane.showMessageDialog(this, "Đã lưu!");
//		else
//			JOptionPane.showMessageDialog(this, "Không lưu được!");
//	}

//	private void tongDoanhThu() {
//		double tongDoanhThu=dSBDTra.tongDoanhThu();
//		JOptionPane.showMessageDialog(this, "Tổng doanh thu: "+tongDoanhThu);
//	}

//	private void dSKHQuaHanTraDia() {
//		new GDDSKHQuaHanThue(dSBDTra.dSKHQuaHanTraDia()).setVisible(true);
//		setVisible(false);
//	}

	private void menu() throws MalformedURLException, RemoteException, NotBoundException {
		setVisible(false);
		new Menu().setVisible(true);
	}
}