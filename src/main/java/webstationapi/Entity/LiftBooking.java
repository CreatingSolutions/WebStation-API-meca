package webstationapi.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
public class LiftBooking {

    @Id
    @GeneratedValue
    private Long id;

    private Long idUser;

    private Long idLift;

    private boolean insurrance = false;

    private boolean isDiamond = false;

    private double nbFois = 0;

    private Double price;

    boolean valid = false;


}
