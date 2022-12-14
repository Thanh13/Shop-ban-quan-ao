package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DanhSachThanhVienDao;
import entity.ThanhVien;

public class DanhSachThanhVien extends JFrame implements ActionListener, MouseListener {
	JLabel lbltitle, lblten, lbltinh, lblsdt, lbldiachi, lblthu, lblma, lblhokhau, lbltim;
	JTextField txtten, txttinh, txtsdt, txtdiachi, txtthu, txtma, txthokhau, txttim;
	JButton btndem, btnsua, btnxoa, btnluu, btnxoatrang, btnMenu, btnthem, btntim;
	JTable table;
	DefaultTableModel tableModel;
	JScrollPane scrollPane;
	JSplitPane splitPane;
	DanhSachThanhVienDao danhSachThanhVienDao;
	List<ThanhVien> tv;
	FormTaoThanhVien a;

	public DanhSachThanhVien() throws MalformedURLException, RemoteException, NotBoundException {
		super("Danh Sách Thành Viên");
		danhSachThanhVienDao = (DanhSachThanhVienDao) Naming.lookup("rmi://192.168.1.107:1990/danhSachThanhVienDao");
		JPanel p1 = new JPanel();
		p1.add(lbltitle = new JLabel("Danh Sách Thành Viên"));
		Font fb = new Font("Arial", Font.BOLD, 35);
		lbltitle.setFont(fb);
		lbltitle.setForeground(Color.BLUE);
		add(p1, BorderLayout.NORTH);
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel pcen = new JPanel();
		pcen.setLayout(new BoxLayout(pcen, BoxLayout.Y_AXIS));
		String col[] = { "Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ", "CMND" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);

		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(850, 200));
		table.addMouseListener(this);
		p4.add(scrollPane);
		p4.add(lblma = new JLabel("Mã khách hàng"));
		p4.add(txtma = new JTextField(30));
		p4.add(lblthu = new JLabel("Nhập CMND"));
		p4.add(txtthu = new JTextField(30));
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(lblten = new JLabel("Nhập tên bạn"));
		p4.add(txtten = new JTextField(30));

		p4.add(lbltinh = new JLabel("Giới Tính"));
		p4.add(txttinh = new JTextField(30));
		p4.add(lblsdt = new JLabel("Nhập SĐT"));
		p4.add(txtsdt = new JTextField(30));
		p4.add(lbldiachi = new JLabel("Địa chỉ"));
		p4.add(txtdiachi = new JTextField(30));
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pcen.add(p4);
		add(pcen, BorderLayout.CENTER);
		splitPane = new JSplitPane();
		JPanel pso = new JPanel();
		pso.add(lbltim = new JLabel("Tìm thành viên"));
		pso.add(txttim = new JTextField(10));
		pso.add(btntim = new JButton("Tìm"));
		add(pso, BorderLayout.SOUTH);
		splitPane.setLeftComponent(pso);
		JPanel pco = new JPanel();
		pco.add(btnthem = new JButton("Thêm"));
		pco.add(btnxoa = new JButton("Xóa"));
		pco.add(btnxoatrang = new JButton("Xóa trắng"));
		pco.add(btnluu = new JButton("Lưu"));
		pco.add(btnsua = new JButton("Sửa"));
		pco.add(btnMenu = new JButton("Menu"));

		add(pco, BorderLayout.SOUTH);
		splitPane.setRightComponent(pco);
		add(splitPane, BorderLayout.SOUTH);
		btnluu.addActionListener(this);
		btnsua.addActionListener(this);
		btnxoa.addActionListener(this);
		btnxoatrang.addActionListener(this);
		btnMenu.addActionListener(this);
		btnthem.addActionListener(this);
		btntim.addActionListener(this);
		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		lbltinh.setPreferredSize(lblthu.getPreferredSize());
		lbldiachi.setPreferredSize(lbltinh.getPreferredSize());
		lblten.setPreferredSize(lblma.getPreferredSize());
		lblsdt.setPreferredSize(lblten.getPreferredSize());

