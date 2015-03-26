/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.util.ArrayList;

/**
 *
 * @author bart
 */
public class Car {
    
    private String brand;
    private String type;
    private int fuelusage;

    public Car(String brand, String type, int fuelusage) {
        this.brand = brand;
        this.type = type;
        this.fuelusage = fuelusage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFuelusage() {
        return fuelusage;
    }

    public void setFuelusage(int fuelusage) {
        this.fuelusage = fuelusage;
    }
    
    @Override
    public String toString()
    {
      return "Brand: " + this.getBrand() + " Type: " + this.getType() + " Fuelusage: " + this.getFuelusage();
    }
}
