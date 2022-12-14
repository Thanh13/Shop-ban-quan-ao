package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CDBiHu;
import entity.ThongTinCD;

public class LocCDHu extends JFrame implements ActionListener, MouseListener {
	JTable table;
	JLabel lbltitle;
	JScrollPane scr;
	DefaultTableModel tableModel;
	CDBiHu cdBiHu;
	JButton btnQuayLai;
	KeBangDia a;

	public LocCDHu() throws MalformedURLException, RemoteException, NotBoundException {
		super("Danh sách cd hư !!!");
		cdBiHu = (CDBiHu) Naming.lookup("rmi://192.168.1.107:1990/cdBiHu");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p2.add(lbltitle = new JLabel("Băng đĩa cd bị hư"));
		Font fb = new Font("Arial", Font.BOLD, 30);
		lbltitle.setFont(fb);
		lbltitle.setForeground(Color.BLUE);
		add(p2, BorderLayout.NORTH);
		String col[] = { "Mã băng đĩa", "Tên băng đĩa", "Thể loai", "Tình trạng băng đĩa", "Hãng sản xuất", "Ghi chú",
				"Đơn giá", "Số lượng" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.addMouseListener(this);
		scr = new JScrollPane(table);
		scr.setPreferredSize(new Dimension(850, 300));
		p1.add(scr);
		add(p1, BorderLayout.CENTER);
		JPanel p3 = new JPanel();
		p3.add(btnQuayLai = new JButton("Quay lại danh sách CD"));
		add(p3, BorderLayout.SOUTH);
		btnQuayLai.addActionListener(this);
		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		updateTableData();

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
		if (o.equals(btnQuayLai)) {
			try {
				new KeBangDia().setVisible(true);
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

	private void updateTableData() throws MalformedURLException, RemoteException, NotBoundException {
		CDBiHu cdBiHu = (CDBiHu) Naming.lookup("rmi://192.168.1.107:1990/cdBiHu");
		for (ThongTinCD thôngTinCD : cdBiHu.getCDHu("Hư")) {
			String[] row = { thôngTinCD.getMaCD(), thôngTinCD.getTenCD(), thôngTinCD.getTheLoai(),
					thôngTinCD.getTinhTrang(), thôngTinCD.getHangSanXuat(), thôngTinCD.getGhiChu(),
					thôngTinCD.getDonGia() + "", thôngTinCD.getSoLuong() + "" };
			tableModel.addRow(row);
		}
		table.setModel(tableModel);

	}

}
