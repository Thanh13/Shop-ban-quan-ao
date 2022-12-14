package dao;


import entity.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface DanhSachThanhVienDao extends Remote {
	public boolean addThanhVien(ThanhVien thanhVien) throws RemoteException;
	
	public boolean deleteTV(String maThanhVien) throws RemoteException;

	public boolean updateTV(ThanhVien thanhVien) throws RemoteException;

	public List<ThanhVien> getDSKhachHang() throws RemoteException;

	public ThanhVien getThanhVienTheoSDT(String soDienThoai) throws RemoteException;

	public ThanhVien getThanhVienTheoMa(String maThanhVien) throws RemoteException;

	public List<ThanhVien> getThanhVienTheoTen(String tenThanhVien) throws RemoteException;

}