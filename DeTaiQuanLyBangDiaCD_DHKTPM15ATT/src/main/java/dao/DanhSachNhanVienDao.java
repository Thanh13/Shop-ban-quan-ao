package dao;

import entity.*;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface DanhSachNhanVienDao extends Remote {
	
	public boolean addNhanVien(NhanVien nhanVien) throws RemoteException;

	public boolean deleteNV(String maNhanVien) throws RemoteException;

	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException;

	public List<NhanVien> getDSNhanVien() throws RemoteException;

	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) throws RemoteException;

	public NhanVien getNhanVienTheoMa(String maNhanVien) throws RemoteException;

}
