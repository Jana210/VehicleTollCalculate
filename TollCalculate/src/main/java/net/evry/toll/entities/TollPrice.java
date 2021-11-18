package net.evry.toll.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for toll price per hour table.
 * 
 * @author Janardhan
 *
 */
@Entity
@Table(name = "toll_price_per_hour_tab")
public class TollPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", length = 3, nullable = false)
    private Integer priceId;

    @Column(name = "hour_min_from", length = 4, nullable = false)
    private Integer hourMinFrom;

    @Column(name = "hour_min_to", length = 4, nullable = false)
    private Integer hourMinTo;

	@Column(name = "price", length = 3, nullable = false)
    private Integer price;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getHourMinFrom() {
        return hourMinFrom;
    }

    public void setHourMinFrom(Integer hourMinFrom) {
        this.hourMinFrom = hourMinFrom;
    }

    public Integer getHourMinTo() {
        return hourMinTo;
    }

    public void setHourMinTo(Integer hourMinTo) {
        this.hourMinTo = hourMinTo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
