package Tuan7_TienDien;

import java.util.*;
import java.util.function.Predicate;

public class ListQuanLy<T> {

    private List<T> danhSach = new ArrayList<>();

    // Thêm một phần tử
    public void them(T item) {
        danhSach.add(item);
    }

    // Thêm nhiều phần tử
    @SafeVarargs
    public final void themNhieu(T... items) {
        Collections.addAll(danhSach, items);
    }

    // Đếm phần tử theo điều kiện
    public long dem(Predicate<T> dieuKien) {
        return danhSach.stream()
                .filter(dieuKien)
                .count();
    }

    // Lọc danh sách theo điều kiện
    public List<T> loc(Predicate<T> dieuKien) {
        return danhSach.stream()
                .filter(dieuKien)
                .toList();
    }

    // Hiển thị toàn bộ danh sách
    public void hienThi() {
        for (T item : danhSach) {
            System.out.println(item);
        }
    }

    // Lấy toàn bộ danh sách
    public List<T> getDanhSach() {
        return danhSach;
    }
}