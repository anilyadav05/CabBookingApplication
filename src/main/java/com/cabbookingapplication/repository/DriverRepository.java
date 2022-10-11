package com.cabbookingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbookingapplication.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer>{

}
