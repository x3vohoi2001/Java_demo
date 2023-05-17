package vn.devpro.qlchtt.qlTimKiem.TimKiemKhachHang;

import java.util.Scanner;

import vn.devpro.qlchtt.qlCapNhat.cnKhachHang.KhachHang;
import vn.devpro.qlchtt.qlCapNhat.cnKhachHang.QuanLyKhachHang;

public class TimKiemKhachHang {
	static Scanner sc = new Scanner(System.in);
	public static void timKiem() {
		do {
			System.out.println("\n------Tim Kiem Khach Hang------");
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
		System.out.print("\tNhap ID Khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		
		int index = QuanLyKhachHang.indexOfID(id);
		if(index == -1) {
			System.out.println("\tKhong co Khach Hang nay!");
			return;
		}
		System.out.println("Ket qua: ");
		QuanLyKhachHang.getList().get(index).display();
	}
	private static void timKiemTen() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap Ten Khach Hang: ");
		String name = sc.nextLine();
		
		int dem =0;
		for(KhachHang x : QuanLyKhachHang.getList()) {
			if(x.getName().trim().equalsIgnoreCase(name.trim()));{
				x.display();
				dem++;
			}
		}if(dem ==0) {
			System.out.println("\tKhong tim thay ket qua nao!");
		}
	}
}
