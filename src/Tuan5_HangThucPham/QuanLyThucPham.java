package Tuan5_HangThucPham;

import java.time.LocalDate;

public class QuanLyThucPham {
    private HangThucPham[] danhSach;
    private int soLuong;
    private int khaNang;

    private static final int KICH_THUOC_BAN_DAU = 5;

    public QuanLyThucPham() {
        this.khaNang = KICH_THUOC_BAN_DAU;
        this.danhSach = new HangThucPham[khaNang];
        this.soLuong = 0;
    }

    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;
        HangThucPham[] mangMoi = new HangThucPham[kichThuocMoi];
        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i];
        }
        danhSach = mangMoi;
        khaNang = kichThuocMoi;
        System.out.println("Đã mở rộng mảng lên " + khaNang + " phần tử.");
    }

    public int timViTriTheoMa(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang)) {
                return i;
            }
        }
        return -1;
    }

    public int timViTriTheoId(int id) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getId() == id) return i;
        }
        return -1;
    }

    public boolean them(HangThucPham h) {
        if (h == null) return false;
        if (timViTriTheoMa(h.getMaHang()) != -1) {
            System.out.println("Lỗi: Mã hàng đã tồn tại!");
            return false;
        }
        if (soLuong >= khaNang) {
            moRongMang();
        }
        danhSach[soLuong++] = h;
        return true;
    }

    public boolean xoa(int id) {
        int index = timViTriTheoId(id);
        if (index == -1) return false;
        for (int i = index; i < soLuong - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }
        danhSach[--soLuong] = null;
        return true;
    }

    public boolean sua(int id, String tenMoi, LocalDate sxMoi, LocalDate hhMoi, float giaMoi) {
        int index = timViTriTheoId(id);
        if (index == -1) return false;
        HangThucPham h = danhSach[index];
        h.setTenHang(tenMoi);
        h.setNgaySanXuatVaNgayHetHan(sxMoi, hhMoi);
        h.setGia(giaMoi);
        return true;
    }

    // Sắp xếp
    public void sapXepTheoGia(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean dieuKien = tangDan ? (danhSach[i].getGia() > danhSach[j].getGia())
                                          : (danhSach[i].getGia() < danhSach[j].getGia());
                if (dieuKien) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    public void sapXepTheoNgaySanXuat(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean dieuKien = tangDan ? danhSach[i].getNgaySanXuat().isAfter(danhSach[j].getNgaySanXuat())
                                          : danhSach[i].getNgaySanXuat().isBefore(danhSach[j].getNgaySanXuat());
                if (dieuKien) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    public void sapXepTheoNgayHetHan(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean dieuKien = tangDan ? danhSach[i].getNgayHetHan().isAfter(danhSach[j].getNgayHetHan())
                                          : danhSach[i].getNgayHetHan().isBefore(danhSach[j].getNgayHetHan());
                if (dieuKien) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    // Tìm kiếm
    public QuanLyThucPham timTheoTienTo(String tk) {
        QuanLyThucPham kq = new QuanLyThucPham();
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().startsWith(tk.toLowerCase())) {
                kq.them(danhSach[i]);
            }
        }
        return kq;
    }

    public QuanLyThucPham timTheoHauTo(String tk) {
        QuanLyThucPham kq = new QuanLyThucPham();
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().endsWith(tk.toLowerCase())) {
                kq.them(danhSach[i]);
            }
        }
        return kq;
    }

    public QuanLyThucPham timGanGiong(String tk) {
        QuanLyThucPham kq = new QuanLyThucPham();
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().contains(tk.toLowerCase())) {
                kq.them(danhSach[i]);
            }
        }
        return kq;
    }

    // Trích lọc
    public QuanLyThucPham trichLocTheoNgaySanXuat(LocalDate tuNgay, LocalDate denNgay) {
        QuanLyThucPham kq = new QuanLyThucPham();
        for (int i = 0; i < soLuong; i++) {
            LocalDate ngaySX = danhSach[i].getNgaySanXuat();
            if (!ngaySX.isBefore(tuNgay) && !ngaySX.isAfter(denNgay)) {
                kq.them(danhSach[i]);
            }
        }
        return kq;
    }

    public QuanLyThucPham trichLocTheoNgayHetHan(LocalDate tuNgay, LocalDate denNgay) {
        QuanLyThucPham kq = new QuanLyThucPham();
        for (int i = 0; i < soLuong; i++) {
            LocalDate ngayHH = danhSach[i].getNgayHetHan();
            if (!ngayHH.isBefore(tuNgay) && !ngayHH.isAfter(denNgay)) {
                kq.them(danhSach[i]);
            }
        }
        return kq;
    }

    // Thống kê
    public int tinhTongSoLuong() { return soLuong; }

    public double tinhTongGiaTri() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            tong += danhSach[i].getGia();
        }
        return tong;
    }

    public void thongKeTheoThang() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        int[] demTheoThang = new int[13];
        for (int i = 0; i < soLuong; i++) {
            int thang = danhSach[i].getNgaySanXuat().getMonthValue();
            demTheoThang[thang]++;
        }
        System.out.println("THỐNG KÊ SẢN PHẨM THEO THÁNG SẢN XUẤT:");
        for (int t = 1; t <= 12; t++) {
            if (demTheoThang[t] > 0) {
                System.out.println("Tháng " + t + ": " + demTheoThang[t] + " sản phẩm");
            }
        }
    }

    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("\n+------+------------+--------------------+--------------+--------------+------------+");
        System.out.println("|  ID  |   Mã hàng  |      Tên hàng      |   Ngày SX    |   Ngày HH    |    Giá     |");
        System.out.println("+------+------------+--------------------+--------------+--------------+------------+");
        for (int i = 0; i < soLuong; i++) {
            System.out.println(danhSach[i]);
        }
        System.out.println("+------+------------+--------------------+--------------+--------------+------------+");
        System.out.println("Tổng: " + soLuong + " sản phẩm.");
    }

    public int laySoLuong() {
        return soLuong;
    }
}