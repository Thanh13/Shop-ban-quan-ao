package daoImlp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.CDBiHu;
import entity.NhanVien;
import entity.ThongTinCD;
import until.HibernaUtil;

public class CDBiHuImlp extends UnicastRemoteObject implements CDBiHu {
	private EntityManager entityManager;

	public CDBiHuImlp() throws RemoteException {
		entityManager = HibernaUtil.getInstance().getEntityManager();
	}

	public List<ThongTinCD> getCDHu(String string) throws RemoteException {
		List<ThongTinCD> thongTinCDs = null;
		EntityTransaction tr = entityManager.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from ThongTinCD where ThongTinCD.tinhTrang =N'Hư'";
			thongTinCDs = entityManager.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return thongTinCDs;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return thongTinCDs;
	}

}
