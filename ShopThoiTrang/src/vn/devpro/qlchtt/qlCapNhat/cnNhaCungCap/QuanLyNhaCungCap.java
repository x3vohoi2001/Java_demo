package vn.devpro.qlchtt.qlCapNhat.cnNhaCungCap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QuanLyNhaCungCap {

	private static ArrayList<NhaCungCap> list = new ArrayList<>();

	public static ArrayList<NhaCungCap> getList() {
		return list;
	}
	static Scanner sc = new Scanner(System.in);
	
	public static int autoN = 11;
	public static void init() {
		list.add(new NhaCungCap(autoN++, "Vans", "Dong Xuan market"));
		list.add(new NhaCungCap(autoN++, "Gucci", "Cong Trang market"));
		list.add(new NhaCungCap(autoN++, "Converse", "America"));
	}
	public static void quanLyNhaCungCap() {
		do {
			System.out.println("\n-------CAP NHAT THONG TIN NHA CUNG CAP--------");
			System.out.println("Chon chuc nang cap nhat thong tin");
			System.out.println("\t1. Xem danh sach NCC");
			System.out.println("\t2. Them NCC moi");
			System.out.println("\t3. Sua thong tin NCC");
			System.out.println("\t4. Xoa thong tin NCC");
			System.out.println("\t5. Sap xep danh sach NCC");
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
		System.out.println("\n-------DANH SACH NHA CUNG CAP---------");
		System.out.printf("%-6s %-16s %-10s%n", "ID", "Nha Cung Cap", "Dia chi");
		System.out.println("-----------------------------------------------");
		for(NhaCungCap x: list) {
			x.display();
		}
	}
	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n--------NHAP THONG TIN NHA CUNG CAP MOI-------");
		System.out.print("Ten cua NCC:");
		String name = sc.nextLine();
		System.out.print("Dia chi cua NCC:");
		String address = sc.nextLine();
		
		if(name.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Ten NCC!");
			return;
		}
		if(address.trim().length()==0) {
			System.out.println("\tKhong duoc de trong Dia Chi!");
			return;
		}
		if(nameIsExist(name) != -1) {
			System.out.println("\tNCC da ton tai!");
			return;
		}
		list.add(new NhaCungCap(autoN++, name, address));
		System.out.println("\tThem moi thanh cong!");
		System.out.println("-----------------------------------------------");
	}
	private static void update() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID NCC muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("\tNha Cung Cap khong co trong danh sach!");
			return;
		}
		list.get(index).update();
		System.out.println("-----------------------------------------------");
	}
	private static void remove() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ID NCC muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfID(id);
		if(index == -1) {
			System.out.println("\tNha Cung Cap khong co trong danh sach!");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thanh Cong");
		System.out.println("-----------------------------------------------");
	}
	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<NhaCungCap>() {
			@Override
			public int compare(NhaCungCap o1, NhaCungCap o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("\tDa Sap Xep Thanh Cong!");
	}
	
	//Ham chung
	//+Tim kiem theo ten NCC
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
		for(NhaCungCap x: list) {
			if(x.getID() == id) {
				return x.getName();
			}
		}return null;
	}
}
