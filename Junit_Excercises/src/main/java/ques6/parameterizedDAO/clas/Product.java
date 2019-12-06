package ques6.parameterizedDAO.clas;


public class Product {
	// Attributes/Fields
	private Integer productId;
	private String name;
	private Double price;
	
	
	// Constructors
	public Product(){}
	public Product(Integer productId,String name,Double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	

}