package Tuan5_HangThucPham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham implements Comparable<HangThucPham> {

    // =========================
    // THUỘC TÍNH
    // =========================
    private int id;
    private final String maHang;
    private String tenHang;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private float gia;

    private static int demSoLuong = 0;

    private static final DateTimeFormatter DTF =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");


    // =========================
    // CONSTRUCTOR MẶC ĐỊNH
    // =========================
    public HangThucPham() {
        this.id = ++demSoLuong;
        this.maHang = "MAC_DINH";
        this.tenHang = "Hàng mặc định";
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = LocalDate.now().plusDays(7);
        this.gia = 1.0f;
    }


    // =========================
    // CONSTRUCTOR ĐẦY ĐỦ
    // =========================
    public HangThucPham(
            String maHang,
            String tenHang,
            LocalDate ngaySanXuat,
            LocalDate ngayHetHan,
            float gia) {

        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Mã hàng không được để trống!");
        }

        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Tên hàng không được để trống!");
        }

        if (!kiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException(
                    "Ngày sản xuất không được là tương lai!");
        }

        if (!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException(
                    "Ngày hết hạn phải sau ngày sản xuất!");
        }

        if (gia <= 0) {
            throw new IllegalArgumentException(
                    "Giá phải lớn hơn 0!");
        }

        this.id = ++demSoLuong;
        this.maHang = maHang.trim();
        this.tenHang = tenHang.trim();
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.gia = gia;
    }


    // =========================
    // GETTER
    // =========================
    public int getId() {
        return id;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public float getGia() {
        return gia;
    }


    // =========================
    // SETTER
    // =========================
    public void setTenHang(String tenHang) {

        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Tên hàng không được để trống!");
        }

        this.tenHang = tenHang.trim();
    }


    public void setNgaySanXuatVaNgayHetHan(
            LocalDate ngaySanXuat,
            LocalDate ngayHetHan) {

        if (!kiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException(
                    "Ngày sản xuất không được là tương lai!");
        }

        if (!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException(
                    "Ngày hết hạn phải sau ngày sản xuất!");
        }

        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }


    public void setNgayHetHan(LocalDate ngayHetHan) {

        if (!kiemTraNgayHetHan(this.ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException(
                    "Ngày hết hạn phải sau ngày sản xuất!");
        }

        this.ngayHetHan = ngayHetHan;
    }


    public void setGia(float gia) {

        if (gia <= 0) {
            throw new IllegalArgumentException(
                    "Giá phải lớn hơn 0!");
        }

        this.gia = gia;
    }


    // =========================
    // KIỂM TRA NGÀY SẢN XUẤT
    // =========================
    public boolean kiemTraNgaySanXuat(LocalDate ngaySanXuat) {

        if (ngaySanXuat == null) {
            return false;
        }

        return !ngaySanXuat.isAfter(LocalDate.now());
    }


    // =========================
    // KIỂM TRA NGÀY HẾT HẠN
    // =========================
    public boolean kiemTraNgayHetHan(
            LocalDate ngaySanXuat,
            LocalDate ngayHetHan) {

        if (ngaySanXuat == null || ngayHetHan == null) {
            return false;
        }

        return ngayHetHan.isAfter(ngaySanXuat);
    }


    // =========================
    // KIỂM TRA ĐÃ HẾT HẠN
    // =========================
    public boolean kiemTraHetHan() {

        return LocalDate.now().isAfter(ngayHetHan);
    }


    // =========================
    // TRẠNG THÁI THỰC PHẨM
    // =========================
    public String trangThaiChiTiet() {

        LocalDate homNay = LocalDate.now();

        if (homNay.isBefore(ngaySanXuat)) {
            return "Chưa sản xuất";
        }

        if (homNay.isAfter(ngayHetHan)) {
            return "Hết hạn";
        }

        if (homNay.isEqual(ngayHetHan)) {
            return "Hết hạn hôm nay";
        }

        long soNgayConLai =
                ngayHetHan.toEpochDay()
                - homNay.toEpochDay();

        return "Còn " + soNgayConLai + " ngày";
    }


    // =========================
    // SO SÁNH THEO ID
    // =========================
    @Override
    public int compareTo(HangThucPham other) {

        if (other == null) {
            return 1;
        }

        return Integer.compare(
                this.id,
                other.id
        );
    }


    // =========================
    // HIỂN THỊ THÔNG TIN
    // =========================
    @Override
    public String toString() {

        return String.format(
                "| %-4d | %-10s | %-18s | %-12s | %-12s | %,10.0f |",
                id,
                maHang,
                tenHang,
                ngaySanXuat.format(DTF),
                ngayHetHan.format(DTF),
                gia
        );
    }
}