		updateTableData();
	}

	public void mouseClicked(MouseEvent e) {
		txtma.setEditable(false);
		int row = table.getSelectedRow();
		if (row != -1) {
			txtma.setText((String) table.getValueAt(row, 0));
			txtten.setText((String) table.getValueAt(row, 1));
			txttinh.setText((String) table.getValueAt(row, 2));
			txtsdt.setText((String) table.getValueAt(row, 3));
			txtdiachi.setText((String) table.getValueAt(row, 4));
			txtthu.setText((String) table.getValueAt(row, 5));
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
		Object o = e.getSource();
		if (o.equals(btnMenu)) {
			dispose();
			try {
				new Menu().setVisible(true);
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
		if (o.equals(btnthem)) {
			try {
				new FormTaoThanhVien().setVisible(true);
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
			setVisible(false);
		} else if (o.equals(btnluu)) {
			try {
				int row = table.getSelectedRow();
				String ma = txtma.getText();
				String ten = txtten.getText();
				String gioitinh = txttinh.getText();
				String sodienthoai = txtsdt.getText();
				String diachi = txtdiachi.getText();
				String chungminh = txtthu.getText();
				ThanhVien p = new ThanhVien(ma, ten, gioitinh, sodienthoai, diachi, chungminh);
				if (row > 0) {

					if (danhSachThanhVienDao.updateTV(p)) {
						table.setValueAt(txtten.getText(), row, 1);
						table.setValueAt(txttinh.getText(), row, 2);
						table.setValueAt(txtsdt.getText(), row, 3);
						table.setValueAt(txtdiachi.getText(), row, 4);
						table.setValueAt(txtthu.getText(), row, 5);
						JOptionPane.showMessageDialog(this, "Lưu thành công nhé!");
					} else {
						JOptionPane.showMessageDialog(this, "Lưu bị thất bại rồi!!");
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		} else if (o.equals(btnsua)) {
			try {
				int row = table.getSelectedRow();
				String ma = txtma.getText();
				String ten = txtten.getText();
				String gioitinh = txttinh.getText();
				String sodienthoai = txtsdt.getText();
				String diachi = txtdiachi.getText();
				String chungminh = txtthu.getText();
				ThanhVien p = new ThanhVien(ma, ten, gioitinh, sodienthoai, diachi, chungminh);
				if (row > 0) {

					if (danhSachThanhVienDao.updateTV(p)) {
						table.setValueAt(txtten.getText(), row, 1);
						table.setValueAt(txttinh.getText(), row, 2);
						table.setValueAt(txtsdt.getText(), row, 3);
						table.setValueAt(txtdiachi.getText(), row, 4);
						table.setValueAt(txtthu.getText(), row, 5);
						JOptionPane.showMessageDialog(this, "Sửa thành công nhé!");
					} else {
						JOptionPane.showMessageDialog(this, "Sửa bị thất bại rồi!!");
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		} else if (o.equals(btnxoa)) {
			try {
				int row = table.getSelectedRow();
				if (row > 0) {
					String ma = (String) table.getValueAt(row, 0);
					if (danhSachThanhVienDao.deleteTV(ma)) {
						tableModel.removeRow(row);
						xoatrang();
					}
					JOptionPane.showMessageDialog(this, "Xóa thành công!!");

				}
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(this, "Xóa thất bại nhé!!");
			}
		}
		if (o.equals(btnxoatrang)) {
			xoatrang();
			JOptionPane.showMessageDialog(this, "Đã xóa xong!!");
		}

		if (o.equals(btntim)) {
			DanhSachThanhVienDao danhSachThanhVienDao = null;
			try {
				danhSachThanhVienDao = (DanhSachThanhVienDao) Naming
						.lookup("rmi://192.168.1.107:1990/danhSachThanhVienDao");
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
			ThanhVien list = null;
			try {
				list = (ThanhVien) danhSachThanhVienDao.getThanhVienTheoMa(txtma.getText());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (txtma.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập dữ liệu");
			} else if (list == null)
				JOptionPane.showMessageDialog(this, "Không tìm thấy hỏi hỏi???");
			else {
				
				tableModel.getDataVector().removeAllElements();
					String[] row = { list.getMaThanhVien(), list.getHoTenThanhVien(), list.getGioiTinh(),
							list.getSoDienThoai(), list.getDiaChi(), list.getCnThu() };
					tableModel.addRow(row);
				
				table.setModel(tableModel);
			}

		}

	}

	private void xoatrang() {
		table.clearSelection();
		txtma.setEditable(true);
		txtten.setText("");
		txtma.setText("");
		txtsdt.setText("");
		txtthu.setText("");
		txttinh.setText("");
		txtdiachi.setText("");
		txtma.requestFocus();
		txtma.selectAll();
	}

	private void updateTableData() throws MalformedURLException, RemoteException, NotBoundException {
		DanhSachThanhVienDao danhSachThanhVienDao = (DanhSachThanhVienDao) Naming
				.lookup("rmi://192.168.1.107:1990/danhSachThanhVienDao");
		for (ThanhVien thanhVien : danhSachThanhVienDao.getDSKhachHang()) {
			String[] row = { thanhVien.getMaThanhVien(), thanhVien.getHoTenThanhVien(), thanhVien.getGioiTinh(),
					thanhVien.getSoDienThoai(), thanhVien.getDiaChi(), thanhVien.getCnThu() };
			tableModel.addRow(row);
		}
		table.setModel(tableModel);

	}
}