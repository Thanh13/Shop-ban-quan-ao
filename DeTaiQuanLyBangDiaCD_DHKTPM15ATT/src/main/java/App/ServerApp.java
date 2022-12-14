package App;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.CDBiHu;
import dao.CDOnDinh;
import dao.DanhSachBDThueDao;
import dao.DanhSachBDTraDao;
import dao.DanhSachNhanVienDao;
import dao.DanhSachThanhVienDao;
import dao.DanhSachThongTinCDDao;
import daoImlp.CDBiHuImlp;
import daoImlp.CDOnDinhImlp;
import daoImlp.DanhSachBDThueImpl;
import daoImlp.DanhSachBDTraImpl;
import daoImlp.DanhSachNhanVienImpl;
import daoImlp.DanhSachThongTinCDImpl;
import daoImlp.ThanhVienImpl;

public class ServerApp {

	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			LocateRegistry.createRegistry(1990);
			DanhSachBDThueDao bdThueDao = new DanhSachBDThueImpl();
			DanhSachBDTraDao bdTraDao = new DanhSachBDTraImpl();
			DanhSachNhanVienDao danhSachNhanVienDao = new DanhSachNhanVienImpl();
			DanhSachThanhVienDao danhSachThanhVienDao = new ThanhVienImpl();
			DanhSachThongTinCDDao cdDao = new DanhSachThongTinCDImpl();
			CDOnDinh cdOnDinh=new CDOnDinhImlp();
			CDBiHu cdBiHu=new CDBiHuImlp();
			Naming.bind("rmi://192.168.1.107:1990/bdThueDao", bdThueDao);
			Naming.bind("rmi://192.168.1.107:1990/bdTraDao", bdTraDao);
			Naming.bind("rmi://192.168.1.107:1990/danhSachNhanVienDao", danhSachNhanVienDao);
			Naming.bind("rmi://192.168.1.107:1990/danhSachThanhVienDao", danhSachThanhVienDao);
			Naming.bind("rmi://192.168.1.107:1990/cdDao", cdDao);
			Naming.bind("rmi://192.168.1.107:1990/cdOnDinh", cdOnDinh);
			Naming.bind("rmi://192.168.1.107:1990/cdBiHu", cdBiHu);
			System.out.println("Server đang chạy nhé...!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
