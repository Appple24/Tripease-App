package com.sudhanva.demo.repository;

import com.sudhanva.demo.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
