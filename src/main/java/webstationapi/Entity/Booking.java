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
}
