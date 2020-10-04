package com.udacity.maccars.pricingservice.domain.price;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface PriceRepository extends CrudRepository<Price, Long> {

//    @Query("select p.id, p.currency from Price p where p.id=:id")
//    Map <Long, Price> getPrice(Long price);

}
