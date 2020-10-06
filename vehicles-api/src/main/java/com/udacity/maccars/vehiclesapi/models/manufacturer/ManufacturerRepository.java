package com.udacity.maccars.vehiclesapi.models.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
