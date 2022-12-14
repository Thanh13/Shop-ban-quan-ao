package daoImlp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.DanhSachBDThueDao;
import entity.BangDiaThue;
import until.HibernaUtil;

public class DanhSachBDThueImpl extends UnicastRemoteObject implements DanhSachBDThueDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public DanhSachBDThueImpl() throws RemoteException {
		em = HibernaUtil.getInstance().getEntityManager();
	}

	@Override
	public boolean addBangDiaThue(BangDiaThue bangDiaThue) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(bangDiaThue);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();

		}
		return false;

	}

	@Override
	public boolean deleteBDT(int id) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			BangDiaThue bangDiaThue = em.find(BangDiaThue.class, id);
			em.remove(bangDiaThue);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateBDT(BangDiaThue bangDiaThue) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(bangDiaThue);
			tr.commit();
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<BangDiaThue> getDSBangDia() throws RemoteException {
		return em.createQuery("from BangDiaThue", BangDiaThue.class).getResultList();
	}

	@Override
	public List<BangDiaThue> getBangDiaThueTheoTen(String tenBangDia) throws RemoteException {
		List<BangDiaThue> bangDiaThues = null;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from BangDiaThue where BangDiaThue.tenBangDia =:tenBangDia";
			bangDiaThues = em.createNativeQuery(sql, BangDiaThue.class).getResultList();
			tr.commit();
			return bangDiaThues;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return bangDiaThues;
	}

	@Override
	public BangDiaThue getBangDiaThueMa(int id) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			BangDiaThue bangDiaThue = em.find(BangDiaThue.class, id);

			tr.commit();

			return bangDiaThue;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
