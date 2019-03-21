package webstationapi.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ForfaitDTO {

    private Long id;

    private String label;

    private Double prices;

}
