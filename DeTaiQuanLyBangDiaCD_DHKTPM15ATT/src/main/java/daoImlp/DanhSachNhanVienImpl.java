package daoImlp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.DanhSachNhanVienDao;
import entity.NhanVien;
import until.HibernaUtil;

public class DanhSachNhanVienImpl extends UnicastRemoteObject implements DanhSachNhanVienDao {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public  DanhSachNhanVienImpl() throws RemoteException {
		em = HibernaUtil.getInstance().getEntityManager();
	}
//	Thêm 1 loai san pham
	public boolean addNhanVien(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(nhanVien);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();

		}
		return false;
	}
	// xóa 
			public boolean deleteNV(String maNhanVien) throws RemoteException {
				EntityTransaction tr = em.getTransaction();
				try {
					tr.begin();
					NhanVien nhanVien=em.find(NhanVien.class, maNhanVien);
					em.remove(nhanVien); 
					tr.commit();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					tr.rollback();
				}
				return false;
			}

// Cập nhật nhân viên
	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nhanVien);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

// tìm hết nhân viên
	@Override
	public List<NhanVien> getDSNhanVien() throws RemoteException {

		return em.createQuery("from NhanVien", NhanVien.class).getResultList();
	}
// Tìm nhân viên theo tên
	@Override
	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) throws RemoteException {		
		List<NhanVien> nhanViens=null;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql="SELECT  * from NhanVien where NhanVien.tenNhanVien =:tenNhanVien";
			nhanViens = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return nhanViens;

		} catch (Exception e) {
			e.printStackTrace();
			

		}
		return nhanViens;
	}

	@Override
	public NhanVien getNhanVienTheoMa(String maNhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			
			NhanVien nhanVien=em.find(NhanVien.class, maNhanVien);

			tr.commit();
			
			return nhanVien;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	

}

