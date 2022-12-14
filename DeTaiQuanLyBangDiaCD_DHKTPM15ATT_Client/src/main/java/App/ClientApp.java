package App;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.CDBiHu;
import dao.CDOnDinh;
import dao.DanhSachBDThueDao;
import dao.DanhSachBDTraDao;
import dao.DanhSachNhanVienDao;
import dao.DanhSachThanhVienDao;
import dao.DanhSachThongTinCDDao;
import gui.dangnhap;

public class ClientApp {

	public static void main(String[] args) {

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			DanhSachBDThueDao bdThueDao = (DanhSachBDThueDao) Naming.lookup("rmi://192.168.1.107:1990/bdThueDao");
			DanhSachBDTraDao bdTraDao = (DanhSachBDTraDao) Naming.lookup("rmi://192.168.1.107:1990/bdTraDao");
			DanhSachNhanVienDao danhSachNhanVienDao = (DanhSachNhanVienDao) Naming
					.lookup("rmi://192.168.1.107:1990/danhSachNhanVienDao");
			DanhSachThanhVienDao danhSachThanhVienDao = (DanhSachThanhVienDao) Naming
					.lookup("rmi://192.168.1.107:1990/danhSachThanhVienDao");
			DanhSachThongTinCDDao cdDao = (DanhSachThongTinCDDao) Naming.lookup("rmi://192.168.1.107:1990/cdDao");
			CDBiHu cdBiHu = (CDBiHu) Naming.lookup("rmi://192.168.1.107:1990/cdBiHu");
			CDOnDinh cdOnDinh = (CDOnDinh) Naming.lookup("rmi://192.168.1.107:1990/cdOnDinh");
			
			dangnhap dangnhap = new dangnhap();
			dangnhap.setVisible(true);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
}
