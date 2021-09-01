package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


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
        boolean exists = carRepository.existsById(carId);
        if(!exists){
            throw new IllegalStateException(
                    " Car with id " + carId + " does not exists ");
        }
        carRepository.deleteById(carId);
    }

    @Transactional
    public void updateCar(Long carId,
                          String brand,
                          String model,
                          String vinNumber,
                          LocalDate dop,
                          Integer mileage) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalStateException(" Car with id " + carId + " does not exists "));
        if(brand != null &&
                brand.length() > 0
                && !Objects.equals(car.getBrand(), brand)) {
            car.setBrand(brand);
        }

        if(model != null &&
                model.length() > 0
                && !Objects.equals(car.getModel(), model)) {
            car.setModel(model);
        }

        if(vinNumber != null &&
                vinNumber.length() > 0
                && !Objects.equals(car.getVinNumber(), vinNumber)) {
            Optional <Car> carOptional = carRepository.findCarByVinNumber(vinNumber);
            if(carOptional.isPresent()) {
                throw new IllegalStateException(" Vin exist in data base ");
            }
            car.setVinNumber(vinNumber);
        }

        if(dop != null
                && !Objects.equals(car.getDop(), dop)) {
            car.setDop(dop);
        }

        if(mileage != null
                && !Objects.equals(car.getMileage(), mileage)) {
            car.setMileage(mileage);
        }
    }
}
