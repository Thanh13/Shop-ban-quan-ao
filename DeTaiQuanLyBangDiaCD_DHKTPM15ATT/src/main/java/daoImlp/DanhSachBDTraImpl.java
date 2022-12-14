package daoImlp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.DanhSachBDTraDao;
import entity.BangDiaTra;
import until.HibernaUtil;

public class DanhSachBDTraImpl extends UnicastRemoteObject implements DanhSachBDTraDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public DanhSachBDTraImpl() throws RemoteException {
		em = HibernaUtil.getInstance().getEntityManager();
	}

	@Override
	public boolean addBangDiaThue(BangDiaTra bangDiaTra) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(bangDiaTra);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();

		}
		return false;
	}

	@Override
	public boolean deleteBDTra(int id) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			BangDiaTra bangDiaTra = em.find(BangDiaTra.class, id);
			em.remove(bangDiaTra);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateBDTra(BangDiaTra bangDiaTra) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(bangDiaTra);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<BangDiaTra> getDSBangDia() throws RemoteException {
		return em.createQuery("from BangDiaTra", BangDiaTra.class).getResultList();
	}

	@Override
	public List<BangDiaTra> getBangDiaTraTheoTen(String tenBangDia) throws RemoteException {
		List<BangDiaTra> bangDiaTras = null;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from BangDiaTra where BangDiaTra.tenBangDia =:tenBangDia";
			bangDiaTras = em.createNativeQuery(sql, BangDiaTra.class).getResultList();
			tr.commit();
			return bangDiaTras;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return bangDiaTras;
	}

	@Override
	public BangDiaTra getBangDiaTraTheoMa(int id) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			BangDiaTra bangDiaTra = em.find(BangDiaTra.class, id);

			tr.commit();

			return bangDiaTra;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

}
