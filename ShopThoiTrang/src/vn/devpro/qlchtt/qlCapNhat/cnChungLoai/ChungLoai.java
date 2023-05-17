package vn.devpro.qlchtt.qlCapNhat.cnChungLoai;

import java.util.Scanner;

public class ChungLoai {
	private int ID;
	private String name;
	private String kieu;
	
	public void display() {
		System.out.printf("%-5d| %-20s| %-20s%n", this.ID, this.name, this.kieu);
	}
	static Scanner sc = new Scanner(System.in);
	public void update() {
		System.out.print("Sua ten chung loai:");
		String name = sc.nextLine();
		System.out.print("Sua ten kieu:");
		String kieu = sc.nextLine();
		
		if(name.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Ten!");
			return;
		}
		if(kieu.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Kieu!");
			return;
		}
		if(QuanLyChungLoai.nameIsExist(name) != -1) {
			System.out.println("\tChung loai da ton tai! Hay chon ten khac.");
			return;
		}
		this.name = name;
		this.kieu = kieu;
		System.out.println("\tSua thanh cong!");
	}
	
	public ChungLoai() {
		super();
	}

	public ChungLoai(int iD, String name, String kieu) {
		super();
		ID = iD;
		this.name = name;
		this.kieu = kieu;
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

	public String getKieu() {
		return kieu;
	}

	public void setKieu(String kieu) {
		this.kieu = kieu;
	}
	
	
}
