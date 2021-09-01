package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarControler {

    private final CarService carService;

    @Autowired
    public CarControler(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping
    public void registerNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @DeleteMapping(path = "{carId}")
    public void deleteCar(@PathVariable ("carId") Long carId){
        carService.deleteCar(carId);
    }

}
