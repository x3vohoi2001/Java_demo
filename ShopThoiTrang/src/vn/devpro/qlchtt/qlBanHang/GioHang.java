package vn.devpro.qlchtt.qlBanHang;

import java.util.ArrayList;

import java.util.Scanner;

import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.QuanLySanPham;
import vn.devpro.qlchtt.qlCapNhat.cnDanhSach.SanPham;
import vn.devpro.qlchtt.qlCapNhat.cnKhachHang.QuanLyKhachHang;

public class GioHang {
	private int ID;
	private int khachID;
	private static ArrayList<Hang> list = new ArrayList<>();
	
	public void display() {
		System.out.println("\n\t--------GIO HANG CUA BAN--------");
		System.out.println("Ma gio: " + this.ID);
		System.out.println("Khach Hang: " + QuanLyKhachHang.getName(this.khachID));
		System.out.println("So Dien Thoai: " + QuanLyKhachHang.getSDT(this.khachID));
		System.out.println("Danh sach mua hang: ");
		System.out.printf("\t%-25s| %-10s| %-14s| %-15s%n","Ten hang",
				"So luong", "Don gia", "Thanh tien");
		System.out.println("----------------------------------------------------------------------------------");
		double tt = 0;
		for(Hang x:list) {
			x.display();
			tt += x.thanhTien();
		}
		System.out.printf("\t\t\t\t\t\tTong Thanh Tien: %,.2f%n" , tt);
		System.out.println("===================================================================================");
	}
	Scanner sc = new Scanner(System.in);
	public void add() {
		System.out.print("\tNhap ID San Pham: ");
		int idh = Integer.parseInt(sc.nextLine());
		int index1 = QuanLySanPham.indexOfID(idh); 
		if (index1 == -1) {
			System.out.println("\tSan khong co de ban");
			return;
		}
		System.out.print("\tNhap so luong can mua: ");
		int buyAmount = Integer.parseInt(sc.nextLine());
		
		if (buyAmount <= 0) {
			System.out.println("\tSo luong mua phai la so duong");
			return;
		}
		int index2 = indexOfGio(idh); //Chi so trong ds hang cua gio hang
		if (index2 != -1) {		//+ Hang da co trong gio
			buyAmount += list.get(index2).getAmount();
		}
		if (index2 != -1) { //hang da co trong gio
			list.get(index2).setAmount(buyAmount);;
		}
		else {//hang chua co trong gio
			list.add(new Hang(idh, buyAmount));
		}
		try {	
			buying(QuanLySanPham.getSanPham(idh) , buyAmount);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}finally {
			System.out.println("\t\tXin cam on!");
		}		
	}
	
	public  void buying(SanPham s, int buyAmount) throws  Exception{
		if(s.getAmount() < buyAmount) {
			throw new Exception("So luong vuot qua san pham hien co!");
		}else {
			s.setAmount(s.getAmount() - buyAmount);
		}
	}
	
	public void update() {
		//Chon loai hang
		System.out.print("\tNhap ID San Pham: ");
		int idh = Integer.parseInt(sc.nextLine());
		int index2 = indexOfGio(idh); 
		if (index2 != -1) {		
			System.out.print("\tNhap so luong mua moi: ");
			int buyAmount = Integer.parseInt(sc.nextLine());
			if (buyAmount <= 0) {
				System.out.println("\tSo luong mua phai la so duong");
				return;
			}else if(buyAmount ==0 ) {
				list.remove(index2);
				return;
			}else {
				int index1 = QuanLySanPham.indexOfID(idh);
				if(index1 == -1) {
					System.out.println("Co loi truy suat du lieu!");
					return;
				}
				try {
					buying(QuanLySanPham.getSanPham(idh) , buyAmount);
				}catch(Exception e) {
					System.out.println(e.getMessage());
					return;
				}
				list.get(index2).setAmount(buyAmount);
				System.out.println("\tSua hang trong gio thanh cong!");
			}
		}else {
			System.out.println("\tHang chua co trong gio!");
			return;
		}
	}
	
	public void remove() {
		System.out.print("\tNhap ID hang hoa: ");
		int idh = Integer.parseInt(sc.nextLine());
		int index2 = indexOfGio(idh);
		if (index2 != -1) {
			list.remove(index2);
			System.out.println("\tXoa hang trong gio thanh cong");
		}else {
			System.out.println("\tHang khong ton tai");
		}
	}
	
	public int indexOfGio(int idh) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getHangID() == idh) {
				return i;
			}
		}
		return -1;
	}
	public GioHang(int iD, int khachID) {
		super();
		ID = iD;
		this.khachID = khachID;
	}
	public GioHang() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getKhachID() {
		return khachID;
	}
	public void setKhachID(int khachID) {
		this.khachID = khachID;
	}
	public ArrayList<Hang> getList() {
		return list;
	}
	public static void setList(ArrayList<Hang> list) {
		GioHang.list = list;
	}
	
	
}
