package tuan3.BaiCD;

import java.util.Scanner;

public class ListCD {

	// =========================================================
	// 1. KHAI BAO
	// =========================================================
	CD[] cd;
	int count;

	// =========================================================
	// 2. CONSTRUCTOR
	// =========================================================
	public ListCD(int n) {
		cd = new CD[n];
		count = 0;
	}

	// =========================================================
	// 3. THEM CD
	// =========================================================
	public boolean themCD(CD crom) {

		if (count < cd.length) {
			cd[count] = crom;
			count++;
			return true;
		}

		return false;
	}

	// =========================================================
	// 4. TIM CD THEO MA
	// =========================================================
	public CD tim(String maCD) {

		for (int i = 0; i < count; i++) {

			if (cd[i].getMaCD().equalsIgnoreCase(maCD)) {
				return cd[i];
			}
		}

		return null;
	}

	// =========================================================
	// 5. XOA CD THEO MA
	// =========================================================
	public boolean xoa(String maCD) {

		for (int i = 0; i < count; i++) {

			if (cd[i].getMaCD().equalsIgnoreCase(maCD)) {

				for (int j = i; j < count - 1; j++) {
					cd[j] = cd[j + 1];
				}

				cd[count - 1] = null;
				count--;

				return true;
			}
		}

		return false;
	}

	// =========================================================
	// 6. XUAT DANH SACH CD
	// =========================================================
	public void xuatDanhSach() {

		CD.tieuDe();

		for (int i = 0; i < count; i++) {
			System.out.println(cd[i]);
		}

		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}

		System.out.println();
	}

	// =========================================================
	// 7. HAM MAIN
	// =========================================================
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so luong CD toi da: ");
		int n = sc.nextInt();
		sc.nextLine();

		ListCD ds = new ListCD(n);

		int chon;

		do {

			System.out.println();
			System.out.println("========== MENU ==========");
			System.out.println("1. Them CD");
			System.out.println("2. Tim CD theo ma");
			System.out.println("3. Xoa CD theo ma");
			System.out.println("4. Xuat danh sach CD");
			System.out.println("0. Thoat");
			System.out.println("===========================");
			System.out.print("Nhap lua chon: ");

			chon = sc.nextInt();
			sc.nextLine();

			switch (chon) {

			// -------------------------------------------------
			// THEM CD
			// -------------------------------------------------
			case 1:

				if (ds.count >= ds.cd.length) {
					System.out.println("Danh sach da day!");
					break;
				}

				System.out.print("Nhap ma CD: ");
				String maCD = sc.nextLine();

				// Kiem tra ma CD da ton tai
				if (ds.tim(maCD) != null) {
					System.out.println("Ma CD da ton tai!");
					break;
				}

				System.out.print("Nhap tua CD: ");
				String tuaCD = sc.nextLine();

				System.out.print("Nhap ten ca sy: ");
				String caSY = sc.nextLine();

				System.out.print("Nhap so bai hat: ");
				int soBai = sc.nextInt();

				System.out.print("Nhap don gia: ");
				float giaThanh = sc.nextFloat();
				sc.nextLine();

				try {

					CD cdMoi = new CD(
							tuaCD,
							caSY,
							soBai,
							giaThanh,
							maCD
					);

					if (ds.themCD(cdMoi)) {
						System.out.println("Them CD thanh cong!");
					} else {
						System.out.println("Them CD that bai!");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			// -------------------------------------------------
			// TIM CD
			// -------------------------------------------------
			case 2:

				System.out.print("Nhap ma CD can tim: ");
				String maTim = sc.nextLine();

				CD ketQua = ds.tim(maTim);

				if (ketQua != null) {

					CD.tieuDe();
					System.out.println(ketQua);

				} else {
					System.out.println("Khong tim thay CD!");
				}

				break;

			// -------------------------------------------------
			// XOA CD
			// -------------------------------------------------
			case 3:

				System.out.print("Nhap ma CD can xoa: ");
				String maXoa = sc.nextLine();

				if (ds.xoa(maXoa)) {
					System.out.println("Xoa CD thanh cong!");
				} else {
					System.out.println("Khong tim thay CD!");
				}

				break;

			// -------------------------------------------------
			// XUAT DANH SACH
			// -------------------------------------------------
			case 4:

				if (ds.count == 0) {
					System.out.println("Danh sach CD rong!");
				} else {
					ds.xuatDanhSach();
				}

				break;

			// -------------------------------------------------
			// THOAT
			// -------------------------------------------------
			case 0:

				System.out.println("Ket thuc chuong trinh!");

				break;

			default:

				System.out.println("Lua chon khong hop le!");

				break;
			}

		} while (chon != 0);

		sc.close();
	}
}