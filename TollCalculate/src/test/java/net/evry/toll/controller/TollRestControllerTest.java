package net.evry.toll.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.evry.toll.service.TollCalService;
import net.evry.toll.service.VehicleTollRequest;

/**
 * Test cases for toll rest controller.
 * 
 * @author Janardhan
 *
 */
@ExtendWith(MockitoExtension.class)
class TollRestControllerTest {

    @InjectMocks
    private TollRestController restController;

    @Mock
    private TollCalService tollCalService;

    @Test
    void vehicleToll() {
        List<String> tollDates = Arrays.asList("2020-01-07 08:35", "2020-01-07 06:45");
        VehicleTollRequest vehicleReq = new VehicleTollRequest();
        vehicleReq.setVehicleType("car");
        vehicleReq.setTollDates(tollDates);

        when(tollCalService.getTollFee(anyString(), anyList())).thenReturn(25);

        int tollPrice = restController.vehicleToll(vehicleReq);
        assertEquals(25, tollPrice);
    }

}
