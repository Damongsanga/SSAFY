package Test04;

//{

//"pCode": "R00001",
//"pName": "S냉장고",
//"price": 1000000,
//"quantity": 20,
//"brand": "삼성",
//"desc": "삼성에서 출시한 스마트 냉장고입니다.",
//"category": "냉장고",
//"liter": 1000,
//"freezer": true,
//"year": 2021
//}

public class Refrigerator {
	private String pCode;
	private String pName;
	private int price;
	private int quantity;
	private String brand;
	private String desc;
	private String category;
	private int liter;
	private boolean freezer;
	private int year;

	public Refrigerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Refrigerator(String pCode, String pName, int price, int quantity, String brand, String desc, String category,
			int liter, boolean freezer, int year) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.desc = desc;
		this.category = category;
		this.liter = liter;
		this.freezer = freezer;
		this.year = year;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	public boolean isFreezer() {
		return freezer;
	}

	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Refrigerator [pCode=" + pCode + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", brand=" + brand + ", desc=" + desc + ", category=" + category + ", liter=" + liter + ", freezer="
				+ freezer + ", year=" + year + "]";
	}

}
