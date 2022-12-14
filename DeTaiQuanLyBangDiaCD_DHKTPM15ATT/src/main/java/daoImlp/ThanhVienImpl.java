package daoImlp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.DanhSachThanhVienDao;
import entity.ThanhVien;
import until.HibernaUtil;

public class ThanhVienImpl extends UnicastRemoteObject implements DanhSachThanhVienDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ThanhVienImpl() throws RemoteException {
		em = HibernaUtil.getInstance().getEntityManager();
	}

//	Thêm 1 Thành Viên
	@Override
	public boolean addThanhVien(ThanhVien thanhVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(thanhVien);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;

	}

// cập nhật Thành viên 
	@Override
	public boolean updateTV(ThanhVien thanhVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(thanhVien);

			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();

		}
		return false;
	}

	// lấy danh sách Thành Viên

	@Override
	public List<ThanhVien> getDSKhachHang() throws RemoteException {

		return em.createQuery("from ThanhVien", ThanhVien.class).getResultList();
	}
// tìm thành viên theo số điển thoại
	@Override
	public ThanhVien getThanhVienTheoSDT(String soDienThoai) throws RemoteException {

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from ThanhVien where ThanhVien.soDienThoai =:soDienThoai";
			ThanhVien thanhVien = (ThanhVien) em.createNativeQuery(sql, ThanhVien.class)
					.setParameter("soDienThoai", soDienThoai).getSingleResult();
			tr.commit();
			return thanhVien;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	// tìm thành viên theo tên
	@Override
	public List<ThanhVien> getThanhVienTheoTen(String tenThanhVien) throws RemoteException {
		List<ThanhVien> thanhViens=null;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from ThanhVien where ThanhVien.hoTenThanhVien =hoTenThanhVien";
			thanhViens = em.createNativeQuery(sql, ThanhVien.class).getResultList();
			tr.commit();
			return thanhViens;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return thanhViens;
	}
	// xóa theo maThanhVien
	@Override
	public boolean deleteTV(String maThanhVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			ThanhVien thanhVien=em.find(ThanhVien.class, maThanhVien);
			em.remove(thanhVien); 
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	// tìm theo mã thành viên
	@Override
	public ThanhVien getThanhVienTheoMa(String maThanhVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			
			ThanhVien thanhVien=em.find(ThanhVien.class, maThanhVien);

			tr.commit();
			
			return thanhVien;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	

}


