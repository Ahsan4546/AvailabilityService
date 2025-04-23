package com.ubidtours.HotelAvailability.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.YearMonth;
@Data
@AllArgsConstructor
public class HotelDistanceDTO {
    private Long hotelId;
    private String name;
    private String starRating;
    private double latitude;
    private double longitude;
    private double distance;
}