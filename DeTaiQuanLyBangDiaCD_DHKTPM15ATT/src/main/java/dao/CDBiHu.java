package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangDiaThue;
import entity.ThongTinCD;

public interface CDBiHu extends Remote {

	public List<ThongTinCD> getCDHu(String tenBangDia) throws RemoteException;
}
