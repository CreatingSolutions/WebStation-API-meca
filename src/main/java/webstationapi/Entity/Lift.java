package webstationapi.Entity;


import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.LabelEnum;
import webstationapi.Enum.TypeEnum;

import javax.persistence.*;

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LabelEnum getLabeltype() {
        return labeltype;
    }

    public void setLabeltype(LabelEnum labeltype) {
        this.labeltype = labeltype;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public AgeEnum getAge() {
        return age;
    }

    public void setAge(AgeEnum age) {
        this.age = age;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isDiamond() {
        return diamond;
    }

    public void setDiamond(boolean diamond) {
        diamond = diamond;
    }

    public Double getPrice_unit() {
        return price_unit;
    }

    public void setPrice_unit(Double price_unit) {
        this.price_unit = price_unit;
    }

    public Double getPrice_group() {
        return price_group;
    }

    public void setPrice_group(Double price_group) {
        this.price_group = price_group;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Double getInsurrance() {
        return insurrance;
    }

    public void setInsurrance(Double insurrance) {
        this.insurrance = insurrance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
