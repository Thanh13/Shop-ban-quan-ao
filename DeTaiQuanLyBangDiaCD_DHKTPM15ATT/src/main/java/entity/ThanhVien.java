package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ThanhVien")
public class ThanhVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2136212877194747564L;
	@Id
	private String maThanhVien;
	private String hoTenThanhVien;
	private String gioiTinh;
	private String soDienThoai;
	private String diaChi;
	private String cnThu;
	public ThanhVien(String maThanhVien, String hoTenThanhVien, String gioiTinh, String soDienThoai, String diaChi,
			String cnThu) {
		super();
		this.maThanhVien = maThanhVien;
		this.hoTenThanhVien = hoTenThanhVien;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.cnThu = cnThu;
	}
	public ThanhVien() {
		super();
	}
	public String getMaThanhVien() {
		return maThanhVien;
	}
	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}
	public String getHoTenThanhVien() {
		return hoTenThanhVien;
	}
	public void setHoTenThanhVien(String hoTenThanhVien) {
		this.hoTenThanhVien = hoTenThanhVien;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getCnThu() {
		return cnThu;
	}
	public void setCnThu(String cnThu) {
		this.cnThu = cnThu;
	}
	@Override
	public String toString() {
		return "ThanhVien [maThanhVien=" + maThanhVien + ", hoTenThanhVien=" + hoTenThanhVien + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", cnThu=" + cnThu + "]";
	}
	
	
	
}
