
CREATE SCHEMA IF NOT EXISTS availabilityservice;


CREATE TABLE dmc (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
-- Hotel Table
CREATE TABLE hotel (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    star_rating VARCHAR(10),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    dmc_id INTEGER
);
-- RoomType Table
CREATE TABLE room_type (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(50),
    max_occupancy INTEGER
);
-- HotelRoomInventory Table
CREATE TABLE hotel_room_inventory (
    id SERIAL PRIMARY KEY,
    hotel_id INTEGER,
    room_type_id INTEGER,
    inventory_month VARCHAR(7),
    available_rooms INTEGER
);