package pl.rafalmecwaldowski.MyAudi.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.MAY;

@Configuration
public class CarConfig {
    @Bean
    CommandLineRunner commandLineRunner(CarRepository repository) {
        return args -> {
            Car auto_1 = new Car(
                    "Audi",
                    "A5",
                    "WVWZZZ1KZ7W518416",
                    LocalDate.of(2010, FEBRUARY, 12),
                    185000
            );

            Car auto_2 = new Car(
                    "Audi",
                    "A6",
                    "WAUZZZ1KZ7W515041",
                    LocalDate.of(2017, MAY, 25),
                    150000
            );

            repository.saveAll(List.of(auto_1, auto_2)
            );
        };
    }
}
