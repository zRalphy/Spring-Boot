package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarControler {
    @GetMapping
    public List<Car> getCars(){
        return List.of(
                new Car(
                        1L,
                        "Audi",
                        "A5",
                        "WVWZZZ1KZ7W518416",
                        LocalDate.of(2010, Month.FEBRUARY, 12),
                        185000
                )
        );
    }
}
