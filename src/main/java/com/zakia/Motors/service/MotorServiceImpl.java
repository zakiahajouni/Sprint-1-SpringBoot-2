package com.zakia.Motors.service;

import com.zakia.Motors.entities.Motor;
import com.zakia.Motors.repos.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MotorServiceImpl implements MotorService {
@Autowired
 MotorRepository motorRepository;
    @Override
    public Motor saveMotor(Motor m) {
        return motorRepository.save(m);
    }

    @Override
    public Motor updateMotor(Motor m) {
        return motorRepository.save(m);
    }

    @Override
    public void deleteMotor(Motor m) {
          motorRepository.delete(m);
    }

    @Override
    public void deleteMotorById(Long id) {
motorRepository.deleteById(id);
    }

    @Override
    public Motor getMotor(Long id) {
        return motorRepository.findById(id).get();
    }

    @Override
    public List<Motor> getAllMotors() {
        return motorRepository.findAll();
    }

    @Override
    public Page<Motor> getAllMotorsParPage(int page, int size) {
        return motorRepository.findAll(PageRequest.of(page, size));

    }
}
