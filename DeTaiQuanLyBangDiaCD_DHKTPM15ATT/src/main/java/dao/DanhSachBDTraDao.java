package dao;

import entity.*;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface DanhSachBDTraDao extends Remote {
	public boolean addBangDiaThue(BangDiaTra bangDiaTra) throws RemoteException;

	public boolean deleteBDTra(int id) throws RemoteException;

	public boolean updateBDTra(BangDiaTra bangDiaTra) throws RemoteException;

	public List<BangDiaTra> getDSBangDia() throws RemoteException;

	public List<BangDiaTra> getBangDiaTraTheoTen(String tenBangDia) throws RemoteException;

	public BangDiaTra getBangDiaTraTheoMa(int id) throws RemoteException;
}