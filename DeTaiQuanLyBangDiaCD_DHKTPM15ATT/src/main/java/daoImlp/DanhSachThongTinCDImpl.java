package daoImlp;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.DanhSachThongTinCDDao;
import entity.NhanVien;
import entity.ThongTinCD;
import until.HibernaUtil;

public class DanhSachThongTinCDImpl extends UnicastRemoteObject implements DanhSachThongTinCDDao {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public DanhSachThongTinCDImpl() throws RemoteException {
		em = HibernaUtil.getInstance().getEntityManager();
	}

	@Override
	public boolean addCD(ThongTinCD thongTinCD) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(thongTinCD);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();

		}
		return false;

	}

	@Override
	public boolean deleteCD(String maCD) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			ThongTinCD thongTinCD = em.find(ThongTinCD.class, maCD);
			em.remove(thongTinCD);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateCD(ThongTinCD thongTinCD) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(thongTinCD);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<ThongTinCD> getDSBangDia() throws RemoteException {
		return em.createQuery("from ThongTinCD", ThongTinCD.class).getResultList();
	}

	@Override
	public List<ThongTinCD> getThôngTinCDTen(String tenBangDia) throws RemoteException {
		List<ThongTinCD> thongTinCDs = null;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from ThongTinCD where ThongTinCD.tenBangDia =:tenBangDia";
			thongTinCDs = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return thongTinCDs;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return thongTinCDs;
	}

}
