package net.evry.toll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.evry.toll.entities.TollPrice;

/**
 * Interface of toll service repository.
 * 
 * @author Janardhan
 *
 */
@Repository
public interface TollPriceRepo extends JpaRepository<TollPrice, Integer> {
    @Query(value = "SELECT * FROM toll_price_per_hour_tab tp WHERE :hourMin between tp.hour_min_from and tp.hour_min_to", nativeQuery = true)
    TollPrice findTollPriceByHourAndMinute(@Param("hourMin") Integer hourMin);
}
