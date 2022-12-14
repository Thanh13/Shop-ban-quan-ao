package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BangDiaTra")
public class BangDiaTra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8418370147981054852L;
	@Id
	private int iD;
	private String tenTV;
	private String maTV;
	private String maCD;
	private String maNV;
	private int sL;
	private double thanhTien;
	private double phiTraThem;
	private LocalDate ngayTra;
	private String ghiChu;
	
	@ManyToOne
	@JoinColumn(name = "maNhanViens")
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name="maThanhViens")
	private ThanhVien thanhVien;
	
	@ManyToOne
	@JoinColumn(name = "maCDs")
	private ThongTinCD thongTinCD;

	public BangDiaTra() {
		super();
	}

	public BangDiaTra(int iD, String tenTV, String maTV, String maCD, String maNV, int sL, double thanhTien,
			double phiTraThem, LocalDate ngayTra, String ghiChu, NhanVien nhanVien, ThanhVien thanhVien,
			ThongTinCD thongTinCD) {
		super();
		this.iD = iD;
		this.tenTV = tenTV;
		this.maTV = maTV;
		this.maCD = maCD;
		this.maNV = maNV;
		this.sL = sL;
		this.thanhTien = thanhTien;
		this.phiTraThem = phiTraThem;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
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

	public String getTenTV() {
		return tenTV;
	}

	public void setTenTV(String tenTV) {
		this.tenTV = tenTV;
	}

	public String getMaTV() {
		return maTV;
	}

	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}

	public String getMaCD() {
		return maCD;
	}

	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public int getsL() {
		return sL;
	}

	public void setsL(int sL) {
		this.sL = sL;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public double getPhiTraThem() {
		return phiTraThem;
	}

	public void setPhiTraThem(double phiTraThem) {
		this.phiTraThem = phiTraThem;
	}

	public LocalDate getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
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
		return "BangDiaTra [iD=" + iD + ", tenTV=" + tenTV + ", maTV=" + maTV + ", maCD=" + maCD + ", maNV=" + maNV
				+ ", sL=" + sL + ", thanhTien=" + thanhTien + ", phiTraThem=" + phiTraThem + ", ngayTra=" + ngayTra
				+ ", ghiChu=" + ghiChu + ", nhanVien=" + nhanVien + ", thanhVien=" + thanhVien + ", thongTinCD="
				+ thongTinCD + "]";
	}
	
	
}
