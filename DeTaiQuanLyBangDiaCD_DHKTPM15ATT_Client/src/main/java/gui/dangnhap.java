package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class dangnhap extends JFrame implements ActionListener {
	JLabel lblten, lblmatkhau, lblhienmatkhau;
	JTextField txtten;
	JPasswordField txtmatkhau;
	JButton btndangnhap, btnxoarong;
	JCheckBox chk;

	public dangnhap() {
		super("Form đăng nhập");
		JPanel north = new JPanel();
		north.add(Box.createVerticalStrut(140));
		JPanel center = new JPanel();

		JPanel taikhoan = new JPanel();
		taikhoan.add(lblten = new JLabel("Tài khoản:"));
		taikhoan.add(txtten = new JTextField(15));

		JPanel matkhau = new JPanel();
		matkhau.add(lblmatkhau = new JLabel("Mật khẩu:"));
		matkhau.add(txtmatkhau = new JPasswordField(15));

		lblmatkhau.setPreferredSize(new Dimension(lblten.getPreferredSize()));

		JPanel hienmatkhau = new JPanel();
		hienmatkhau.add(chk = new JCheckBox("Hiện mật khẩu"));

		JPanel button = new JPanel();
		button.add(btndangnhap = new JButton("Đăng nhập"));
		button.add(btnxoarong = new JButton("Xóa rỗng"));

		Box b = Box.createVerticalBox();
		b.add(taikhoan);
		b.add(matkhau);
		b.add(hienmatkhau);
		b.add(button);
		center.add(b);
		center.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.setSize(400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		btndangnhap.addActionListener(this);
		btnxoarong.addActionListener(this);
		chk.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object ooo = e.getSource();
		if (ooo.equals(btndangnhap)) {
			String username = txtten.getText();
			String password = txtmatkhau.getText();
			if (username.equalsIgnoreCase("sa") && password.equalsIgnoreCase("sapassword")) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
				dispose();
				Menu mn = null;
				try {
					mn = new Menu();
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
				mn.show();
			} else {
				JOptionPane.showMessageDialog(this,
						"Sai tài khoản hoặc mật khẩu, tài khoản mặc định:sa, mật khẩu mặc định: sapassword!",
						"Thông báo", HEIGHT);
			}
		} else// BIGEST ELSE
		{
			if (ooo.equals(btnxoarong)) {
				txtten.setText("");
				txtmatkhau.setText("");
			} // END xoarong

			if (ooo.equals(chk)) {
				if (chk.isSelected()) {
					txtmatkhau.setEchoChar((char) 0);
				} else {
					txtmatkhau.setEchoChar('*');
				}
			} // END chk
		} // END ELSE
	}

}
