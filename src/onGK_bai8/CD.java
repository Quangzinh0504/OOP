package onGK_bai8;

import java.util.Scanner;

public class CD {

	// =========================================================
	// 1. KHAI BAO THUOC TINH
	// =========================================================
	private String tuaCD;
	private String caSY;
	private int sBHat;
	private float giaThanh;
	private String maCD;

	// =========================================================
	// 2. DONG GOI VA RANG BUOC
	// =========================================================

	public String getMaCD() {
		return maCD;
	}

	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}

	public String getCaSY() {
		return caSY;
	}

	public void setCaSY(String caSY) {
		this.caSY = caSY;
	}

	public int getsBHat() {
		return sBHat;
	}

	public void setsBHat(int sBHat) {
		this.sBHat = sBHat;
	}

	public float getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}

	// =========================================================
	// 3. CONSTRUCTOR
	// =========================================================

	public CD(String tuaCD, String caSY, int soBai, float giaThanh, String maCD) throws Exception {

		this.tuaCD = tuaCD;
		this.caSY = caSY;

		// Rang buoc: so bai hat phai lon hon 0
		if (soBai > 0) {
			this.sBHat = soBai;
		} else {
			throw new Exception("So bai hat phai lon hon 0");
		}

		this.giaThanh = giaThanh;
		this.maCD = maCD;
	}

	// Constructor khong tham so
	public CD() {
	}

	// =========================================================
	// 4. TAO TIEU DE IN
	// =========================================================

	public static void tieuDe() {

		System.out.println("In danh sach CD");

		// In duong ke
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}

		System.out.println();

		// Tao tieu de cac cot
		String s = "";

		s = String.format(
				"|%-10s|%-20s|%-20s|%-12s|%-12s|%-15s|",
				"Ma CD",
				"Tua CD",
				"Ten Ca Sy",
				"So Bai Hat",
				"Don gia",
				"Thanh Tien"
		);

		System.out.println(s);

		// In duong ke
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}

		System.out.println();
	}

	// =========================================================
	// 5. TO STRING
	// =========================================================

	@Override
	public String toString() {

		return String.format(
				"|%-10s|%-20s|%-20s|%12d|%12.0f|%15.0f|",
				maCD,
				tuaCD,
				caSY,
				sBHat,
				giaThanh,
				sBHat * giaThanh
		);
	}

	// =========================================================
	// 6. HAM MAIN - NHAP TU BAN PHIM
	// =========================================================

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			// Nhap ma CD
			System.out.print("Nhap ma CD: ");
			String maCD = sc.nextLine();

			// Nhap tua CD
			System.out.print("Nhap tua CD: ");
			String tuaCD = sc.nextLine();

			// Nhap ten ca sy
			System.out.print("Nhap ten ca sy: ");
			String caSY = sc.nextLine();

			// Nhap so bai hat
			System.out.print("Nhap so bai hat: ");
			int soBai = sc.nextInt();

			// Nhap don gia
			System.out.print("Nhap don gia: ");
			float giaThanh = sc.nextFloat();

			// Tao doi tuong CD
			CD cd = new CD(
					tuaCD,
					caSY,
					soBai,
					giaThanh,
					maCD
			);

			// Goi ham tao tieu de
			CD.tieuDe();

			// Xuat thong tin CD
			System.out.println(cd);

			// In duong ket thuc bang
			for (int i = 0; i < 100; i++) {
				System.out.print("-");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}
}