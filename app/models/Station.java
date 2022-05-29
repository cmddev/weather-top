package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    //Station basic attributes
    public String name;
    public double longitude;
    public double latitude;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    //Temperature
    public double latestTempCelsius;
    public double latestTempFahrenheit;
    public double minTempCelsius;
    public double maxTempCelsius;

    //WeatherConditions
    public String latestWeatherCondition;
    public String weatherCondition;
    public String latestWeatherIcons;

    //Pressure
    public double latestPressure;
    public double minPressure;
    public double maxPressure;

    //WIND
    public double latestWindSpeed;
    public double minWindSpeed;
    public double maxWindSpeed;
    public double beaufortScale;
    public String windCompass;
    public double windChill;

    public Station(String name, double latitude,double longitude ) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }
    public double getLongitude() {return longitude;}
    public double getLatitude() {return latitude;}


}


