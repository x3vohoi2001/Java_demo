package vn.devpro.qlchtt.qlCapNhat.cnNhaCungCap;

import java.util.Scanner;

public class NhaCungCap {
	private int ID;
	private String name;
	private String address;
	
	public void display() {
		System.out.printf("%-5d| %-15s| %-20s%n", this.ID, this.name, this.address);
	}
	static Scanner sc = new Scanner(System.in);
	public void update() {
		System.out.print("Sua ten nha cung cap:");
		String name = sc.nextLine();
		System.out.print("Sua Dia chi:");
		String address = sc.nextLine();
		
		if(name.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Ten!");
			return;
		}
		if(address.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Kieu!");
			return;
		}
		if(QuanLyNhaCungCap.nameIsExist(name) != -1) {
			System.out.println("\tChung loai da ton tai! Hay chon ten khac.");
			return;
		}
		this.name = name;
		this.address = address;
		System.out.println("\tSua thanh cong!");
	}
	
	public NhaCungCap() {
		super();
	}

	public NhaCungCap(int iD, String name, String address) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
