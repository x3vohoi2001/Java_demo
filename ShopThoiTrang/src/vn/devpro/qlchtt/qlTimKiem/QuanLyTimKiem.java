package vn.devpro.qlchtt.qlTimKiem;

import java.util.Scanner;

import vn.devpro.qlchtt.qlTimKiem.TimKiemChungLoai.TimKiemChungLoai;
import vn.devpro.qlchtt.qlTimKiem.TimKiemGioHang.TimKiemGioHang;
import vn.devpro.qlchtt.qlTimKiem.TimKiemKhachHang.TimKiemKhachHang;
import vn.devpro.qlchtt.qlTimKiem.TimKiemNhaCungCap.TimKiemNCC;
import vn.devpro.qlchtt.qlTimKiem.TimKiemSanPham.TimKiemSanPham;

public class QuanLyTimKiem {
	static Scanner sc = new Scanner(System.in);
	public static void quanLyTimKiem() {
		do {
			System.out.println("\n----TIM KIEM THONG TIN---");
			System.out.println("Chon chua nang: ");
			System.out.println("\t1. Tìm kiếm nhà cung cấp.");
			System.out.println("\t2. Tìm kiểm chủng loại.");
			System.out.println("\t3. Tìm kiếm sản phẩm.");
			System.out.println("\t4. Tìm kiếm khách hàng.");
			System.out.println("\t4. Tìm kiếm giỏ hàng");
			System.out.println("\t0. quay lai");
			
			System.out.print("Lua chon: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: TimKiemNCC.timKiem();
				break;
			case 2: TimKiemChungLoai.timKiem();
				break;
			case 3: TimKiemSanPham.timKiem();
				break;
			case 4: TimKiemKhachHang.timKiem();
				break;
			case 5: TimKiemGioHang.timKiem();
				break;
			case 0: 
				return;
			default:System.out.println("Lua chon khong hop le");
			}
			
		}while(true);
	}
}
