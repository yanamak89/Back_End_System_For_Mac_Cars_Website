package com.udacity.maccars.vehiclesapi;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation."),
        @ApiResponse(code = 401, message = "Due to security credentials, your access request cannot be authorized."),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Mac-cars microservice is running.")
})
@RequestMapping("/car")
public class CarController {
    /**
     The Vehicles API can receive GET requests from a user,
     and read back either a list of all existing vehicles,
     or the data for a single vehicle.
     */

    private CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public String index(Model model){
        model.addAttribute("car", carDAO.index());
        return "car/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
       model.addAttribute("car", carDAO.show(id));
        return "/car/show";
    }
}
