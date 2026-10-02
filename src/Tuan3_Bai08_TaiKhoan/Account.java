package Tuan3_Bai08_TaiKhoan;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private long soTK;
    private String tenTK;
    private double soDu;
    private static final double LAI_SUAT = 0.035;

    // Constructor mặc định
    public Account() {
        this(999999, "Chưa xác định", 50000);
    }

    // Constructor đầy đủ tham số
    public Account(long soTK, String tenTK, double soDu) {
        setSoTK(soTK);
        setTenTK(tenTK);
        setSoDu(soDu);
    }

    // Constructor khởi tạo số dư mặc định 50.000 VNĐ
    public Account(long soTK, String tenTK) {
        this(soTK, tenTK, 50000);
    }

    public long getSoTK() {
        return soTK;
    }

    public void setSoTK(long soTK) {
        if (soTK > 0) {
            this.soTK = soTK;
        } else {
            this.soTK = 999999;
        }
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        if (tenTK != null && !tenTK.trim().isEmpty()) {
            this.tenTK = tenTK;
        } else {
            this.tenTK = "Chưa xác định";
        }
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        if (soDu >= 50000) {
            this.soDu = soDu;
        } else {
            this.soDu = 50000;
        }
    }

    // Nạp tiền
    public boolean napTien(double soTien) {
        if (soTien > 0) {
            this.soDu += soTien;
            return true;
        }
        return false;
    }

    // Rút tiền kèm phí rút
    public boolean rutTien(double soTien, double phiRut) {
        if (soTien > 0 && (soTien + phiRut) <= this.soDu) {
            this.soDu -= (soTien + phiRut);
            return true;
        }
        return false;
    }

    // Đáo hạn tiền gửi
    public void daoHan() {
        this.soDu += this.soDu * LAI_SUAT;
    }

    // Chuyển khoản sang tài khoản khác
    public boolean chuyenKhoan(Account accDich, double soTien) {
        if (accDich != null && soTien > 0 && soTien <= this.soDu) {
            this.soDu -= soTien;
            accDich.napTien(soTien);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Locale local = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(local);
        return String.format("%-15d %-25s %20s", soTK, tenTK, formatter.format(soDu));
    }
}
