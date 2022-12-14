package dao;

import entity.*;

import java.time.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public interface DanhSachBDThueDao extends Remote{
	public boolean addBangDiaThue(BangDiaThue bangDiaThue) throws RemoteException;

	public boolean deleteBDT(int id) throws RemoteException;

	public boolean updateBDT(BangDiaThue bangDiaThue) throws RemoteException;

	public List<BangDiaThue> getDSBangDia() throws RemoteException;

	public List<BangDiaThue> getBangDiaThueTheoTen(String tenBangDia) throws RemoteException;

	public BangDiaThue getBangDiaThueMa(int id) throws RemoteException;
}