package until;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernaUtil {
	private static HibernaUtil instance;
	private EntityManager entityManager;

	private HibernaUtil() {
		entityManager = Persistence.createEntityManagerFactory("DeTaiQuanLyBangDiaCD_DHKTPM15ATT") // nhớ thay cái này
																									// thành tên
				// project
				.createEntityManager();
	}

	public synchronized static HibernaUtil getInstance() {
		if (instance == null)
			instance = new HibernaUtil();
		return instance;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
