package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ThongTinCD")
public class ThongTinCD implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5968464381094747900L;
	@Id
	private String maCD;
	private String tenCD;
	private String tinhTrang;
	private int soLuong;
	private String hangSanXuat;
	private String ghiChu;
	private String theLoai;
	private double donGia;
	public ThongTinCD() {
		super();
	}
	public ThongTinCD(String maCD, String tenCD, String tinhTrang, int soLuong, String hangSanXuat, String ghiChu,
			String theLoai, double donGia) {
		super();
		this.maCD = maCD;
		this.tenCD = tenCD;
		this.tinhTrang = tinhTrang;
		this.soLuong = soLuong;
		this.hangSanXuat = hangSanXuat;
		this.ghiChu = ghiChu;
		this.theLoai = theLoai;
		this.donGia = donGia;
	}
	public String getMaCD() {
		return maCD;
	}
	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}
	public String getTenCD() {
		return tenCD;
	}
	public void setTenCD(String tenCD) {
		this.tenCD = tenCD;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "ThongTinCD [maCD=" + maCD + ", tenCD=" + tenCD + ", tinhTrang=" + tinhTrang + ", soLuong=" + soLuong
				+ ", hangSanXuat=" + hangSanXuat + ", ghiChu=" + ghiChu + ", theLoai=" + theLoai + ", donGia=" + donGia
				+ "]";
	}
	

	
}
