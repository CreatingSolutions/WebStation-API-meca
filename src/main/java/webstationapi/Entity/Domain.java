package webstationapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MECA_DOMAIN")
public class Domain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOMAIN_ID")
	private int domainId;
	
	@Column(name = "NAME")
	private String name;
	
	public Domain() { }
	
	public int getDomainId() { return domainId; }
	public void setDomainId(int domainId) { this.domainId = domainId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
}
