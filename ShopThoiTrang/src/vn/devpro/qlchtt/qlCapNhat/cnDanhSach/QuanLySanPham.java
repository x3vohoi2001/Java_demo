package vn.devpro.qlchtt.qlCapNhat.cnDanhSach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlchtt.qlCapNhat.cnChungLoai.QuanLyChungLoai;
import vn.devpro.qlchtt.qlCapNhat.cnNhaCungCap.QuanLyNhaCungCap;


public class QuanLySanPham {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<SanPham> list = new ArrayList<>();
	
	public static ArrayList<SanPham> getList() {
		return list;
	}
	public static int autoN = 10001;
	public static void init() {
		list.add(new SanPham(autoN++, 102, 13, "Giay Cao Co nam", 14, 1700000));
		list.add(new SanPham(autoN++, 104, 12, "Tui deo cheo", 4, 17000000));
		list.add(new SanPham(autoN++, 102, 11, "Giay Balenciaga", 10, 7000000));
		list.add(new SanPham(autoN++, 103, 13, "Ao thun", 14, 550000));
	}
	
	public static void quanLySanPham() {
		do {
			System.out.println("\n-------CAP NHAT THONG TIN SAN PHAM--------");
			System.out.println("Chon chuc nang cap nhat thong tin");
			System.out.println("\t1. Xem danh sach san pham");
			System.out.println("\t2. Them san pham moi");
			System.out.println("\t3. Sua thong tin san pham");
			System.out.println("\t4. Xoa thong tin san pham");
			System.out.println("\t5. Sap xep danh sach san pham");
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
				System.out.println("Lua chon khong hop le!");
			}
			System.out.println("=======================================================================================");
		} while (true);
		
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("\n\t-------DANH SACH SAN PHAM---------");
		System.out.printf("%-6s %-16s %-16s %-21s %-9s %-15s%n", 
				"ID", "Chung Loai", "Nha Cung Cap","Ten San Pham", "So Luong", "Gia Tien");
		System.out.println("--------------------------------------------------------------------------------------");
		for(SanPham x: list) {
			x.display();
		}
	}
	
	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n-------THEM SAN PHAM---------");
		System.out.print("\tNhap ID chung loai: ");
		int loaiID = Integer.parseInt(sc.nextLine());
		if(QuanLyChungLoai.indexOfID(loaiID) == -1) {
			System.out.println("\tChua co chung loai nay!");
			return;
		}
		System.out.print("\tNhap ID Nha Cung Cap: ");
		int nccID = Integer.parseInt(sc.nextLine());
		if(QuanLyNhaCungCap.indexOfID(nccID) == -1) {
			System.out.println("\tChua co Nha Cung Cap nay!");
			return;
		}
		
		System.out.print("\tNhap Ten San Pham: ");
		String name = sc.nextLine();
		if(name.trim().length() ==0) {
			System.out.println("\tKhong duoc de trong Ten!");
			return;
		}
		System.out.print("\tNhap So Luong: ");
		int amount = Integer.parseInt(sc.nextLine());
		if(amount <= 0) {
			System.out.println("\tSo Luong Khong Hop Le!");
			return;
		}
		System.out.print("\tNhap Gia Tien: ");
		int price = Integer.parseInt(sc.nextLine());
		if(price <0) {
			System.out.println("\tGia Tien Khong Hop le!");
			return;
		}
		
		list.add(new SanPham(autoN++, loaiID, nccID, name, amount, price));
		System.out.println("\tThem Moi Thanh Cong!");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID San pham muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("Khong Co San pham nay!");
			return;
		}
		
		list.get(index).update();
	}

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID San pham muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		if(indexOfID(id) == -1) {
			System.out.println("Khong Co San pham nay!");
			return;
		}
		list.remove(id);
	}

	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham o1, SanPham o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("\tDa Sap Xep Thanh Cong!");
	}
	public static int indexOfID(int id) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getID() == id) {
				return i;
			}
		}return -1;
	}
	public static int nameIsExist(String name) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().trim().compareToIgnoreCase(name.trim())==0) {
				return i;
			}
		}return -1;
	}
	public static String getName(int id) {
		for(SanPham x: list) {
			if(x.getID() == id) {
				return x.getName();
			}
		}return null;
	}
	public static SanPham getSanPham(int id) {
		for(SanPham x: list) {
			if(x.getID() == id) {
				return x;
			}
		}return null;
	}
	
}
