package net.evry.toll.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.evry.toll.service.TollCalService;
import net.evry.toll.service.VehicleTollRequest;

/**
 * Handle calls from web and give response.
 * 
 * @author Janardhan
 *
 */
@RestController
@RequestMapping(path = "api/")
public class TollRestController {

    @Autowired
    private TollCalService tollCalService;

	/**
     * Calculate vehicle toll for given times in day.
     * 
     * @param vehicleReq
     * @return
     */
    @PostMapping(path = "toll", consumes = "application/json")
    public int vehicleToll(@RequestBody VehicleTollRequest vehicleReq) {
        List<LocalDateTime> tollDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (String tollDate : vehicleReq.getTollDates()) {
            tollDates.add(LocalDateTime.parse(tollDate, formatter));
        }
        return tollCalService.getTollFee(vehicleReq.getVehicleType(), tollDates);
	}
}
