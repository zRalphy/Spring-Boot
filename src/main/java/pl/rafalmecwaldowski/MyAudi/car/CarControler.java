package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
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

    @PutMapping(path = "{carId}")
    public void updateCar(
            @PathVariable ("carId") Long carId,
            @RequestParam (required = false) String brand,
            @RequestParam (required = false) String model,
            @RequestParam (required = false) String vinNumber,
            // @RequestParam (required = false) LocalDate dop,
            @RequestParam("dop") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dop,
            @RequestParam (required = false) Integer mileage
            ){
        carService.updateCar(carId, brand, model, vinNumber, dop, mileage);

    }
}
