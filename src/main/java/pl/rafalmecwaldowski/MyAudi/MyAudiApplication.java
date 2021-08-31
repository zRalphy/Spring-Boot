package pl.rafalmecwaldowski.MyAudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rafalmecwaldowski.MyAudi.car.Car;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class MyAudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAudiApplication.class, args);
	}

	@GetMapping
	public List<Car> addCar(){
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
