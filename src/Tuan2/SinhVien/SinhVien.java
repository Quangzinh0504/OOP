package Tuan2.SinhVien;

import java.util.Scanner;

public class SinhVien {

    private int maSinhVien;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    // Constructor mặc định
    public SinhVien() {
        this.maSinhVien = 1;
        this.hoTen = "Chua co ten";
        this.diemLT = 0;
        this.diemTH = 0;
    }

    // Constructor đầy đủ thông tin
    public SinhVien(int maSinhVien, String hoTen, double diemLT, double diemTH) {
        setMaSinhVien(maSinhVien);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    // Getter và Setter mã sinh viên
    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        if (maSinhVien > 0) {
            this.maSinhVien = maSinhVien;
        } else {
            this.maSinhVien = 1;
        }
    }

    // Getter và Setter họ tên
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.trim().isEmpty()) {
            this.hoTen = hoTen;
        } else {
            this.hoTen = "Chua co ten";
        }
    }

    // Getter và Setter điểm LT
    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) {
        if (diemLT >= 0 && diemLT <= 10) {
            this.diemLT = diemLT;
        } else {
            this.diemLT = 0;
        }
    }

    // Getter và Setter điểm TH
    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        if (diemTH >= 0 && diemTH <= 10) {
            this.diemTH = diemTH;
        } else {
            this.diemTH = 0;
        }
    }

    // Tính điểm trung bình
    public double tinhDiemTrungBinh() {
        return (diemLT + diemTH) / 2;
    }

    // Hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return String.format(
                "%-12d %-25s %-10.2f %-10.2f %-10.2f",
                maSinhVien,
                hoTen,
                diemLT,
                diemTH,
                tinhDiemTrungBinh()
        );
    }

    // Hàm main
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Sinh viên 1
        SinhVien sv1 = new SinhVien(
                22663701,
                "Tran Quang Vinh",
                8.5,
                9.0
        );

        // Sinh viên 2
        SinhVien sv2 = new SinhVien(
                2,
                "Nguyen Van A",
                7.5,
                8.0
        );

        // Sinh viên 3 tạo bằng constructor mặc định
        SinhVien sv3 = new SinhVien();

        // Nhập thông tin sinh viên 3
        System.out.println("=== NHAP THONG TIN SINH VIEN 3 ===");

        System.out.print("Nhap MSSV: ");
        int maSV = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhap diem LT: ");
        double diemLT = scanner.nextDouble();

        System.out.print("Nhap diem TH: ");
        double diemTH = scanner.nextDouble();

        // Gán dữ liệu bằng setter
        sv3.setMaSinhVien(maSV);
        sv3.setHoTen(hoTen);
        sv3.setDiemLT(diemLT);
        sv3.setDiemTH(diemTH);

        // In danh sách sinh viên
        System.out.println("\n========== DANH SACH SINH VIEN ==========");

        System.out.printf(
                "%-12s %-25s %-10s %-10s %-10s%n",
                "MSSV",
                "Ho ten",
                "Diem LT",
                "Diem TH",
                "Diem TB"
        );

        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);

        scanner.close();
    }
}