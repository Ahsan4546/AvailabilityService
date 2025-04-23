package com.ubidtours.HotelAvailability.controller;


import com.ubidtours.HotelAvailability.dto.HotelDistanceDTO;
import com.ubidtours.HotelAvailability.service.HotelService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping("/nearby")
    public List<HotelDistanceDTO> getNearby(@RequestParam double lat, @RequestParam double lon) {
        return hotelService.getNearbyHotels(lat, lon);
    }
}
