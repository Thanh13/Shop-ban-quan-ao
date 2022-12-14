package gui;

import javax.swing.*;

import dao.DanhSachBDThueDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Menu extends JFrame implements ActionListener {
	DanhSachBDThueDao bdThueDao;
	JButton btntaotv, btndstv, btndsbd, btnbdthue, btnthuebd, btnqlnv, btnDSKHTraDia, btnthoat;
	JLabel lbltitle;

	public Menu() throws MalformedURLException, RemoteException, NotBoundException {
		super("Phần mềm Quản lý băng đĩa");
		bdThueDao = (DanhSachBDThueDao) Naming.lookup("rmi://192.168.1.107:1990/bdThueDao");
		JPanel n = new JPanel();
		n.add(lbltitle = new JLabel("Menu chính"));
		n.setLayout(new FlowLayout(FlowLayout.CENTER));
		Font fpt = new Font("Times New Roman", Font.BOLD, 25);
		lbltitle.setFont(fpt);
		lbltitle.setForeground(Color.DARK_GRAY);
		JPanel c = new JPanel();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.add(btntaotv = new JButton("Tạo thành viên"));
		btntaotv.setFont(new Font("Calibri", Font.PLAIN, 14));
		btntaotv.setBackground(new Color(0x2dce98));
		btntaotv.setForeground(Color.white);
		btntaotv.setUI(new cssButton());

		c.add(btndstv = new JButton("Danh sách thành viên"));
		btndstv.setFont(new Font("Calibri", Font.PLAIN, 14));
		btndstv.setBackground(new Color(0x2dce98));
		btndstv.setForeground(Color.white);
		btndstv.setUI(new cssButton());

		c.add(btndsbd = new JButton("Danh sách băng đĩa"));
		btndsbd.setFont(new Font("Calibri", Font.PLAIN, 14));
		btndsbd.setBackground(new Color(0x2dce98));
		btndsbd.setForeground(Color.white);
		btndsbd.setUI(new cssButton());

		c.add(btnbdthue = new JButton("Băng đĩa đang thuê"));
		btnbdthue.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnbdthue.setBackground(new Color(0x2dce98));
		btnbdthue.setForeground(Color.white);
		btnbdthue.setUI(new cssButton());

		c.add(btnthuebd = new JButton("Thuê băng đĩa"));
		btnthuebd.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnthuebd.setBackground(new Color(0x2dce98));
		btnthuebd.setForeground(Color.white);
		btnthuebd.setUI(new cssButton());

		c.add(btnqlnv = new JButton("Quản lý nhân viên"));
		btnqlnv.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnqlnv.setBackground(new Color(0x2dce98));
		btnqlnv.setForeground(Color.white);
		btnqlnv.setUI(new cssButton());

		c.add(btnDSKHTraDia = new JButton("Danh sách khách hàng trả đĩa"));
		btnDSKHTraDia.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnDSKHTraDia.setBackground(new Color(0x2dce98));
		btnDSKHTraDia.setForeground(Color.white);
		btnDSKHTraDia.setUI(new cssButton());

		JPanel s = new JPanel();
		s.add(btnthoat = new JButton("Thoát chương trình"));
		s.setBorder(BorderFactory.createTitledBorder("Tác vụ khác:"));
		btnthoat.setUI(new cssButton());

		this.add(n, BorderLayout.NORTH);
		this.add(c, BorderLayout.CENTER);
		this.add(s, BorderLayout.SOUTH);
		this.setSize(400, 270);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		btntaotv.addActionListener(this);
		btndsbd.addActionListener(this);
		btnthuebd.addActionListener(this);
		btndstv.addActionListener(this);
		btnbdthue.addActionListener(this);
		btnqlnv.addActionListener(this);
		btnDSKHTraDia.addActionListener(this);
		btnthoat.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object ooo = e.getSource();
		if (ooo.equals(btntaotv)) {
			dispose();
			FormTaoThanhVien taotv = null;
			try {
				taotv = new FormTaoThanhVien();
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
			taotv.setVisible(true);
		} else// BIGEST ELSE
		{
			if (ooo.equals(btndstv)) {
				dispose();
				DanhSachThanhVien dstv = null;
				try {
					dstv = new DanhSachThanhVien();
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
				dstv.setVisible(true);
			} // Ended btn1
			if (ooo.equals(btndsbd)) {
				dispose();
				KeBangDia dsbd = null;
				try {
					dsbd = new KeBangDia();
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
				dsbd.setVisible(true);
			} // Ended btn2
			if (ooo.equals(btnbdthue)) {
				dispose();
				GiaoDienDSKHDangThueDia bdthue = null;
				try {
					bdthue = new GiaoDienDSKHDangThueDia();
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
				bdthue.setVisible(true);
			} // Ended btn3
			if (ooo.equals(btnthuebd)) {
				dispose();
				FormThueDia thuebd = null;
				try {
					thuebd = new FormThueDia();
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
				thuebd.setVisible(true);
			} // Ended btn4
			if (ooo.equals(btnqlnv)) {
				dispose();
				GiaoDienQLNV qlnv = null;
				try {
					qlnv = new GiaoDienQLNV();
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
				qlnv.setVisible(true);
			} // Ended btn5
			if (ooo.equals(btnDSKHTraDia)) {
				dispose();
				GiaoDienDSKHTraDia bdtra = null;
				try {
					bdtra = new GiaoDienDSKHTraDia();
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
				bdtra.setVisible(true);
			} // Ended btn6
			if (ooo.equals(btnthoat)) {
				System.exit(0);
			} // Ended btn7
		}
	}

}
