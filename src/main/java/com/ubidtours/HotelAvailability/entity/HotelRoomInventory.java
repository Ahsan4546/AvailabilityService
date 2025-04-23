package com.ubidtours.HotelAvailability.entity;

//import jakarta.persistence.*;
import lombok.Data;
import java.time.YearMonth;
import jakarta.persistence.*;

import java.time.YearMonth;

@Entity
//@Table(name = "hotel_room_inventory", schema = "availabilityservice")
@Data
public class HotelRoomInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hotelId;
    private Long roomTypeId;
    private YearMonth inventoryMonth;
    private int availableRooms;
}
