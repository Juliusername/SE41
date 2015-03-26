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
public class GasStation {
    
    private String GasStationname;
    private String GasStationlocation;
    private double GasStationprice;
    private ArrayList<GasStation> GasStations = new  ArrayList<>();

    public GasStation(String GasStationname, String GasStationlocation, double GasStationprice) {
        this.GasStationname = GasStationname;
        this.GasStationlocation = GasStationlocation;
        this.GasStationprice = GasStationprice;
    }

    public String getGasStationname() {
        return GasStationname;
    }

    public void setGasStationname(String GasStationname) {
        this.GasStationname = GasStationname;
    }

    public String getGasStationlocation() {
        return GasStationlocation;
    }

    public void setGasStationlocation(String GasStationlocation) {
        this.GasStationlocation = GasStationlocation;
    }

    public double getGasStationprice() {
        return GasStationprice;
    }

    public void setGasStationprice(double GasStationprice) {
        this.GasStationprice = GasStationprice;
    }
    
    public boolean Addcar(GasStation newGasStation)
    {
        if(newGasStation != null)
        {
        this.GasStations.add(newGasStation);
        return true;
        }
        
        return false;
    }
    
    public boolean Removecar(GasStation newGasStation)
    {
        if(newGasStation != null)
        {
        this.GasStations.remove(newGasStation);
        return true;
        }
        
        return false;
    }
    
    public boolean UpdateGasStation(GasStation newGasStation) {
        if (newGasStation != null) {
            for (GasStation oldGasStation : GasStations) {
                if (oldGasStation.getGasStationname().equals(newGasStation.getGasStationname())) {
                    oldGasStation.setGasStationname(newGasStation.getGasStationname());
                    oldGasStation.setGasStationlocation(newGasStation.getGasStationlocation());
                    oldGasStation.setGasStationprice(newGasStation.getGasStationprice());
                }
            }
            return true;
        }

        return false;
    }
    
    @Override
    public String toString()
    {
      return "Name: " + this.getGasStationname() + " Location: " + this.getGasStationlocation() + " Price: " + this.getGasStationprice();
    }
    
}
