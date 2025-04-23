package com.ubidtours.HotelAvailability.entity;

//import jakarta.persistence.*;
import lombok.Data;

import jakarta.persistence.*;
import java.time.YearMonth;
@Entity
//@Table(name = "dmc", schema = "availabilityservice")
@Data
public class DMC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}