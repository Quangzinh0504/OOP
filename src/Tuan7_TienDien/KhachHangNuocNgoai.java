package Tuan7_TienDien;

import java.time.LocalDate;

public class KhachHangNuocNgoai extends KhachHang {
    private String quocTich;

    public KhachHangNuocNgoai(String ma, String ten, LocalDate ngay, double soKW, double donGia, String quocTich) {
        super(ma, ten, ngay, soKW, donGia);
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    @Override
    public double thanhTien() {
        return soKW * donGia;
    }
}