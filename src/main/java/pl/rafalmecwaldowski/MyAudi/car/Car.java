package pl.rafalmecwaldowski.MyAudi.car;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )

    private Long id;
    private String brand;
    private String model;
    private String vinNumber;
    private LocalDate dop;
    private Integer mileage;

    public Car() {
    }

    public Car(Long id, String brand, String model, String vinNumber, LocalDate dop, Integer mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.dop = dop;
        this.mileage = mileage;
    }

    public Car(String brand, String model, String vinNumber, LocalDate dop, Integer mileage) {
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.dop = dop;
        this.mileage = mileage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public LocalDate getDop() {
        return dop;
    }

    public void setDop(LocalDate dop) {
        this.dop = dop;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", dop=" + dop +
                ", mileage=" + mileage +
                '}';
    }
}
