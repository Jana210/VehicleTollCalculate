package net.evry.toll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.evry.toll.entities.Holiday;

/**
 * Interface of holiday year repository.
 * 
 * @author Janardhan
 *
 */
@Repository
public interface HolidayRepo extends JpaRepository<Holiday, Integer> {
    @Query(value = "SELECT * FROM year_holiday_tab h WHERE h.year = :year and h.month = :month and h.day = :day", nativeQuery = true)
    Holiday findHolidayByYearMonthAndDay(@Param("year") Integer year, @Param("month") Integer month, @Param("day") Integer day);
}
