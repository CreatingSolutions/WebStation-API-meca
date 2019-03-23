package webstationapi.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@Entity
public class LiftBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long liftId;

    private int userId;

    private boolean insurance;

    private Double price;

}
