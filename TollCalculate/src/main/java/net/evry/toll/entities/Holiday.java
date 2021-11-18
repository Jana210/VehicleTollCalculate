package net.evry.toll.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for holiday per year.
 * 
 * @author Janardhan
 *
 */
@Entity
@Table(name = "year_holiday_tab")
public class Holiday {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holiday_id", length = 3, nullable = false)
    private Integer holidayId;

	@Column(name = "year", length = 2, nullable = false)
    private Integer year;

	@Column(name = "month", length = 2, nullable = false)
    private Integer month;

	@Column(name = "day", length = 2, nullable = false)
    private Integer day;

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
