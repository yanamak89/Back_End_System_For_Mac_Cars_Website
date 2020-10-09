package com.udacity.maccars.vehiclesapi.service;

import com.udacity.maccars.vehiclesapi.client.maps.MapsClient;
import com.udacity.maccars.vehiclesapi.client.prices.PriceClient;
import com.udacity.maccars.vehiclesapi.models.Location;
import com.udacity.maccars.vehiclesapi.models.car.Car;
import com.udacity.maccars.vehiclesapi.models.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository repository;
    private final MapsClient mapsClient;
    private final PriceClient priceClient;
    private Long id;

    public CarService(CarRepository repository, MapsClient mapsClient, PriceClient priceClient) {
        this.repository = repository;
        this.mapsClient = mapsClient;
        this.priceClient = priceClient;
    }

    public List<Car> list() {
        return repository.findAll();
    }

    public Car findById(Long Id) {
        Car car = new Car();
        Optional optionalCar = repository.findById(id);

        if (optionalCar.isEmpty()) {
            throw new CarNotFoundException();
        } else {
            car = (Car) optionalCar.get();
        }
        car.setPrice(priceClient.getPrice(id));

        Location carLocation = car.getLocation();
        car.setLocation(mapsClient.getAddress(carLocation));

        return car;
    }

    public Car save(Car car){
        if(car.getId() != null){
            return repository.findById(car.getId())
                    .map(carToBeUpdated -> {
                        carToBeUpdated.setDetails(car.getDetails());
                        carToBeUpdated.setLocation(car.getLocation());
                        carToBeUpdated.setCondition(car.getCondition());
                        return repository.save(carToBeUpdated);
                    }).orElseThrow(CarNotFoundException::new);
        }
        return repository.save(car);
    }

    public void delete(Long id){
        Car car = new Car();
        Optional optionalCar = repository.findById(id);

        if(optionalCar.isEmpty()){
            throw new CarNotFoundException();
        }else{
            car = (Car) optionalCar.get();
            repository.delete(car);
        }
    }
}

