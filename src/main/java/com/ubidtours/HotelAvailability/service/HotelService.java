package com.ubidtours.HotelAvailability.service;

import com.ubidtours.HotelAvailability.dto.HotelDistanceDTO;
import com.ubidtours.HotelAvailability.entity.*;
import com.ubidtours.HotelAvailability.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository _hotelRepository;
    private final DMCRepository _dmcRepository;
    private final RoomTypeRepository _roomTypeRepository;
    private final HotelRoomInventoryRepository _inventoryRepository;

    public HotelService(HotelRepository hotelRepository, DMCRepository dmcRepository,
                        RoomTypeRepository roomTypeRepository, HotelRoomInventoryRepository inventoryRepository) {
        _hotelRepository = hotelRepository;
        _dmcRepository = dmcRepository;
        _roomTypeRepository = roomTypeRepository;
        _inventoryRepository = inventoryRepository;
    }

    public List<HotelDistanceDTO> getNearbyHotels(double lat, double lon) {
        return _hotelRepository.findAll().stream()
                .map(h -> new HotelDistanceDTO(
                        h.getId(),
                        h.getName(),
                        h.getStarRating(),
                        h.getLatitude(),
                        h.getLongitude(),
                        haversine(lat, lon, h.getLatitude(), h.getLongitude())
                ))
                .sorted(Comparator.comparingDouble(HotelDistanceDTO::getDistance))
                .collect(Collectors.toList());
    }

    @Transactional
    public Hotel saveHotelWithRelations(DMC dmc, Hotel hotel, List<RoomType> roomTypes, List<HotelRoomInventory> inventories) {
        DMC savedDmc = _dmcRepository.save(dmc);
        hotel.setDmcId(savedDmc.getId());
        Hotel savedHotel = _hotelRepository.save(hotel);
        for (RoomType rt : roomTypes) {
            _roomTypeRepository.save(rt);
        }
        for (HotelRoomInventory inv : inventories) {
            inv.setHotelId(savedHotel.getId());
            _inventoryRepository.save(inv);
        }
        return savedHotel;
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDist = Math.toRadians(lat2 - lat1);
        double lonDist = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDist / 2) * Math.sin(lonDist / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}