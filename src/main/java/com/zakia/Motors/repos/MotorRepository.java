package com.zakia.Motors.repos;

import com.zakia.Motors.entities.Motor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorRepository extends JpaRepository<Motor, Long> {

}