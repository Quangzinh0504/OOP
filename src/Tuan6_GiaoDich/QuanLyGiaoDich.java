package Tuan6_GiaoDich;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuanLyGiaoDich {

    public static void main(String[] args) {

        // =========================================
        // TẠO DANH SÁCH ĐA HÌNH
        // =========================================
        List<GiaoDich> danhSach = new ArrayList<GiaoDich>();


        // =========================================
        // THÊM 3 GIAO DỊCH ĐẤT
        // =========================================
        danhSach.add(
            new GiaoDichDat(
                "GD001",
                LocalDate.of(2013, 9, 15),
                10_000_000,
                100,
                "A"
            )
        );

        danhSach.add(
            new GiaoDichDat(
                "GD002",
                LocalDate.of(2013, 10, 20),
                8_000_000,
                200,
                "B"
            )
        );

        danhSach.add(
            new GiaoDichDat(
                "GD003",
                LocalDate.of(2014, 1, 10),
                12_000_000,
                150,
                "C"
            )
        );


        // =========================================
        // THÊM 3 GIAO DỊCH NHÀ
        // =========================================
        danhSach.add(
            new GiaoDichNha(
                "GDN01",
                LocalDate.of(2013, 9, 25),
                15_000_000,
                80,
                "cao cấp",
                "Quận 1"
            )
        );

        danhSach.add(
            new GiaoDichNha(
                "GDN02",
                LocalDate.of(2013, 8, 5),
                10_000_000,
                120,
                "thường",
                "Quận 3"
            )
        );

        danhSach.add(
            new GiaoDichNha(
                "GDN03",
                LocalDate.of(2014, 2, 14),
                20_000_000,
                60,
                "cao cấp",
                "Quận 7"
            )
        );


        // =========================================
        // CÂU A:
        // TÍNH TỔNG SỐ LƯỢNG TỪNG LOẠI
        // =========================================
        int soLuongDat = 0;
        int soLuongNha = 0;

        for (GiaoDich gd : danhSach) {

            if (gd instanceof GiaoDichDat) {
                soLuongDat++;
            }

            if (gd instanceof GiaoDichNha) {
                soLuongNha++;
            }
        }

        System.out.println("===== SỐ LƯỢNG GIAO DỊCH =====");
        System.out.println("Số giao dịch đất: " + soLuongDat);
        System.out.println("Số giao dịch nhà: " + soLuongNha);


        // =========================================
        // CÂU B:
        // TRUNG BÌNH THÀNH TIỀN GIAO DỊCH ĐẤT
        // =========================================
        double tongTienDat = 0;

        for (GiaoDich gd : danhSach) {

            if (gd instanceof GiaoDichDat) {

                // Đa hình:
                // Java tự gọi thanhTien()
                // của GiaoDichDat
                tongTienDat += gd.thanhTien();
            }
        }

        double trungBinhTienDat = 0;

        if (soLuongDat > 0) {
            trungBinhTienDat =
                    tongTienDat / soLuongDat;
        }

        System.out.printf(
            "Trung bình thành tiền đất: %,.0f%n",
            trungBinhTienDat
        );


        // =========================================
        // CÂU C:
        // XUẤT GIAO DỊCH THÁNG 9 NĂM 2013
        // =========================================
        System.out.println();
        System.out.println(
            "===== GIAO DỊCH THÁNG 9/2013 ====="
        );

        for (GiaoDich gd : danhSach) {

            int thang =
                gd.getNgayGiaoDich().getMonthValue();

            int nam =
                gd.getNgayGiaoDich().getYear();

            if (thang == 9 && nam == 2013) {

                // Tự động gọi toString()
                // của GiaoDichDat hoặc GiaoDichNha
                System.out.println(gd);
            }
        }
    }
}