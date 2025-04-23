package com.ubidtours.HotelAvailability.entity;

//import jakarta.persistence.*;
import lombok.Data;
import java.time.YearMonth;
import jakarta.persistence.*;

@Entity
//@Table(name = "hotel", schema = "availabilityservice")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String starRating;
    private double latitude;
    private double longitude;
    private Long dmcId;
}