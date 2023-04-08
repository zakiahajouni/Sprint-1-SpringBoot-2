package com.zakia.Motors.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


@Entity

public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMotor;
    private String nameMotor;
    private Double priceMotor;

    private Date dateCreation;
    private int maxSpeedMotor;
    private String colorMotor;
    public Motor() {
        super();
    }
public Motor(String nameMotor, Double priceMotor, Date DateCreation, int maxSpeedMotor, String colorMotor) {
        super();
        this.nameMotor = nameMotor;
        this.priceMotor = priceMotor;
        this.dateCreation = DateCreation;
        this.maxSpeedMotor = maxSpeedMotor;
        this.colorMotor = colorMotor;
    }
    public Long getIdMotor() {
        return idMotor;
    }
    public void setIdMotor(Long idMotor) {
        this.idMotor = idMotor;
    }
    public String getNameMotor() {
        return nameMotor;
    }
    public void setNameMotor(String nameMotor) {
        this.nameMotor = nameMotor;
    }
    public Double getPriceMotor() {
        return priceMotor;
    }
    public void setPriceMotor(Double priceMotor) {
        this.priceMotor = priceMotor;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date DateCreation) {
        this.dateCreation = DateCreation;
    }
    public int getMaxSpeedMotor() {
        return maxSpeedMotor;
    }
    public void setMaxSpeedMotor(int maxSpeedMotor) {
        this.maxSpeedMotor = maxSpeedMotor;
    }
    public String getColorMotor() {
        return colorMotor;
    }
    public void setColorMotor(String colorMotor) {
        this.colorMotor = colorMotor;
    }
    @Override
    public String toString() {
        return "Motor [idMotor=" + idMotor + ", nameMotor=" + nameMotor + ", priceMotor=" + priceMotor
                + ", DateCreation=" + dateCreation + ", maxSpeedMotor=" + maxSpeedMotor + ", colorMotor="
                + colorMotor + "]";
    }

}
