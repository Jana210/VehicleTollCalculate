package net.evry.toll.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.util.StringUtils;
import net.evry.toll.entities.Holiday;
import net.evry.toll.entities.TollPrice;
import net.evry.toll.repository.HolidayRepo;
import net.evry.toll.repository.TollPriceRepo;

/**
 * Handles calls from rest controller service.
 * 
 * @author Janardhan
 *
 */
@Service
public class TollCalServiceImpl implements TollCalService {
	
	private Logger logger = LoggerFactory.getLogger(TollCalServiceImpl.class);

    @Autowired
    private TollPriceRepo tollPriceRepo;
    @Autowired
    private HolidayRepo holidayRepo;

    public int getTollFee(String vehicle, List<LocalDateTime> dates) {
		dates = dates.stream().sorted().distinct().collect(Collectors.toList());
		LocalDateTime intervalStart = dates.get(0);
        int totalFee = 0;
        for (LocalDateTime date : dates) {
            int nextFee = getTollFee(date, vehicle);
            int tempFee = getTollFee(intervalStart, vehicle);
            long minutes = ChronoUnit.MINUTES.between(intervalStart, date);

            if (minutes <= 60) {
                if (totalFee > 0) totalFee -= tempFee;
                if (nextFee >= tempFee) tempFee = nextFee;
                totalFee += tempFee;
            } else {
                totalFee += nextFee;
            }
        }
        if (totalFee > 60) totalFee = 60;
        return totalFee;
    }

    private boolean isTollFreeVehicle(String vehicleType) {
        if (StringUtils.isEmpty(vehicleType))
            return false;
        return vehicleType.equalsIgnoreCase(TollFreeVehicles.MOTORBIKE.toString()) || vehicleType.equalsIgnoreCase(TollFreeVehicles.TRACTOR.toString())
            || vehicleType.equalsIgnoreCase(TollFreeVehicles.EMERGENCY.toString()) || vehicleType.equalsIgnoreCase(TollFreeVehicles.DIPLOMAT.toString())
            || vehicleType.equalsIgnoreCase(TollFreeVehicles.FOREIGN.toString()) || vehicleType.equalsIgnoreCase(TollFreeVehicles.MILITARY.toString());
    }

    private int getTollFee(LocalDateTime date, String vehicle) {
        if (isTollFreeDate(date) || isTollFreeVehicle(vehicle)) return 0;

        int hour = date.getHour();
        int minute = date.getMinute();
        logger.info("Price for given hour {} and minute {}", hour, minute);
        int mergedHourMin = minute == 0 ? Integer.parseInt(String.valueOf(hour).concat(String.valueOf(minute)).concat("0"))
            : Integer.parseInt(String.valueOf(hour).concat(String.valueOf(minute)));
        logger.info("hour and minute {} ", mergedHourMin);
        TollPrice tollPrice = tollPriceRepo.findTollPriceByHourAndMinute(mergedHourMin);
        logger.info("Price for given time {}", tollPrice);

        return tollPrice != null ? tollPrice.getPrice() : 0;
    }

    private boolean isTollFreeDate(LocalDateTime date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

		if (date.getMonth().equals(Month.JULY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
				|| date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return true;
        }

        logger.info("Holiday for given year {} and month {} and day {}", year, month, day);
        Holiday holiday = holidayRepo.findHolidayByYearMonthAndDay(year, month, day);
        logger.info("is it Holiday date from DB {}", holiday);

        return holiday != null;
    }
}
