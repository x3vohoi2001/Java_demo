package vn.devpro.qlchtt.qlCapNhat.cnKhachHang;

import java.util.Scanner;

public class KhachHang {
	private int ID;
	private String name;
	private String sdt;
	
	public void display() {
		System.out.printf("%-5d| %-24s| %-14s%n", this.ID, this.name, this.sdt);
	}
	static Scanner sc = new Scanner(System.in);
	
	public void update() {
		System.out.print("Sua ten Khach Hang:");
		String name = sc.nextLine();
		System.out.print("Sua So Dien Thoai:");
		String sdt = sc.nextLine();
		
		if(name.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Ten!");
			return;
		}
		if(sdt.trim().length()==0) {
			System.out.println("\tKhong duoc de trong So Dien Thoai!");
			return;
		}
		if(QuanLyKhachHang.validSDT(sdt) == -1) {
			System.out.println("\tSo Dien Thoai Khong Hop Le!");
			return;
		}
		if(QuanLyKhachHang.nameIsExist(name) != -1 && QuanLyKhachHang.ktraSDT(sdt) != -1) {
			System.out.println("\tKhach Hang da ton tai!");
			return;
		}
		this.name = name;
		this.sdt = sdt;
		System.out.println("\tSua thanh cong!");
	}
	
	public KhachHang() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public KhachHang(int iD, String name, String sdt) {
		super();
		ID = iD;
		this.name = name;
		this.sdt = sdt;
	}
	
	
}
