package Tuan4_CD;

public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    public static final int maCD_macdinh = 999999;
    public static final String tuaCD_macdinh = "khong xac dinh";

    public CD() {
        this.maCD = maCD_macdinh;
        this.tuaCD = tuaCD_macdinh;
        this.soBaiHat = 1;
        this.giaThanh = 1.0;
    }

    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD <= 0) {
            throw new IllegalArgumentException("Ma CD > 0");
        }
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD == null || tuaCD.trim().isEmpty()) {
            throw new IllegalArgumentException("Tua CD khong duoc rong");
        }
        this.tuaCD = tuaCD;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0) {
            throw new IllegalArgumentException("So bai hat > 0");
        }
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh <= 0) {
            throw new IllegalArgumentException("Gia thanh > 0");
        }
        this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return String.format(
            "|%-10d|%-25s|%-12d|%-15.2f|",
            maCD, tuaCD, soBaiHat, giaThanh
        );
    }
}
