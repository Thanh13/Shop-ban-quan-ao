package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DanhSachThanhVienDao;
import entity.ThanhVien;

public class FormTaoThanhVien extends JFrame implements ActionListener, MouseListener {
	JLabel lbltitle, lblten, lbltinh, lblsdt, lbldiachi, lblthu, lblma, lblhokhau;
	JTextField txtten, txttinh, txtsdt, txtdiachi, txtthu, txtma, txthokhau;
	JButton btnthem, btnxoatrang, btnMenu, btntdstv;
	JTable table;
	DefaultTableModel tableModel;
	JScrollPane src;
	DanhSachThanhVienDao danhSachThanhVienDao;

	public FormTaoThanhVien() throws MalformedURLException, RemoteException, NotBoundException {
		super("Thông tin thành viên");

		JPanel p1 = new JPanel();
		p1.add(lbltitle = new JLabel("Form tạo thành viên"));
		Font fb = new Font("Arial", Font.BOLD, 35);
		lbltitle.setFont(fb);
		lbltitle.setForeground(Color.BLUE);
		danhSachThanhVienDao = (DanhSachThanhVienDao) Naming.lookup("rmi://192.168.1.107:1990/danhSachThanhVienDao");
		add(p1, BorderLayout.NORTH);
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel pcen = new JPanel();
		pcen.setLayout(new BoxLayout(pcen, BoxLayout.Y_AXIS));
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
		JPanel pso = new JPanel();
		pso.add(btnthem = new JButton("Thêm"));
		pso.add(btnxoatrang = new JButton("Xóa Trắng"));
		pso.add(btnMenu = new JButton("Menu"));
		pso.add(btntdstv = new JButton("Danh Sách Thành Viên"));
		add(pso, BorderLayout.SOUTH);
		lbltinh.setPreferredSize(lblthu.getPreferredSize());
		lbldiachi.setPreferredSize(lbltinh.getPreferredSize());
		lblten.setPreferredSize(lblma.getPreferredSize());
		lblsdt.setPreferredSize(lblten.getPreferredSize());
		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		btnthem.addActionListener(this);
		btnxoatrang.addActionListener(this);
		btnMenu.addActionListener(this);
		btntdstv.addActionListener(this);

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
			if (validData()) {
				try {
					String ma = txtma.getText();
					String ten = txtten.getText();
					String gioitinh = txttinh.getText();
					String sodt = txtsdt.getText();
					String diachi = txtdiachi.getText();
					String cmthu = txtthu.getText();
					ThanhVien tv = new ThanhVien(ma, ten, gioitinh, sodt, diachi, cmthu);
					if (danhSachThanhVienDao.addThanhVien(tv)) {
						Object[] row = { txtma.getText(), txtten.getText(), txttinh.getText(), txtsdt.getText(),
								txtdiachi.getText(), txtthu.getText() };
						JOptionPane.showMessageDialog(this, "Thêm thành công nhé");
					} else {
						JOptionPane.showMessageDialog(this, "Trùng mã không thể thêm");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		if (o.equals(btnxoatrang)) {
			xoatrang();
			JOptionPane.showMessageDialog(this, "Đã xóa xong!!");
		}
		if (o.equals(btntdstv)) {
			try {
				new DanhSachThanhVien().setVisible(true);
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
		table.clearSelection();
		txtten.setText("");
		txtma.setText("");
		txtsdt.setText("");
		txtthu.setText("");
		txttinh.setText("");
		txtdiachi.setText("");
		txtma.requestFocus();
		txtma.selectAll();
	}

	private boolean validData() {
		String ma = txtma.getText();
		String ten = txtten.getText();
		String gioitinh = txttinh.getText();
		String sodt = txtsdt.getText();
		String diachi = txtdiachi.getText();
		String cmthu = txtthu.getText();

		if (!(ma.length() > 0 && ma.matches("TV[0-9]{1,3}"))) {
			JOptionPane.showMessageDialog(this, "Mã Thành viên phải nhập theo định dạng TVXXX và không được bỏ trống!");
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
		return true;
	}
}