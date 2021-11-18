package net.evry.toll.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.evry.toll.entities.Holiday;
import net.evry.toll.entities.TollPrice;
import net.evry.toll.repository.HolidayRepo;
import net.evry.toll.repository.TollPriceRepo;

/**
 * Test cases for toll service.
 * 
 * @author Janardhan
 *
 */
@ExtendWith(MockitoExtension.class)
class TollCalServiceImplTest {

    @InjectMocks
    private TollCalServiceImpl service;

    @Mock
    private TollPriceRepo tprepo;

    @Mock
    private HolidayRepo hrepo;

    @Test
    void testCarHoliday() {
        String str = "2020-01-01 08:15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(dateTime);
        Holiday holiday = mock(Holiday.class);
        when(hrepo.findHolidayByYearMonthAndDay(anyInt(), anyInt(), anyInt())).thenReturn(holiday);

        int price = service.getTollFee("car", dates);
        assertEquals(0, price);
    }

    @Test
    void testCarAfterWorkingTime() {
        String str = "2020-02-01 19:15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(dateTime);

        int price = service.getTollFee("car", dates);
        assertEquals(0, price);
    }

    @Test
    void testCarForWeekend() {
        String str = "2020-01-05 19:15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(dateTime);


        int price = service.getTollFee("car", dates);
        assertEquals(0, price);
    }

    @Test
    void testCarMultipleDates() {
        List<String> tollDates = Arrays.asList("2020-01-07 08:35", "2020-01-07 07:55");
        List<LocalDateTime> dates = createDates(tollDates);

        TollPrice tp1 = new TollPrice();
        tp1.setPrice(22);

        TollPrice tp2 = new TollPrice();
        tp2.setPrice(9);

        when(hrepo.findHolidayByYearMonthAndDay(anyInt(), anyInt(), anyInt())).thenReturn(null);
        when(tprepo.findTollPriceByHourAndMinute(755)).thenReturn(tp1);
        when(tprepo.findTollPriceByHourAndMinute(835)).thenReturn(tp2);

        int price = service.getTollFee("car", dates);
        assertEquals(22, price);
    }

    @Test
    void testCarMaxPrice() {
        List<String> tollDates = Arrays.asList("2020-01-07 08:35", "2020-01-07 06:45", "2020-01-07 07:55", "2020-01-07 10:15", "2020-01-07 11:25",
            "2020-01-07 12:35", "2020-01-07 13:45", "2020-01-07 15:35", "2020-01-07 16:45");
        List<LocalDateTime> dates = createDates(tollDates);

        TollPrice tp1 = new TollPrice();
        tp1.setPrice(22);
        TollPrice tp2 = new TollPrice();
        tp2.setPrice(9);
        TollPrice tp3 = new TollPrice();
        tp3.setPrice(16);

        when(hrepo.findHolidayByYearMonthAndDay(anyInt(), anyInt(), anyInt())).thenReturn(null);
        when(tprepo.findTollPriceByHourAndMinute(755)).thenReturn(tp1);
        when(tprepo.findTollPriceByHourAndMinute(835)).thenReturn(tp2);
        when(tprepo.findTollPriceByHourAndMinute(645)).thenReturn(tp3);
        when(tprepo.findTollPriceByHourAndMinute(1015)).thenReturn(tp2);
        when(tprepo.findTollPriceByHourAndMinute(1125)).thenReturn(tp2);
        when(tprepo.findTollPriceByHourAndMinute(1235)).thenReturn(tp2);
        when(tprepo.findTollPriceByHourAndMinute(1345)).thenReturn(tp2);
        when(tprepo.findTollPriceByHourAndMinute(1535)).thenReturn(tp1);
        when(tprepo.findTollPriceByHourAndMinute(1645)).thenReturn(tp1);

        int price = service.getTollFee("car", dates);
        assertEquals(60, price);
    }

    private List<LocalDateTime> createDates(List<String> tollDates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        List<LocalDateTime> dates = new ArrayList<>();
        for (String date : tollDates) {
            dates.add(LocalDateTime.parse(date, formatter));
        }
        return dates;
    }
}
