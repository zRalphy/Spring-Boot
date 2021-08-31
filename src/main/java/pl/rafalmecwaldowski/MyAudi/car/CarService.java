package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CarService {
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
