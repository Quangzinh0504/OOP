package Tuan3_Bai08_TaiKhoan;

public class TestAccount {
    public static void main(String[] args) {
        Account acc1 = new Account(100001, "Nguyen Van A", 500000);
        Account acc2 = new Account(100002, "Tran Thi B", 200000);
        Account acc3 = new Account(100003, "Le Van C");

        System.out.println("=== DANH SÁCH TÀI KHOẢN BAN ĐẦU ===");
        inTieuDe();
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);

        System.out.println("\n--- GIAO DỊCH PHÁT SINH ---");
        // 1. Nạp tiền vào acc1
        if (acc1.napTien(150000)) {
            System.out.println("- Nạp 150.000 VNĐ vào acc1 thành công.");
        }

        // 2. Rút tiền từ acc2 (phí 2.000 VNĐ)
        if (acc2.rutTien(50000, 2000)) {
            System.out.println("- Rút 50.000 VNĐ từ acc2 thành công (phí 2.000 VNĐ).");
        }

        // 3. Chuyển khoản từ acc1 sang acc2
        if (acc1.chuyenKhoan(acc2, 100000)) {
            System.out.println("- Chuyển 100.000 VNĐ từ acc1 sang acc2 thành công.");
        }

        // 4. Đáo hạn lãi suất acc3
        acc3.daoHan();
        System.out.println("- Đã tính tiền lãi định kỳ cho acc3.");

        System.out.println("\n=== DANH SÁCH TÀI KHOẢN SAU GIAO DỊCH ===");
        inTieuDe();
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
    }

    private static void inTieuDe() {
        System.out.printf("%-15s %-25s %20s\n", "Số TK", "Tên Chủ TK", "Số Dư");
        System.out.println("------------------------------------------------------------------");
    }
}
