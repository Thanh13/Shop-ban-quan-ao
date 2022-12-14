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
import java.util.List;

import javax.swing.BorderFactory;
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

import dao.DanhSachThongTinCDDao;
import entity.ThongTinCD;

public class KeBangDia extends JFrame implements ActionListener, MouseListener {
	private double donGia;
	JLabel lblTitle, lblma, lblten, lbltinhtrang, lblsoluong, lblhangsx, lblghichu, lbltheloai, lbldongia;
	JTextField txtma, txtten, txttinhtrang, txtsoluong, txthangsx, txtghichu, txttheloai, txtdongia;
	JButton btnthem, btnsua, btnxoa, btnxoatrang, btnluu, btnsoluongcd, btncdondinh, btncdhu, btnMenu;
	JScrollPane scrollPane = new JScrollPane();
	JTable table;
	DanhSachThongTinCDDao cdDao;
	DefaultTableModel tableModel;
	JSplitPane splitPane;
	List<ThongTinCD> cd;
	LocCDHu a;
	DanhSachCDOnDinh b;

	public KeBangDia() throws MalformedURLException, RemoteException, NotBoundException {
		super("Ke Bang Dia!!!");
		cdDao = (DanhSachThongTinCDDao) Naming.lookup("rmi://192.168.1.107:1990/cdDao");
		JPanel p1 = new JPanel();
		p1.add(lblTitle = new JLabel("Kệ băng đĩa cd "));
		Font fb = new Font("Arial", Font.BOLD, 36);
		lblTitle.setFont(fb);
		lblTitle.setForeground(Color.BLUE);
		add(p1, BorderLayout.NORTH);
		JPanel pcen = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		pcen.setLayout(new BoxLayout(pcen, BoxLayout.Y_AXIS));
		String col[] = { "Mã băng đĩa", "Tên băng đĩa", "Thể loai", "Tình trạng băng đĩa", "Hãng sản xuất", "Ghi chú",
				"Đơn giá", "Số lượng" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.addMouseListener(this);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(850, 300));
		p2.add(scrollPane);
		p2.add(lblma = new JLabel("Mã CD"));
		p2.add(txtma = new JTextField(30));
		p2.add(lblten = new JLabel("Tên CD"));
		p2.add(txtten = new JTextField(30));

		p2.add(lblhangsx = new JLabel("Hãng sản xuất CD"));
		p2.add(txthangsx = new JTextField(30));
		p2.add(lblsoluong = new JLabel("Số lượng"));
		p2.add(txtsoluong = new JTextField(30));

		p2.add(lbltheloai = new JLabel("Thể loại CD"));
		p2.add(txttheloai = new JTextField(30));

		p2.add(lbldongia = new JLabel("'Đơn giá"));
		p2.add(txtdongia = new JTextField(30));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(lbltinhtrang = new JLabel("Tình Trạng CD"));
		p2.add(txttinhtrang = new JTextField(30));

		p2.add(lblghichu = new JLabel("Ghi chú"));
		p2.add(txtghichu = new JTextField(30));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pcen.add(p2);
		lblma.setPreferredSize(lblhangsx.getPreferredSize());
		lbltheloai.setPreferredSize(lblma.getPreferredSize());
		lbltinhtrang.setPreferredSize(lbltheloai.getPreferredSize());
		lblten.setPreferredSize(lblsoluong.getPreferredSize());
		lbldongia.setPreferredSize(lblten.getPreferredSize());
		lblghichu.setPreferredSize(lbldongia.getPreferredSize());

		add(pcen, BorderLayout.CENTER);
		JPanel psouth = new JPanel();
//		splitPane = new JSplitPane();
		psouth.add(btncdondinh = new JButton("Lọc CD ổn định"));
		psouth.add(btncdhu = new JButton("Lọc CD Hư"));
//		add(psouth, BorderLayout.SOUTH);
//		splitPane.setLeftComponent(psouth);
		JPanel right = new JPanel();
		right.add(btnthem = new JButton("Thêm"));
		right.add(btnsua = new JButton("Sửa"));
		right.add(btnxoa = new JButton("Xóa"));
		right.add(btnxoatrang = new JButton("Xóa trắng"));
		right.add(btnluu = new JButton("Lưu"));
		right.add(btnMenu = new JButton("Menu"));
		add(right, BorderLayout.SOUTH);
//		splitPane.setRightComponent(right);
//		add(splitPane, BorderLayout.SOUTH);
		JPanel sd = new JPanel();
//		splitPane.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ tùy chọn:"));
		btncdhu.addActionListener(this);
		btncdondinh.addActionListener(this);
		btnluu.addActionListener(this);
		btnthem.addActionListener(this);
		btnxoa.addActionListener(this);
		btnxoatrang.addActionListener(this);
		btnMenu.addActionListener(this);
		btnsua.addActionListener(this);

		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		updateTableData();

	}

