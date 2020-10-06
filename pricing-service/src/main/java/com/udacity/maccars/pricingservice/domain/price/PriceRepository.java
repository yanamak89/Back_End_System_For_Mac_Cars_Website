package com.udacity.maccars.pricingservice.domain.price;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {


}
