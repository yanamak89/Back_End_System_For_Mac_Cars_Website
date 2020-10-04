package com.udacity.maccars.pricingservice.domain.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Data
@AllArgsConstructor
@ToString
@Entity
public class Price {
    public Price(String currency, BigDecimal price, Long vehicleId) {
        this.id = id;
        this.currency = currency;
        this.price = price;
        this.vehicleId = vehicleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currency;
    private BigDecimal price;
    private Long vehicleId;

    public Price() {
    }
}
