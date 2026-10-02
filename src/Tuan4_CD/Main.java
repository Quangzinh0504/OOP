package Tuan4_CD;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        CDList ql = new CDList();

        int luaChon;

        do {
            System.out.println("\n========== QUẢN LÝ CD ==========");
            System.out.println("1. Thêm CD");
            System.out.println("2. Xóa CD theo mã");
            System.out.println("3. Cập nhật CD");
            System.out.println("4. Tìm CD theo mã");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Tính tổng giá thành");
            System.out.println("7. Sắp xếp giảm dần theo giá");
            System.out.println("8. Sắp xếp tăng dần theo tựa");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {

                case 1:
                    themCD(ql);
                    break;

                case 2:
                    xoaCD(ql);
                    break;

                case 3:
                    capNhatCD(ql);
                    break;

                case 4:
                    timCD(ql);
                    break;

                case 5:
                    ql.hienThiDanhSach();
                    break;

                case 6:
                    System.out.printf(
                        "Tổng giá thành: %,.2f VNĐ%n",
                        ql.tinhTongGiaThanh()
                    );
                    break;

                case 7:
                    ql.sapXepGiamDanTheoGia();
                    ql.hienThiDanhSach();
                    break;

                case 8:
                    ql.sapXepTangDanTheoTua();
                    ql.hienThiDanhSach();
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (luaChon != 0);

        sc.close();
    }


    // ==========================
    // THÊM CD
    // ==========================
    static void themCD(CDList ql) {

        try {
            System.out.print("Nhập mã CD: ");
            int ma = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tựa CD: ");
            String tua = sc.nextLine();

            System.out.print("Nhập số bài hát: ");
            int soBaiHat = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập giá thành: ");
            double giaThanh = Double.parseDouble(sc.nextLine());

            CD cd = new CD(
                ma,
                tua,
                soBaiHat,
                giaThanh
            );

            if (ql.themCD(cd)) {
                System.out.println("Thêm CD thành công!");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    // ==========================
    // XÓA CD
    // ==========================
    static void xoaCD(CDList ql) {

        System.out.print("Nhập mã CD cần xóa: ");
        int ma = Integer.parseInt(sc.nextLine());

        if (ql.xoaCD(ma)) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy CD!");
        }
    }


    // ==========================
    // CẬP NHẬT CD
    // ==========================
    static void capNhatCD(CDList ql) {

        System.out.print("Nhập mã CD cần cập nhật: ");
        int ma = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập tựa mới: ");
        String tua = sc.nextLine();

        System.out.print("Nhập số bài hát mới: ");
        int soBaiHat = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập giá mới: ");
        double giaThanh = Double.parseDouble(sc.nextLine());

        if (ql.capNhatCD(
                ma,
                tua,
                soBaiHat,
                giaThanh)) {

            System.out.println("Cập nhật thành công!");

        } else {
            System.out.println("Không tìm thấy CD!");
        }
    }


    // ==========================
    // TÌM CD
    // ==========================
    static void timCD(CDList ql) {

        System.out.print("Nhập mã CD cần tìm: ");
        int ma = Integer.parseInt(sc.nextLine());

        CD cd = ql.timTheoMa(ma);

        if (cd != null) {

            System.out.println("Tìm thấy:");
            System.out.println(cd);

        } else {

            System.out.println(
                "Không tìm thấy CD có mã " + ma
            );
        }
    }
}