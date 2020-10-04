package com.udacity.maccars.vehiclesapi;

import com.udacity.maccars.vehiclesapi.models.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static int CAR_COUNT;
    private List<Car> car;

    {
        car = new ArrayList<>();

        car.add(new Car(++CAR_COUNT, "Mersedes"));
        car.add(new Car(++CAR_COUNT, "BMW"));
        car.add(new Car(++CAR_COUNT, "Porsche"));
        car.add(new Car(++CAR_COUNT, "Ferrari"));
        car.add(new Car(++CAR_COUNT, "Toyota"));
    }
    public List<Car> index(){
        return car;
    }

    public Car show(int id){
        return car.stream().filter(car-> car.getId() == id).findAny().orElse(null);
    }
}
