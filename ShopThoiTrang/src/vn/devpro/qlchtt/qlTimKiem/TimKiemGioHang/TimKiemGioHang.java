package vn.devpro.qlchtt.qlTimKiem.TimKiemGioHang;

import java.util.Scanner;

import vn.devpro.qlchtt.qlBanHang.GioHang;


public class TimKiemGioHang {
	static Scanner sc = new Scanner(System.in);
	public static void timKiem() {
		do {
			System.out.println("\n------Tim Kiem Gio Hang------");
			System.out.println("Chon muc tim kiem: ");
			System.out.println("\t1. Tim kiem theo ID");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: timKiemID();
				break;
			case 0: return;
			default: System.out.println("Khong hop le");
			}
		}while(true);
	}
	private static void timKiemID() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ID gio hang: ");
		int id = Integer.parseInt(sc.nextLine());
		GioHang gio = new GioHang();
		int index = gio.indexOfGio(id);
		if(index == -1) {
			System.out.println("\tKhong co gio hang nay!");
			return;
		}
		System.out.println("Ket qua: ");
		gio.getList().get(index).display();
	}
	
}
