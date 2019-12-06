package Project05;

public class Home {
	int homeId;
	int userId;
	String address1;
	String address2;
	String state;
    String city;
    int zip;
    int yearBuilt;
    double homeValue;
    
    public Home() {}
    
    
	public Home(int homeId, int userId, String address1, String address2, String state, String city, int zip,
			int yearBuilt, double homeValue) {
		super();
		this.homeId = homeId;
		this.userId = userId;
		this.address1 = address1;
		this.address2 = address2;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.yearBuilt = yearBuilt;
		this.homeValue = homeValue;
	}


	/**
	 * @return the homeId
	 */
	public int getHomeId() {
		return homeId;
	}
	/**
	 * @param homeId the homeId to set
	 */
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * @return the yearBuilt
	 */
	public int getYearBuilt() {
		return yearBuilt;
	}
	/**
	 * @param yearBuilt the yearBuilt to set
	 */
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	/**
	 * @return the homeValue
	 */
	public double getHomeValue() {
		return homeValue;
	}
	/**
	 * @param homeValue the homeValue to set
	 */
	public void setHomeValue(double homeValue) {
		this.homeValue = homeValue;
	}


	@Override
	public String toString() {
		return "Home [homeId=" + homeId + ", userId=" + userId + ", address1=" + address1 + ", address2=" + address2
				+ ", state=" + state + ", city=" + city + ", zip=" + zip + ", yearBuilt=" + yearBuilt + ", homeValue="
				+ homeValue + "]";
	}
    

}
