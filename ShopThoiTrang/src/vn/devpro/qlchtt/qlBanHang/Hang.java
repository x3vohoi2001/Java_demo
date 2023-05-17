package vn.devpro.qlchtt.qlBanHang;

import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.QuanLySanPham;
import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.SanPham;

public class Hang {
	private int hangID;
	private int amount;
	
	public void display() {
		SanPham x = QuanLySanPham.getSanPham(this.hangID);
		System.out.printf("\t%-25s| %10d| %,14.2f| %,15.2f%n",
				x.getName(), this.amount, x.getPrice(), this.thanhTien());
	}
	
	public double thanhTien() {
		SanPham x = QuanLySanPham.getSanPham(this.hangID);
		return this.amount * x.getPrice();
	}
	
	public Hang() {
		super();
	}
	public Hang(int hangID, int amount) {
		super();
		this.hangID = hangID;
		this.amount = amount;
	}
	public int getHangID() {
		return hangID;
	}
	public void setHangID(int hangID) {
		this.hangID = hangID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
