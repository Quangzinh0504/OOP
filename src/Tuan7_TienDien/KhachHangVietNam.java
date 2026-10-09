package Tuan7_TienDien;

import java.time.LocalDate;

public class KhachHangVietNam extends KhachHang {
    private String doiTuong;
    private double dinhMuc;

    public KhachHangVietNam(String ma, String ten, LocalDate ngay, double soKW, double donGia, String doiTuong, double dinhMuc) {
        super(ma, ten, ngay, soKW, donGia);
        this.doiTuong = doiTuong;
        this.dinhMuc = dinhMuc;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    @Override
    public double thanhTien() {
        return soKW <= dinhMuc
                ? soKW * donGia
                : dinhMuc * donGia
                  + (soKW - dinhMuc) * donGia * 2.5;
    }
}