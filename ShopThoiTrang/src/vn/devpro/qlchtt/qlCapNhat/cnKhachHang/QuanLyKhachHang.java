package vn.devpro.qlchtt.qlCapNhat.cnKhachHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QuanLyKhachHang {

	private static ArrayList<KhachHang> list = new ArrayList<>();

	public static ArrayList<KhachHang> getList() {
		return list;
	}
	static Scanner sc = new Scanner(System.in);
	
	public static int autoN = 1001;
	public static void init() {
		list.add(new KhachHang(autoN++, "Phi Duc Duy", "0332603626"));
		list.add(new KhachHang(autoN++, "Trinh Xuan Du", "0338382086"));
		list.add(new KhachHang(autoN++, "Luu Cong Truong", "0362848241"));
		list.add(new KhachHang(autoN++, "Nguyen Cong Tuyen", "0368721777"));		
	}
	
	public static void quanLyKhachHang() {
		do {
			System.out.println("\n-------CAP NHAT THONG TIN KHACH HANG--------");
			System.out.println("Chon chuc nang cap nhat thong tin");
			System.out.println("\t1. Xem danh sach Khach Hang");
			System.out.println("\t2. Them Khach Hang moi");
			System.out.println("\t3. Sua thong tin Khach Hang");
			System.out.println("\t4. Xoa thong tin Khach Hang");
			System.out.println("\t5. Sap xep danh sach Khach Hang");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: display(); break;
			case 2: add(); break;
			case 3: update(); break;
			case 4: remove(); break;
			case 5: sort(); break;
			case 0: return;
			default:
				System.out.println("Lua chon khong hop le");
			}
			System.out.println("============================================");
		}while(true);
	}
	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("\n-------DANH SACH KHACH HANG---------");
		System.out.printf("%-6s %-25s %-15s%n", "ID", "Ten Khach Hang", "So Dien Thoai");
		System.out.println("-----------------------------------------------");
		for(KhachHang x: list) {
			x.display();
		}
	}
	public static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n--------NHAP KHACH HANG MOI-------");
		System.out.print("Ten cua Khach Hang:");
		String name = sc.nextLine();
		System.out.print("SDT cua Khach Hang:");
		String sdt = sc.nextLine();
		
		if(name.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Ten!");
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
		if(nameIsExist(name) != -1) {
			System.out.println("\tKhach Hang da ton tai!");
			return;
		}
		list.add(new KhachHang(autoN++, name, sdt));
		System.out.println("\tThem moi thanh cong!");
		System.out.println("-----------------------------------------------");
	}
	private static void update() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID Khach Hang muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("\tKhach Hang khong co trong danh sach!");
			return;
		}
		list.get(index).update();
		System.out.println("-----------------------------------------------");
	}
	private static void remove() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID Khach Hang muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("\tKhach Hang khong co trong danh sach!");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thanh Cong");
		System.out.println("-----------------------------------------------");
	}
	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("\tDa Sap Xep Thanh Cong!");
	}
	
	//Ham chung
	//+Tim kiem theo ten Chung Loai
	public static int nameIsExist(String name) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().trim().compareToIgnoreCase(name.trim())==0) {
				return i;
			}
		}return -1;
	}
	public static int ktraSDT(String sdt) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSdt().trim().compareToIgnoreCase(sdt.trim()) == 0) {
				return i;
			}
		}return -1;
	}
	
	//+Tim kiem theo ID
	public static int indexOfID(int id) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getID() == id) {
				return i;
			}
		}return -1;
	}
	//Nhap Id tim ten
	public static String getName(int id) {
		for(KhachHang x: list) {
			if(x.getID() == id) {
				return x.getName();
			}
		}return null;
	}
	public static String getSDT(int id) {
		for(KhachHang x: list) {
			if(x.getID() == id) {
				return x.getSdt();
			}
		}return null;
	}
	public static int validSDT(String sdt) {
		if(sdt.matches("[0-9]+")) {
			return 1;
		}else {
			return -1;
		}
	}
}
