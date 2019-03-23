package webstationapi.Service;

import org.junit.Test;
import webstationapi.DTO.ForfaitDTO;
import webstationapi.Entity.Lift;
import webstationapi.Enum.TypeEnum;
import webstationapi.Repository.LiftRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LiftServiceTest {


    @Test
    public void findById() {
    }

    @Test
    public void findByTypeAndAge() {
    }

    @Test
    public void calculePrice() {
        LiftRepository mock = mock(LiftRepository.class);
        LiftService liftService = new LiftService(mock, null);
        Double aDouble = liftService.calculePrice(new ArrayList<>());
        assertEquals(aDouble, Double.valueOf(0.0));
    }

    @Test
    public void buildForfait() {
        LiftRepository mock = mock(LiftRepository.class);
        LiftService liftService = new LiftService(mock, null);

        Lift lift = new Lift();
        lift.setId(1L);
        lift.setLabel("test");
        lift.setPrice(42.0);
        List<Lift> lifts = new ArrayList<>();
        lifts.add(lift);
        List<ForfaitDTO> forfaitDTOS = liftService.buildForfait(lifts);
        ForfaitDTO forfaitDTO = forfaitDTOS.get(0);
        assertEquals(forfaitDTO.getId(), Long.valueOf(1L));
        assertEquals(forfaitDTO.getLabel(), "test");
        assertEquals(forfaitDTO.getPrices(), Double.valueOf(42.0));
    }

    @Test
    public void findtelesiege() {
        LiftRepository mock = mock(LiftRepository.class);
        LiftService liftService = new LiftService(mock, null);

        Lift lift = new Lift();
        lift.setId(1L);
        List lifts = new ArrayList();
        lifts.add(lift);

        when(mock.findByType(TypeEnum.TELESIEGE)).thenReturn(lifts);

        List<Lift> findtelesiege = liftService.findtelesiege(TypeEnum.TELESIEGE);

        assertEquals(findtelesiege.get(0).getId(), Long.valueOf(1L));

    }
}