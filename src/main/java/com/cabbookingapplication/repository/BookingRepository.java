package com.cabbookingapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cabbookingapplication.entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
