package webstationapi.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.LabelEnum;
import webstationapi.Enum.TypeEnum;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "MECA_LIFT")
public class Lift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LabelEnum labeltype;

    private String label;

    @Enumerated(EnumType.STRING)
    private AgeEnum age;

    private Double price;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private boolean diamond;

    private Double insurrance;

    private Double price_unit;

    private Double price_group;

    private String description;

}
