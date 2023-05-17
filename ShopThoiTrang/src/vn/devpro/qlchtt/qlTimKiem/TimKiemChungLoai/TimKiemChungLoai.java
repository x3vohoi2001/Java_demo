package vn.devpro.qlchtt.qlTimKiem.TimKiemChungLoai;

import java.util.Scanner;

import vn.devpro.qlchtt.qlCapNhat.cnChungLoai.ChungLoai;
import vn.devpro.qlchtt.qlCapNhat.cnChungLoai.QuanLyChungLoai;

public class TimKiemChungLoai {
	static Scanner sc = new Scanner(System.in);
	public static void timKiem() {
		do {
			System.out.println("\n------Tim Kiem Chung Loai------");
			System.out.println("Chon muc tim kiem: ");
			System.out.println("\t1. Tim kiem theo ID");
			System.out.println("\t2. Tim kiem ten");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: timKiemID();
				break;
			case 2: timKiemTen();
				break;
			case 0: return;
			default: System.out.println("Khong hop le");
			}
		}while(true);
	}
	private static void timKiemID() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ID Chung Loai: ");
		int id = Integer.parseInt(sc.nextLine());
		
		int index = QuanLyChungLoai.indexOfID(id);
		if(index == -1) {
			System.out.println("\tKhong co chung loai nay!");
			return;
		}
		System.out.println("Ket qua: ");
		QuanLyChungLoai.getList().get(index).display();
	}
	private static void timKiemTen() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap Ten Chung Loai: ");
		String name = sc.nextLine();
		
		int dem =0;
		for(ChungLoai x : QuanLyChungLoai.getList()) {
			if(x.getName().trim().equalsIgnoreCase(name.trim()));{
				x.display();
				dem++;
			}
		}if(dem ==0) {
			System.out.println("\tKhong tim thay ket qua nao!");
		}
	}
}
