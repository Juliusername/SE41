/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class Person {
    private String username;
    private String password;
    private Car car;
    private List<Gasstation> gasstations;
    
    public Person() {
        this.username = "Henkie94";
        this.password = "pizza";
        this.car = null;
        this.gasstations = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Car getCar() {
        return car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }

    public List<Gasstation> getGasstations() {
        return gasstations;
    }

    public void addGasstation(Gasstation gasstation) {
        this.gasstations.add(gasstation);
    }
    
    public void removeGasstation(Gasstation gasstation) {
        this.gasstations.remove(gasstation);
    }
}
