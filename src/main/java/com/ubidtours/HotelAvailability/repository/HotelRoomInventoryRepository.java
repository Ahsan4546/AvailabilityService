package com.ubidtours.HotelAvailability.repository;

import com.ubidtours.HotelAvailability.entity.HotelRoomInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomInventoryRepository extends JpaRepository<HotelRoomInventory, Long> {}