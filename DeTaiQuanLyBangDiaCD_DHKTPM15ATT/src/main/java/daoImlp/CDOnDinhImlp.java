package daoImlp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.CDOnDinh;
import entity.NhanVien;
import entity.ThongTinCD;
import until.HibernaUtil;

public class CDOnDinhImlp extends UnicastRemoteObject implements CDOnDinh {
	private EntityManager em;

	public CDOnDinhImlp() throws RemoteException {
		em = HibernaUtil.getInstance().getEntityManager();
	}

	@Override
	public List<ThongTinCD> getCDOnDinh(String tinhTrang) throws RemoteException {
		List<ThongTinCD> thongTinCDs = null;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT  * from ThongTinCD where ThongTinCD.tinhTrang =N'Ổn Định'";
			thongTinCDs = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return thongTinCDs;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return thongTinCDs;
	}

}
