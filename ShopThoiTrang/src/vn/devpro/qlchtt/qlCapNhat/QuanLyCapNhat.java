package vn.devpro.qlchtt.qlCapNhat;

import java.util.Scanner;

import vn.devpro.qlchtt.qlCapNhat.cnChungLoai.QuanLyChungLoai;
import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.QuanLySanPham;
import vn.devpro.qlchtt.qlCapNhat.cnKhachHang.QuanLyKhachHang;
import vn.devpro.qlchtt.qlCapNhat.cnNhaCungCap.QuanLyNhaCungCap;


public class QuanLyCapNhat {
	static Scanner sc = new Scanner(System.in);
	
	public static void quanLyCapNhat() {
		do {
			System.out.println("\n========CHUC NANG CAP NHAT THONG TIN HE THONG=======");
			System.out.println("Chon chuc nang cap nhat he thong");
			System.out.println("\t1. Cap nhat nha cung cap.");
			System.out.println("\t2. Cap nhat chung loai.");
			System.out.println("\t3. Cap nhat danh sach san pham.");
			System.out.println("\t4. Cap nhat khach hang.");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1:  QuanLyNhaCungCap.quanLyNhaCungCap();
				break;
			case 2:  QuanLyChungLoai.quanLyChungLoai();
				break;
			case 3:  QuanLySanPham.quanLySanPham();
				break;
			case 4: QuanLyKhachHang.quanLyKhachHang();
				break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}	
		} while (true);
	}

}
