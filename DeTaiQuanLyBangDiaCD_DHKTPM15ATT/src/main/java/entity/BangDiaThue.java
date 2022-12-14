package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BangDiaThue")
public class BangDiaThue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2452100195968503640L;
	@Id
	private int iD;
	private String maThanhVien;
	private String tenThanhVien;
	private String maCD;
	private String tenCD;
	private String maNhanVien;
	private String theLoai;
	private int soLuong;
	private LocalDate ngayThue;
	private LocalDate ngayTra;
	
	@ManyToOne
	@JoinColumn(name = "maNhanViens")
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name="maThanhViens")
	private ThanhVien thanhVien;
	
	@ManyToOne
	@JoinColumn(name = "maCDs")
	private ThongTinCD thongTinCD;

	public BangDiaThue() {
		super();
	}

	public BangDiaThue(int iD) {
		super();
		this.iD = iD;
	}

	public BangDiaThue(int iD, String maThanhVien, String tenThanhVien, String maCD, String tenCD, String maNhanVien,
			String theLoai, int soLuong, LocalDate ngayThue, LocalDate ngayTra, NhanVien nhanVien, ThanhVien thanhVien,
			ThongTinCD thongTinCD) {
		super();
		this.iD = iD;
		this.maThanhVien = maThanhVien;
		this.tenThanhVien = tenThanhVien;
		this.maCD = maCD;
		this.tenCD = tenCD;
		this.maNhanVien = maNhanVien;
		this.theLoai = theLoai;
		this.soLuong = soLuong;
		this.ngayThue = ngayThue;
		this.ngayTra = ngayTra;
		this.nhanVien = nhanVien;
		this.thanhVien = thanhVien;
		this.thongTinCD = thongTinCD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getTenThanhVien() {
		return tenThanhVien;
	}

	public void setTenThanhVien(String tenThanhVien) {
		this.tenThanhVien = tenThanhVien;
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

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public LocalDate getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}

	public LocalDate getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ThanhVien getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	}

	public ThongTinCD getThongTinCD() {
		return thongTinCD;
	}

	public void setThongTinCD(ThongTinCD thongTinCD) {
		this.thongTinCD = thongTinCD;
	}

	@Override
	public String toString() {
		return "BangDiaThue [iD=" + iD + ", maThanhVien=" + maThanhVien + ", tenThanhVien=" + tenThanhVien + ", maCD="
				+ maCD + ", tenCD=" + tenCD + ", maNhanVien=" + maNhanVien + ", theLoai=" + theLoai + ", soLuong="
				+ soLuong + ", ngayThue=" + ngayThue + ", ngayTra=" + ngayTra + ", nhanVien=" + nhanVien
				+ ", thanhVien=" + thanhVien + ", thongTinCD=" + thongTinCD + "]";
	}
	
	
	
}
