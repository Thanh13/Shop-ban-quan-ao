package App;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.DanhSachNhanVienDao;
import dao.DanhSachThanhVienDao;
import daoImlp.DanhSachNhanVienImpl;
import daoImlp.ThanhVienImpl;
import entity.NhanVien;
import entity.ThanhVien;
import until.HibernaUtil;

public class App {

	public static void main(String[] args) throws RemoteException {
		EntityManager  entityManager=HibernaUtil.getInstance().getEntityManager();
		NhanVien nhanVien =new NhanVien("NV12", "Duong", "0338629576", "Khong");
		DanhSachNhanVienDao danhSachNhanVienDao=new DanhSachNhanVienImpl();
		boolean s=danhSachNhanVienDao.addNhanVien(nhanVien);
		if (s) {
			System.out.println("Thêm thành công nhé..!");
		}
		else {
			System.out.println("Thêm thất bại rồi");
		}
		ThanhVien thanhVien=new ThanhVien("TV10", "TVM", "NAM", "0123", "Thanh Hoa", "1357");
		DanhSachThanhVienDao danhSachThanhVienDao=new ThanhVienImpl();
		danhSachThanhVienDao.addThanhVien(thanhVien);
		List<ThanhVien> list=danhSachThanhVienDao.getThanhVienTheoTen("TV10");
		System.out.println(list);
//		System.out.println(danhSachThanhVienDao.getThanhVienTheoMa("TV10"));
		
	}

}
