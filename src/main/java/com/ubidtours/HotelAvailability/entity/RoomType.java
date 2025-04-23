package com.ubidtours.HotelAvailability.entity;


//import jakarta.persistence.*;
import lombok.Data;
import java.time.YearMonth;
import jakarta.persistence.*;

@Entity
//@Table(name = "room_type", schema = "availabilityservice")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    private int maxOccupancy;
}