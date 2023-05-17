package vn.devpro.qlchtt;

import java.util.Scanner;

import vn.devpro.qlchtt.qlBanHang.QuanLyBanHang;
import vn.devpro.qlchtt.qlCapNhat.QuanLyCapNhat;
import vn.devpro.qlchtt.qlCapNhat.cnChungLoai.QuanLyChungLoai;
import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.QuanLySanPham;
import vn.devpro.qlchtt.qlCapNhat.cnKhachHang.QuanLyKhachHang;
import vn.devpro.qlchtt.qlCapNhat.cnNhaCungCap.QuanLyNhaCungCap;
import vn.devpro.qlchtt.qlTimKiem.QuanLyTimKiem;

public class QuanLyShopThoiTrang {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		QuanLyChungLoai.init();
		QuanLyNhaCungCap.init();
		QuanLyKhachHang.init();
		QuanLySanPham.init();
		do {
			System.out.println("\n==========CHUONG TRINH QUAN LY==========");
			System.out.println("Chon mot chuc nang quan ly he thong:");
			System.out.println("\t1. Cap nhat thong tin he thong");
			System.out.println("\t2. Quan ly ban hang");
			System.out.println("\t3. Quan ly tim kiem");
			System.out.println("\t0. Thoat");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: QuanLyCapNhat.quanLyCapNhat(); 
				break;
			case 2: QuanLyBanHang.quanLyBanHang(); 
				break;
			case 3: QuanLyTimKiem.quanLyTimKiem();
				break;
			case 0:
				System.out.println("Da dong ung dung");
				System.exit(0);
			default: 
				System.out.println("Lua chon khong hop le");
			}
			System.out.println("============================================");
		} while (true);
	}
}
