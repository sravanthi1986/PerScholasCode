package Project05;

import java.util.Date;

public class Quote {
	int quoteId;
	int homeId;
	double yearlyPremium;
	Date startDate;
	Date expiration;
	Boolean active;
 public Quote(){}
public Quote(int quoteId, int homeId, double yearlyPremium, Date startDate, Date expiration, Boolean active) {
	super();
	this.quoteId = quoteId;
	this.homeId = homeId;
	this.yearlyPremium = yearlyPremium;
	this.startDate = startDate;
	this.expiration = expiration;
	this.active = active;
}
/**
 * @return the quoteId
 */
public int getQuoteId() {
	return quoteId;
}
/**
 * @param quoteId the quoteId to set
 */
public void setQuoteId(int quoteId) {
	this.quoteId = quoteId;
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
 * @return the yearlyPremium
 */
public double getYearlyPremium() {
	return yearlyPremium;
}
/**
 * @param yearlyPremium the yearlyPremium to set
 */
public void setYearlyPremium(double yearlyPremium) {
	this.yearlyPremium = yearlyPremium;
}
/**
 * @return the startDate
 */
public Date getStartDate() {
	return startDate;
}
/**
 * @param startDate the startDate to set
 */
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
/**
 * @return the expiration
 */
public Date getExpiration() {
	return expiration;
}
/**
 * @param expiration the expiration to set
 */
public void setExpiration(Date expiration) {
	this.expiration = expiration;
}
/**
 * @return the active
 */
public Boolean getActive() {
	return active;
}
/**
 * @param active the active to set
 */
public void setActive(Boolean active) {
	this.active = active;
}
@Override
public String toString() {
	return "Quote [quoteId=" + quoteId + ", homeId=" + homeId + ", yearlyPremium=" + yearlyPremium + ", startDate="
			+ startDate + ", expiration=" + expiration + ", active=" + active + ", getQuoteId()=" + getQuoteId()
			+ ", getHomeId()=" + getHomeId() + ", getYearlyPremium()=" + getYearlyPremium() + ", getStartDate()="
			+ getStartDate() + ", getExpiration()=" + getExpiration() + ", getActive()=" + getActive() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
 

}