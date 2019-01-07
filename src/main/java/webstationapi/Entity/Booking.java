package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="LIFT_BOOKINGS")
public class Booking {

	@Id
    @Column(name="ID_BOOKING")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
	private long bookingId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_DOMAIN")
	private Domain domain;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="INSURANCE")
	private int insurance;

	@Column(name="DURATION")
	private int duration;
	
	public Booking() {}
    public Booking(Domain domain, double price, Date startDate, Date endDate, int insurance, int duration) {
        this.domain = domain;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insurance = insurance;
        this.duration = duration;
    }
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getInsurance() {
		return insurance;
	}
	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
