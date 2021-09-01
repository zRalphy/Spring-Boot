package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        Optional<Car> carOptional = carRepository.findCarByVinNumber(car.getVinNumber());
        if(carOptional.isPresent()) {
            throw new IllegalStateException(" Vin exist in data base ");
        }
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        boolean exist = carRepository.existsById(carId);
        if(!exist){
            throw new IllegalStateException(
                    " Car with id " + carId + " does not exists ");
        }
        carRepository.findById(carId);
    }
}
