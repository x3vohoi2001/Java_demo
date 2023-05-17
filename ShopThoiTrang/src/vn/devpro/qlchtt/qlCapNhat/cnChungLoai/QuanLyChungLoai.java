package vn.devpro.qlchtt.qlCapNhat.cnChungLoai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QuanLyChungLoai {

	private static ArrayList<ChungLoai> list = new ArrayList<>();

	public static ArrayList<ChungLoai> getList() {
		return list;
	}
	static Scanner sc = new Scanner(System.in);
	
	public static int autoN = 101;
	public static void init() {
		list.add(new ChungLoai(autoN++, "Vay", "Trang Phuc"));
		list.add(new ChungLoai(autoN++, "Giay Dep", "Phu Kien"));
		list.add(new ChungLoai(autoN++, "Quan Ao", "Trang Phuc"));
		list.add(new ChungLoai(autoN++, "Tui Xach", "Phu Kien"));
		list.add(new ChungLoai(autoN++, "Balo", "Phu Kien"));
	}
	public static void quanLyChungLoai() {
		do {
			System.out.println("\n-------CAP NHAT THONG TIN CHUNG LOAI--------");
			System.out.println("Chon chuc nang cap nhat thong tin");
			System.out.println("\t1. Xem danh sach chung loai");
			System.out.println("\t2. Them chung loai moi");
			System.out.println("\t3. Sua thong tin chung loai");
			System.out.println("\t4. Xoa thong tin chung loai");
			System.out.println("\t5. Sap xep danh sach chung loai");
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
		System.out.println("\n-------DANH SACH CHUNG LOAI---------");
		System.out.printf("%-6s %-21s %-21s%n", "ID", "Ten Chung Loai", "Kieu");
		System.out.println("-----------------------------------------------");
		for(ChungLoai x: list) {
			x.display();
		}
	}
	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n--------NHAP CHUNG LOAI MOI-------");
		System.out.print("Ten cua chung loai:");
		String name = sc.nextLine();
		System.out.print("Kieu cua chung loai:");
		String kieu = sc.nextLine();
		
		if(name.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Ten!");
			return;
		}
		if(kieu.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Kieu!");
			return;
		}
		if(nameIsExist(name) != -1) {
			System.out.println("\tChung loai da ton tai!");
			return;
		}
		list.add(new ChungLoai(autoN++, name, kieu));
		System.out.println("\tThem moi thanh cong!");
		System.out.println("-----------------------------------------------");
	}
	private static void update() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID chung loai muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("\tChung loai khong co trong danh sach!");
			return;
		}
		list.get(index).update();
		System.out.println("-----------------------------------------------");
	}
	private static void remove() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID chung loai muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("\tChung loai khong co trong danh sach!");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thanh Cong");
		System.out.println("-----------------------------------------------");
	}
	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<ChungLoai>() {
			@Override
			public int compare(ChungLoai o1, ChungLoai o2) {
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
		for(ChungLoai x: list) {
			if(x.getID() == id) {
				return x.getName();
			}
		}return null;
	}
}
