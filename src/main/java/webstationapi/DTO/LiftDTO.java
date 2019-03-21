package webstationapi.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class LiftDTO {

    private String description;

    private List<ForfaitDTO> normal;

    private List<ForfaitDTO> diamant;

    private ForfaitDTO unitaire;

    private ForfaitDTO groupe;

}