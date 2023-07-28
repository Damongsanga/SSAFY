package com.ssafy.ws.step4;

public class KoreanRestaurant extends Restaurant{
	private String number;
	private String breaktime;
	
	public KoreanRestaurant() {
		// TODO Auto-generated constructor stub
	}

	public KoreanRestaurant(int resid, String name, String address, String signatureMenu, int rate, String number, String breaktime) {
		super(resid, name, address, signatureMenu, rate);
		this.number = number;
		this.breaktime = breaktime;
		// TODO Auto-generated constructor stub
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBreaktime() {
		return breaktime;
	}

	public void setBreaktime(String breaktime) {
		this.breaktime = breaktime;
	}

	@Override
	public String toString() {
		return "Restaurant [resid=" + getResid()
				+ ", name=" + getName() + ", address=" + getAddress() + ", signatureMenu="
				+ getSignatureMenu() + ", rate=" + getRate() + "]" + "number=" + number + ", breaktime=" + breaktime;
	}
	
	
	
	

}
