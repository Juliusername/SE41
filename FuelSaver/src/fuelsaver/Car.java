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
    private ArrayList<Car> Cars = new  ArrayList<>();

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

    public ArrayList<Car> getCars() {
        return Cars;
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
    
    public boolean Addcar(Car newcar)
    {
        if(newcar != null)
        {
        this.Cars.add(newcar);
        return true;
        }
        
        return false;
    }
    
    public boolean Removecar(Car newcar)
    {
        if(newcar != null)
        {
        this.Cars.remove(newcar);
        return true;
        }
        
        return false;
    }
    
    public boolean Updatecar(Car newcar) {
        if (newcar != null) {
            for (Car oldcar : Cars) {
                if (oldcar.getBrand().equals(newcar.getBrand()) && oldcar.getType().equals(newcar.getType())) {
                    oldcar.setBrand(newcar.brand);
                    oldcar.setType(newcar.type);
                    oldcar.setFuelusage(newcar.fuelusage);
                }
            }
            return true;
        }

        return false;
    }
    
    @Override
    public String toString()
    {
      return "Brand: " + this.getBrand() + " Type: " + this.getType() + " Fuelusage: " + this.getFuelusage();
    }
}
