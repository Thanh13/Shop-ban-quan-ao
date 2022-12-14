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

import javax.swing.JOptionPane;

public interface DanhSachThongTinCDDao extends Remote {

	public boolean addCD(ThongTinCD thongTinCD) throws RemoteException;

	public boolean deleteCD(String maCD) throws RemoteException;

	public boolean updateCD(ThongTinCD thongTinCD) throws RemoteException;

	public List<ThongTinCD> getDSBangDia() throws RemoteException;

	public List<ThongTinCD> getThôngTinCDTen(String tenBangDia) throws RemoteException;

}
