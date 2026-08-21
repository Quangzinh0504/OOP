package Tuan1.BaiHCN;

import java.io.ObjectInputStream.GetField;

public class HinhChuNhat {
	// khai bao thuoc tinh private ( gioi han truy xuat)
	private double ChieuDai;
	private double ChieuRong;
	// đóng gi truy xuất private 
	/**
	 * @return the chieuDai
	 */
	public double getChieuDai() {
		return ChieuDai;
	}


	/**
	 * @param chieuDai the chieuDai to set
	 * @throws Exception 
	 */
	public void setChieuDai(double cD) throws Exception {
		if (cD>0) {
			ChieuDai = cD;
		} else {
			throw new Exception("Lỗi");

		}
		
	}


	/**
	 * @return the chieuRong
	 */
	public double getChieuRong() {
		return ChieuRong;
	}


	/**
	 * @param chieuRong the chieuRong to set
	 */
	public void setChieuRong(double chieuRong) {
		ChieuRong = chieuRong;
	}
	// tao ham khoi tao 
	/**
	 * 
	 */
	public HinhChuNhat() {
		super();
	}
	
	
	/**
	 * @param chieuDai
	 * @param chieuRong
	 */
	public HinhChuNhat(double chieuDai, double chieuRong) {
		
		ChieuDai = chieuDai;
		ChieuRong = chieuRong;
	}
	// tinh dien tich và chu vi 
	public double getDT() {
		
		return this.ChieuDai*this.ChieuRong;
	}
	public double getCV() {
		
		return (this.ChieuDai+this.ChieuRong)*2;
	}
	


	public static void main(String[] args) {
		// testchuongtrinh 
		HinhChuNhat h1=	new HinhChuNhat(8,5);
		// xem gia tri
		System.out.println(h1.getChieuDai());
		System.out.println(h1.getChieuRong());
		// tính dien tich và chu vi 
		System.out.println("Tinh chu vi");
		System.out.println(h1.getDT());
		System.out.println("Tinh dien tich");
		System.out.println(h1.getCV());

	}


	

}

	




	