	public void mouseClicked(MouseEvent e) {
		txtma.setEditable(false);
		int row = table.getSelectedRow();
		if (row != -1) {
			txtma.setText((String) table.getValueAt(row, 0));
			txtten.setText((String) table.getValueAt(row, 1));
			txttheloai.setText((String) table.getValueAt(row, 2));
			txttinhtrang.setText((String) table.getValueAt(row, 3));
			txthangsx.setText((String) table.getValueAt(row, 4));
			txtghichu.setText((String) table.getValueAt(row, 5));
			txtdongia.setText((String) table.getValueAt(row, 6));
			txtsoluong.setText((String) table.getValueAt(row, 7));
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
				if (validData()) {
					String ma = txtma.getText();
					String ten = txtten.getText();
					String theloa = txttheloai.getText();
					String tinhtrang = txttinhtrang.getText();
					String hangsx = txthangsx.getText();
					int soluong = Integer.parseInt(txtsoluong.getText());
					double dongia = Double.parseDouble(txtdongia.getText());
					String ghichu = txtghichu.getText();
					ThongTinCD p = new ThongTinCD(ma, ten, tinhtrang, soluong, hangsx, ghichu, theloa, dongia);
					if (cdDao.addCD(p)) {
						Object[] row = { txtma.getText(), txtten.getText(), txttheloai.getText(),
								txttinhtrang.getText(), txthangsx.getText(), txtghichu.getText(), txtdongia.getText(),
								txtsoluong.getText() };
						tableModel.addRow(row);
						JOptionPane.showMessageDialog(this, "Thêm thành công nhé");
					} else {
						JOptionPane.showMessageDialog(this, "Trùng mã không thể thêm");
					}
				}
				if (cdDao.addCD(null)) {
					JOptionPane.showMessageDialog(this, "Bạn chưa nhập dữ liệu vào");
					txtma.requestFocus();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (o.equals(btnluu)) {
			try {
				int row = table.getSelectedRow();
				String ma = txtma.getText();
				String ten = txtten.getText();
				String theloa = txttheloai.getText();
				String tinhtrang = txttinhtrang.getText();
				String hangsx = txthangsx.getText();
				int soluong = Integer.parseInt(txtsoluong.getText());
				double dongia = Double.parseDouble(txtdongia.getText());
				String ghichu = txtghichu.getText();
				ThongTinCD p = new ThongTinCD(ma, ten, tinhtrang, soluong, hangsx, ghichu, theloa, dongia);
				if (row > 0) {
					if (cdDao.updateCD(p)) {
						table.setValueAt(txtten.getText(), row, 1);
						table.setValueAt(txttheloai.getText(), row, 2);
						table.setValueAt(txttinhtrang.getText(), row, 3);
						table.setValueAt(txthangsx.getText(), row, 4);
						table.setValueAt(txtghichu.getText(), row, 5);
						table.setValueAt(txtdongia.getText(), row, 6);
						table.setValueAt(txtsoluong.getText(), row, 7);
						JOptionPane.showMessageDialog(this, "Lưu thành công rồi nhé!");
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
				String theloa = txttheloai.getText();
				String tinhtrang = txttinhtrang.getText();
				String hangsx = txthangsx.getText();
				int soluong = Integer.parseInt(txtsoluong.getText());
				double dongia = Double.parseDouble(txtdongia.getText());
				String ghichu = txtghichu.getText();
				ThongTinCD p = new ThongTinCD(ma, ten, tinhtrang, soluong, hangsx, ghichu, theloa, dongia);
				if (row > 0) {

					if (cdDao.updateCD(p)) {
						table.setValueAt(txtten.getText(), row, 1);
						table.setValueAt(txttheloai.getText(), row, 2);
						table.setValueAt(txttinhtrang.getText(), row, 3);
						table.setValueAt(txthangsx.getText(), row, 4);
						table.setValueAt(txtghichu.getText(), row, 5);
						table.setValueAt(txtdongia.getText(), row, 6);
						table.setValueAt(txtsoluong.getText(), row, 7);
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
					if (cdDao.deleteCD(ma)) {
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
		if (o.equals(btncdhu)) {
			try {
				new LocCDHu().setVisible(true);
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
		}
		if (o.equals(btncdondinh)) {
			try {
				new DanhSachCDOnDinh().setVisible(true);
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
		}
	}

	private void xoatrang() {
		txtma.setEditable(true);
		txtdongia.setText("");
		txtghichu.setText("");
		txthangsx.setText("");
		txtma.setText("");
		txtsoluong.setText("");
		txtten.setText("");
		txttheloai.setText("");
		txttinhtrang.setText("");
		txtma.requestFocus();
		txtma.selectAll();
		table.clearSelection();
	}

	private void updateTableData() throws MalformedURLException, RemoteException, NotBoundException {
		DanhSachThongTinCDDao cdDao = (DanhSachThongTinCDDao) Naming.lookup("rmi://192.168.1.107:1990/cdDao");
		for (ThongTinCD thôngTinCD : cdDao.getDSBangDia()) {
			String[] row = { thôngTinCD.getMaCD(), thôngTinCD.getTenCD(), thôngTinCD.getTheLoai(),
					thôngTinCD.getTinhTrang(), thôngTinCD.getHangSanXuat(), thôngTinCD.getGhiChu(),
					thôngTinCD.getDonGia() + "", thôngTinCD.getSoLuong() + "" };
			tableModel.addRow(row);
		}
		table.setModel(tableModel);

	}

	private boolean validData() {
		String ma = txtma.getText();
		String ten = txtten.getText();
		String theloa = txttheloai.getText();
		String tinhtrang = txttinhtrang.getText();
		String hangsx = txthangsx.getText();
		int soluong = Integer.parseInt(txtsoluong.getText());
		double dongia = Double.parseDouble(txtdongia.getText());
		String ghichu = txtghichu.getText();

		if (!(ma.length() > 0 && ma.matches("BD[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên phải nhập theo định dạng BDXXX và không được bỏ trống!");
			txtma.selectAll();
			txtma.requestFocus();
			return false;
		}
		if (!(ten.length() > 0 && ten.matches("^[A-Z].+([A-Z].*[A-Z].)*"))) {
			JOptionPane.showMessageDialog(this,
					"Tên không được bỏ trống, chữ cái đầu phải viết hoa và phải nhập đầy đủ họ tên!");
			txtten.selectAll();
			txtten.requestFocus();
			return false;
		}
		if (!(theloa.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập thể loại cd!");
			txttheloai.selectAll();
			txttheloai.requestFocus();
			return false;
		}
		if (!(hangsx.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập hãng sản xuất cd!");
			txthangsx.selectAll();
			txthangsx.requestFocus();
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		new KeBangDia();
	}
}