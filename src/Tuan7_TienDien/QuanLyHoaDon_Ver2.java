package Tuan7_TienDien;

import java.time.LocalDate;

public class QuanLyHoaDon_Ver2 {

    public static void main(String[] args) {

        ListQuanLy<KhachHang> ql = new ListQuanLy<>();

        ql.themNhieu(
            new KhachHangVietNam("VN01", "Nguyen Van A",
                LocalDate.of(2018, 9, 10),
                100, 1500, "sinh hoat", 50),

            new KhachHangVietNam("VN02", "Tran Thi B",
                LocalDate.of(2018, 10, 5),
                200, 2000, "kinh doanh", 100),

            new KhachHangVietNam("VN03", "Le Van C",
                LocalDate.of(2019, 1, 20),
                80, 1800, "san xuat", 60),

            new KhachHangNuocNgoai("NN01", "John Smith",
                LocalDate.of(2018, 9, 25),
                150, 2500, "My"),

            new KhachHangNuocNgoai("NN02", "Yuki Tanaka",
                LocalDate.of(2018, 8, 15),
                120, 3000, "Nhat"),

            new KhachHangNuocNgoai("NN03", "Kim Min Su",
                LocalDate.of(2019, 3, 8),
                90, 2800, "Han")
        );

        // Đếm khách hàng Việt Nam
        System.out.println("VN: " +
            ql.dem(kh -> kh instanceof KhachHangVietNam));

        // Đếm khách hàng nước ngoài
        System.out.println("NN: " +
            ql.dem(kh -> kh instanceof KhachHangNuocNgoai));

        // Hiển thị tất cả hóa đơn
        System.out.println("\n=== DANH SACH HOA DON ===");
        ql.hienThi();
    }
}