package com.example.tesla.dto;


import com.example.tesla.model.Car;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CarIn implements Serializable {
    @NotBlank
    @Length(min = 2, max = 30)
    private String brand;

    @NotBlank
    @Length(min = 2, max = 30)
    private String model;

    @Min(2000)
    @Max(2030)
    private Integer year;

    @Min(100000)
    private Double price;

    @Min(100)
    @Max(1000)
    private Integer rangeKm;

    @NotBlank
    private String color;

    private String imageUrl;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRangeKm() {
        return rangeKm;
    }

    public void setRangeKm(Integer rangeKm) {
        this.rangeKm = rangeKm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Car toCar(CarIn carIn) {
        return new Car(
                carIn.getBrand(),
                carIn.getModel(),
                carIn.getYear(),
                carIn.getPrice(),
                carIn.getRangeKm(),
                carIn.getColor(),
                carIn.getImageUrl()
        );
    }


    public void updateCar(Car car) {
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setPrice(price);
        car.setRangeKm(rangeKm);
        car.setColor(color);
        car.setImageUrl(imageUr);
    }
}
