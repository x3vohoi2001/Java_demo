package vn.devpro.qlchtt.qlBanHang;

import java.util.ArrayList;
import java.util.Scanner;
import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.QuanLySanPham;
import vn.devpro.qlchtt.qlCapNhat.cnKhachHang.QuanLyKhachHang;


public class QuanLyBanHang {
	
	public static int autoNgio = 111;
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<GioHang> list = new ArrayList<>();
	
	public static void quanLyBanHang() {
		System.out.println("\n-------CHUC NANG QUAN LY BAN HANG---------");
		System.out.println("Chon doi tuong thuc hien");
		System.out.println("\t1. Gio Hang cua Khach");
		System.out.println("\t2. Danh sach gio hang");
		
		System.out.print("Lua chon cua ban: ");
		int chon = Integer.parseInt(sc.nextLine());
		if (chon == 1) {
			gioHangKhach();
		}
		else if (chon == 2) {
			checkGiohang();
		}
		else {
			System.out.println("Lua chon khong hop le");
		}
	}

	public static void gioHangKhach() {
		GioHang gio = new GioHang();
		System.out.println("\t\t-------------CHAO MUNG QUY KHACH-------------");
		do {
			System.out.println("===========================================");
			System.out.println("Chon thao tac voi gio hang cua ban");
			System.out.println("\t1. Xem gio hang");
			System.out.println("\t2. Them hang vao gio");
			System.out.println("\t3. Sua hang trong gio");
			System.out.println("\t4. Xoa hang khoi gio");
			System.out.println("\t5. Huy gio hang");
			System.out.println("\t6. Thanh toan gio hang");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: gio.display();
				break;
			case 2: gio.add(); 
				break;
			case 3: gio.update();
				break;
			case 4: gio.remove();
				break;
			case 5:
				System.out.println("\tDa huy gio hang");
				gio = null;
				return;
			case 6:
				thanhToanGioHang(gio);
				return;
			default:
				System.out.println("Lua chon khong hop le!");	
			}
		}while(true);
	}

	private static void thanhToanGioHang(GioHang gio) {
		// TODO Auto-generated method stub
		if (gio.getList().size() == 0) {
			System.out.println("Chua co hang trong gio!");
			return;
		}
		System.out.println("\n-----Thanh Toan Gio Hang-----");
		System.out.print("\tNhap ID khach hang:");
		int idk = Integer.parseInt(sc.nextLine());
		int index1 = QuanLyKhachHang.indexOfID(idk);
		if(index1 != -1) {
			gio.setKhachID(idk);
		}else {
			gio.setKhachID(QuanLyKhachHang.autoN);
			QuanLyKhachHang.add();
		}
		gio.setID(autoNgio ++);
		System.out.println();
		gio.display();
		
		System.out.println("\t\t\tCam on quy khach, hen gap lai!");
		for(Hang x: gio.getList()) {
			int index =QuanLySanPham.indexOfID(x.getHangID());
			if (index == -1) {
				System.out.println("\tLoi Truy suat du lieu");
				return;
			}
			QuanLySanPham.getList().get(index).setAmount(
					QuanLySanPham.getList().get(index).getAmount()- x.getAmount());
		}
		list.add(gio);
	}
	
	private static void checkGiohang() {
		// TODO Auto-generated method stub
		System.out.println("\t-----DANH SACH CAC GIO DA BAN-----");
		for(GioHang gio: list) {
			gio.display();
			System.out.print("------------------------------------------------------------");
		}
	}
}
