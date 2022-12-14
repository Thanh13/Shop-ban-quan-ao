package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangDiaThue;
import entity.ThongTinCD;

public interface CDOnDinh extends Remote {
	public List<ThongTinCD> getCDOnDinh(String tenBangDia) throws RemoteException;
}
