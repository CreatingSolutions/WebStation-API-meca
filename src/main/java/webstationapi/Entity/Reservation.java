package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MECA_RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESERVATION_ID")
	private int reservationId;
	
	private int userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOMAIN_ID")
	private int domainId;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "STARTING_DATE")
	private Date debut;
	
	@Column(name = "ENDING_DATE")
	private Date fin;
	
	@Column(name = "INSURANCE")
	private int insurance;

	public int getReservationId() {return reservationId; }
	public void setReservationId(int reservationId) {this.reservationId = reservationId; }
	public int getUserId() {return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	public int getDomainId() { return domainId; }
	public void setDomainId(int domainId) { this.domainId = domainId; }
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	public Date getDebut() { return debut; }
	public void setDebut(Date debut) { this.debut = debut; }
	public Date getFin() { return fin; }
	public void setFin(Date fin) { this.fin = fin; }
	public int getInsurance() { return insurance; }
	public void setInsurance(int insurance) { this.insurance = insurance; }
	
}
