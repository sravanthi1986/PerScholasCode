package com.perscholas.vechicle.model;

public class Vechicle {
	private Integer vechicleID;
	private String make;
	private String model;
	private String[] colorList;
	
	/**
	 * @return the colorList
	 */
	public String[] getColorList() {
		return colorList;
	}

	/**
	 * @param colorList the colorList to set
	 */
	public void setColorList(String[] colorList) {
		this.colorList = colorList;
	}

	public Vechicle() {}



	public Vechicle(Integer vechicleID, String make, String model, String[] colorList) {
		super();
		this.vechicleID = vechicleID;
		this.make = make;
		this.model = model;
		this.colorList = colorList;
	}

	/**
	 * @return the vechicleID
	 */
	public Integer getVechicleID() {
		return vechicleID;
	}

	/**
	 * @param vechicleID the vechicleID to set
	 */
	public void setVechicleID(Integer vechicleID) {
		this.vechicleID = vechicleID;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
}
