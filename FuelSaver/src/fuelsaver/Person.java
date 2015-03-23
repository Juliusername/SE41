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
    private List<GasStation> gasstations;
    
    public Person(String username, String password) {
        this.username = username;
        this.password = password;
        this.car = null;
        this.gasstations = new ArrayList<>();
    }
    
    public Person() {
        this("Henkie94", "pizza");
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

    public List<GasStation> getGasstations() {
        return gasstations;
    }

    public void addGasstation(GasStation gasstation) {
        this.gasstations.add(gasstation);
    }
    
    public void removeGasstation(GasStation gasstation) {
        this.gasstations.remove(gasstation);
    }
        
}
