package Tuan1.BaiHTron;

public class HinhTron {
	// khai bao thuoc tinh 
	private ToaDo tam;
	private double bankinh;
	public final double Pi=3.1416;
	// đong goi
	


	



	/**
	 * @return the tam
	 */
	public ToaDo getTam() {
		return tam;
	}



	/**
	 * @param tam the tam to set
	 */
	public void setTam(ToaDo tam) {
		this.tam = tam;
	}



	/**
	 * @return the bankinh
	 */
	public double getBankinh() {
		return bankinh;
	}



	/**
	 * @param bankinh the bankinh to set
	 */
	public void setBankinh(double bankinh) {
		this.bankinh = bankinh;
	}
	// contructor



	/**
	 * @param tam
	 * @param bankinh
	 */
	public HinhTron(ToaDo tam, double bankinh) {
		
		this.tam = tam;
		this.bankinh = bankinh;
	}



	public static void main(String[] args) {
	    HinhTron ht1 = new HinhTron(new ToaDo("O", 3, 4), 12);

	    System.out.println("Thong tin hinh tron");
	    System.out.println("Ban kinh hinh tron: ");
	    System.out.println(ht1.getBankinh());

	    System.out.println("Tam hinh tron: " + ht1.getTam().getTen());
	}


}
