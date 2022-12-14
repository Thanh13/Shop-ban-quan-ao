package gui;

import entity.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GDDSKHQuaHanThue extends JFrame implements ActionListener {
	ArrayList<BangDiaTra> dSKHQuaHanTraDia;
	private DefaultTableModel tblmdl;
	private JTable tbl;
	JLabel lblTitle;
	JButton btnQuayLai;
	Font font = new Font("Times New Roman", Font.BOLD, 30);

	public GDDSKHQuaHanThue(ArrayList<BangDiaTra> dSKHQuaHanTraDia) {

		super("Danh sách khách hàng quá hạn trả đĩa");

		this.dSKHQuaHanTraDia = dSKHQuaHanTraDia;

		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("DANH SÁCH KHÁCH HÀNG QUÁ HẠN TRẢ ĐĨA");
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		pnTitle.add(lblTitle);

		JPanel pnCenter = new JPanel();
		String[] col = { "ID", "Mã nhân viên", "Tên thành viên", "Mã thành viên", "Mã băng đĩa", "Số lượng",
				"Thành tiền", "Phí trả thêm", "Ngày trả", "Ghi chú" };
		tblmdl = new DefaultTableModel(col, 0);
		tbl = new JTable(tblmdl);
		tbl.setRowHeight(20);
		JScrollPane scrollTbl = new JScrollPane(tbl);
		scrollTbl.setPreferredSize(new Dimension(880, 300));
		btnQuayLai = new JButton("Quay lại");
		pnCenter.add(scrollTbl);
		pnCenter.add(btnQuayLai);

		add(pnTitle, BorderLayout.NORTH);
		add(pnCenter);

		btnQuayLai.addActionListener(this);

		hienTable();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void hienTable() {
		for (BangDiaTra bDTra : dSKHQuaHanTraDia) {
			String[] row = { bDTra.getiD() + "", bDTra.getMaNV(), bDTra.getTenTV(), bDTra.getMaTV(), bDTra.getMaCD(),
					bDTra.getsL() + "", bDTra.getThanhTien() + "", bDTra.getPhiTraThem() + "", bDTra.getNgayTra() + "",
					bDTra.getGhiChu() };
			tblmdl.addRow(row);
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnQuayLai))
			try {
				quayLai();
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

	private void quayLai() throws MalformedURLException, RemoteException, NotBoundException {
		setVisible(false);
		new GiaoDienDSKHTraDia().setVisible(true);
	}
}