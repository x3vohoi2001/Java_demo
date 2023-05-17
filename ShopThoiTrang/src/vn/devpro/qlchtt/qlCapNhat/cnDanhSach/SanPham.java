package vn.devpro.qlchtt.qlCapNhat.cnDanhSach;

import vn.devpro.qlchtt.qlCapNhat.cnChungLoai.QuanLyChungLoai;
import vn.devpro.qlchtt.qlCapNhat.cnNhaCungCap.QuanLyNhaCungCap;

public class SanPham {
	private int ID;
	private int loaiID;
	private int nccID;
	private String name;
	private int amount;
	private double price;
	
	public void display() {
		System.out.printf("%-5s| %-15s| %-15s| %-21s| %-8d| %-,15.2f%n", this.ID,
				QuanLyChungLoai.getName(this.loaiID), QuanLyNhaCungCap.getName(this.nccID),
				this.name, this.amount, this.price);
	}
	public void update() {
		do {
			System.out.println("\n-------CAP NHAT THONG TIN SAN PHAM--------");
			System.out.println("Chon thong tin sua:");
			System.out.println("\t1. Sua Ten ");
			System.out.println("\t2. Sua Chung Loai");
			System.out.println("\t3. Sua Nha Cung Cap");
			System.out.println("\t4. Sua So Luong");
			System.out.println("\t5. Sua Gia Tien");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(QuanLySanPham.sc.nextLine());
			
			switch (chon) {
			case 1: 
				System.out.println("\t\t---SUA TEN---");
				System.out.print("\tNhap Ten moi: ");
				String name = QuanLySanPham.sc.nextLine();
				if(name.trim().length() == 0) {
					System.out.println("\tKhong duoc de trong Ten!");
					return;
				}
				if(QuanLySanPham.nameIsExist(name) != -1) {
					System.out.println("\tTen San Pham da ton tai!");
					return;
				}
				this.setName(name);
				System.out.println("\t-( Doi ten Thanh Cong! )-");
				break;
			case 2: 
				System.out.println("\t\t---SUA CHUNG LOAI---");
				System.out.print("\tNhap ID chung loai moi: ");
				int idloai = Integer.parseInt(QuanLySanPham.sc.nextLine());
				int index = QuanLyChungLoai.indexOfID(idloai);
				if(index == -1) {
					System.out.println("\tKhong tim thay Chung Loai!");
					return;
				}
				this.setLoaiID(idloai);
				System.out.println("\t-( Doi Thanh Cong! )-");
				System.out.println("-------------------------------");
				break;
			case 3: 
				System.out.println("\t\t---SUA NHA CUNG CAP---");
				System.out.print("\tNhap ID nha cung cap moi: ");
				int idncc = Integer.parseInt(QuanLySanPham.sc.nextLine());
				if(QuanLyNhaCungCap.indexOfID(idncc) == -1) {
					System.out.println("\tKhong tim thay nha cung cap!");
					return;
				}
				this.setLoaiID(idncc);;
				System.out.println("\t-( Doi Thanh Cong! )-");
				System.out.println("-------------------------------");
				break;
			case 4: 
				System.out.println("\t\t---SUA NHA SO LUONG---");
				System.out.print("\tNhap so luong moi: ");
				int amount = Integer.parseInt(QuanLySanPham.sc.nextLine());
				if(amount < 0) {
					System.out.println("\tSo luong khong hop le!");
					return;
				}
				this.setAmount(amount);
				System.out.println("\t-( Doi Thanh Cong! )-");
				System.out.println("-------------------------------");
				break;
			case 5: 
				System.out.println("\t\t---SUA NHA GIA TIEN---");
				System.out.print("\tNhap gia tien moi: ");
				int price = Integer.parseInt(QuanLySanPham.sc.nextLine());
				if(price < 0) {
					System.out.println("\tGia Tien khong hop le!");
					return;
				}
				this.setPrice(price);;
				System.out.println("\t-( Doi Thanh Cong! )-");
				System.out.println("-------------------------------");
				break;
			case 0: return;
			default:
				System.out.println("Lua chon khong hop le");
			}
			System.out.println("============================================");
		}while(true);
	}
	
	public SanPham() {
		super();
	}

	public SanPham(int iD, int loaiID, int nccID, String name, int amount, double price) {
		super();
		ID = iD;
		this.loaiID = loaiID;
		this.nccID = nccID;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getLoaiID() {
		return loaiID;
	}

	public void setLoaiID(int loaiID) {
		this.loaiID = loaiID;
	}

	public int getNccID() {
		return nccID;
	}

	public void setNccID(int nccID) {
		this.nccID = nccID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
