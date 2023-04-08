package com.zakia.Motors.service;

import com.zakia.Motors.entities.Motor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MotorService {
   Motor saveMotor(Motor m);
    Motor updateMotor(Motor m);
    void deleteMotor(Motor m);
    void deleteMotorById(Long id);
    Motor getMotor(Long id);
    List<Motor> getAllMotors();
    Page<Motor> getAllMotorsParPage(int page, int size);

}
