package net.evry.toll.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Request model to send vehciel data with toll dates.
 *
 */
public class VehicleTollRequest {
    private String vehicleType;
    private List<String> tollDates = new ArrayList<>();

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<String> getTollDates() {
        return tollDates;
    }

    public void setTollDates(List<String> tollDates) {
        this.tollDates = tollDates;
    }
}
